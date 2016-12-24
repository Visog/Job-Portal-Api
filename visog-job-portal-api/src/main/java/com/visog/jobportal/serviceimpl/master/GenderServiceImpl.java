package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.GenderDao;
import com.visog.jobportal.model.master.Gender;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.req.master.GenderReq;
import com.visog.jobportal.res.master.GenderRes;
import com.visog.jobportal.res.master.RolesRes;
import com.visog.jobportal.service.master.GenderService;
import com.visog.jobportal.utils.DaoUtils;

public class GenderServiceImpl implements GenderService {

	private static final Logger logger = Logger.getLogger(GenderServiceImpl.class);

	@Inject
	GenderDao dao;

	/**
	 * This method saves the Gender
	 */

	public void saveGender(GenderReq req) {

		Gender gender = new Gender();
		gender.setCode(req.getCode());
		gender.setName(req.getName());
		gender.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(gender);
		dao.save(gender);

		logger.info("Gender created successfully : " + gender.getId());

	}

	/**
	 * This method updates the Gender
	 */
	public void updateGender(GenderReq req, String genderId) {
		Gender gender = (Gender) dao.getByKey(Gender.class, genderId);
		gender.setCode(req.getCode());
		gender.setName(req.getName());
		gender.setDescription(req.getDescription());
		dao.update(gender);
		logger.info("Gender updated successfully : " + gender.getId());

	}

	/**
	 * This method returns all the roles
	 */

	public List<GenderRes> getGenders() {

		List<Gender> gender = dao.getGenders();

		List<GenderRes> genderList = new ArrayList<>();
		GenderRes genderRes = null;

		for (Gender genders : gender) {
			genderRes = new GenderRes();
			genderRes.setId(genders.getId());
			genderRes.setCode(genders.getCode());
			genderRes.setName(genders.getName());
			genderRes.setDescription(genders.getDescription());
			genderList.add(genderRes);
		}

		return genderList;
	}

	/**
	 * This method returns Gender Details for the given Gender id
	 */
	public GenderRes getGender(String id) {

		Gender gender = (Gender) dao.getByKey(Gender.class, id);
		GenderRes genderRes = new GenderRes();
		genderRes.setId(gender.getId());
		genderRes.setCode(gender.getCode());
		genderRes.setName(gender.getName());
		genderRes.setDescription(gender.getDescription());
		return genderRes;

	}

	/**
	 * This method deletes the given Gender
	 */
	public Boolean deleteGender(String genderId) {
		return (dao.delete(Gender.class, genderId) != 0);
	}

}