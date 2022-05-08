package com.edonation.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.edonation.dto.DonorDto;
import com.edonation.dto.NgoDto;
import com.edonation.entity.DonorEntity;
import com.edonation.entity.NgoEntity;
import com.edonation.exceptions.NgoNotFoundException;
import com.edonation.repository.DonorRepository;
import com.edonation.repository.NgoRepository;
import com.edonation.service.DonorService;

@Service
public class DonorServiceImpl implements DonorService {

	@Autowired
	private DonorRepository donorRepository;
	
	@Autowired
	private NgoRepository ngoRepository;

	@Override
	@Transactional
	public DonorDto registerDonor(DonorDto donorDto) {
	    DonorEntity donorEntity = new DonorEntity();
	    NgoEntity ngoEntity=new NgoEntity();
	    BeanUtils.copyProperties(donorDto.getNgo(),ngoEntity);
	    BeanUtils.copyProperties(donorDto,donorEntity);
	    donorEntity.setNgo(ngoEntity);
	    donorEntity.setNgo(ngoRepository.save(donorEntity.getNgo()));
	    donorEntity.setNgoId(donorEntity.getNgo().getId());
	    donorEntity= donorRepository.save(donorEntity);
	    BeanUtils.copyProperties(donorEntity,donorDto);
	    BeanUtils.copyProperties(ngoEntity,donorDto.getNgo());
	    return donorDto;
	}

	@Override
	public List<DonorDto> donorsByNgoId(Long ngoId) {
	    List<DonorDto> donorDtos=new ArrayList<>();
	    if(ngoRepository.existsById(ngoId)) {
		List<DonorEntity> donorEntities= donorRepository.findByNgoId(ngoId);
		DonorDto donorDto=null;
		NgoDto ngoDto=null;
		for (DonorEntity donorEntity : donorEntities) {
		    donorDto=new DonorDto();
		    BeanUtils.copyProperties(donorEntity, donorDto);
		    if(donorEntity.getNgo()!=null) {
			ngoDto=new NgoDto();
			BeanUtils.copyProperties(donorEntity.getNgo(), ngoDto);
			donorDto.setNgo(ngoDto);
		    }
		    donorDtos.add(donorDto);
		}
	    }else {
		throw new NgoNotFoundException("Ngo not found with given id");
	    }
	    return donorDtos;
	}

	@Override
	public DonorDto updateDonor(DonorDto donorDto) {
	    if(ngoRepository.existsById(donorDto.getNgoId())) {
		DonorEntity donorEntity=new DonorEntity();
		BeanUtils.copyProperties(donorDto, donorEntity);
		BeanUtils.copyProperties(donorRepository.save(donorEntity), donorDto);
	    }else {
		throw new NgoNotFoundException("Ngo not found with given id");
	    }
	    return donorDto;
	}

}
