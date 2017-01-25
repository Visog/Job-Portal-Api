package com.visog.jobportal.service.jobseeeker;

import java.util.List;

import com.visog.jobportal.req.jobseeker.LanguageKnownReq;
import com.visog.jobportal.res.jobseeker.LanguageKnownRes;


public interface LanguageKnownService {
	
	public void saveLanguageKnown(LanguageKnownReq req);
	
	public void updateLanguageKnown(LanguageKnownReq req,String languageKnownId);
	
	public List<LanguageKnownRes> getLanguageKnown();
	
	public LanguageKnownRes getLanguageKnown(String Id);
	
	public Boolean deleteLanguageKnown(String languageKnownId);

}
