package com.edonation.entity;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "donation")
public class DonationEntity implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@ManyToOne
	@JoinColumn(name="donor_id",insertable = false,updatable = false)
	private DonorEntity donor;
	
	@Column(name = "donor_id")
	private Long donorId;
	
	@ManyToOne
	@JoinColumn(name="ngo_id",insertable = false,updatable = false)
	private NgoEntity ngo;
	
	@Column(name = "ngo_id")
	private Long ngoId;
	
	private String donationType;
	
	private Double amount;

	private LocalDate donationDate;

	public Long getId() {
	    return id;
	}

	public void setId(Long id) {
	    this.id = id;
	}

	public DonorEntity getDonor() {
	    return donor;
	}

	public void setDonor(DonorEntity donor) {
	    this.donor = donor;
	}

	public Long getDonorId() {
	    return donorId;
	}

	public void setDonorId(Long donorId) {
	    this.donorId = donorId;
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

	public String getDonationType() {
	    return donationType;
	}

	public void setDonationType(String donationType) {
	    this.donationType = donationType;
	}

	public Double getAmount() {
	    return amount;
	}

	public void setAmount(Double amount) {
	    this.amount = amount;
	}

	public LocalDate getDonationDate() {
	    return donationDate;
	}

	public void setDonationDate(LocalDate donationDate) {
	    this.donationDate = donationDate;
	}
	
}
