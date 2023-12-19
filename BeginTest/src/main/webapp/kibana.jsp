<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://me2.do/5BvBFJ57">
<style>
	iframe {
		width: 1190px;
		margin: 0 auto;
		border: 0;
	}
	
	

</style>
</head>
<body class="wide">
	<h1>Elasticsearch <small>DashBoard</small></h1>
	<iframe src="http://localhost:5601/app/dashboards#/create?embed=true&_g=(filters:!(),refreshInterval:(pause:!t,value:0),time:(from:now-30y,to:now))&_a=(description:'',filters:!(),fullScreenMode:!f,options:(hidePanelTitles:!f,syncColors:!f,useMargins:!t),panels:!((embeddableConfig:(savedVis:(data:(aggs:!((enabled:!t,id:'1',params:(),schema:metric,type:count),(enabled:!t,id:'2',params:(field:buseo,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'1',otherBucket:!f,otherBucketLabel:Other,size:5),schema:segment,type:terms)),searchSource:(filter:!(),index:'9e0706b0-9e10-11ee-bab1-2ff19641f9ef',query:(language:kuery,query:''))),description:'',id:'',params:(addLegend:!t,addTimeMarker:!f,addTooltip:!t,categoryAxes:!((id:CategoryAxis-1,labels:(filter:!t,show:!t,truncate:100),position:bottom,scale:(type:linear),show:!t,style:(),title:(),type:category)),detailedTooltip:!t,grid:(categoryLines:!f),labels:(show:!f),legendPosition:right,maxLegendLines:1,palette:(name:default,type:palette),radiusRatio:0,row:!t,seriesParams:!((circlesRadius:1,data:(id:'1',label:Count),drawLinesBetweenPoints:!t,interpolate:linear,lineWidth:2,mode:stacked,show:!t,showCircles:!t,type:histogram,valueAxis:ValueAxis-1)),thresholdLine:(color:%23E7664C,show:!f,style:full,value:10,width:1),times:!(),truncateLegend:!t,type:histogram,valueAxes:!((id:ValueAxis-1,labels:(filter:!f,rotate:0,show:!t,truncate:100),name:LeftAxis-1,position:left,scale:(mode:normal,type:linear),show:!t,style:(),title:(text:''),type:value))),title:%EB%B6%80%EC%84%9C,type:histogram,uiState:())),gridData:(h:14,i:'9f1b900f-e4f5-4a6d-abb4-993fa53b843b',w:12,x:0,y:0),panelIndex:'9f1b900f-e4f5-4a6d-abb4-993fa53b843b',type:visualization,version:'7.17.15'),(embeddableConfig:(savedVis:(data:(aggs:!((enabled:!t,id:'1',params:(),schema:metric,type:count),(enabled:!t,id:'2',params:(field:buseo,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'1',otherBucket:!f,otherBucketLabel:Other,size:5),schema:segment,type:terms),(enabled:!t,id:'3',params:(field:position,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'1',otherBucket:!f,otherBucketLabel:Other,size:5),schema:segment,type:terms)),searchSource:(filter:!(),index:'9e0706b0-9e10-11ee-bab1-2ff19641f9ef',query:(language:kuery,query:''))),description:'',id:'',params:(addLegend:!f,addTooltip:!t,distinctColors:!f,isDonut:!t,labels:(last_level:!f,percentDecimals:2,position:default,show:!t,truncate:100,values:!t,valuesFormat:percent),legendPosition:right,maxLegendLines:1,nestedLegend:!f,palette:(name:default,type:palette),row:!t,truncateLegend:!t,type:pie),title:%EB%B6%80%EC%84%9C%EB%B3%84%EC%A7%81%EA%B8%89,type:pie,uiState:(vis:(legendOpen:!f)))),gridData:(h:15,i:'8ffc2a1e-69f8-4a58-8705-4507882abbdc',w:15,x:12,y:0),panelIndex:'8ffc2a1e-69f8-4a58-8705-4507882abbdc',type:visualization,version:'7.17.15'),(embeddableConfig:(savedVis:(data:(aggs:!((enabled:!t,id:'1',params:(),schema:metric,type:count),(enabled:!t,id:'2',params:(field:buseo,missingBucket:!f,missingBucketLabel:Missing,order:desc,orderBy:'1',otherBucket:!f,otherBucketLabel:Other,size:5),schema:bucket,type:terms)),searchSource:(filter:!(),index:'9e0706b0-9e10-11ee-bab1-2ff19641f9ef',query:(language:kuery,query:''))),description:'',id:'',params:(autoFitRowToContent:!f,perPage:10,percentageCol:'',showMetricsAtAllLevels:!f,showPartialRows:!f,showToolbar:!f,showTotal:!f,totalFunc:sum),title:%EB%B6%80%EC%84%9C%EB%B3%84%EC%9D%B8%EC%9B%90%EC%88%98,type:table,uiState:())),gridData:(h:15,i:b96bd0c9-5d3c-49dd-8a98-8a8330784511,w:13,x:27,y:0),panelIndex:b96bd0c9-5d3c-49dd-8a98-8a8330784511,type:visualization,version:'7.17.15')),query:(language:kuery,query:''),tags:!(),timeRestore:!f,title:'',viewMode:edit)" height="600" width="800"></iframe>




	<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	<script>


	</script>

</body>
</html>