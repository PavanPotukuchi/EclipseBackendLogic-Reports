package com.edonation.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edonation.dto.DonationDto;
import com.edonation.exceptions.InvalidDataException;
import com.edonation.exceptions.InvalidDonationAmountException;
import com.edonation.exceptions.InvalidDonationDateException;
import com.edonation.service.DonationService;

@RestController
@RequestMapping("/api/v1/donations")
@CrossOrigin("*")
public class DonationController {

    @Autowired
    private DonationService donationService; 
    
    @PostMapping("/add-donation")
    public ResponseEntity<DonationDto> addDonation(@Valid @RequestBody DonationDto donationDto, BindingResult result) {
	if (result.hasErrors()) {
	    throw new InvalidDataException("Donation data is not Valid!");
	}
	if(!donationDto.getDonationDate().isEqual(LocalDate.now())) {
	    throw new InvalidDonationDateException("Donation date should be current date");
	}
	if(donationDto.getAmount()<=0) {
	    throw new InvalidDonationAmountException("Donation amount not should be zero or negative");
	}
	donationDto = this.donationService.addDonation(donationDto);
	return ResponseEntity.ok(donationDto);
    }
    
    
    @GetMapping("/by-donor-id/{donorId}")
    public ResponseEntity<List<DonationDto>> donationsByDonorId(@PathVariable("donorId") Long donorId) {
	List<DonationDto> donationDtos = this.donationService.donationsByDonorId(donorId);
	return ResponseEntity.ok(donationDtos);
    }

}
