package com.techblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.techblog.entites.User;
import com.techblog.services.PostServices;
import com.techblog.services.UserServices;

@Controller
public class HomeController {

	@Autowired 
	public UserServices userServices;
	
	@Autowired
	private PostServices postServices;
	
	@RequestMapping(value = {""})
	public ModelAndView customerList() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("index");
		//model.addObject("customerDetails", customerDetails);
		return model;
	}
	@RequestMapping(value = {"/single.html"})
	public ModelAndView customerList1() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("single");
		//model.addObject("customerDetails", customerDetails);
		return model;
	}
	
	@RequestMapping(value = {"/Post"})
	public ModelAndView insertPost() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("Post");
		return model;
	}
	
	@RequestMapping(value = {"/home"})
	public ModelAndView home() {
		
		ModelAndView model = new ModelAndView();
		model.setViewName("Home");
		model.addObject("AllPost", postServices.getAllPost());
		return model;
	}
	
	
}
