package com.edonation.dto;

import java.io.Serializable;
import java.time.LocalDate;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class DonationDto implements Serializable {

    private Long id;

    private DonorDto donor;

    @NotNull
    private Long donorId;

    private NgoDto ngo;

    @NotNull
    private Long ngoId;

    @NotBlank
    @Length(min = 5, max = 100)
    private String donationType;

    @NotNull
    private Double amount;

    private LocalDate donationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public DonorDto getDonor() {
        return donor;
    }

    public void setDonor(DonorDto donor) {
        this.donor = donor;
    }

    public Long getDonorId() {
        return donorId;
    }

    public void setDonorId(Long donorId) {
        this.donorId = donorId;
    }

    public NgoDto getNgo() {
        return ngo;
    }

    public void setNgo(NgoDto ngo) {
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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((amount == null) ? 0 : amount.hashCode());
	result = prime * result + ((donationDate == null) ? 0 : donationDate.hashCode());
	result = prime * result + ((donationType == null) ? 0 : donationType.hashCode());
	result = prime * result + ((donor == null) ? 0 : donor.hashCode());
	result = prime * result + ((donorId == null) ? 0 : donorId.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((ngo == null) ? 0 : ngo.hashCode());
	result = prime * result + ((ngoId == null) ? 0 : ngoId.hashCode());
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
	DonationDto other = (DonationDto) obj;
	if (amount == null) {
	    if (other.amount != null)
		return false;
	} else if (!amount.equals(other.amount))
	    return false;
	if (donationDate == null) {
	    if (other.donationDate != null)
		return false;
	} else if (!donationDate.equals(other.donationDate))
	    return false;
	if (donationType == null) {
	    if (other.donationType != null)
		return false;
	} else if (!donationType.equals(other.donationType))
	    return false;
	if (donor == null) {
	    if (other.donor != null)
		return false;
	} else if (!donor.equals(other.donor))
	    return false;
	if (donorId == null) {
	    if (other.donorId != null)
		return false;
	} else if (!donorId.equals(other.donorId))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (ngo == null) {
	    if (other.ngo != null)
		return false;
	} else if (!ngo.equals(other.ngo))
	    return false;
	if (ngoId == null) {
	    if (other.ngoId != null)
		return false;
	} else if (!ngoId.equals(other.ngoId))
	    return false;
	return true;
    }
    

}
