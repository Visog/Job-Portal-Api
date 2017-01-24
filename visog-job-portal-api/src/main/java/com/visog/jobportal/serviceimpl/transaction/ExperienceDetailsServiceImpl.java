package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;
import com.visog.jobportal.service.transaction.ExperienceDetailsService;
import com.visog.jobportal.utils.DaoUtils;
/**
 * 
 * @author ShivaPrasad
 *
 */
public class ExperienceDetailsServiceImpl implements ExperienceDetailsService {
	
	private static final Logger logger = Logger.getLogger(ExperienceDetailsServiceImpl.class);

	@Inject
	private ExperienceDetailsDao dao;

	/***
	 * This method Saves Experience Details
	 */
	public void saveExperienceDetails(ExperienceDetailsReq req) {
		
		ExperienceDetails experienceDetails = new ExperienceDetails();
		
		Users users = new Users();
		EmploymentType employmentType = new EmploymentType();

		users.setId(req.getUser());
		experienceDetails.setUser(users);

		employmentType.setId(req.getEmploymentType());
		experienceDetails.setEmploymentType(employmentType);

		experienceDetails.setCompanyName(req.getCompanyName());
		experienceDetails.setDurationFrom(req.getDurationFrom());
		experienceDetails.setDurationTo(req.getDurationTo());
		experienceDetails.setDesignation(req.getDesignation());
		experienceDetails.setJobProfile(req.getJobProfile());
		
		DaoUtils.setEntityCreateAuditColumns(experienceDetails);
		dao.save(experienceDetails);
		logger.info("experiencedetails created successfully : " + experienceDetails.getId());
		

	}
	/***
	 * this gives details of given ID
	 */

	public ExperienceDetailsRes getexperienceDetails(String id) {
		
		ExperienceDetails experienceDetails = (ExperienceDetails) dao.getByKey(ExperienceDetails.class, id);

		ExperienceDetailsRes experienceDetailsRes = new ExperienceDetailsRes();
	
		experienceDetailsRes.setId(experienceDetails.getId());
		experienceDetailsRes.setCompanyName(experienceDetails.getCompanyName());
		experienceDetailsRes.setUser(experienceDetails.getUser().getId());
		experienceDetailsRes.setEmploymentType(experienceDetails.getEmploymentType().getId());
		experienceDetailsRes.setDurationFrom(experienceDetails.getDurationFrom());
		experienceDetailsRes.setDurationTo(experienceDetails.getDurationTo());
		experienceDetailsRes.setJobProfile(experienceDetails.getJobProfile());
		experienceDetailsRes.setDesignation(experienceDetails.getDesignation());
		
		return experienceDetailsRes;
	}

	
	public void updateExperienceDetails(ExperienceDetailsReq req, String experienceDetailsId) {
		
		ExperienceDetails experienceDetails  = (ExperienceDetails) dao.getByKey(ExperienceDetails.class, experienceDetailsId); 
		
		EmploymentType employmentType = new EmploymentType();
		employmentType.setId(req.getEmploymentType());

		Users users = new Users();
		users.setId(req.getUser());
		
		experienceDetails.setEmploymentType(employmentType);
		experienceDetails.setCompanyName(req.getCompanyName());
		experienceDetails.setUser(users);
		experienceDetails.setDesignation(req.getDesignation());
		experienceDetails.setDurationFrom(req.getDurationFrom());
		experienceDetails.setDurationTo(req.getDurationTo());
		experienceDetails.setJobProfile(req.getJobProfile());
		
		dao.update(experienceDetails);
		logger.info("experienceDetails updated successfully : " + experienceDetails.getId());

		
	}
/**
 * this deletes experience details
 */
	
	public Boolean deleteExperienceDetails(String experienceDetailsId) {
		
		return (dao.delete(ExperienceDetails.class, experienceDetailsId) != 0);
	}

	/**
	 * this give list of experience details
	 */

	public List<ExperienceDetailsRes> getExperienceDetails() {
		
		List<ExperienceDetails> experienceDetails = dao.getExperienceDetails();

		List<ExperienceDetailsRes>  experienceDetailsList = new ArrayList<>();
		
		ExperienceDetailsRes experienceDetailsRes = null;

		
		for(ExperienceDetails experienceDetail:experienceDetails){
			experienceDetailsRes=new ExperienceDetailsRes();
			experienceDetailsRes.setId(experienceDetail.getId());
			experienceDetailsRes.setCompanyName(experienceDetail.getCompanyName());
			experienceDetailsRes.setUser(experienceDetail.getUser().getId());
			experienceDetailsRes.setEmploymentType(experienceDetail.getEmploymentType().getId());
			experienceDetailsRes.setDurationFrom(experienceDetail.getDurationFrom());
			experienceDetailsRes.setDurationTo(experienceDetail.getDurationTo());
			experienceDetailsRes.setJobProfile(experienceDetail.getJobProfile());
			experienceDetailsRes.setDesignation(experienceDetail.getDesignation());
			experienceDetailsList
			.add(experienceDetailsRes);
			logger.info("experienceDetails get data : " + experienceDetail.getId());
		}
	

		return experienceDetailsList;
	}

	
}
