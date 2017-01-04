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
		jobseeker.setId(req.getJobRole());
		jobseeker.setOtherJobRole(req.getJobRole());
		jobseeker.setJobRole(jobrole);

		DaoUtils.setEntityCreateAuditColumns(jobseeker);
		dao.save(jobseeker);

		logger.info(" postjob Successfully" + jobseeker.getId());

	}

	public void updateJobSeeker(JobSeekerReq req, String jobseekerId) {
		JobSeeker jobSeeker=(JobSeeker) dao.getByKey(JobSeeker.class, jobseekerId);

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

		
		jobSeeker.setResumeHeadline(req.getResumeHeadline());
		jobSeeker.setCompanyName(req.getCompanyName());
		jobSeeker.setUser(users);
		jobSeeker.setEmploymentType(employment);
		jobSeeker.setJobRole(jobrole);
		jobSeeker.setHobbiesAndInterest(req.getHobbiesAndInterest());
		jobSeeker.setProfileSummary(req.getProfileSummary());
		jobSeeker.setWorkExperienceMonths(req.getWorkExperienceMonths());
		jobSeeker.setWorkExperienceYears(req.getWorkExperienceYears());
		jobSeeker.setKeySkills(req.getKeySkills());
		jobSeeker.setIndustry(industry);
		jobSeeker.setOtherJobRole(req.getJobRole());
		jobSeeker.setDomain(domain);

	}

	public List<JobSeekerRes> getJobSeekers() {

		List<JobSeeker> jobSeeker = dao.getJobSeekers();
		List<JobSeekerRes> jobSeekerList = new ArrayList<>();

		JobSeekerRes jobSeekerRes = null;

		Users users = new Users();

		Domains domain = new Domains();

		JobRole jobrole = new JobRole();

		Industry industry = new Industry();

		EmploymentType employment = new EmploymentType();

		for (JobSeeker jobSeekers : jobSeeker) {
			jobSeekerRes = new JobSeekerRes();

			jobSeekerRes.setId(jobSeekers.getId());

			jobSeekerRes.setUser(jobSeekers.getUser().getId());
			jobSeekerRes.setDomain(jobSeekers.getDomain().getId());
			jobSeekerRes.setJobRole(jobSeekers.getJobRole().getId());
			jobSeekerRes.setIndustry(jobSeekers.getIndustry().getId());
			jobSeekerRes.setEmploymentType(jobSeekers.getEmploymentType().getId());

			jobSeekerRes.setCompanyName(jobSeekers.getCompanyName());
			jobSeekerRes.setHobbiesAndInterest(jobSeekers.getHobbiesAndInterest());
			jobSeekerRes.setKeySkills(jobSeekers.getKeySkills());
			jobSeekerRes.setOtherJobRole(jobSeekers.getOtherJobRole());
			jobSeekerRes.setProfileSummary(jobSeekers.getProfileSummary());
			jobSeekerRes.setWorkExperienceMonths(jobSeekers.getWorkExperienceMonths());
			jobSeekerRes.setWorkExperienceYears(jobSeekers.getWorkExperienceYears());
			jobSeekerRes.setOtherJobRole(jobSeekers.getOtherJobRole());
			jobSeekerRes.setResumeHeadline(jobSeekers.getResumeHeadline());

			jobSeekerList.add(jobSeekerRes);

		}

		return jobSeekerList;
	}

	public JobSeekerRes getJobSeeker(String id) {

		JobSeeker jobSeekers = (JobSeeker) dao.getByKey(JobSeeker.class, id);
		JobSeekerRes jobSeekerRes = new JobSeekerRes();

		jobSeekerRes.setUser(jobSeekers.getUser().getId());
		jobSeekerRes.setDomain(jobSeekers.getDomain().getId());
		jobSeekerRes.setJobRole(jobSeekers.getJobRole().getId());
		jobSeekerRes.setIndustry(jobSeekers.getIndustry().getId());
		jobSeekerRes.setEmploymentType(jobSeekers.getEmploymentType().getId());

		jobSeekerRes.setCompanyName(jobSeekers.getCompanyName());
		jobSeekerRes.setHobbiesAndInterest(jobSeekers.getHobbiesAndInterest());
		jobSeekerRes.setKeySkills(jobSeekers.getKeySkills());
		jobSeekerRes.setOtherJobRole(jobSeekers.getOtherJobRole());
		jobSeekerRes.setProfileSummary(jobSeekers.getProfileSummary());
		jobSeekerRes.setWorkExperienceMonths(jobSeekers.getWorkExperienceMonths());
		jobSeekerRes.setWorkExperienceYears(jobSeekers.getWorkExperienceYears());
		jobSeekerRes.setOtherJobRole(jobSeekers.getOtherJobRole());
		jobSeekerRes.setResumeHeadline(jobSeekers.getResumeHeadline());

		return jobSeekerRes;
	}

	public Boolean deleteJobSeeker(String jobseekerId) {

		return (dao.delete(JobSeeker.class, jobseekerId) != 0);
	}

}
