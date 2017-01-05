package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.EmployerDao;
import com.visog.jobportal.model.master.EmployerType;
import com.visog.jobportal.model.master.EmploymentType;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.model.transaction.Employer;
import com.visog.jobportal.model.transaction.JobSeeker;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.EmployerReq;
import com.visog.jobportal.res.transaction.EmployerRes;
import com.visog.jobportal.res.transaction.JobSeekerRes;
import com.visog.jobportal.service.transaction.EmployerService;
import com.visog.jobportal.utils.DaoUtils;

public class EmployerServiceImpl implements EmployerService {

	private static final Logger logger = Logger.getLogger(EmployerServiceImpl.class);

	@Inject
	EmployerDao dao;

	/**
	 * @author Raghava
	 */

	public void saveEmployer(EmployerReq req) {

		Users users = new Users();
		users.setId(req.getUser());

		Industry industry = new Industry();
		industry.setId(req.getIndustry());

		EmployerType employerType = new EmployerType();
		employerType.setId(req.getEmployerType());

		Employer employer = new Employer();

		employer.setUser(users);
		employer.setIndustry(industry);
		employer.setEmployerType(employerType);
		employer.setPremiumEmployer(req.getPremiumEmployer());
		employer.setCompanyName(req.getCompanyName());
		employer.setRegisteredDate(req.getRegisteredDate());
		employer.setCin(req.getCin());
		employer.setRegistrationNumber(req.getRegistrationNumber());

		DaoUtils.setEntityCreateAuditColumns(employer);
		dao.save(employer);

		logger.info(" Employer Saved Successfully" + employer.getId());

	}

	public void updateEmployer(EmployerReq req, String EmployerId) {
		

		Employer employer=(Employer) dao.getByKey(Employer.class, EmployerId);
		
		Users users = new Users();
		users.setId(req.getUser());
		
		Industry industry = new Industry();
		industry.setId(req.getIndustry());

		EmployerType employerType = new EmployerType();
		employerType.setId(req.getEmployerType());
		employer.setUser(users);
		employer.setIndustry(industry);
		employer.setEmployerType(employerType);
		employer.setPremiumEmployer(req.getPremiumEmployer());
		employer.setCompanyName(req.getCompanyName());
		employer.setRegisteredDate(req.getRegisteredDate());
		employer.setCin(req.getCin());
		employer.setRegistrationNumber(req.getRegistrationNumber());

		dao.update(employer);
		logger.info("PostJob updated Successfully" + employer.getId());
	}

	public List<EmployerRes> getEmployers() {

		List<Employer> employer = dao.getEmployers();

		List<EmployerRes> employerList = new ArrayList<>();

		EmployerRes employerRes = null;

		Users users = new Users();

		Industry industry = new Industry();

		EmployerType employerType = new EmployerType();

		for (Employer employers : employer) {

			employerRes = new EmployerRes();

			employerRes.setUser(employers.getUser().getId());
			employerRes.setId(employers.getId());
			employerRes.setIndustry(employers.getIndustry().getId());
			employerRes.setEmployerType(employers.getEmployerType().getId());
			employerRes.setPremiumEmployer(employers.getPremiumEmployer());
			employerRes.setCompanyName(employers.getCompanyName());
			employerRes.setRegisteredDate(employers.getRegisteredDate());
			employerRes.setCin(employers.getCin());
			employerRes.setRegistrationNumber(employers.getRegistrationNumber());

			employerList.add(employerRes);
		}
		return employerList;

	}

	public EmployerRes getEmployer(String id) {
		
		Employer employers= (Employer) dao.getByKey(Employer.class, id);
		
		EmployerRes employerRes=new EmployerRes();
		
		employerRes.setUser(employers.getUser().getId());
		employerRes.setIndustry(employers.getIndustry().getId());
		employerRes.setEmployerType(employers.getEmployerType().getId());
		employerRes.setPremiumEmployer(employers.getPremiumEmployer());
		employerRes.setCompanyName(employers.getCompanyName());
		employerRes.setRegisteredDate(employers.getRegisteredDate());
		employerRes.setCin(employers.getCin());
		employerRes.setRegistrationNumber(employers.getRegistrationNumber());

		
		
		return employerRes;
	}

	public Boolean deleteEmployer(String EmployerId) {
		
		return (dao.delete(Employer.class, EmployerId) != 0);
	}

}
