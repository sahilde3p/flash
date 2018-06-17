package com.sahil;


import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Handler {
	String passValidation = null;

	@RequestMapping("/login")
	public String login(@RequestParam("username") String user, @RequestParam("password") String pass,
			HttpServletRequest req, Model m) {
		
		if (JdbcDao.authenticate(user, pass)) {
			HttpSession session = req.getSession();
			session.setAttribute("login", 1);
			return "redirect: welcome.jsp";
		} else {

			m.addAttribute("error", "Incorrect Student ID or Password");
			return "index";
		}

	}

	@RequestMapping("/signout")
	public String signout(HttpServletRequest req) {
		HttpSession session = req.getSession(false);
		session.removeAttribute("login");
		session.invalidate();
		return "redirect: index.jsp";
	}

	@RequestMapping("/registrationverification")
	public ModelAndView register(@ModelAttribute("user") UserInfo userInfo, HttpServletRequest req,
			@RequestParam("password") String pass, @RequestParam("confirmpassword") String cpass) {
		ModelAndView mv = new ModelAndView("register");
		if(userInfo.getFirstName().equals("") || userInfo.getLastName().equals("") || userInfo.getEmail().equals("") || userInfo.getCourse().equals("")) {
			mv.addObject("error", "Required Feilds Cannot Be Blank");
			return mv;
		}
	
	
		if (passValidation(pass, cpass)) {

			Random rand = new Random();
			int no = 50 + rand.nextInt(10000);
			String userid = userInfo.getFirstName().toLowerCase() + no;
			while(JdbcDao.checkExistingUserId(userid)) {
				userid = userInfo.getFirstName().toLowerCase() + no;
			}
		if(!(JdbcDao.checkExistingEmail(userInfo.getEmail()))) {
			if(JdbcDao.registerationSuccess(userid,pass,userInfo.getFirstName(),userInfo.getLastName(),userInfo.getCourse(),userInfo.getEmail())) {
				mv.addObject("userid", "<a href=index.jsp>Login here</a> with your StudentID "+userid+" and your choosen password");
				return mv;
			}
			else {
				mv.addObject("error", "Couldnot access Database. Please Try Again later");
				return mv;
			}
		}
		else {
			mv.addObject("error","This Email is already used for another account");
			return mv;
		}
			

			
		} else {
			mv.addObject("error", passValidation);
			return mv;
		}
	}
	@RequestMapping("/forgot")
	public ModelAndView forgot(@RequestParam("email") String email) {
		ModelAndView mv = new ModelAndView("index");
		
		String userId = JdbcDao.getUserId(email);
		if(userId.length()==0) {
			mv.addObject("error","Sorry there is no such email in our database");
			return mv;
		}
		else {
			mv.addObject("userid",userId);
			return mv;
		}

	}


	public boolean passValidation(String pass, String cpass) {
		boolean upper=false;
		boolean lower=false;
		boolean digit=false;
		
		
	if((pass.length()) != 0)	{
		if (pass.length() >= 8) {
			if (pass.equals(cpass)) {	
			} else {
				passValidation = "Password Dosenot match";
				return false;
			}
			for (int i = 0; i < pass.length(); i++) {
				if ((Character.isUpperCase(pass.charAt(i)))) {
					
					passValidation=null;
					upper = true;
					break;

				} else {
					passValidation = "Password Should Contain Atleast One UpperCase";
					
				}

			}
		} else {
			passValidation = "Password is too short";
			return false;
		}
	} else {
		passValidation = "Password Cannot be empty";
		return false;
	}
		for (int j = 0; j < pass.length(); j++) {
			if (Character.isLowerCase(pass.charAt(j))) {
				
				lower = true;
				break;
			
			} else {
				passValidation = "Password Should Contain Atleast One Lower Case";
				
			}
			
		}
		if(lower==true) {}
		else {
			return false;
		}
		for (int k = 0; k < pass.length(); k++) {
			if (Character.isDigit(pass.charAt(k))) {
				
				
				
				digit = true;
				break;
				
			} else {
				passValidation = "Password Should Contain Atleast One Numeric Character";
				
			}
		}
		if(upper && lower && digit == true) {
			return true;
		}
		else {
			return false;
		}
	}

}
