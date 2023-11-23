package com.test.persistence;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

//1. JUnit
//2. Log4j

@Log4j
public class JDBCTest {
   
   //마음대로 만들어도 되는 메소드, 무언가를 테스트하는 메소드 : 오류뜨면 porm.xml에서 <scope>test</scope> 지우기
   @Test
   public void testConnection() {
      
      //JDBC연결 확인
      //연결확인할때는 예외처리가 필수니까 try catch
	   try {
			
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "java1234");
			
			assertNotNull(conn);
			
			log.info(conn.isClosed());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
      
   }
}