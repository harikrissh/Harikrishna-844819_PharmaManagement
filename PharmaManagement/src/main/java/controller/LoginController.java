package controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import entities.Pharmacy;
import serviceImpl.PharmacyServiceImpl;

@Controller
public class LoginController {
	@Autowired
	private PharmacyServiceImpl phSer;
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public ModelAndView viewLogin(@ModelAttribute Pharmacy pharmacy) {
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView processLogin(@Valid @ModelAttribute Pharmacy pharmacy, BindingResult result, Model m1) {
		boolean pharmacyFound = phSer.checkLogin(pharmacy.getpName(),pharmacy.getpPwd());
		ModelAndView model = null;
		if (pharmacyFound) 
		{
			m1.addAttribute("pname", pharmacy.getpName());
			model = new ModelAndView("redirect:/viewPharmacy/{pname}");
		} else {
			model = new ModelAndView("login");
			model.addObject("result", "Invalid Pharmacy Name or Password");
		}
		return model;
	}
}
