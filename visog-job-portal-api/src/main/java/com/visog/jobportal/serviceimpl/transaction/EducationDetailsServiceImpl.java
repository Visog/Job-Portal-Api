package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.EducationDetailsDao;
import com.visog.jobportal.model.master.Courses;
import com.visog.jobportal.model.master.EducationType;
import com.visog.jobportal.model.master.Specilization;
import com.visog.jobportal.model.master.University;
import com.visog.jobportal.model.transaction.EducationDetails;
import com.visog.jobportal.model.transaction.PostJob;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;
import com.visog.jobportal.service.transaction.EducationDetailsService;
import com.visog.jobportal.utils.DaoUtils;

public class EducationDetailsServiceImpl implements EducationDetailsService {

	private static final Logger logger = Logger.getLogger(EducationDetailsServiceImpl.class);

	@Inject
	private EducationDetailsDao dao;

	/**
	 * @author Raghava
	 */

	public void saveEducationDetails(EducationDetailsReq req) {
		EducationDetails educationdetails = new EducationDetails();
		
		Users users = new Users();
		Courses courses = new Courses();
		Specilization specialization = new Specilization();
		EducationType educationType = new EducationType();
		University university = new University();

		users.setId(req.getUser());

		courses.setId(req.getCourses());

		specialization.setId(req.getSpecialization());
		educationType.setId(req.getEducationType());
		university.setId(req.getUniversity());

		educationdetails.setDurationFromDate(req.getDurationFromDate());
		educationdetails.setDurationToDate(req.getDurationToDate());
		educationdetails.setUser(users);
		educationdetails.setCourses(courses);
		educationdetails.setSpecialization(specialization);
		educationdetails.setEducationType(educationType);
		educationdetails.setUniversity(university);

		DaoUtils.setEntityCreateAuditColumns(educationdetails);

		dao.save(educationdetails);

		logger.info("educationDetails created successfully : " + educationdetails.getId());

	}

	public void updateEducationDetails(EducationDetailsReq req, String educationdetailsId) {
		EducationDetails educationdetails = (EducationDetails) dao.getByKey(EducationDetails.class, educationdetailsId);

		Users users = new Users();
		Courses courses = new Courses();
		Specilization specialization = new Specilization();
		EducationType educationType = new EducationType();
		University university = new University();

		users.setId(req.getUser());

		courses.setId(req.getCourses());

		specialization.setId(req.getSpecialization());
		educationType.setId(req.getEducationType());
		university.setId(req.getUniversity());

		educationdetails.setDurationFromDate(req.getDurationFromDate());
		educationdetails.setDurationToDate(req.getDurationToDate());
		educationdetails.setUser(users);
		educationdetails.setCourses(courses);
		educationdetails.setSpecialization(specialization);
		educationdetails.setEducationType(educationType);
		educationdetails.setUniversity(university);

		dao.update(educationdetails);
		logger.info("Educationdetails updated Successfully" + educationdetails.getId());
	}

	public List<EducationDetailsRes> getEducationDetails() {

		List<EducationDetails> educationdetails = dao.getEducationDetails();
		
		List<EducationDetailsRes> educationDetailsList = new ArrayList<>();

		EducationDetailsRes educationDetailsRes = null;

		for (EducationDetails educationdetail : educationdetails) {

			educationDetailsRes = new EducationDetailsRes();

			educationDetailsRes.setId(educationdetail.getId());

			educationDetailsRes.setCourses(educationdetail.getCourses().getId());

			educationDetailsRes.setSpecialization(educationdetail.getSpecialization().getId());

			educationDetailsRes.setUser(educationdetail.getUser().getId());

			educationDetailsRes.setEducationType(educationdetail.getEducationType().getId());

			educationDetailsRes.setUniversity(educationdetail.getUniversity().getId());

			educationDetailsRes.setDurationFromDate(educationdetail.getDurationFromDate());
			educationDetailsRes.setDurationToDate(educationdetail.getDurationToDate());

			educationDetailsList.add(educationDetailsRes);
		}

		return educationDetailsList;
	}

	public EducationDetailsRes getEducationDetail(String id) {

		EducationDetails educationdetails = (EducationDetails) dao.getByKey(EducationDetails.class, id);

		EducationDetailsRes educationDetailsRes = new EducationDetailsRes();

		educationDetailsRes.setId(educationdetails.getId());
		educationDetailsRes.setCourses(educationdetails.getCourses().getId());

		educationDetailsRes.setSpecialization(educationdetails.getSpecialization().getId());

		educationDetailsRes.setUser(educationdetails.getUser().getId());

		educationDetailsRes.setEducationType(educationdetails.getEducationType().getId());

		educationDetailsRes.setUniversity(educationdetails.getUniversity().getId());

		educationDetailsRes.setDurationFromDate(educationdetails.getDurationFromDate());
		educationDetailsRes.setDurationToDate(educationdetails.getDurationToDate());

		return educationDetailsRes;
	}

	public Boolean deleteEducationDetails(String educationdetailsId) {

		return (dao.delete(EducationDetails.class, educationdetailsId) != 0);
	}

}
