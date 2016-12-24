package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.StatusDao;
import com.visog.jobportal.model.master.Status;
import com.visog.jobportal.req.master.StatusReq;
import com.visog.jobportal.res.master.StatusRes;
import com.visog.jobportal.service.master.StatusService;
import com.visog.jobportal.utils.DaoUtils;

public class StatusServiceImpl implements StatusService {

	private static final Logger logger = Logger.getLogger(RolesSeviceImpl.class);

	@Inject
	StatusDao dao;

	public void saveStatus(StatusReq req) {
		Status status = new Status();
		status.setName(req.getName());
		status.setCode(req.getCode());
		status.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(status);

		dao.save(status);

		logger.info("Status created successfully : " + status.getId());
	}

	/**
	 * This method updates the Status
	 * 
	 * @author Raghava
	 */
	public void updateStatus(StatusReq req, String roleId) {

		Status status = (Status) dao.getByKey(Status.class, roleId);
		status.setName(req.getName());
		status.setCode(req.getCode());
		status.setDescription(req.getDescription());
		dao.update(status);
		logger.info("Role updated successfully : " + status.getId());

	}

	/**
	 * This method returns all the Status
	 * 
	 * @author Raghava
	 */

	public List<StatusRes> getStatus() {

		List<Status> Status = dao.getStatus();

		List<StatusRes> statusList = new ArrayList<>();
		StatusRes statusRes = null;

		for (Status status : Status) {
			statusRes = new StatusRes();
			statusRes.setId(status.getId());
			statusRes.setName(status.getName());
			status.setCode(status.getCode());
			statusRes.setDescription(status.getDescription());
			statusList.add(statusRes);
		}

		return statusList;

	}

	/**
	 * This method returns Status Details for the given status id
	 * 
	 * @author Raghava
	 */

	public StatusRes getStatus(String id) {
		Status status = (Status) dao.getByKey(Status.class, id);
		StatusRes statusRes = new StatusRes();
		statusRes.setId(status.getId());
		statusRes.setName(status.getName());
		statusRes.setCode(status.getCode());
		statusRes.setDescription(status.getDescription());
		return statusRes;
	}

	/**
	 * This method deletes the given Status
	 * 
	 * @author Raghava
	 */

	public Boolean deleteStatus(String roleId) {
		return (dao.delete(Status.class, roleId) != 0);

	}

}
