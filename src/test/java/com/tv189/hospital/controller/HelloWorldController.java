package com.tv189.hospital.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author xuezhiyu
 *
 * 2014-6-12
 */
@Controller
@RequestMapping("/helloword")
public class HelloWorldController {
	 @RequestMapping("/hello")
	 public ModelAndView helloWorld() {
	 
	  String message = "Hello World, Spring 3.0!";
	  System.out.println(message);
	  return new ModelAndView("hello", "message", message);
	 }
	 
}
