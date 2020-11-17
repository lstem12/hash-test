package com.hash.test.repository;

import java.util.List;
import java.util.Map;

public interface BoardRepository {
	public int insertBoard(Map<String,Object> param);
	public int insertBoardTableMaps(List<Map<String,Object>> list);
	public Map<String,Object> selectHashBoard(Map<String,Object> param);
	public List<Map<String,String>> selectHashList(Map<String,Object> param);
	public List<Map<String,String>> selectHashBoardListByHashTag(Map<String,Object> param);
}
