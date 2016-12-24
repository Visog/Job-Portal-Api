package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.CityDao;
import com.visog.jobportal.model.master.City;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.req.master.CityReq;
import com.visog.jobportal.res.master.CityRes;
import com.visog.jobportal.service.master.CityService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * @author Mubarak
 *
 */
public class CityServiceImpl implements CityService {

	private static final Logger logger = Logger.getLogger(CityServiceImpl.class);

	@Inject
	CityDao dao;

	/**
	 * @author Mubarak
	 * 
	 *         This method saves the City
	 * 
	 * 
	 */
	public Boolean saveCity(CityReq req) {

		City city = new City();
		city.setName(req.getName());
		States states = new States();
		states.setId(req.getState());
		city.setState(states);
		Country country = new Country();
		country.setId(req.getCountry());
		city.setCountry(country);
		DaoUtils.setEntityCreateAuditColumns(city);
		if (dao.isCityExists(req.getName())) {

			logger.info("city already exists:" + city.getId());
			return false;

		} else {

			dao.save(city);

			logger.info("city created successfully : " + city.getId());
			return true;

		}

	}

	/**
	 * This method updates the City
	 */

	public Boolean updateCity(CityReq req, String cityId) {

		City city = (City) dao.getByKey(City.class, cityId);

		logger.info("city Exists:" + city.getName().toLowerCase().trim());
		logger.info("City new :" + req.getName().toLowerCase().trim());

		if (city.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isCityExists(req.getName()))) {

			city.setName(req.getName());
			States states = new States();
			states.setId(req.getState());
			city.setState(states);
			Country country = new Country();
			country.setId(req.getCountry());
			city.setCountry(country);
			dao.update(city);
			logger.info("city updated successfully : " + city.getId());
			return true;

		} else {
			logger.info("city already exists : " + city.getId());
			return false;

		}

	}

	/**
	 * This method returns all the Cities
	 */
	public List<CityRes> getCities() {

		List<City> city = dao.getCities();
		List<CityRes> cityList = new ArrayList<>();

		CityRes cityRes = null;

		States st = new States();
		Country country = new Country();
		for (City cities : city) {

			cityRes = new CityRes();
			cityRes.setId(cities.getId());
			cityRes.setName(cities.getName());

			cityRes.setState(cities.getState().getId());
			cityRes.setCountry(cities.getCountry().getId());

			cityList.add(cityRes);

		}
		return cityList;
	}

	public CityRes getCity(String id) {

		City city = (City) dao.getByKey(City.class, id);

		CityRes cityRes = new CityRes();
		cityRes.setId(city.getId());
		cityRes.setName(city.getName());

		cityRes.setState(city.getState().getId());
		cityRes.setCountry(city.getCountry().getId());

		return cityRes;
	}

	public Boolean deleteCity(String cityId) {
		return (dao.delete(City.class, cityId) != 0);
	}

}
