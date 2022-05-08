package com.edonation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edonation.entity.NgoEntity;

@Repository
public interface NgoRepository extends JpaRepository<NgoEntity, Long> {

}
