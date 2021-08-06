package main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Admin extends AbstractUser{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public Admin(String username, String password, String address, String email, String mobileNumber, int adminId) {
		super(username, password, address, email, mobileNumber);
		this.adminId = adminId;
	}

	public Admin() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	

}
