/**
 * 
 */
package com.aurospaces.neighbourhood.rest;

/**
 * @author YOGI
 *
 */
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.aurospaces.neighbourhood.bean.CustomerBean;
import com.aurospaces.neighbourhood.dao.CustomerDao;
import com.aurospaces.neighbourhood.service.CustomerService;
import com.aurospaces.neighbourhood.service.CustomerServiceImpl;

// Plain old Java Object it does not extend as class or implements 
// an interface

// The class registers its methods for the HTTP GET request using the @GET annotation. 
// Using the @Produces annotation, it defines that it can deliver several MIME types,
// text, XML and HTML. 

// The browser requests per default the HTML MIME type.

//Sets the path to base URL + /hello
@Path("/hello")
@Controller
public class Hello {
	
  @GET
  
  public String sayHtmlHello() {
	  System.out.println("this is java....");
    return "<html> " + "<title>" + "Hello Jersey" + "</title>"
        + "<body><h1>" + "Hello Jersey" + "</body></h1>" + "</html> ";
  }

} 
