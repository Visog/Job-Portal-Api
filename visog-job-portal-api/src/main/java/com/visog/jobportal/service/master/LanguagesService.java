package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.LanguagesReq;
import com.visog.jobportal.res.master.LanguagesRes;


public interface LanguagesService {
public void saveLanguage(LanguagesReq req);
	
	public void updateLanguage(LanguagesReq req, String languageId);
	
	public List<LanguagesRes> getLanguages();
	
	public LanguagesRes getLanguage(String id);
	
	public Boolean deleteLanguage(String languageId);
	

}
