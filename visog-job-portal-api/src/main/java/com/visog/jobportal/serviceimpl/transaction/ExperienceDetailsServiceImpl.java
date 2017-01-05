package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.ExperienceDetailsDao;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.transaction.ExperienceDetails;
import com.visog.jobportal.model.transaction.ProjectDetails;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.ExperienceDetailsReq;
import com.visog.jobportal.res.transaction.ExperienceDetailsRes;
import com.visog.jobportal.service.transaction.ExperienceDetailsService;
import com.visog.jobportal.utils.DaoUtils;

public class ExperienceDetailsServiceImpl implements ExperienceDetailsService {
	private static final Logger logger = Logger.getLogger(ExperienceDetailsServiceImpl.class);

	@Inject
	ExperienceDetailsDao dao;

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

	/*****
	 * This gives details of given id
	 */

	public ExperienceDetailsRes getexperienceDetails(String experienceDetailsId) {

		ExperienceDetails experienceDetails = (ExperienceDetails) dao.getByKey(ExperienceDetails.class,
				experienceDetailsId);

		ExperienceDetailsRes experienceDetailsRes = new ExperienceDetailsRes();

		experienceDetailsRes.setUser(experienceDetails.getUser().getId());
		experienceDetailsRes.setEmploymentType(experienceDetails.getEmploymentType().getId());
		experienceDetailsRes.setId(experienceDetails.getId());
		experienceDetailsRes.setCompanyName(experienceDetails.getCompanyName());
		experienceDetailsRes.setDurationFrom(experienceDetails.getDurationFrom());
		experienceDetailsRes.setDurationTo(experienceDetails.getDurationTo());
		experienceDetailsRes.setDesignation(experienceDetails.getDesignation());
		experienceDetailsRes.setJobProfile(experienceDetails.getJobProfile());

		return experienceDetailsRes;
	}

	/****
	 * This updates the details
	 */
	public void updateExperienceDetails(ExperienceDetailsReq req, String experienceDetailsId) {

		ExperienceDetails experienceDetails = (ExperienceDetails) dao.getByKey(ExperienceDetails.class,
				experienceDetailsId);

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

		dao.update(experienceDetails);
		logger.info("experiencedetails updated successfully : " + experienceDetails.getId());
	}

	/****
	 * This delete the desired task
	 */
	public Boolean deleteExperienceDetails(String id) {
		return (dao.delete(ExperienceDetails.class, id) != 0);

	}

	public List<ExperienceDetailsRes> getExperienceDetails() {

		List<ExperienceDetails> experienceDetails = dao.getExperienceDetails();
		List<ExperienceDetailsRes> experienceDetailsList = new ArrayList<>();

		ExperienceDetailsRes experienceDetailsRes = null;
		Users users = new Users();
		EmploymentType employmentType = new EmploymentType();
		for (ExperienceDetails experienceDetail : experienceDetails)

		{

			experienceDetailsRes = new ExperienceDetailsRes();

			experienceDetailsRes.setId(experienceDetail.getId());
			experienceDetailsRes.setUser(experienceDetail.getUser().getId());
			experienceDetailsRes.setEmploymentType(experienceDetail.getEmploymentType().getId());
			experienceDetailsRes.setCompanyName(experienceDetail.getCompanyName());
			experienceDetailsRes.setDurationFrom(experienceDetail.getDurationFrom());
			experienceDetailsRes.setDurationTo(experienceDetail.getDurationTo());
			experienceDetailsRes.setDesignation(experienceDetail.getDesignation());
			experienceDetailsRes.setJobProfile(experienceDetail.getJobProfile());

		}

		return experienceDetailsList;
	}

}
