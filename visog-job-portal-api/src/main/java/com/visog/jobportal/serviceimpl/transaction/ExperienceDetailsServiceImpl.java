package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;
import com.visog.jobportal.service.transaction.ExperienceDetailsService;
import com.visog.jobportal.utils.DaoUtils;

public class ExperienceDetailsServiceImpl implements ExperienceDetailsService {
	private static final Logger logger = Logger.getLogger(ExperienceDetails.class);
	
	@Inject
	ExperienceDetailsDao dao;
	
	
	public void saveExperienceDetails(ExperienceDetailsReq req) {
		
		ExperienceDetails experiencedetails=new ExperienceDetails();
		Users users =new Users();
		users.setId(req.getUser());
		
		experiencedetails.setUser(users);
		experiencedetails.setCompanyName(req.getCompanyName());
		experiencedetails.setEmploymentType(req.getEmploymentType());
		experiencedetails.setDurationFrom(req.getDurationFrom());
		experiencedetails.setDurationTo(req.getDurationTo());
		experiencedetails.setDesignation(req.getDesignation());
		experiencedetails.setJobProfile(req.getJobProfile());
		

		 dao.save(experiencedetails);
		// DaoUtils.setEntityCreateAuditColumns(experiencedetails);
		 logger.info("experiencedetails created successfully : " + experiencedetails.getId());
		
		
		
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
		experienceDetailsRes.setUser(experiencedetails.getUser().getId());
		
		return experienceDetailsRes;
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
		
		dao.update(experiencedetails);
		logger.info("experiencedetails updated successfully : " + experiencedetails.getId());
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
			Users users =new Users();
			ExperienceDetailsRes experiencedetailsRes=new ExperienceDetailsRes();
			experiencedetailsRes.setId(experiencedetail.getId());
			experiencedetailsRes.setUser(experiencedetail.getUser().getId());
			experiencedetailsRes.setCompanyName(experiencedetail.getCompanyName());
			experiencedetailsRes.setEmploymentType(experiencedetail.getEmploymentType());
			experiencedetailsRes.setDurationFrom(experiencedetail.getDurationFrom());
			experiencedetailsRes.setDurationTo(experiencedetail.getDurationTo());
			experiencedetailsRes.setDesignation(experiencedetail.getDesignation());
			experiencedetailsRes.setJobProfile(experiencedetail.getJobProfile());
			
		}
		
		return experienceDetailsList;
	}
	

}
