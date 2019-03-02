package com.avalah.clientlist.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avalah.clientlist.model.Country;

@Repository("countryRepository")
public interface CountryRepository extends JpaRepository<Country, Long> {
}
