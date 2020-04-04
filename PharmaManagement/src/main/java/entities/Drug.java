package entities;

import java.util.Calendar;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;


@Entity
@Table(name = "Drug")
public class Drug {
	
	@Id
	@SequenceGenerator(name = "drugIdGen", sequenceName = "drugId", initialValue = 100)
	@GeneratedValue(generator = "drugIdGen")
	@Column(name="DrugId")
	private int dId;
	
	@Column(name="DrugName")
	private String dName;
	
	@Column(name="DrugCost")
	private int dCost;
	
	@Column(name="DrugMfdDate")
	private Date mfdDate;
	
	@Column(name="DrugExpiryDate")
	private Date expDate;
	
	@Column(name="DrugDescription")
	private String dDesc;
	
	@ManyToMany(mappedBy="pharmaDrugs")
	private Set<Pharmacy> pharmacies = new HashSet<Pharmacy>();
	

	public Drug() {
		
	}
	
	public Drug(String dName){
		this.dName=dName;
		this.dCost=20;
		this.dDesc="Drug";
		this.mfdDate=new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.mfdDate);
		cal.add(Calendar.MONTH, 5);
		this.expDate=cal.getTime();
		
	}
	
	public String toString(){
		return this.dName;
	}

	public int getdId() {
		return dId;
	}


	public void setdId(int dId) {
		this.dId = dId;
	}

	public String getdName() {
		return dName;
	}

	public void setdName(String dName) {
		this.dName = dName;
	}

	public int getdCost() {
		return dCost;
	}

	public void setdCost(int dCost) {
		this.dCost = dCost;
	}

	public Date getMfdDate() {
		return mfdDate;
	}

	public void setMfdDate(Date mfdDate) {
		this.mfdDate = mfdDate;
	}

	public Date getExpDate() {
		return expDate;
	}

	public void setExpDate(Date expDate) {
		this.expDate = expDate;
	}

	public String getdDesc() {
		return dDesc;
	}

	public void setdDesc(String dDesc) {
		this.dDesc = dDesc;
	}
	
	public Set<Pharmacy> getPharmacies() {
		return pharmacies;
	}

	public void setPharmacies(Set<Pharmacy> pharmacies) {
		this.pharmacies = pharmacies;
	}
	
	
}
