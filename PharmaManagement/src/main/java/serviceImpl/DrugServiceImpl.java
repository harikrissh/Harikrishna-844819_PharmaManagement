package serviceImpl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import daoImpl.DrugDAOImpl;
import entities.Drug;

public class DrugServiceImpl {
	
	@Autowired
	private DrugDAOImpl drugDAO;
	
	public void addDrug(Drug drug){
		drugDAO.addDrug(drug);
	}
	
	@Transactional
	public Set<Drug> getDrugs(){
		return drugDAO.getDrugs();
	}
	
	@Transactional 
	public Set<Drug> getDrugsForOnePharma(String pharma){
		return drugDAO.getDrugsForOnePharma(pharma);
	}

	@Transactional
	public void updateDrug(int id, String name, String desc, String cost) {
		drugDAO.updateDrug(id, name, desc, cost);
		
	}
	
	@Transactional
	public List<Drug> searchDrug(String name){
	 	return drugDAO.searchDrug(name);
		
	}
}
