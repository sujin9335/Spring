package com.test.mybatis.persistence;

import static org.junit.Assert.assertNotNull;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j //연결 체크용 
public class MapperTest {
	
	
	@Autowired //root-context에있는 sqlSessionFactory 자동연결
	private SqlSessionFactory sqlSessionFactory;
	
	@Test //Log4j 연결 체크
	public void testQuery() {
		
		assertNotNull(sqlSessionFactory); //실행시켜서 JUnit 초록색뜨는지 확인
		
		//SqlSessionTemplate > SQL 실행 (Statement 역할)
		SqlSession session=sqlSessionFactory.openSession();
		
		//session.executeQuery("select")
		
		String time=session.selectOne("test.time");
		log.info(time);
		
	}

}
