package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;

public interface ExperienceDetailsService {
	
		public void saveExperienceDetails(ExperienceDetailsReq req);
		
		public ExperienceDetailsRes getexperienceDetails(String id);
		
		public void updateExperienceDetails(ExperienceDetailsReq req, String userId);
		
		public Boolean deleteExperienceDetails(String experienceDetailsId);
		

		public List<ExperienceDetailsRes> getExperienceDetails();
		
		

}
