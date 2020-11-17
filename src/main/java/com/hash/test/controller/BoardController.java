package com.hash.test.controller;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.hash.test.service.BoardService;

@Controller
public class BoardController {
	private static final Logger log = LoggerFactory.getLogger(BoardController.class);
	
	@Resource
	private BoardService boardSerivce;
	
	@Resource
	private SqlSession ss;
	
	@GetMapping("/board/list")
	public String boardList(Model m) {
		m.addAttribute("boardList",ss.selectList("com.hash.test.repository.HashBoardRespository.selectHashBoardList"));
		return "board/board-list";
	}
	@GetMapping("/board/list/{ht_hash}")
	public String boardList(Model m, @PathVariable("ht_hash") String htHash) {
		Map<String,String> param = new HashMap<>();
		param.put("ht_hash", htHash);
		m.addAttribute("boardList",ss.selectList("com.hash.test.repository.HashBoardRespository.selectHashBoardListByHashTag",param));
		return "board/board-list";
	}
	@GetMapping("/board/view/{hb_no}")
	public String board(Model m, @PathVariable("hb_no") int hbNo) {
		Map<String,Object> param = new HashMap<>();
		param.put("hb_no", hbNo);
		m.addAttribute("hb", boardSerivce.selectHashBoard(param));
		log.info("hbNo=>{}",hbNo);
		return "board/board-view";
	}
	@GetMapping("/board/insert")
	public String goInsert() {
		return "board/board-insert";
	}
	@PostMapping("/board/insert")
	public ModelAndView doInsert(@RequestParam Map<String,Object> param, ModelAndView mv) {	
		log.debug("param=>{}",param);
		mv.setViewName("board/board-insert");
		mv.addObject("map", boardSerivce.insertBoard(param));
		return mv;
	}
}
