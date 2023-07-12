package com.cydeo.repository;

import com.cydeo.entity.Region;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegionRepository extends JpaRepository<Region,Long> {

    //display all regions in Canada
    List<Region> findByCountry(String country);

    //display all regions in Canada without duplicates
    List<Region> findDistinctByCountry(String country);






}
