package com.test.test1.persistence;

import com.test.test1.domain.TestDTO;

public interface TestDAO {

	int getCount();

	int add(TestDTO dto);
}
