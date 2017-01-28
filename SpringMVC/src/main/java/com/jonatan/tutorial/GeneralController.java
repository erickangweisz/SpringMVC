package com.jonatan.tutorial;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class GeneralController {

	@Autowired
	private ServletContext context;
	
	@ModelAttribute
	public void objetosComunes(Model model) {
		String context = this.context.getContextPath();
		
		model.addAttribute("context", context);
	}
	
}
