package com.edonation.service;

import java.util.List;

import com.edonation.dto.DonationDto;

public interface DonationService {

    DonationDto addDonation( DonationDto donationDto);

    List<DonationDto> donationsByDonorId(Long donorId);

}
