package com.edonation.service;

import java.util.List;

import com.edonation.dto.DonorDto;

public interface DonorService {

    DonorDto registerDonor( DonorDto donorDto);

    List<DonorDto> donorsByNgoId(Long ngoId);

    DonorDto updateDonor( DonorDto donorDto);
	
}
