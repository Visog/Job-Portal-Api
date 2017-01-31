package com.visog.jobportal.serviceimpl.employer;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.dao.common.AddressDao;
import com.visog.jobportal.dao.common.AppCommons;
import com.visog.jobportal.dao.employer.PostJobDao;
import com.visog.jobportal.model.common.Address;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.employer.PostJob;
import com.visog.jobportal.model.master.AddrerssType;
import com.visog.jobportal.model.master.City;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.Currency;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.req.common.AddressReq;
import com.visog.jobportal.req.employer.PostJobReq;
import com.visog.jobportal.res.employer.PostJobRes;
import com.visog.jobportal.service.common.AddressService;
import com.visog.jobportal.service.employer.PostJobService;
import com.visog.jobportal.utils.DaoUtils;


public class PostJobserviceImpl implements PostJobService {

	private static final Logger logger = Logger.getLogger(PostJobserviceImpl.class);

	private static final String String = null;

	@Inject
	PostJobDao dao;
	@Inject
	AppCommons appCommonsDao;
	@Inject
	AddressDao addressdao;

	
	@Inject
	AddressService addressService;
	public void savePostJob(PostJobReq req) {
		
		logger.info("Status::"+appCommonsDao.getStatusId("active").getId());
		logger.info("Address::"+appCommonsDao.getAddressId("postjob").getId());

		Currency currency = new Currency();
		Status status = new Status();
		PostJob postJob = new PostJob();
		Users users = new Users();
		users.setId(AppConstants.userId);
		postJob.setUser(users);

		postJob.setJobTitle(req.getJobTitle());
		postJob.setJobDescription(req.getJobDescription());
		postJob.setAnnualPackageFrom(req.getAnnualPackageFrom());
		postJob.setAnnualPackageTo(req.getAnnualPackageTo());
		currency.setId(req.getCurrency());
		postJob.setCurrency(currency);
		postJob.setCompany(req.getCompany());
		postJob.setEffectedDateFrom(req.getEffectedDateFrom());
		postJob.setEffectedDateTo(req.getEffectedDateTo());
		status.setId(appCommonsDao.getStatusId("active").getId());
		postJob.setStatus(status);
		postJob.setMinExperience(req.getMinExperience());
		postJob.setPhoneNo(req.getPhoneNo());
		postJob.setWalkIn(req.getWalkIn());

		DaoUtils.setEntityCreateAuditColumns(postJob);

		dao.save(postJob);

		logger.info(" postjob Successfully" + postJob.getId());
		
				
		
AddressReq address = new AddressReq();
		
		Country country = new Country();
		country.setId(req.getCountry());
		
		States states = new States();
		states.setId(req.getState());

		

		City city = new City();
		city.setId(req.getCity());

		AddrerssType addressType = new AddrerssType();
		addressType.setId(appCommonsDao.getAddressId("postjob").getId());

		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setCountry(country.getId());
		address.setState(states.getId());
		address.setCity(city.getId());
		address.setZipcode(req.getZipcode());
		
		address.setAssociatedType("postjob");
		address.setAssociated(postJob.getId());
		address.setAddressType(addressType.getId());
		
		addressService.saveAddress(address);

	}

