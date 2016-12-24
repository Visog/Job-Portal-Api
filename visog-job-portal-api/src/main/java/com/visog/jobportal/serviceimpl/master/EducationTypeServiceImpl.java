package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.EducationTypeDao;
import com.visog.jobportal.model.master.EducationType;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.req.master.EducationTypeReq;
import com.visog.jobportal.res.master.EducationTypeRes;
import com.visog.jobportal.res.master.RolesRes;
import com.visog.jobportal.service.master.EducationTypeService;
import com.visog.jobportal.utils.DaoUtils;

public class EducationTypeServiceImpl implements EducationTypeService {

	private static final Logger logger = Logger.getLogger(EducationTypeServiceImpl.class);

	@Inject
	EducationTypeDao dao;

	/**
	 * This method saves the Education Type
	 */
	public void saveEducationType(EducationTypeReq req) {

		EducationType educationtype = new EducationType();
		educationtype.setName(req.getName());
		educationtype.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(educationtype);

		dao.save(educationtype);

		logger.info("Education Type created successfully : " + educationtype.getId());

	}

	/**
	 * This method updates the Education Type
	 */

	public void updateEducationType(EducationTypeReq req, String educationtypeId) {

		EducationType educationtype = (EducationType) dao.getByKey(EducationType.class, educationtypeId);
		educationtype.setName(req.getName());
		educationtype.setDescription(req.getDescription());
		dao.update(educationtype);
		logger.info("Education Type updated successfully : " + educationtype.getId());

	}

	/**
	 * This method returns all the Education Types
	 */

	public List<EducationTypeRes> getEducationTypes() {

		List<EducationType> educationtype = dao.getEducationTypes();

		List<EducationTypeRes> educationtypeList = new ArrayList<>();
		EducationTypeRes educationtypeRes = null;

		for (EducationType educationtypes : educationtype) {

			educationtypeRes = new EducationTypeRes();
			educationtypeRes.setId(educationtypes.getId());
			educationtypeRes.setName(educationtypes.getName());
			educationtypeRes.setDescription(educationtypes.getDescription());
			educationtypeList.add(educationtypeRes);
		}

		return educationtypeList;

	}

	/**
	 * This method returns Education Type Details for the given Education Type
	 * id
	 */

	public EducationTypeRes getEducationType(String id) {

		EducationType educationtype = (EducationType) dao.getByKey(EducationType.class, id);
		EducationTypeRes educationtypeRes = new EducationTypeRes();
		educationtypeRes.setId(educationtype.getId());
		educationtypeRes.setName(educationtype.getName());
		educationtypeRes.setDescription(educationtype.getDescription());
		return educationtypeRes;
	}


	/**
	 * This method deletes the given Education Type
	 */
	public Boolean deleteEducationType(String educationtypeId) {
		return (dao.delete(EducationType.class, educationtypeId) != 0);
		
	}

}
