package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.model.transaction.EducationDetails;
import com.visog.jobportal.req.transaction.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;
import com.visog.jobportal.rest.controller.transaction.educationDetailsReq;

public interface EducationDetailsService {
	
	public void saveEducationDetails(EducationDetailsReq req);
	
	public void updateEducationDetails(educationDetailsReq req ,String educationdetailsId );
	
	public List<EducationDetailsRes> getEducationDetails();
	
	public EducationDetailsRes getEducationDetails(String id);
	
	public Boolean deleteEducationDetails(String educationdetailsId);

	
	

}