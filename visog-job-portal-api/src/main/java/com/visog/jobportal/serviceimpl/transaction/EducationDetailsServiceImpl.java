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
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;
import com.visog.jobportal.service.transaction.EducationDetailsService;
import com.visog.jobportal.utils.DaoUtils;

public class EducationDetailsServiceImpl implements EducationDetailsService {

	private static final Logger logger = Logger.getLogger(EducationDetailsServiceImpl.class);

	@Inject
	EducationDetailsDao dao;

	/**
	 * @author Raghava
	 */

	public void saveEducationDetails(EducationDetailsReq req) {
		EducationDetails educationDetails = new EducationDetails();
		Users users = new Users();
		Courses courses = new Courses();
		Specilization specialization = new Specilization();
		EducationType educationType = new EducationType();
		University university = new University();
		
		users.setId(req.getUser());
	
		courses.setId(req.getCourses());
		
		specialization.setId(req.getSpecialization());
		educationType.setId(req.getEducationtype());
		university.setId(req.getUniversity());

		educationDetails.setDurationFrom(req.getDurationfrom());
		educationDetails.setDurationTo(req.getDurationto());
		educationDetails.setUser(users);
		educationDetails.setCourses(courses);
		educationDetails.setSpecialization(specialization);
		educationDetails.setEducationType(educationType);
		educationDetails.setUniversity(university);

		DaoUtils.setEntityCreateAuditColumns(educationDetails);
		
		dao.save(educationDetails);
		
		logger.info("educationDetails created successfully : " + educationDetails.getId());

	}

	public void updateEducationDetails(EducationDetailsReq req, String educationdetailsId) {

		EducationDetails educationDetails = (EducationDetails) dao.getByKey(EducationDetails.class, educationdetailsId);

		Users users = new Users();
		Courses courses = new Courses();
		Specilization specialization = new Specilization();
		EducationType educationType = new EducationType();
		University university = new University();
		
		users.setId(req.getUser());
	
		courses.setId(req.getCourses());
		
		specialization.setId(req.getSpecialization());
		educationType.setId(req.getEducationtype());
		university.setId(req.getUniversity());

		educationDetails.setDurationFrom(req.getDurationfrom());
		educationDetails.setDurationTo(req.getDurationto());
		educationDetails.setUser(users);
		educationDetails.setCourses(courses);
		educationDetails.setSpecialization(specialization);
		educationDetails.setEducationType(educationType);
		educationDetails.setUniversity(university);
	}

	public List<EducationDetailsRes> getEducationDetails() {

		List<EducationDetails> educationDetails=dao.getEducationDetails();
		List<EducationDetailsRes> educationDetailsList =new ArrayList<>();
		
		EducationDetailsRes educationDetailsRes=null;
		
	
		return null;
	}


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public EducationDetailsRes getEducationDetail(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean deleteEducationDetails(String educationdetailsId) {
		// TODO Auto-generated method stub
		return null;
	}

}
