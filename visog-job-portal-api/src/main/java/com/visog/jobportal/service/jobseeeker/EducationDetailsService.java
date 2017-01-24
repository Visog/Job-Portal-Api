package com.visog.jobportal.service.jobseeeker;

import java.util.List;

import com.visog.jobportal.req.common.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;

public interface EducationDetailsService {

	public void saveEducationDetails(EducationDetailsReq req);

	public void updateEducationDetails(EducationDetailsReq req, String educationdetailsId);

	public List<EducationDetailsRes> getEducationDetails();

	public EducationDetailsRes getEducationDetail(String id);

	public Boolean deleteEducationDetails(String educationdetailsId);

}
