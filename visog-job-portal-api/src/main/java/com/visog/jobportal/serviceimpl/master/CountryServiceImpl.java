package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.CountryDao;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.req.master.CountryReq;
import com.visog.jobportal.res.master.CountryRes;
import com.visog.jobportal.service.master.CountryService;
import com.visog.jobportal.utils.DaoUtils;

public class CountryServiceImpl implements CountryService {

	private static final Logger logger = Logger.getLogger(CountryServiceImpl.class);

	@Inject
	CountryDao dao;	

	/**
	 * This method saves the Country
	 */

	public Boolean saveCountry(CountryReq req) {

		Country country = new Country();
		country.setCode(req.getCode());
		country.setName(req.getName());
		//country.setOrderNum(req.getOrderNum());
		DaoUtils.setEntityCreateAuditColumns(country);

		if (dao.isCountryExists(req.getName())) {

			logger.info("Countries Created Successfully" + country.getId());
			return false;

		} else {

			dao.save(country);
			logger.info("Countries Created Successfully" + country.getId());

			return true;
		}

	}

	/**
	 * This method updates the Country
	 */

	public Boolean updateCountry(CountryReq req, String countryId) {

		Country country = (Country) dao.getByKey(Country.class, countryId);
		
		logger.info("Country Exists :"+country.getName().toLowerCase().trim());
		logger.info("Country new :"+req.getName().toLowerCase().trim());

		if (country.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				||(!dao.isCountryExists(req.getName()))) {
			country.setCode(req.getCode());
			country.setName(req.getName());
			//country.setOrderNum(req.getOrderNum());
			dao.update(country);

			logger.info("Countries Updated Successfully" + country.getId());
			return true;
			
		} else {
			
			logger.info("Country already Exists:" +country.getId());
			return false;

		}

		

	}

	/**
	 * This method returns all the countries
	 */
	public List<CountryRes> getCountries() {

		List<Country> countries = dao.getCountries();
		List<CountryRes> countryList = new ArrayList<>();
		CountryRes countryRes = null;

		for (Country country : countries) {

			countryRes = new CountryRes();
			countryRes.setId(country.getId());
			countryRes.setCode(country.getCode());
			countryRes.setName(country.getName());
			//countryRes.setOrderNum(country.getOrderNum());
			countryList.add(countryRes);

		}

		return countryList;
	}

	/**
	 * This method returns country Details for the given country id
	 */
	public CountryRes getCountry(String id) {

		Country country = (Country) dao.getByKey(Country.class, id);

		CountryRes countryRes = new CountryRes();
		countryRes.setId(country.getId());
		countryRes.setCode(country.getCode());
		countryRes.setName(country.getName());
	//countryRes.setOrderNum(country.getOrderNum());
		return countryRes;
	}

	public Boolean deleteCountry(String countryId) {
		return (dao.delete(Country.class, countryId) != 0);
	}

}
