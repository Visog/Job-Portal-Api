package com.visog.jobportal.serviceimpl.employer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.employer.EmployerDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.employer.Employer;
import com.visog.jobportal.model.master.EmployerType;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.req.employer.EmployerReq;
import com.visog.jobportal.res.employer.EmployerRes;
import com.visog.jobportal.service.employer.EmployerService;
import com.visog.jobportal.utils.DaoUtils;

public class EmployerServiceImpl implements EmployerService {

	private static final Logger logger = Logger.getLogger(EmployerServiceImpl.class);

	@Inject
	EmployerDao dao;

	/**
	 * @author Raghava
	 */
	public void saveEmployer(EmployerReq req) {

		Employer employer = new Employer();

		Users users = new Users();
		users.setId(req.getUser());
		employer.setUser(users);

		Industry industry = new Industry();
		industry.setId(req.getIndustry());
		employer.setIndustry(industry);

		EmployerType employerType = new EmployerType();
		employerType.setId(req.getEmployerType());
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

	public void updateEmployer(EmployerReq req, String employerId) {

		Employer employer = (Employer) dao.getByKey(Employer.class, employerId);


		Users users = new Users();
		users.setId(req.getUser());
		employer.setUser(users);

		Industry industry = new Industry();
		industry.setId(req.getIndustry());
		employer.setIndustry(industry);

		EmployerType employerType = new EmployerType();
		employerType.setId(req.getEmployerType());
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

		Employer employers = (Employer) dao.getByKey(Employer.class, id);

		EmployerRes employerRes = new EmployerRes();

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

	public Boolean deleteEmployer(String employerId) {

		return (dao.delete(Employer.class, employerId) != 0);
	}

}
