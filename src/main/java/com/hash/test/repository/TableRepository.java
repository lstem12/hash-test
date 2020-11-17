package com.hash.test.repository;

import java.util.List;
import java.util.Map;

public interface TableRepository {
	public int insertTables(List<Map<String,Object>> param);
	public Map<String,Object> selectHashTableByHtHash(Map<String,Object> param);
}
