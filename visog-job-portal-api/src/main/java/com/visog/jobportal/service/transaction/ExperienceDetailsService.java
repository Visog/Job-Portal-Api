package com.visog.jobportal.service.transaction;

import java.util.List;

import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;

public interface ExperienceDetailsService {

	public void saveExperienceDetails(ExperienceDetailsReq req);

	public ExperienceDetailsRes getexperienceDetails(String experienceDetailsId);

	public void updateExperienceDetails(ExperienceDetailsReq req, String experienceDetailsId);

	public Boolean deleteExperienceDetails(String id);

	public List<ExperienceDetailsRes> getExperienceDetails();

}
