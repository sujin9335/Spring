package com.test.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.elasticsearch.xcontent.XContentType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TestController {

	//목록보기
	@SuppressWarnings("deprecation")
	@GetMapping(value = "/list.do")
	public String list(Model model, String type, String word, String word2,
							@RequestParam(defaultValue = "0") int slop) {

		//검색어가 들어왔는지 아닌지 구분 : 첫페이지에서는 type이 안들어옴
		if(type == null || type.equals("")) {
			//전체 검색
			type="match_all";
		}
		
		try {
			
			//엘라스틱서치 연결 정보 객체
			//HttpHost host=new HttpHost("엘라스틱서치 IP", "포트번호", "프로토콜");
			//IP정보는 Ubuntu 에서 아래 입력
			//ip addr show eth0 | grep inet | awk '{ print $2; }' | sed 's/\/.*$//'
			
			HttpHost host=new HttpHost("172.30.116.4", 9200, "http");
			
			
			RestClientBuilder builder=RestClient.builder(host);
			
			//client > 엘라스틱서치와 대화 객체
			RestHighLevelClient client=new RestHighLevelClient(builder);
			
			//접근하려는 인덱스 참조 > spring 인덱스
			SearchRequest searchRequest=new SearchRequest("spring");
			
			SearchSourceBuilder searchSourceBuilder=new SearchSourceBuilder().size(100);
			
			//***엘라스틱 서치 검색기능
			// - GET spring/_search : 이거 하는거랑 같음
			//	{
			//		"query": {
			//			"match_all": {}
			//		}
			//	{
			
			
			//searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			
			if(type.equals("match_all")) {
				
				//match_all
				searchSourceBuilder.query(QueryBuilders.matchAllQuery());
			}else if(type.equals("match_or")){
				
				//match > 풀스텍 검색
				/*
					GET my_type2/_search
					{
					  "query": {
					    "match": {
					      "txt2": "배부른 고양이"
					    }
					  }
					}
			
				 */
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word));
			}else if(type.equals("match_and")) {
				//match + operator(and)
				searchSourceBuilder.query(QueryBuilders.matchQuery("message", word).operator(Operator.AND));
				
				
			}else if(type.equals("match_phrase")) {
				
				if(slop == 0) {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word));
				}else {
					searchSourceBuilder.query(QueryBuilders.matchPhraseQuery("message", word).slop(slop));
				}
				
				
			}else if(type.equals("match_bool")) {
				
				/*searchSourceBuilder.query(QueryBuilders.boolQuery()
									.must(반드시 포함될 조건)
									.mustNot(반드시 제거할 조건)));*/
				
				searchSourceBuilder.query(QueryBuilders.boolQuery()
									.must(QueryBuilders.matchQuery("message", word))
									.mustNot(QueryBuilders.matchQuery("message", word2)));
			}else if(type.equals("match_should")) {
				searchSourceBuilder.query(QueryBuilders.boolQuery()
									.must(QueryBuilders.matchQuery("message", word))
									.should(QueryBuilders.matchQuery("message", word))
									);
			}
			
			
			
			
			searchRequest.source(searchSourceBuilder);
			
			
			//실제 검색 요청 : 옵션은 바꿀일없음
			SearchResponse searchResponse=client.search(searchRequest, RequestOptions.DEFAULT);
			
			SearchHits searchHits=searchResponse.getHits();
			
			for(SearchHit hit : searchHits) {
				System.out.println(hit);
			}
			
			
			//SearchHits > (변환) > List<HashMap>
			
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			
			for(SearchHit hit : searchHits) {
				//Document > HasMap
				//getSourceAsMap : hit데이터의 source 만 가져오는것임
				Map<String,Object> map=hit.getSourceAsMap();

				//나머지 id, score 가져오는것
				map.put("id", hit.getId());
				map.put("score", hit.getScore());
				
				list.add(map);
			}
			System.out.println(list.toString());
			model.addAttribute("list", list);
			
			
			model.addAttribute("word", word);
			model.addAttribute("type", type);
			model.addAttribute("slop", slop);
			
			
			
			//사용 종료 > 엘라스틱서치 접속 종료
			client.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "list";
	}
	
	//추가하기(폼)
	@GetMapping(value = "/add.do")
	public String add(Model model) {

		return "add";
	}
	
	
	//추가하기(처리)
	@PostMapping(value = "/addok.do")
	public String addok(Model model, String id, String message) {

		try {
			
			//client 객체
			RestHighLevelClient client=new RestHighLevelClient(RestClient.builder(new HttpHost("172.30.116.4", 9200, "http")));
			
			/*
			
				PUT spring/_doc/11
				{
					"message": "안녕하세요. 홍길동입니다."
				}
			
			*/
			
			String data=String.format("{ \"message\": \"%s\" }", message);
			
			IndexRequest indexRequest=new IndexRequest("spring")
											.source(data, XContentType.JSON)
											.setRefreshPolicy("wait_for");
			
			indexRequest.id(id);
			
			//실제로 엘라스틱서치에 데이터(도큐먼트)를 추가하기
			//위에만들걸 등록하는 방법
			client.index(indexRequest, RequestOptions.DEFAULT);
			
			client.close();
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}	
		
		
		return "redirect:/list.do";
	}
	
}