	public void updatePostJob(PostJobReq req, String postJobId) {

		PostJob postJob = (PostJob) dao.getByKey(PostJob.class, postJobId);
		
		
		Currency currency = new Currency();
		Status status = new Status();
		Users users = new Users();

		users.setId(AppConstants.userId);
		postJob.setUser(users);
		postJob.setJobTitle(req.getJobTitle());
		postJob.setJobDescription(req.getJobDescription());
		postJob.setAnnualPackageFrom(req.getAnnualPackageFrom());
		postJob.setAnnualPackageTo(req.getAnnualPackageTo());
		currency.setId(req.getCurrency());
		postJob.setCurrency(currency);
		postJob.setCompany(req.getCompany());
		postJob.setEffectedDateFrom(req.getEffectedDateFrom());
		postJob.setEffectedDateTo(req.getEffectedDateTo());
		status.setId(appCommonsDao.getStatusId("active").getId());
		postJob.setStatus(status);
		postJob.setMinExperience(req.getMinExperience());
		postJob.setPhoneNo(req.getPhoneNo());
		postJob.setWalkIn(req.getWalkIn());

		dao.update(postJob);
		logger.info("PostJob updated Successfully" + postJob.getId());
		
		
		////////////////////////////////////////////////////
		
		Address address = (Address) addressdao.getDataByAssociatedAddress(postJobId);

		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setZipcode(req.getZipcode());
		address.setAssociatedType("postjob");
		address.setAssociated(postJobId);

		Country country = new Country();
		country.setId(req.getCountry());
		address.setCountry(country);

		States states = new States();
		states.setId(req.getState());
		address.setState(states);

		City city = new City();
		city.setId(req.getCity());
		address.setCity(city);
		
		AddrerssType addressType = new AddrerssType();
		addressType.setId(appCommonsDao.getAddressId("postjob").getId());
		address.setAddressType(addressType);

		DaoUtils.setEntityCreateAuditColumns(address);
		dao.save(address);
		logger.info("address created successfully : " + address.getId());
/*AddressReq address = new AddressReq();
		
		Country country = new Country();
		country.setId(req.getCountry());
		
		States states = new States();
		states.setId(req.getState());

		

		City city = new City();
		city.setId(req.getCity());

		AddrerssType addressType = new AddrerssType();
		addressType.setId(appCommonsDao.getAddressId("postjob").getId());

		address.setAddressLine1(req.getAddressLine1());
		address.setAddressLine2(req.getAddressLine2());
		address.setCountry(country.getId());
		address.setState(states.getId());
		address.setCity(city.getId());
		address.setZipcode(req.getZipcode());
		
		address.setAssociatedType("postjob");
		address.setAssociated(postJob.getId());
		address.setAddressType(addressType.getId());
		
		addressService.updateAddress(address,addressType.getId());*/

	}

	public List<PostJobRes> getpostjobs() {

		List<PostJob> postJobs = dao.getPostJobs();

		List<PostJobRes> postJobList = new ArrayList<>();

		PostJobRes postJobRes = null;

		for (PostJob postJob : postJobs) {

			postJobRes = new PostJobRes();

			postJobRes.setId(postJob.getId());
			postJobRes.setUser(postJob.getUser().getId());

			postJobRes.setJobTitle(postJob.getJobTitle());
			postJobRes.setJobDescription(postJob.getJobDescription());

			postJobRes.setAnnualPackageFrom(postJob.getAnnualPackageFrom());
			postJobRes.setAnnualPackageTo(postJob.getAnnualPackageTo());

			postJobRes.setCurrency(postJob.getCurrency().getId());

			postJobRes.setCompany(postJob.getCompany());

			postJobRes.setEffectedDateFrom(postJob.getEffectedDateFrom());
			postJobRes.setEffectedDateTo(postJob.getEffectedDateTo());
			postJobRes.setStatus(postJob.getStatus().getId());

			postJobRes.setMinExperience(postJob.getMinExperience());

			postJobRes.setPhoneNo(postJob.getPhoneNo());

			postJobRes.setWalkIn(postJob.getWalkIn());

			postJobList.add(postJobRes);

		}

		return postJobList;
	}

	public PostJobRes getPostJob(String id) {

		PostJob postJob = (PostJob) dao.getByKey(PostJob.class, id);
		PostJobRes postJobRes = new PostJobRes();

		postJobRes.setId(postJob.getId());
		postJobRes.setUser(postJob.getUser().getId());

		postJobRes.setJobTitle(postJob.getJobTitle());
		postJobRes.setJobDescription(postJob.getJobDescription());

		postJobRes.setAnnualPackageFrom(postJob.getAnnualPackageFrom());
		postJobRes.setAnnualPackageTo(postJob.getAnnualPackageTo());

		postJobRes.setCurrency(postJob.getCurrency().getId());

		postJobRes.setCompany(postJob.getCompany());

		postJobRes.setEffectedDateFrom(postJob.getEffectedDateFrom());
		postJobRes.setEffectedDateTo(postJob.getEffectedDateTo());
		postJobRes.setStatus(postJob.getStatus().getId());

		postJobRes.setMinExperience(postJob.getMinExperience());

		postJobRes.setPhoneNo(postJob.getPhoneNo());

		postJobRes.setWalkIn(postJob.getWalkIn());

		return postJobRes;
	}

	public Boolean deletePostJob(String postJobId) {

		return (dao.delete(PostJob.class, postJobId) != 0);
	}

}
