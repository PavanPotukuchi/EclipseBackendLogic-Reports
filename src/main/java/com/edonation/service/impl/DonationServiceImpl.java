package com.edonation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edonation.dto.DonationDto;
import com.edonation.dto.DonorDto;
import com.edonation.dto.NgoDto;
import com.edonation.entity.DonationEntity;
import com.edonation.repository.DonationRepository;
import com.edonation.service.DonationService;

@Service
public class DonationServiceImpl implements DonationService {

	@Autowired
	private DonationRepository donationRepository;

	@Override
	public DonationDto addDonation(DonationDto donationDto) {
	    DonationEntity donationEntity=new DonationEntity();
	    BeanUtils.copyProperties(donationDto, donationEntity);
	    BeanUtils.copyProperties(donationRepository.save(donationEntity), donationDto);
	    return donationDto;
	}

	@Override
	public List<DonationDto> donationsByDonorId(Long donorId) {
	    List<DonationEntity> donationEntities= donationRepository.findByDonorIdOrderByAmountDesc(donorId);
	    List<DonationDto> donationDtos=new ArrayList<>();
	    DonationDto donationDto=null; 
	    DonorDto donorDto=null;
	    NgoDto ngoDto=null;
	    for (DonationEntity donationEntity : donationEntities) {
		donationDto=new DonationDto();
		BeanUtils.copyProperties(donationEntity, donationDto);
		if(donationEntity.getDonor()!=null) {
		    donorDto=new DonorDto();
		    BeanUtils.copyProperties(donationEntity.getDonor(), donorDto);
		    donationDto.setDonor(donorDto);
		}
		if(donationEntity.getNgo()!=null) {
		    ngoDto=new NgoDto();
		    BeanUtils.copyProperties(donationEntity.getNgo(), ngoDto);
		    donationDto.setNgo(ngoDto);
		}
		donationDtos.add(donationDto);
	    }
	    return donationDtos;
	}

}
