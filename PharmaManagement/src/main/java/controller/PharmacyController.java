package controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import entities.Drug;
import entities.Pharmacy;
import serviceImpl.DrugServiceImpl;
import serviceImpl.PharmacyServiceImpl;

@Controller
public class PharmacyController {
	
	@Autowired
	private PharmacyServiceImpl phSer;
	@Autowired
	private DrugServiceImpl drSer;
	
	@RequestMapping("AddPharmacy")
	public String addPharma(Model m){
		
		Set<Drug> drugList=drSer.getDrugs();
		m.addAttribute("pharma", new Pharmacy());
		m.addAttribute("drugList", drugList);
		return "PharmaRegister";
	}
	
	@RequestMapping(value = "registerPharma", method = RequestMethod.POST)
	public String addPharmacy(@ModelAttribute("pharma")@Valid Pharmacy pharmacy, BindingResult result, Model m){
		if(result.hasErrors()){
			return "redirect:/AddPharmacy";
		} else {
			
			phSer.addPharmacy(pharmacy, pharmacy.getPharmaDrugs());
			m.addAttribute("pName", pharmacy.getpName());
			return "redirect:/viewPharmacy/{pName}";
		}
	}
	
	@RequestMapping(value="viewPharmacy/{pName}", method = RequestMethod.GET)
	public String viewPharmacy(@ModelAttribute Pharmacy pharmacy, Model m, @PathVariable String pName){
		List<Pharmacy> pharma = phSer.getPharmacy(pName);
		m.addAttribute("p_single", pharma);
		m.addAttribute("drug", new Drug());
		return "pharmacy-one";
	}
	
	@RequestMapping(value="viewPharmacies", method = RequestMethod.GET)
	public String viewPharmacies(@ModelAttribute Pharmacy pharmacy, Model m){
		List<Pharmacy> pharmaciesList = phSer.getPharmacies();
		m.addAttribute("p", pharmaciesList);
		return "Pharmacies";
	}
}
