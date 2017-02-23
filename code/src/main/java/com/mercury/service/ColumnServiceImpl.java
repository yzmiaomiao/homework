package com.mercury.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mercury.dao.ColumnService;
import com.mercury.entity.Column;
import com.mercury.util.MercuryStringUtils;

@Service
public class ColumnServiceImpl implements ColumnService {
	@Autowired
	private ColumnService columnService;

	@Override
	public List<Column> listColumns() {
		List<Column> columns = columnService.listColumns();
		for (Column column : columns) {
			column.setFirstLetterLowerColumnName(MercuryStringUtils.firstLetterLower(column.getColumnName()));
			column.setFirstLetterUpperColumnName(MercuryStringUtils.firstLetterUpper(column.getColumnName()));
		}
		return columns;
	}

}
