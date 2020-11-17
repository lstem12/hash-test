package com.hash.test.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.hash.test.repository.BoardRepository;
import com.hash.test.service.BoardService;
import com.hash.test.service.TableService;

@Service
public class BoardServiceImpl implements BoardService {
	private static final Logger log = LoggerFactory.getLogger(BoardServiceImpl.class);
	
	@Resource
	private BoardRepository boardRepository;
	@Resource
	private TableService tableService;
	@Override
	public Map<String, String> insertBoard(Map<String, Object> param) {
		Map<String, String> map = new HashMap<>();
		map.put("msg", "입력실패");
		map.put("result", "failed");
		if(boardRepository.insertBoard(param) == 1) {
			String hash = param.get("ht_hash").toString();
			if(hash!=null) {
				String[] hashs = hash.split(",");
				List<Map<String,Object>> htList = tableService.insertTable(hashs);
				for(Map<String,Object> ht:htList) {
					ht.put("hb_no", param.get("hb_no"));
				}
				boardRepository.insertBoardTableMaps(htList);
			}
			map.put("result", "succeed");
		}
		return map;
	}
	@Override
	public Map<String, Object> selectHashBoard(Map<String, Object> param) {
		Map<String, Object> hb = boardRepository.selectHashBoard(param);
		hb.put("hashs", boardRepository.selectHashList(param));
		return hb;
	}

}
