package com.edonation.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donar")
public class DonorEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String donorName;
	
	private String username;

	private String password;
	
	private String email;
	
	private String phoneNumber;
	
	private String address;
	
	@ManyToOne
	@JoinColumn(name="ngo_id",insertable = false,updatable = false)
	private NgoEntity ngo;
	
	@Column(name = "ngo_id")
	private Long ngoId;

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public String getDonorName() {
	    return donorName;
	}

	public void setDonorName(String donorName) {
	    this.donorName = donorName;
	}

	public String getUsername() {
	    return username;
	}

	public void setUsername(String username) {
	    this.username = username;
	}

	public String getPassword() {
	    return password;
	}

	public void setPassword(String password) {
	    this.password = password;
	}

	public String getEmail() {
	    return email;
	}

	public void setEmail(String email) {
	    this.email = email;
	}

	public String getPhoneNumber() {
	    return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
	    this.phoneNumber = phoneNumber;
	}

	public String getAddress() {
	    return address;
	}

	public void setAddress(String address) {
	    this.address = address;
	}

	public NgoEntity getNgo() {
	    return ngo;
	}

	public void setNgo(NgoEntity ngo) {
	    this.ngo = ngo;
	}

	public Long getNgoId() {
	    return ngoId;
	}

	public void setNgoId(Long ngoId) {
	    this.ngoId = ngoId;
	}
	

}
