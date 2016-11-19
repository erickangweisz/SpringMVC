package com.jonatan.tutorial;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.jonatan.tutorial.model.Provincia;
import com.jonatan.tutorial.model.User;
import com.jonatan.tutorial.service.ProvinciaService;

@Controller
public class ProvinciaController {
	
	private ProvinciaService provinciaService;
	
	@Autowired(required = true)
	@Qualifier(value = "provinciaService")
	public void setProvinciaService(ProvinciaService provinciaService) {
		this.provinciaService = provinciaService;
	}
	
	@RequestMapping(value = "/provincias", method = RequestMethod.GET)
	public ModelAndView listProvincias() {
		ModelAndView mav = new ModelAndView("provinciasList");
		mav.addObject("provincia", new Provincia());
		mav.addObject("provinciaList", this.provinciaService.listProvincias());
		
		return mav;
	}
	
	@RequestMapping(value = "/provincia/add", method = RequestMethod.POST)
	public ModelAndView addProvincia(@ModelAttribute("provincia") Provincia p) {
		ModelAndView mav = new ModelAndView("redirect:/provincias");
		
		List<Provincia> pList = this.provinciaService.listProvincias();
		
		for (Provincia provincia : pList) {
			if(p.getCodigo().equals(provincia.getCodigo())) {
				this.provinciaService.updateProvincia(p);
				return mav;
			}
		}
		
		this.provinciaService.addProvincia(p);
		return mav;
	}
	
	@RequestMapping("/removeprovincia/{codigo}")
	public ModelAndView removeProvincia(@PathVariable("codigo") String codigo) {
		ModelAndView mav = new ModelAndView("redirect:/provincias");
		this.provinciaService.removeProvincia(codigo);
		
		return mav;
	}
	
	@RequestMapping("/editprovincia/{codigo}")
	public ModelAndView editUser(@PathVariable("codigo") String codigo) {
		ModelAndView mav = new ModelAndView("redirect:/provincias");
		mav.addObject("provincia", this.provinciaService.getProvinciaByCodigo(codigo));
		mav.addObject("provinciaList", this.provinciaService.listProvincias());
		
		return mav;
	}
	
	@RequestMapping("/viewprovincia/{codigo}")
	public ModelAndView viewProvincia(@PathVariable("codigo") String codigo) {
		ModelAndView mav = new ModelAndView("provinciaView");
		mav.addObject("user", this.provinciaService.getProvinciaByCodigo(codigo));
		
		return mav;
	}
}
