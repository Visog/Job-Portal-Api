package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.IndustryReq;
import com.visog.jobportal.res.master.IndustryRes;


public interface IndustryService {
	
	public void saveIndustry(IndustryReq req);

	public void updateIndustry(IndustryReq req, String industryId);

	public List<IndustryRes> getIndustry();

	public IndustryRes getIndustry(String id);

	public Boolean deleteIndustry(String industryId);

}
