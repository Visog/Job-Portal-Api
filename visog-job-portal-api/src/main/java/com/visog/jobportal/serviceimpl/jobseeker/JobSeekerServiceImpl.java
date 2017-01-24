package com.visog.jobportal.serviceimpl.jobseeker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.jobseeker.JobSeekerDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.jobseeker.JobSeeker;
import com.visog.jobportal.model.master.Domains;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.model.master.JobRole;
import com.visog.jobportal.req.common.JobSeekerReq;
import com.visog.jobportal.res.transaction.JobSeekerRes;
import com.visog.jobportal.service.jobseeeker.JobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

public class JobSeekerServiceImpl implements JobSeekerService {

	private static final Logger logger = Logger.getLogger(JobSeekerServiceImpl.class);

	@Inject
	JobSeekerDao dao;

	/**
	 * @author Raghava
	 */

	public void saveJObSeeker(JobSeekerReq req) {
		JobSeeker jobseeker = new JobSeeker();

		Users users = new Users();
		users.setId(req.getUser());
		jobseeker.setUser(users);

		Domains domain = new Domains();
		domain.setId(req.getDomain());
		jobseeker.setDomain(domain);

		JobRole jobrole = new JobRole();
		jobrole.setId(req.getJobRole());
		jobseeker.setJobRole(jobrole);

		Industry industry = new Industry();
		industry.setId(req.getIndustry());
		jobseeker.setIndustry(industry);

		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());
		jobseeker.setEmploymentType(employment);

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

		jobseeker.setJobRole(jobrole);

		DaoUtils.setEntityCreateAuditColumns(jobseeker);
		dao.save(jobseeker);

		logger.info(" jobseeker Saved Successfully" + jobseeker.getId());

	}

	public void updateJobSeeker(JobSeekerReq req, String jobseekerId) {
		JobSeeker jobseeker = (JobSeeker) dao.getByKey(JobSeeker.class, jobseekerId);

		Users users = new Users();
		users.setId(req.getUser());
		jobseeker.setUser(users);

		Domains domain = new Domains();
		domain.setId(req.getDomain());
		jobseeker.setDomain(domain);

		JobRole jobrole = new JobRole();
		jobrole.setId(req.getJobRole());
		jobseeker.setJobRole(jobrole);

		Industry industry = new Industry();
		industry.setId(req.getIndustry());
		jobseeker.setIndustry(industry);

		EmploymentType employment = new EmploymentType();
		employment.setId(req.getEmploymentType());
		jobseeker.setEmploymentType(employment);

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

		jobseeker.setJobRole(jobrole);

		dao.update(jobseeker);

		logger.info("Job Seeker updated Successfully" + jobseeker.getId());

	}

	public List<JobSeekerRes> getJobSeekers() {

		List<JobSeeker> jobSeeker = dao.getJobSeekers();
		List<JobSeekerRes> jobSeekerList = new ArrayList<>();

		JobSeekerRes jobSeekerRes = null;

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
