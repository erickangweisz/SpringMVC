package com.jonatan.tutorial.util;

import org.springframework.web.servlet.ModelAndView;

public class ErrorMessage {

	public static ModelAndView error(ModelAndView mav, String mensaje){
		mav.setViewName("error");
		mav.addObject("error", mensaje);
		return mav;
	}
	
}
