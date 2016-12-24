package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.CountryReq;
import com.visog.jobportal.res.master.CountryRes;

public interface CountryService {

	public Boolean saveCountry(CountryReq req);

	public Boolean updateCountry(CountryReq req, String countryId);

	public List<CountryRes> getCountries();

	public CountryRes getCountry(String id);

	public Boolean deleteCountry(String countryId);
}
