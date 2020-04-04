package controller;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import entities.Drug;
import serviceImpl.DrugServiceImpl;

@Controller
public class DrugController {

	@Autowired
	private DrugServiceImpl drugSer;
	
	@RequestMapping("/addDrug")
	public String addPharma(Model m){
		m.addAttribute("drug", new Drug());
		return "DrugRegister";
	}
	
	@RequestMapping(value = "/registerDrug", method = RequestMethod.POST)
	public String addDrug(@ModelAttribute("drug") Drug drug, Model m){
		drugSer.addDrug(drug);
		return "redirect:/viewPharmacies";
	}
	
	@RequestMapping(value="viewDrugs", method = RequestMethod.GET)
	public ModelAndView viewDrugs(){
		ModelAndView mv=new ModelAndView("drugs-list");
		Set<Drug> drugs=drugSer.getDrugs();
		mv.addObject("drugs", drugs);
		return mv;
	}
	
	@RequestMapping(value="viewDrugs/{pName}", method = RequestMethod.GET)
	public ModelAndView viewDrugsForOnePharma(@ModelAttribute Drug drug, Model m, @PathVariable String pName){
		ModelAndView mv=new ModelAndView("drugs-list-one");
		Set<Drug> drugs=drugSer.getDrugsForOnePharma(pName);
		mv.addObject("drugs", drugs);
		return mv;
	}
	
	@RequestMapping("/updateDrug/{id}")
	public String updateDrug(Model m, @PathVariable("id") int id, Drug d){
		m.addAttribute("dId",id);
		m.addAttribute("upd", d);
		return "update-drug";
	}
	
	@RequestMapping(value = "/update/drug/{id}", method = RequestMethod.POST)
	public String updateDrug(@RequestParam("dId")int id, @RequestParam("dName")String name, @RequestParam("dDesc")String desc, @RequestParam("dCost")String cost){
		drugSer.updateDrug(id, name, desc, cost);
		return "redirect:/viewDrugs";
	}
	
	@RequestMapping("/search")
	public String search(Model m){
		m.addAttribute("drug", new Drug());
		return "search";
	}
	
	@RequestMapping(value="/searchRes", method=RequestMethod.POST)
	public String searchDrug(@ModelAttribute("drug")Drug d, Model m){
		List<Drug> searched=drugSer.searchDrug(d.getdName());
		m.addAttribute("drugres", searched);
		return "searchRes";
	}
}
