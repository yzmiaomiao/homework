package com.mercury.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.mercury.entity.Column;

@Repository
public interface ColumnService {

	List<Column> listColumns();

}
