package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;

public interface EducationDetailsService {
	
	public void saveEducationDetails(EducationDetailsReq req);
	
<<<<<<< HEAD
	public void updateEducationDetails(EducationDetailsReq req ,String educationdetailsId );
=======
	public void updateEducationDetails(EducationDetails req ,String educationDetailsId );
>>>>>>> branch 'master' of https://github.com/Visog/Job-Portal-Api.git
	
	public List<EducationDetailsRes> getEducationDetails();
	
	public EducationDetailsRes getEducationDetail(String id);
	
	public Boolean deleteEducationDetails(String educationDetailsId);

	
	

}
