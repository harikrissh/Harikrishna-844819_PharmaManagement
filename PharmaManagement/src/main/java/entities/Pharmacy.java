package entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

@Entity
@Table(name = "Pharmacy")
public class Pharmacy {

	@Id
	@SequenceGenerator(name = "pharmaIdGen", sequenceName = "pharmaId", initialValue = 500)
	@GeneratedValue(generator = "pharmaIdGen")
	@Column(name="PharmacyId")
	private int pId;
	
	@Column(name="PharmacyName")
	@Size(min=5, max=20, message="Name must contain min 5 characters and max 20 characters")
	//@NotBlank(message="This is a required field")
	private String pName;
	
	@Column(name="PharmacyPassword")
	@Size(min=3, max=12, message="Password must contain min 3 characters and max 12 characters")
	//@NotBlank(message="This is a required field")
	private String pPwd;
	
	@Column(name="PharmacyAddress")
	//@NotBlank(message="This is a required field")
	private String pAddr;
	
	@Column(name="PharmacyMail")
	@Email(message = "Please enter a valid email address")
	@Pattern(regexp=".+@.+\\..+", message="Please enter a valid email address")
	//@NotBlank(message="This is a required field")
	private String pMail;
	
	@Column(name="PharmacyContact")
	@Pattern(regexp="^[0-9]{10}", message="Contact number must contain 10 digits")
	//@NotBlank(message="This is a required field")
	private String pMob;
	
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(name="PharmacyDrug", 
	joinColumns= {@JoinColumn(name="PharmacyId")},  
	inverseJoinColumns= {@JoinColumn(name="DrugId")})
	//@NotBlank(message = "Please select atleast one drug")
	private Set<Drug> pharmaDrugs = new HashSet<Drug>();
	
	
	public Pharmacy(){ 
	
	}
	
	public Pharmacy(int pId) {
		this.pId = pId;
	}


	public int getpId() {
		return pId;
	}

	public void setpId(int pId) {
		this.pId = pId;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public String getpPwd() {
		return pPwd;
	}

	public void setpPwd(String pPwd) {
		this.pPwd = pPwd;
	}

	public String getpAddr() {
		return pAddr;
	}

	public void setpAddr(String pAddr) {
		this.pAddr = pAddr;
	}

	public String getpMail() {
		return pMail;
	}

	public void setpMail(String pMail) {
		this.pMail = pMail;
	}

	public String getpMob() {
		return pMob;
	}

	public void setpMob(String pMob) {
		this.pMob = pMob;
	}
	
	public Set<Drug> getPharmaDrugs() {
		return pharmaDrugs;
	}

	public void setPharmaDrugs(Set<Drug> pharmaDrugs) {
		this.pharmaDrugs = pharmaDrugs;
	}
	
}
