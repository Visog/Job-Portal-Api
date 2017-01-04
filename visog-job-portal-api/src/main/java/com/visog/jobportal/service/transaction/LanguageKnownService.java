package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.LanguageKnown;
import com.visog.jobportal.req.transaction.LanguageKnownReq;
import com.visog.jobportal.res.transaction.LanguageKnownRes;

public interface LanguageKnownService {
	
	public void saveLanguageKnown(LanguageKnownReq req);
	
	public void updateLanguageKnown(LanguageKnownReq req,String lanhguageKnownId);
	
	public List<LanguageKnownRes> getLanguageKnown();
	
	public LanguageKnownRes getLanguageKnown(String Id);
	public Boolean deleteLanguageKnown(String lanhguageKnownId);

}
