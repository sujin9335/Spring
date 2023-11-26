package com.test.test1.persistence;

import com.test.test1.domain.TestDTO;

public class TestDAOImpl implements TestDAO{
	
	@Override
	public int add(TestDTO dto) {
		System.out.println("insert 완료");
		System.out.println(dto);
		
		return 1;
	}
	
	@Override
	public int getCount() {
		return 100;
	}
}
