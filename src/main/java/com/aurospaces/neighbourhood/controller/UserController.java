package com.aurospaces.neighbourhood.controller;

import javax.servlet.ServletContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Controller;
import com.aurospaces.neighbourhood.db.dao.StudentFeeDao;
import com.aurospaces.neighbourhood.db.dao.usersDao1;

@Controller
public class UserController {
	
	Logger log = Logger.getLogger(SchoolHomecontroller.class);
	@Autowired ServletContext objContext;
	@Autowired StudentFeeDao objStudentFeeDao;
	@Autowired usersDao1 usesDao1;
	@Autowired DataSourceTransactionManager transactionManager;
	
	private Logger logger = Logger.getLogger(UserController.class);
	
}