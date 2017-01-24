package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.dao.transaction.AppRoleId;
import com.visog.jobportal.dao.transaction.RegistrationAdminDao;
import com.visog.jobportal.model.master.Gender;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;
import com.visog.jobportal.service.transaction.RegistrationAdminService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * @author Divya
 *
 */
public class RegistrationAdminServiceImpl implements RegistrationAdminService {

	private static final Logger logger = Logger.getLogger(RegistrationAdminServiceImpl.class);

	@Inject
	RegistrationAdminDao dao;

	@Inject
	AppRoleId appRoleIdDao;
	/**
	 * @author Divya
	 * 
	 *         This method saves the Users
	 * 
	 * 
	 */

	public Boolean saveAdmin(UsersReq req) {

		Users user = new Users();
		user.setFirstName(req.getFirstName());
		user.setMiddleName(req.getMiddleName());
		user.setLastName(req.getLastName());
		Roles role = new Roles();
		role.setId(appRoleIdDao.getAdminRoleId().getId());
		logger.info("AdminRoleName IDS Successfull :" + appRoleIdDao.getAdminRoleId().getId());
		user.setRole(role);
		user.setEmail(req.getEmail());
		user.setAlternativeEmail(req.getAlternativeEmail());
		Gender gender = new Gender();
		gender.setId(req.getGender());
		user.setGender(gender);
		user.setDob(req.getDob());
		user.setPassword(req.getPassword());
		user.setPhone(req.getPhone());
		user.setLandline(req.getLandline());
		DaoUtils.setEntityCreateAuditColumns(user);

		if (dao.isAdminExists(req.getEmail().toLowerCase().trim())) {

			logger.info("Admin Email already exists:" + user.getId());
			return false;

		} else if (dao.isAdminPhoneExists(req.getPhone().trim())) {

			logger.info("Admin phoneno already exists:" + user.getId());
			return false;
		}

		else {

			dao.save(user);

			logger.info("Admin created successfully : " + user.getId());
			return true;

		}

	}

	/**
	 * This method updates the Users
	 */

	public Boolean updateAdmin(UsersReq req, String adminId) {

		Users user = (Users) dao.getByKey(Users.class, adminId);

		if (user.getEmail().toLowerCase().trim().equals(req.getEmail().toLowerCase().trim())
				|| (!dao.isAdminExists(req.getEmail()))) {

			user.setFirstName(req.getFirstName());
			user.setMiddleName(req.getMiddleName());
			user.setLastName(req.getLastName());
			Roles role = new Roles();
			role.setId(appRoleIdDao.getAdminRoleId().getId());
			logger.info("AdminRoleName IDS Successfull :" + appRoleIdDao.getAdminRoleId().getId());
			user.setRole(role);
			user.setEmail(req.getEmail());
			user.setAlternativeEmail(req.getAlternativeEmail());
			Gender gender = new Gender();
			gender.setId(req.getGender());
			user.setGender(gender);
			user.setDob(req.getDob());
			user.setPassword(req.getPassword());
			user.setPhone(req.getPhone());
			user.setLandline(req.getLandline());
			dao.update(user);
			logger.info("Admin updated successfully : " + user.getId());
			return true;

		} else {
			logger.info("Admin already exists : " + user.getId());
			return false;

		}

	}

	/**
	 * This method returns all the Cities
	 */
	public List<UsersRes> getAdmin() {

		List<Users> users = dao.getAdmin();

		List<UsersRes> userList = new ArrayList<>();
		UsersRes usersRes = null;

		for (Users user : users) {
			usersRes = new UsersRes();
			usersRes.setId(user.getId());
			usersRes.setFirstName(user.getFirstName());
			usersRes.setMiddleName(user.getMiddleName());
			usersRes.setLastName(user.getLastName());

			usersRes.setRole(user.getRole().getId());
			usersRes.setEmail(user.getEmail());
			usersRes.setAlternativeEmail(user.getAlternativeEmail());
			usersRes.setGender(user.getGender().getId());
			usersRes.setDob(user.getDob());
			usersRes.setPassword(user.getPassword());
			usersRes.setPhone(user.getPhone());
			usersRes.setLandline(user.getLandline());
			userList.add(usersRes);
		}

		return userList;

	}

	public UsersRes getAdmin(String id) {

		Users user = (Users) dao.getByKey(Users.class, id);

		UsersRes usersRes = new UsersRes();
		usersRes.setId(user.getId());
		usersRes.setFirstName(user.getFirstName());
		usersRes.setMiddleName(user.getMiddleName());
		usersRes.setLastName(user.getLastName());
		usersRes.setRole(user.getRole().getId());
		usersRes.setEmail(user.getEmail());
		usersRes.setAlternativeEmail(user.getAlternativeEmail());
		usersRes.setGender(user.getGender().getId());
		usersRes.setDob(user.getDob());
		usersRes.setPassword(user.getPassword());
		usersRes.setPhone(user.getPhone());
		usersRes.setLandline(user.getLandline());

		return usersRes;
	}

	public Boolean deleteAdmin(String adminId) {
		return (dao.delete(Users.class, adminId) != 0);
	}

}
