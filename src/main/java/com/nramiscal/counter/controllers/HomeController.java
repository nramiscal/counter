package com.nramiscal.counter.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	public static int count = 0;
	
	@RequestMapping("/")
	public String index(HttpSession session) {
		count++;
		
		session.setAttribute("count", count);
		return "index";
	}
	
	@RequestMapping("/counter")
	public String counter(HttpSession session, Model model) {
		int count = (Integer) session.getAttribute("count");
		model.addAttribute("count", count);
		return "counter";
	}
	
	@RequestMapping("/addtwo")
	public String plustwo(HttpSession session) {
		count = count + 2;
		session.setAttribute("count", count);
		
		return "plustwo";
	}
	
	@RequestMapping("/reset")
	public String reset(HttpSession session) {
		count = 0;
		session.setAttribute("count", count);
		return "counter";
	}
	
}
