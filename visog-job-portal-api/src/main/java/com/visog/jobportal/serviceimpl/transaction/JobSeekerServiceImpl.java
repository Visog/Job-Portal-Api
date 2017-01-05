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

		Users users = new Users();
		users.setId(req.getUser());
		
		Domains domain = new Domains();
		domain.setId(req.getDomain());

		JobRole jobrole = new JobRole();
		jobrole.setId(req.getJobRole());

		Industry industry = new Industry();
		industry.setId(req.getIndustry());

		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());

		JobSeeker jobseeker = new JobSeeker();

		jobseeker.setResumeHeadline(req.getResumeHeadline());
		jobseeker.setCompanyName(req.getCompanyName());

		jobseeker.setUser(users);
		jobseeker.setEmploymentType(employment);
		jobseeker.setIndustry(industry);
		jobseeker.setHobbiesAndInterest(req.getHobbiesAndInterest());
		jobseeker.setProfileSummary(req.getProfileSummary());
		jobseeker.setWorkExperienceMonths(req.getWorkExperienceMonths());
		jobseeker.setWorkExperienceYears(req.getWorkExperienceYears());
		jobseeker.setKeySkills(req.getKeySkills());
		
		jobseeker.setOtherJobRole(req.getJobRole());
		jobseeker.setUser(users);
		jobseeker.setDomain(domain);
		jobseeker.setEmploymentType(employment);
		jobseeker.setIndustry(industry);
		jobseeker.setJobRole(jobrole);

		
		jobseeker.setJobRole(jobrole);

		DaoUtils.setEntityCreateAuditColumns(jobseeker);
		dao.save(jobseeker);

		logger.info(" jobseeker Successfully" + jobseeker.getId());

	}

	public void updateJobSeeker(JobSeekerReq req, String jobseekerId) {
		JobSeeker jobseeker=(JobSeeker) dao.getByKey(JobSeeker.class, jobseekerId);

		Users users = new Users();
		users.setId(req.getUser());
		
		Domains domain = new Domains();
		domain.setId(req.getDomain());

		JobRole jobrole = new JobRole();
		jobrole.setId(req.getJobRole());

		Industry industry = new Industry();
		industry.setId(req.getIndustry());

		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());

		
		jobseeker.setResumeHeadline(req.getResumeHeadline());
		jobseeker.setCompanyName(req.getCompanyName());
		jobseeker.setUser(users);
		jobseeker.setEmploymentType(employment);
		jobseeker.setJobRole(jobrole);
		jobseeker.setHobbiesAndInterest(req.getHobbiesAndInterest());
		jobseeker.setProfileSummary(req.getProfileSummary());
		jobseeker.setWorkExperienceMonths(req.getWorkExperienceMonths());
		jobseeker.setWorkExperienceYears(req.getWorkExperienceYears());
		jobseeker.setKeySkills(req.getKeySkills());
		jobseeker.setIndustry(industry);
		jobseeker.setOtherJobRole(req.getJobRole());
		jobseeker.setDomain(domain);
		
		dao.update(jobseeker);
		logger.info(" jobseeker Successfully" + jobseeker.getId());

	}

	public List<JobSeekerRes> getJobSeekers() {

		List<JobSeeker> jobseeker = dao.getJobSeekers();
		List<JobSeekerRes> jobSeekerList = new ArrayList<>();

		JobSeekerRes jobSeekerRes = null;

		Users users = new Users();

		Domains domain = new Domains();

		JobRole jobrole = new JobRole();

		Industry industry = new Industry();

		EmploymentType employment = new EmploymentType();

		for (JobSeeker jobseekers : jobseeker) {
			jobSeekerRes = new JobSeekerRes();

			jobSeekerRes.setId(jobseekers.getId());

			jobSeekerRes.setUser(jobseekers.getUser().getId());
			jobSeekerRes.setDomain(jobseekers.getDomain().getId());
			jobSeekerRes.setJobRole(jobseekers.getJobRole().getId());
			jobSeekerRes.setIndustry(jobseekers.getIndustry().getId());
			jobSeekerRes.setEmploymentType(jobseekers.getEmploymentType().getId());

			jobSeekerRes.setCompanyName(jobseekers.getCompanyName());
			jobSeekerRes.setHobbiesAndInterest(jobseekers.getHobbiesAndInterest());
			jobSeekerRes.setKeySkills(jobseekers.getKeySkills());
			jobSeekerRes.setOtherJobRole(jobseekers.getOtherJobRole());
			jobSeekerRes.setProfileSummary(jobseekers.getProfileSummary());
			jobSeekerRes.setWorkExperienceMonths(jobseekers.getWorkExperienceMonths());
			jobSeekerRes.setWorkExperienceYears(jobseekers.getWorkExperienceYears());
			jobSeekerRes.setOtherJobRole(jobseekers.getOtherJobRole());
			jobSeekerRes.setResumeHeadline(jobseekers.getResumeHeadline());

			jobSeekerList.add(jobSeekerRes);

		}

		return jobSeekerList;
	}

	public JobSeekerRes getJobSeeker(String id) {

		JobSeeker jobseekers = (JobSeeker) dao.getByKey(JobSeeker.class, id);
		JobSeekerRes jobSeekerRes = new JobSeekerRes();

		jobSeekerRes.setUser(jobseekers.getUser().getId());
		jobSeekerRes.setDomain(jobseekers.getDomain().getId());
		jobSeekerRes.setJobRole(jobseekers.getJobRole().getId());
		jobSeekerRes.setIndustry(jobseekers.getIndustry().getId());
		jobSeekerRes.setEmploymentType(jobseekers.getEmploymentType().getId());

		jobSeekerRes.setCompanyName(jobseekers.getCompanyName());
		jobSeekerRes.setHobbiesAndInterest(jobseekers.getHobbiesAndInterest());
		jobSeekerRes.setKeySkills(jobseekers.getKeySkills());
		jobSeekerRes.setOtherJobRole(jobseekers.getOtherJobRole());
		jobSeekerRes.setProfileSummary(jobseekers.getProfileSummary());
		jobSeekerRes.setWorkExperienceMonths(jobseekers.getWorkExperienceMonths());
		jobSeekerRes.setWorkExperienceYears(jobseekers.getWorkExperienceYears());
		jobSeekerRes.setOtherJobRole(jobseekers.getOtherJobRole());
		jobSeekerRes.setResumeHeadline(jobseekers.getResumeHeadline());

		return jobSeekerRes;
	}

	public Boolean deleteJobSeeker(String jobseekerId) {

		return (dao.delete(JobSeeker.class, jobseekerId) != 0);
	}

}
