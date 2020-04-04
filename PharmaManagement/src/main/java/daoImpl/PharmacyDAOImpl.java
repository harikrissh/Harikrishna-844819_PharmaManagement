package daoImpl;

import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import entities.Drug;
import entities.Pharmacy;

@Repository
public class PharmacyDAOImpl {

	@Autowired
	SessionFactory sessionFactory;
	
	public void addPharmacy(Pharmacy pharmacy, Set<Drug> pharmaDrugs) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		for(Drug d: pharmaDrugs){
			pharmacy.getPharmaDrugs().add(d);
		}
		session.save(pharmacy);
		session.getTransaction().commit();
		session.close();
	}
	
	@SuppressWarnings("unchecked")
	public List<Pharmacy> getPharmacy(String pharmacyName){
		Session session = sessionFactory.openSession();
		Query selectPharmacy = session.createQuery("from Pharmacy where PharmacyName=:name");
		selectPharmacy.setString("name", pharmacyName);
		List<Pharmacy> pharmaList = selectPharmacy.list();
		session.close();
		return pharmaList;
	}
	
	@SuppressWarnings("unchecked")
	public List<Pharmacy> getPharmacies(){
		Session session = sessionFactory.openSession();
		Query selectAllPharmacy = session.createQuery("from Pharmacy");
		List<Pharmacy> pharmaList = selectAllPharmacy.list();
		return pharmaList;
	}
	
	@SuppressWarnings("rawtypes")
	public boolean checkLogin(String pName, String pPwd){
		Session session = sessionFactory.openSession();
		boolean isAvailable = false;
		Query login = session.createQuery("from Pharmacy where PharmacyName=:name and PharmacyPassword=:pwd");
		login.setString("name", pName);
		login.setString("pwd", pPwd);
		List l=login.list();
		if(l!=null && l.size()>0)
			isAvailable=true;
		return isAvailable;
	}
}
