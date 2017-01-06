package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.RegistrationEmployerDao;
import com.visog.jobportal.model.master.Gender;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;
import com.visog.jobportal.utils.DaoUtils;

import RegistrationEmployerDaoImpl.RegistrationEmployerService;

public class RegistrationEmployerServiceImpl implements RegistrationEmployerService {

	private static final Logger logger = Logger.getLogger(RegistrationEmployerServiceImpl.class);

	@Inject
	private RegistrationEmployerDao dao;

	public void saveRegistrationEmployerDetails(UsersReq req) {

		Users users = new Users();

		Gender gender = new Gender();

		Roles roles = new Roles();

		users.setFirstName(req.getFirstName());
		users.setMiddleName(req.getMiddleName());
		users.setLastName(req.getLastName());
		users.setEmail(req.getEmail());
		users.setAlternativeEmail(req.getAlternativeEmail());

		gender.setId(req.getGender());
		users.setGender(gender);

		users.setDob(req.getDob());

		roles.setId("2556718a-37cc-40b4-9465-81ece73a6031");
		users.setRole(roles);

		users.setPassword(req.getPassword());
		users.setPhone(req.getPhone());
		users.setLandline(req.getLandline());

		dao.save(users);
		DaoUtils.setEntityCreateAuditColumns(users);
		logger.info("Employer Registration Successfully" + users.getId());
	}

	public void updateEmployerDetails(UsersReq req, String employerDetailsId) {

		Users users = (Users) dao.getByKey(Users.class, employerDetailsId);

		Gender gender = new Gender();

		Roles roles = new Roles();

		users.setFirstName(req.getFirstName());
		users.setMiddleName(req.getMiddleName());
		users.setLastName(req.getLastName());
		users.setEmail(req.getEmail());
		users.setAlternativeEmail(req.getAlternativeEmail());

		gender.setId(req.getGender());
		users.setGender(gender);

		users.setDob(req.getDob());

		roles.setId(req.getRole());
		users.setRole(roles);

		users.setPassword(req.getPassword());
		users.setPhone(req.getPhone());
		users.setLandline(req.getLandline());

		dao.update(users);

		logger.info("Employer Updated Successfully" + users.getId());

	}

	public List<UsersRes> getEmployerDetails() {

		List<Users> users = dao.getRegistrationEmployerDetails();
		List<UsersRes> employersList = new ArrayList<>();
		UsersRes usersRes = null;

		Gender gender = new Gender();
		Roles roles = new Roles();

		for (Users user : users) {

			usersRes = new UsersRes();
			usersRes.setId(user.getId());
			usersRes.setFirstName(user.getFirstName());
			usersRes.setMiddleName(user.getMiddleName());
			usersRes.setLastName(user.getLastName());
			usersRes.setEmail(user.getEmail());
			usersRes.setAlternativeEmail(user.getAlternativeEmail());
			usersRes.setGender(user.getGender().getId());
			usersRes.setDob(user.getDob());
			usersRes.setRole(user.getRole().getId());
			usersRes.setPassword(user.getPassword());
			usersRes.setPhone(user.getPhone());
			usersRes.setLandline(user.getLandline());

			employersList.add(usersRes);

		}

		return employersList;
	}

	public UsersRes getEmployerDetails(String employerDetailsId) {
		
		Users users = (Users) dao.getByKey(Users.class, employerDetailsId);
		
		UsersRes usersRes =new UsersRes();

		usersRes.setId(users.getId());
		usersRes.setFirstName(users.getFirstName());
		usersRes.setMiddleName(users.getMiddleName());
		usersRes.setLastName(users.getLastName());
		usersRes.setEmail(users.getEmail());
		usersRes.setAlternativeEmail(users.getAlternativeEmail());
		usersRes.setGender(users.getGender().getId());
		usersRes.setDob(users.getDob());
		usersRes.setRole(users.getRole().getId());
		usersRes.setPassword(users.getPassword());
		usersRes.setPhone(users.getPhone());
		usersRes.setLandline(users.getLandline());

		
		return usersRes;
	}

	public Boolean deleteAddress(String id) {
		return (dao.delete(Users.class,id) !=0);
	}

}
