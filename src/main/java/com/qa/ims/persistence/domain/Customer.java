package com.qa.ims.persistence.domain;

public class Customer {

	private Long id;
	private String name;
	private String emailAddress;
	private String phoneNumber;

	public Customer(String name, String emailAddress,String phoneNumber) {
		this.setName(name);
		this.setEmailAddress(emailAddress);
		this.setPhoneNumber(phoneNumber);
	}

	public Customer(Long id, String name, String emailAddress,String phoneNumber ) {
		this.setId(id);
		this.setName(name);
		this.setEmailAddress(emailAddress);
		this.setPhoneNumber(phoneNumber);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public String getPhoneNumber() {
		return this.phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	


	@Override
	public String toString() {
		return "id:" + id + " name:" + name + " email address:" + emailAddress + " phone number:" + phoneNumber;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((emailAddress == null) ? 0 : emailAddress.hashCode());
		result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Customer other = (Customer) obj;
		if (getName() == null) {
			if (other.getName() != null)
				return false;
		} else if (!getName().equals(other.getName()))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (getEmailAddress() == null) {
			if (other.getEmailAddress() != null)
				return false;
		} else if (!getEmailAddress().equals(other.getEmailAddress()))
			return false;
		if (getPhoneNumber() == null) {
			if (other.getPhoneNumber() != null)
				return false;
		} else if (!getPhoneNumber().equals(other.getPhoneNumber()))
			return false;
		return true;
	}

}
