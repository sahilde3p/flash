package com.sahil;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Handler {

	@RequestMapping("pages/login")
	public ModelAndView login(@RequestParam("username") String user,@RequestParam("password") String pass,HttpServletRequest req) {
		if(user.equals("admin") && pass.equals("1234")) {
			HttpSession session = req.getSession();
			session.setAttribute("login", 1);
			ModelAndView mv = new ModelAndView("welcome");
			return mv;
		}
		else {
		ModelAndView mv = new ModelAndView("index");
		mv.addObject("error", "Incorrect Student ID or Password");
		return mv;
		}
		
	}
	@RequestMapping("pages/signout")
	public ModelAndView signout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("login");
		session.invalidate();
		return new ModelAndView("index");
	}
	
	
	@RequestMapping("pages/registrationverification")
	public ModelAndView register(HttpServletRequest req, @RequestParam("firstname") String first) {
		ModelAndView mv = new ModelAndView("register");
		Random rand = new Random();
		int no = 50 + rand.nextInt(10000);
		String userid = first+no;
		
		mv.addObject("userid", "Login with your StudentID "+userid+" And your choosen password");
		return mv;
	}
	
	
	public static List<String> listFile(){
		List<String> list = new ArrayList<>();
		list.add("Sahil");
		list.add("gurbir");
		list.add("jj");
		list.add("vishu");
		return list;
	}

}
