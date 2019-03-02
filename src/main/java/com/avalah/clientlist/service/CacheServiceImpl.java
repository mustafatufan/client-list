package com.avalah.clientlist.service;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.avalah.clientlist.model.Country;
import com.avalah.clientlist.repository.CountryRepository;

@Service("cacheService")
public class CacheServiceImpl implements CacheService {

	private CountryRepository countryRepository;

	private List<Country> countryList;

	@PostConstruct
	public void init() {
		this.setCountryList(countryRepository.findAll());
	}

	@Override
	public List<Country> getCountryList() {
		return countryList;
	}

	private void setCountryList(List<Country> countryList) {
		this.countryList = countryList;
	}

	@Autowired
	@Qualifier("countryRepository")
	public void setCountryRepository(CountryRepository countryRepository) {
		this.countryRepository = countryRepository;
	}
}
