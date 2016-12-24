package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.CityReq;
import com.visog.jobportal.res.master.CityRes;

public interface CityService {

	public Boolean saveCity(CityReq req);

	public Boolean updateCity(CityReq req, String cityId);

	public List<CityRes> getCities();

	public CityRes getCity(String id);

	public Boolean deleteCity(String cityId);

}
