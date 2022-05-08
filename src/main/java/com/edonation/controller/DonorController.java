package com.edonation.controller;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edonation.dto.DonorDto;
import com.edonation.exceptions.InvalidDataException;
import com.edonation.exceptions.InvalidEstablishedDateException;
import com.edonation.service.DonorService;

@RestController
@RequestMapping("/api/v1/donors")
public class DonorController {

    @Autowired
    private DonorService donorService;

    @PostMapping("/register-donor")
    public ResponseEntity<DonorDto> registerDonor(@Valid @RequestBody DonorDto donorDto, BindingResult result) {
	if (result.hasErrors()) {
	    throw new InvalidDataException("Donor data is not Valid!");
	}
	if(!donorDto.getNgo().getEstablishedDate().isBefore(LocalDate.now())) {
	    throw new InvalidEstablishedDateException("EstablishedDate should be past date");
	}
	donorDto = this.donorService.registerDonor(donorDto);
	return ResponseEntity.ok(donorDto);
    }

    @PutMapping("/update-donor")
    public ResponseEntity<DonorDto> updateDonor(@Valid @RequestBody DonorDto donorDto, BindingResult result) {
	if (result.hasErrors()||donorDto.getId()==null) {
	    throw new InvalidDataException("Donor data is not Valid!");
	}
	donorDto = this.donorService.updateDonor(donorDto);
	return ResponseEntity.ok(donorDto);
    }

    
    @GetMapping("/by-ngo-id/{ngoId}")
    public ResponseEntity<List<DonorDto>> donorsByNgoId(@PathVariable("ngoId") Long ngoId) {
	List<DonorDto> donorDtos = this.donorService.donorsByNgoId(ngoId);
	return ResponseEntity.ok(donorDtos);
    }
}
