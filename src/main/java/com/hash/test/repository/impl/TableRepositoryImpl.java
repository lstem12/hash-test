package com.hash.test.repository.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.hash.test.repository.TableRepository;

@Repository
public class TableRepositoryImpl implements TableRepository {
	@Resource
	SqlSession ss;
	
	@Override
	public int insertTables(List<Map<String, Object>> params) {
		int cnt = 0;
		for(Map<String,Object> param : params) {
			if(param.get("exists")!=null) {
				cnt += ss.insert("com.hash.test.repository.HashTableRepository.insertHashTable",param);				
			}
		}
		return cnt;
	}

	@Override
	public Map<String, Object> selectHashTableByHtHash(Map<String, Object> param) {		
		return ss.selectOne("com.hash.test.repository.HashTableRepository.selectHashTableByHtHash", param);
	}

}
