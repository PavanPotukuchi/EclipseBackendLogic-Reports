package com.edonation.dto;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

public class DonorDto implements Serializable {

    private Long id;

    @NotBlank
    @Length(min = 5, max = 30)
    private String donorName;

    @NotBlank
    @Length(min = 5, max = 30)
    private String username;

    @NotBlank
    @Length(min = 3, max = 25)
    private String password;

    @NotBlank
    @Email
    private String email;

    @NotNull
    @Size(min = 10, max = 10)
    @Pattern(regexp = "(^$|[0-9]{10})")
    private String phoneNumber;

    @NotBlank
    @Length(min = 5, max = 100)
    private String address;

    @Valid
    private NgoDto ngo;

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

    @Override
    public int hashCode() {
	final int prime = 31;
	int result = 1;
	result = prime * result + ((address == null) ? 0 : address.hashCode());
	result = prime * result + ((donorName == null) ? 0 : donorName.hashCode());
	result = prime * result + ((email == null) ? 0 : email.hashCode());
	result = prime * result + ((id == null) ? 0 : id.hashCode());
	result = prime * result + ((ngo == null) ? 0 : ngo.hashCode());
	result = prime * result + ((ngoId == null) ? 0 : ngoId.hashCode());
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
	DonorDto other = (DonorDto) obj;
	if (address == null) {
	    if (other.address != null)
		return false;
	} else if (!address.equals(other.address))
	    return false;
	if (donorName == null) {
	    if (other.donorName != null)
		return false;
	} else if (!donorName.equals(other.donorName))
	    return false;
	if (email == null) {
	    if (other.email != null)
		return false;
	} else if (!email.equals(other.email))
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
