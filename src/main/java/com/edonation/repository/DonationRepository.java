package com.edonation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edonation.entity.DonationEntity;

@Repository
public interface DonationRepository extends JpaRepository<DonationEntity, Long> {

    List<DonationEntity> findByDonorIdOrderByAmountDesc(Long donorId);

}
