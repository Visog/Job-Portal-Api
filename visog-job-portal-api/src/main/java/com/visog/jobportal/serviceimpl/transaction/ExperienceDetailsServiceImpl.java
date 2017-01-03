package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;
import com.visog.jobportal.service.transaction.ExperienceDetailsService;

public class ExperienceDetailsServiceImpl implements ExperienceDetailsService {
	@Inject
	ExperienceDetailsDao dao;

	
	
	
	public void saveExperienceDetails(ExperienceDetailsReq req) {
		ExperienceDetails experiencedetails =new ExperienceDetails();
		Users users =new Users();
		users.setId(req.getUser());
		experiencedetails.setUser(users);
		
		experiencedetails.setCompanyName(req.getCompanyName());
		
		experiencedetails.setEmploymentType(req.getEmploymentType());
		
		experiencedetails.setDurationFrom(req.getDurationFrom());
		
		experiencedetails.setDurationTo(req.getDurationTo());
		
		experiencedetails.setDesignation(req.getDesignation());
		
		experiencedetails.setJobProfile(req.getJobProfile());
		
		
	}
/*****
 * This gives details of given id
 */
	
	public ExperienceDetailsRes getexperienceDetails(String Id) {
		
		ExperienceDetails experiencedetails= (ExperienceDetails) dao.getByKey(ExperienceDetails.class, Id);
		
		ExperienceDetailsRes experienceDetailsRes=new ExperienceDetailsRes();
		
		experienceDetailsRes.setId(experiencedetails.getId());
		
		experienceDetailsRes.setCompanyName(experiencedetails.getCompanyName());
		
		experienceDetailsRes.setEmploymentType(experiencedetails.getEmploymentType());
		
		experienceDetailsRes.setDurationFrom(experiencedetails.getDurationFrom());
		
		experienceDetailsRes.setDurationTo(experiencedetails.getDurationTo());
		
		experienceDetailsRes.setDesignation(experiencedetails.getDesignation());
		
		experienceDetailsRes.setJobProfile(experiencedetails.getJobProfile());
		
		return null;
	}

	/****
	 *  This updates  the details
	 */
	public void updateExperienceDetails(ExperienceDetailsReq req, String experiencedetailsId) {
		
		ExperienceDetails experiencedetails= (ExperienceDetails) dao.getByKey(ExperienceDetails.class, experiencedetailsId);
		
		Users users=new Users();
		users.setId(req.getUser());
		experiencedetails.setUser(users);
		
		
		experiencedetails.setCompanyName(experiencedetails.getCompanyName());
		
		experiencedetails.setEmploymentType(experiencedetails.getEmploymentType());
		
		experiencedetails.setDesignation(experiencedetails.getDesignation());
		
		experiencedetails.setDurationFrom(experiencedetails.getDurationFrom());
		
		experiencedetails.setDurationTo(experiencedetails.getDurationTo());
		
		experiencedetails.setJobProfile(experiencedetails.getJobProfile());
		
		
		
		
	}
/****
 * This delete the desired task
 */
	
	public Boolean deleteExperienceDetails(String experienceDetailsId) {
		return (dao.delete(ExperienceDetails.class, experienceDetailsId) != 0);
		
	}

	
	public List<ExperienceDetailsRes> getExperienceDetails() {
		
		
		List<ExperienceDetails> experiencedetails=dao.getExperienceDetails();
		List<ExperienceDetailsRes>experienceDetailsList=new ArrayList<>();
		
		ExperienceDetailsRes experienceDetailsRes=null;
		
		for(ExperienceDetails experiencedetail :  experiencedetails)
			
		{
			
			ExperienceDetailsRes experiencedetailsRes=new ExperienceDetailsRes();
			
			experiencedetailsRes.setId(experiencedetail.getId());
			Users users =new Users();
			experiencedetailsRes.setUser(experiencedetail.getUser().getId());
			
			experiencedetailsRes.setCompanyName(experiencedetail.getCompanyName());
			
			experiencedetailsRes.setEmploymentType(experiencedetail.getEmploymentType());
			
			experiencedetailsRes.setDurationFrom(experiencedetail.getDurationFrom());
			
			experiencedetailsRes.setDurationTo(experiencedetail.getDurationTo());
			
			experiencedetailsRes.setDesignation(experiencedetail.getDesignation());
			
			experiencedetailsRes.setJobProfile(experiencedetail.getJobProfile());
			
			
			
			
		}
		
		return null;
	}
	

}
