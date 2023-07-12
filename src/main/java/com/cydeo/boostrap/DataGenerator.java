package com.cydeo.boostrap;

import com.cydeo.repository.RegionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataGenerator implements CommandLineRunner {

    private final RegionRepository regionRepository;

    public DataGenerator(RegionRepository regionRepository) {
        this.regionRepository = regionRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("-------------------REGION START--------------------");

        System.out.println("findByCountry" + regionRepository.findByCountry("Canada"));

        System.out.println("Find unique" + regionRepository.findDistinctByCountry("United States"));

        System.out.println("-------------------REGION END--------------------");

    }
}
