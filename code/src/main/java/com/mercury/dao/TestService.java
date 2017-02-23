package com.mercury.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercury.entity.Test;

@Repository
public interface TestService {

	Test getTestById(int id);

	List<Test> listTest(Test t);

	int saveTest(Test t);

	int removeTest(int id);

	int updateTest(Test t);
}