package com.aurospaces.neighbourhood.controller;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.aurospaces.neighbourhood.bean.StudentMarksBean;
import com.aurospaces.neighbourhood.bean.TimetableBean;
import com.aurospaces.neighbourhood.db.dao.ClassCreationDao;
import com.aurospaces.neighbourhood.db.dao.ExamTypeDao;
import com.aurospaces.neighbourhood.db.dao.TimetableDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;
import com.aurospaces.neighbourhood.util.MiscUtils;
import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
@Controller
public class StudentTimeTableController {
	@Autowired
	usersDao1 usesDao1;
	@Autowired
	ClassCreationDao objClassCreation;
	@Autowired  ExamTypeDao  examTypeDao;
	@Autowired TimetableDao timetableDao;
	
	@RequestMapping("/studenttimetable")
	public String studenttimetable(@ModelAttribute("timetableCmd") StudentMarksBean studentMarksBean,HttpServletRequest request,Model model) {
//		model.addAttribute("examType", examTypeDao.getAllExamType()) ;
		System.out.println("studenttimetable");
		String filepath=timetableDao.getFilepath();
		System.out.println("Image"+filepath);
		request.setAttribute("filepath", filepath);
		
		return "studenttimetable";
	}


	
	
@RequestMapping(value = "/importtimetable")
public String importtimetable(@RequestParam("file") MultipartFile file,HttpServletRequest request) throws JsonGenerationException, JsonMappingException, IOException {
	System.out.println("Import Time table page...");
	String size = null;
	String name=null;
	String sTomcatRootPath = null;
	String sDirPath = null;
	String filepath = null;
	try{
		
		System.out.println("-------importtimetable-----------");
		TimetableBean tBean=new TimetableBean();
		if (!file.isEmpty()) {
			byte[] bytes = file.getBytes();
			name =file.getOriginalFilename();
			int n=name.lastIndexOf(".");
			String ext1 = FilenameUtils.getExtension(name);
			filepath= MiscUtils.generateRandomString(5)+"."+ext1;
			//filepath= name+file.getContentType();
			String rootPath = request.getSession().getServletContext().getRealPath("/");
			System.out.println("----rootPath----"+rootPath);
			File dir = new File(rootPath + File.separator + "documents");
			if (!dir.exists()) {
				dir.mkdirs();
			}

			File serverFile = new File(dir.getAbsolutePath() + File.separator + filepath);
		 InputStream is = file.getInputStream(); BufferedOutputStream stream = new BufferedOutputStream(new FileOutputStream(serverFile));
					int i;
					while ((i = is.read()) != -1) {
						stream.write(i);
					}
					stream.flush();
				}
			
			filepath= "documents/"+filepath;
			tBean.setFilePath(filepath);
			sTomcatRootPath = System.getProperty("catalina.base");
			sDirPath = sTomcatRootPath + File.separator + "webapps"+ File.separator + "documents" ;
			System.out.println(sDirPath);
			File file1 = new File(sDirPath);
			file.transferTo(file1);
			
			timetableDao.save(tBean);
			
		
	}catch(Exception e){
e.printStackTrace();
System.out.println(e);
		
		
	}
	return "studenttimetable";
}
}
