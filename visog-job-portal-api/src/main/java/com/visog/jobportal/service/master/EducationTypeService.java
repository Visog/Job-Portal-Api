package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.EducationTypeReq;
import com.visog.jobportal.res.master.EducationTypeRes;

public interface EducationTypeService {
	
public void saveEducationType(EducationTypeReq req);
	
	public void updateEducationType(EducationTypeReq req, String educationtypeId);
	
	public List<EducationTypeRes> getEducationTypes();
	
	public EducationTypeRes getEducationType(String id);
	
	public Boolean deleteEducationType(String educationtypeId);
}
