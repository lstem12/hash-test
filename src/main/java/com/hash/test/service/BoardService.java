package com.hash.test.service;

import java.util.Map;

public interface BoardService {
	public Map<String,String> insertBoard(Map<String,Object> param);
	public Map<String,Object> selectHashBoard(Map<String,Object> param);
}
