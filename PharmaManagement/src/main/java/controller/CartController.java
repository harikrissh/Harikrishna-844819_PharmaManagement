package controller;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entities.Drug;

@Controller
public class CartController {
	
	@RequestMapping(value="/cart", method=RequestMethod.POST)
	public ModelAndView cart(@RequestParam(value="drug", required=false) Drug d, @RequestParam("qty")int qty){
		ModelAndView mv=new ModelAndView("cart");
		Set<Drug> set=new HashSet<>();
		set.add(d);		
		mv.addObject("set", set);
		mv.addObject("qty", qty);
		return mv;
	}
	
}
