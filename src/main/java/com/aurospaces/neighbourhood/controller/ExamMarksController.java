
package com.aurospaces.neighbourhood.controller;


import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonGenerationException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aurospaces.neighbourhood.bean.BoardBean;
import com.aurospaces.neighbourhood.bean.ExamMarksBean;
import com.aurospaces.neighbourhood.bean.ExamPatternBean;
import com.aurospaces.neighbourhood.db.dao.ExamPatternDao;
import com.aurospaces.neighbourhood.db.dao.ExamTypeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;

@Controller public class ExamMarksController {
	@Autowired private SchoolHomecontroller schoolHomecontroller;
	@Autowired private ExamTypeDao  examTypeDao;
	@Autowired ExamPatternDao examPatternDao;
	@Autowired usersDao1 usesDao1;
	@RequestMapping(value = "/examMarks")
	public String examMarksHome(@ModelAttribute("examMarkscmd") ExamMarksBean examMarksBean,Model model )  {
		model.addAttribute("board", schoolHomecontroller.populate()) ;
		model.addAttribute("sections", schoolHomecontroller.populateallSection()) ;
		model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		return "examMarks";
	}

	
	@RequestMapping(value = "/examPattern")
	public String examPatternHome(@ModelAttribute("examPattern") ExamPatternBean examPatternBean,Model model)  {
		model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		return "examPattern";
	}
	
	@RequestMapping(value = "/examPattern",method = RequestMethod.POST)
	public String examPattern(@ModelAttribute("examPattern") ExamPatternBean examPatternBean,Model model)  {
		String  subjectArray[] =examPatternBean.getSubjectId().split(",");
		  String  maxMarksArray[] =examPatternBean.getMaxMarks().split(",");
		  Random rand = new Random();
		    // Generate random integers in range 0 to 999
	        int rand_int1 = rand.nextInt(1000);
		if(StringUtils.isNotBlank(examPatternBean.getRandomnum())) {
			
			examPatternDao.removeOldRecordForUpdate(examPatternBean.getRandomnum());
		}
		 for(int i=0;i<subjectArray.length;i++) {
			 examPatternBean.setId(0);
			 examPatternBean.setSubjectId(subjectArray[i]);
			 examPatternBean.setMaxMarks(maxMarksArray[i]);
			 examPatternBean.setRandomnum(Integer.toString(rand_int1));
			 examPatternDao.save(examPatternBean);
		 }
		
		return "redirect:examPattern";
	}
	
	
	@RequestMapping(value = "/examPatternList",method = RequestMethod.POST)
	public @ResponseBody String examPatternList(@ModelAttribute("examPattern") ExamPatternBean examPatternBean,Model model,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException  {
		
		List<ExamPatternBean> listOrderBeans = null;
		ObjectMapper objectMapper = null;
		String sJson = "";
		
		listOrderBeans = examPatternDao.getExamPatternList(examPatternBean.getBoardId(),examPatternBean.getClassId(),examPatternBean.getSectionId(),examPatternBean.getMedium(),examPatternBean.getExamTypeId());
		if(listOrderBeans != null ) {
			  objectMapper = new ObjectMapper(); 
			  sJson =objectMapper.writeValueAsString(listOrderBeans);
			  request.setAttribute("examPattern", sJson);
		}
		return sJson;
		
	}
	
	@ModelAttribute("board")
	public Map<String, String> populate() {
		Map<String, String> statesMap = new LinkedHashMap<String, String>();
		try {
			String sSql = "select id,name from boardname order by name asc";
			List<BoardBean> list = usesDao1.populate(sSql);
			for (BoardBean bean : list) {
				statesMap.put(bean.getId(), bean.getName());
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
		}
		return statesMap;
	}
}
