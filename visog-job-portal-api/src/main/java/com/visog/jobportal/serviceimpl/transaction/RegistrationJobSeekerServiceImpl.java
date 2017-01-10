package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.RegistrationJobSeekerDao;
import com.visog.jobportal.dao.transaction.UserDao;
import com.visog.jobportal.model.master.Gender;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.UsersReq;
import com.visog.jobportal.res.transaction.UsersRes;
import com.visog.jobportal.service.transaction.RegistrationJobSeekerService;
import com.visog.jobportal.utils.DaoUtils;

/**
 * @author Divya
 *
 */
public class RegistrationJobSeekerServiceImpl implements RegistrationJobSeekerService{

	private static final Logger logger = Logger.getLogger(RegistrationJobSeekerServiceImpl.class);

	@Inject
	RegistrationJobSeekerDao dao;

	/**
	 * @author Divya
	 * 
	 *         This method saves the Users
	 * 
	 * 
	 */
	/*public Boolean isUsersLoginExists(String password,String email) {
		if(dao.isUsersLoginExists(password, email))
		{
			return true;
		}else{
			return false;
		}
		
	}*/
	
	
	
	public Boolean saveJobSeeker(UsersReq req) {

		Users user=new Users();
		user.setFirstName(req.getFirstName());
		user.setMiddleName(req.getMiddleName());
		user.setLastName(req.getLastName());
		Roles role=new Roles();
		role.setId("921366a2-7b19-4d72-ae8e-d17b6cfd1445");
		user.setRole(role);
		user.setEmail(req.getEmail());
		user.setAlternativeEmail(req.getAlternativeEmail());
		Gender gender=new Gender();
		gender.setId(req.getGender());
		user.setGender(gender);
		user.setDob(req.getDob());
		user.setPassword(req.getPassword());
		user.setPhone(req.getPhone());
		user.setLandline(req.getLandline());
         DaoUtils.setEntityCreateAuditColumns(user);
		 
	
		if (dao.isJobSeekerExists(req.getEmail().toLowerCase().trim())) {

			logger.info("user already exists:" + user.getId());
			return false;

		}else if (dao.isJobSeekerExists(req.getEmail().toLowerCase().trim())) {

			logger.info("user already exists:" + user.getId());
			return false;

		}
		
		
		else {

			dao.save(user);

			logger.info("user created successfully : " + user.getId());
			return true;

		}

		
		
/*		
		Users user = new Users();
		user.setName(req.getEmail());
		States states = new States();
		states.setId(req.getState());
		user.setState(states);
		Country country = new Country();
		country.setId(req.getCountry());
		user.setCountry(country);
		DaoUtils.setEntityCreateAuditColumns(user);
		if (dao.isJobSeekerExists(req.getEmail())) {

			logger.info("user already exists:" + user.getId());
			return false;

		} else {

			dao.save(user);

			logger.info("user created successfully : " + user.getId());
			return true;

		}*/

	}

	/**
	 * This method updates the Users
	 */

	public Boolean updateJobSeeker(UsersReq req, String userId) {

		Users user = (Users) dao.getByKey(Users.class, userId);

		logger.info("user Exists:" + user.getEmail().toLowerCase().trim());
		logger.info("Users new :" + req.getEmail().toLowerCase().trim());

		if (user.getEmail().toLowerCase().trim().equals(req.getEmail().toLowerCase().trim())
				|| (!dao.isJobSeekerExists(req.getEmail()))) {

			user.setFirstName(req.getFirstName());
			user.setMiddleName(req.getMiddleName());
			user.setLastName(req.getLastName());
			Roles role=new Roles();
			role.setId("921366a2-7b19-4d72-ae8e-d17b6cfd1445");
			user.setRole(role);
			user.setEmail(req.getEmail());
			user.setAlternativeEmail(req.getAlternativeEmail());
			Gender gender=new Gender();
			gender.setId(req.getGender());
			user.setGender(gender);
			user.setDob(req.getDob());
			user.setPassword(req.getPassword());
			user.setPhone(req.getPhone());
			user.setLandline(req.getLandline());
			dao.update(user);
			logger.info("user updated successfully : " + user.getId());
			return true;

		} else {
			logger.info("user already exists : " + user.getId());
			return false;

		}

	}

	/**
	 * This method returns all the Cities
	 */
	public List<UsersRes> getJobSeeker() {

		List<Users> users = dao.getJobSeeker();

		List<UsersRes> userList = new ArrayList<>();
		UsersRes  usersRes =null;
		
		for(Users user :  users)
		{
			usersRes = new UsersRes();
			usersRes.setId(user.getId());
			usersRes.setFirstName(user.getFirstName());
			usersRes.setMiddleName(user.getMiddleName());
			usersRes.setLastName(user.getLastName());
		//	Roles role=new Roles();
		//	role.setId(user.getRoleID());
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

	public UsersRes getJobSeeker(String id) {

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

	public Boolean deleteJobSeeker(String userId) {
		return (dao.delete(Users.class, userId) != 0);
	}

	
	



}