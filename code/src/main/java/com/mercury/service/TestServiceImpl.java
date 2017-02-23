package com.mercury.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.dao.TestService;
import com.mercury.entity.Test;

@Service
public class TestServiceImpl implements TestService {
	@Autowired
	private TestService testService;

	@Override
	public Test getTestById(int id) {
		return testService.getTestById(id);
	}

	@Override
	public List<Test> listTest(Test t) {
		return testService.listTest(t);
	}

	@Override
	public int saveTest(Test t) {
		return testService.saveTest(t);
	}

	@Override
	public int removeTest(int id) {
		return testService.removeTest(id);
	}

	@Override
	public int updateTest(Test t) {
		return testService.updateTest(t);
	}

}