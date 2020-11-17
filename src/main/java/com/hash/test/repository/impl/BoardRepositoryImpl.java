package com.hash.test.repository.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hash.test.repository.BoardRepository;

@Repository
public class BoardRepositoryImpl implements BoardRepository {

	@Resource
	private SqlSession ss;
	@Override
	public int insertBoard(Map<String, Object> param) {
		return ss.insert("com.hash.test.repository.HashBoardRespository.insertHashBoard", param);
	}
	@Override
	public int insertBoardTableMaps(List<Map<String, Object>> list) {
		int cnt = 0;
		for(Map<String,Object> btm:list) {
			cnt += ss.insert("com.hash.test.repository.HashBoardRespository.insertBoardTableMap", btm);
		}
		return cnt;
	}
	@Override
	public Map<String, Object> selectHashBoard(Map<String, Object> param) {
		return ss.selectOne("com.hash.test.repository.HashBoardRespository.selectHashBoard", param);
	}
	@Override
	public List<Map<String, String>> selectHashList(Map<String, Object> param) {
		return ss.selectList("com.hash.test.repository.HashBoardRespository.selectHashList", param);
	}
	@Override
	public List<Map<String, String>> selectHashBoardListByHashTag(Map<String, Object> param) {
		return ss.selectList("com.hash.test.repository.HashBoardRespository.selectHashBoardListByHashTag",param);
	}

}
