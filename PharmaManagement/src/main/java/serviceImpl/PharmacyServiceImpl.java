package serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import daoImpl.PharmacyDAOImpl;
import entities.Drug;
import entities.Pharmacy;

public class PharmacyServiceImpl {

	@Autowired
	private PharmacyDAOImpl pharmacyDAO;
	
	public void addPharmacy(Pharmacy pharmacy, Set<Drug> drugs){
		pharmacyDAO.addPharmacy(pharmacy, drugs);
	}
	
	@Transactional
	public List<Pharmacy> getPharmacy(String pharmacyName){
		return pharmacyDAO.getPharmacy(pharmacyName);
	}
	
	@Transactional
	public List<Pharmacy> getPharmacies(){
		return pharmacyDAO.getPharmacies();
	}
	
	@Transactional
	public boolean checkLogin(String pName, String pPwd){
		return pharmacyDAO.checkLogin(pName, pPwd);
	}
}
