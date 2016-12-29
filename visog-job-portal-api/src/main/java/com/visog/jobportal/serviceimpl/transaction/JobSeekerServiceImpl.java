 package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.JobSeekerDao;
import com.visog.jobportal.model.master.Domains;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.model.master.JobRole;
import com.visog.jobportal.model.transaction.JobSeeker;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.JobSeekerReq;
import com.visog.jobportal.res.transaction.JobSeekerRes;
import com.visog.jobportal.service.transaction.JobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

public class JobSeekerServiceImpl implements JobSeekerService {

	private static final Logger logger = Logger.getLogger(JobSeekerServiceImpl.class);
	
	@Inject
	JobSeekerDao dao;


	/**
	 * @author Raghava
	 */
	
	public void saveJObSeeker(JobSeekerReq req) {

		Users users =new Users();
		users.setId(req.getUser());
		
		Domains domain=new Domains();
		domain.setId(req.getDomain());
		
		JobRole jobrole=new JobRole();
		jobrole.setId(req.getJobRole());
		
		Industry industry =new Industry();
		industry.setId(req.getIndustry());
		
		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());
		
		
		JobSeeker jobseeker =new JobSeeker();
		
	jobseeker.setResumeHeadline(req.getResumeHeadline());
	jobseeker.setCompanyName(req.getCompanyName());
	jobseeker.setId(req.getDomain());
	jobseeker.setId(req.getEmploymentType());
	jobseeker.setId(req.getIndustry());
	jobseeker.setHobbiesAndInterest(req.getHobbiesAndInterest());
    jobseeker.setProfileSummary(req.getProfileSummary());
    jobseeker.setWorkExperienceMonths(req.getWorkExperienceMonths());
    jobseeker.setWorkExperienceYears(req.getWorkExperienceYears());
	jobseeker.setKeySkills(req.getKeySkills());
	jobseeker.setId(req.getJobRole());
	jobseeker.setOtherJobRole(req.getJobRole());
	jobseeker.setId(req.getUser());

	DaoUtils.setEntityCreateAuditColumns(jobseeker);
	dao.save(jobseeker);
	
	logger.info(" postjob Successfully"+jobseeker.getId());

	}

	public void updateJobSeeker(JobSeekerReq req, String jobseekerId) {

		Users users =new Users();
	

		Domains domain=new Domains();
		domain.setId(req.getDomain());
		
		JobRole jobrole=new JobRole();
		jobrole.setId(req.getJobRole());
		
		Industry industry =new Industry();
		industry.setId(req.getIndustry());
		
		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());
		
		
		JobSeeker jobseeker =new JobSeeker();
		
		jobseeker.setResumeHeadline(req.getResumeHeadline());
		jobseeker.setCompanyName(req.getCompanyName());
		jobseeker.setId(req.getDomain());
		jobseeker.setId(req.getEmploymentType());
		jobseeker.setId(req.getIndustry());
		jobseeker.setHobbiesAndInterest(req.getHobbiesAndInterest());
	    jobseeker.setProfileSummary(req.getProfileSummary());
	    jobseeker.setWorkExperienceMonths(req.getWorkExperienceMonths());
	    jobseeker.setWorkExperienceYears(req.getWorkExperienceYears());
		jobseeker.setKeySkills(req.getKeySkills());
		jobseeker.setId(req.getJobRole());
		jobseeker.setOtherJobRole(req.getJobRole());
		jobseeker.setId(req.getUser());
	
	
	}

	
	public List<JobSeekerRes> getJobSeekers() {
		
		
		List<JobSeeker> jobSeeker=dao.getJobSeekers();
		List<JobSeekerRes> jobSeekerList = new ArrayList<>();
		
		JobSeekerRes jobSeekerRes=null;
		
		Users users = new Users();
		
		Domains domain=new Domains();
		
		JobRole jobrole=new JobRole();
		
		Industry industry =new Industry();
		
		EmploymentType employment = new EmploymentType();
		
		
		for(JobSeeker jobSeekers : jobSeeker)
		{
			
	             jobSeekerRes = new JobSeekerRes();
	             
	            
	            
	             
			
			
		}
		
		
		
		return null;
	}

	public JobSeekerRes getJobSeeker(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public Boolean deleteJobSeeker(String jobseekerId) {
		// TODO Auto-generated method stub
		return null;
	}

}  