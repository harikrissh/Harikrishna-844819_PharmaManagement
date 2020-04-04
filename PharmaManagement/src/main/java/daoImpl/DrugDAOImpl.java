package daoImpl;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Drug;

@Repository
public class DrugDAOImpl {
	
	@Autowired
	SessionFactory sessionFactory;
	
	public void addDrug(Drug drug) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(drug);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public Set<Drug> getDrugs(){
		Set<Drug> drugSet=new HashSet<>();
		Session session = sessionFactory.openSession();
		Query selectAllDrugs = session.createQuery("from Drug");
		List<Drug> drugsList = selectAllDrugs.list();
		for(Drug d: drugsList){
			drugSet.add(d);
		}
		session.close();
		return drugSet;
	}
	
	@SuppressWarnings("unchecked")
	public Set<Drug> getDrugsForOnePharma(String pharmacyName){
		Set<Drug> drugSet=new HashSet<>();
		Session session = sessionFactory.openSession();
		String qry="select DrugName, DrugDescription, DrugMfdDate, DrugExpiryDate, DrugCost from Pharmacy as p, Drug as d, PharmacyDrug as pd where p.PharmacyName=:name and p.PharmacyId=pd.PharmacyId and d.DrugId=pd.DrugId";
		Query selectDrugs = session.createQuery(qry);
		selectDrugs.setString("name", pharmacyName);
		List<Drug> drugsList = selectDrugs.list();
		for(Drug d: drugsList){
			drugSet.add(d);
		}
		session.close();
		return drugSet;
	}
	
	public void updateDrug(int id, String name, String desc, String cost){
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		Query upd = session.createQuery("update Drug set DrugName=:name, DrugCost=:cost, DrugDescription=:desc where DrugId=:id");
		upd.setParameter("id", id);
		upd.setParameter("name", name);
		upd.setParameter("cost", cost);
		upd.setParameter("desc", desc);
		upd.executeUpdate();
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Drug> searchDrug(String name){
		Session session = sessionFactory.openSession();
		Query q=session.createQuery("from Drug where DrugName=:name");
		q.setString("name", name);
		List<Drug> drugList = q.list();
		session.close();
		return drugList;
	}
}
