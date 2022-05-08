package com.edonation.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import org.hibernate.validator.constraints.Length;

public class NgoDto implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    
    private String ngoName;
    
    @NotBlank
    @Length(min = 5, max = 30)
    private String username;
    
    @NotBlank
    @Length(min = 3, max = 25)
    private String password;
    
    @NotBlank
    @Length(min = 5, max = 100)
    private String address;
    
    private String phoneNumber;
    
    private LocalDate establishedDate;
    
    @OneToMany(mappedBy="ngo")
    private List<DonorDto> donors;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNgoName() {
        return ngoName;
    }

    public void setNgoName(String ngoName) {
        this.ngoName = ngoName;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getEstablishedDate() {
        return establishedDate;
    }

    public void setEstablishedDate(LocalDate establishedDate) {
        this.establishedDate = establishedDate;
    }

    public List<DonorDto> getDonors() {
        return donors;
    }

    public void setDonors(List<DonorDto> donors) {
        this.donors = donors;
    }

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((donors == null) ? 0 : donors.hashCode());
	result = prime * result + ((establishedDate == null) ? 0 : establishedDate.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((ngoName == null) ? 0 : ngoName.hashCode());
	result = prime * result + ((password == null) ? 0 : password.hashCode());
	result = prime * result + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
	result = prime * result + ((username == null) ? 0 : username.hashCode());
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
	NgoDto other = (NgoDto) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (donors == null) {
	    if (other.donors != null)
		return false;
	} else if (!donors.equals(other.donors))
	    return false;
	if (establishedDate == null) {
	    if (other.establishedDate != null)
		return false;
	} else if (!establishedDate.equals(other.establishedDate))
	    return false;
	if (id == null) {
	    if (other.id != null)
		return false;
	} else if (!id.equals(other.id))
	    return false;
	if (ngoName == null) {
	    if (other.ngoName != null)
		return false;
	} else if (!ngoName.equals(other.ngoName))
	    return false;
	if (password == null) {
	    if (other.password != null)
		return false;
	} else if (!password.equals(other.password))
	    return false;
	if (phoneNumber == null) {
	    if (other.phoneNumber != null)
		return false;
	} else if (!phoneNumber.equals(other.phoneNumber))
	    return false;
	if (username == null) {
	    if (other.username != null)
		return false;
	} else if (!username.equals(other.username))
	    return false;
	return true;
    }
    
    

}
