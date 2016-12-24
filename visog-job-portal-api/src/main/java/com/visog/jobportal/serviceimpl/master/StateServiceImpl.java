package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.StateDao;
import com.visog.jobportal.model.master.Country;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.model.master.States;
import com.visog.jobportal.req.master.StateReq;
import com.visog.jobportal.res.master.RolesRes;
import com.visog.jobportal.res.master.StateRes;
import com.visog.jobportal.service.master.StateService;
import com.visog.jobportal.utils.DaoUtils;

public class StateServiceImpl implements StateService {

	private static final Logger logger = Logger.getLogger(StateServiceImpl.class);

	@Inject
	StateDao dao;

	/**
	 * This method saves the State
	 */
	public Boolean saveState(StateReq req) {

		States states = new States();
		states.setName(req.getName());

		Country country = new Country();
		country.setId(req.getCountry());
		states.setCountry(country);
		DaoUtils.setEntityCreateAuditColumns(states);

		if (dao.isStateExists(req.getName())) {

			logger.info("State already exist : " + states.getId());
			return false;

		} else {
			dao.save(states);

			logger.info("state created successfully : " + states.getId());
			return true;

		}

	}

	/**
	 * This method updates the State
	 */
	public Boolean updateState(StateReq req, String stateId) {

		States states = (States) dao.getByKey(States.class, stateId);
		logger.info("states exist : " + states.getName().toLowerCase().trim());
		logger.info("states new : " + req.getName().toLowerCase().trim());

		if (states.getName().toLowerCase().trim().equals(req.getName().toLowerCase().trim())
				|| (!dao.isStateExists(req.getName()))) {

			states.setName(req.getName());

			Country country = new Country();
			country.setId(req.getCountry());

			states.setCountry(country);

			dao.update(states);
			logger.info("state updated successfully : " + states.getId());
			return true;

		} else {
			logger.info("states already exist : " + states.getId());
			return false;

		}

	}

	/**
	 * This method returns all the states
	 */

	public List<StateRes> getStates() {
		List<States> states = dao.getStates();

		List<StateRes> stateList = new ArrayList<>();
		StateRes stateRes = null;

		for (States state : states) {
			stateRes = new StateRes();
			stateRes.setId(state.getId());
			stateRes.setName(state.getName());
			stateRes.setCountry(state.getCountry().getId());
			stateList.add(stateRes);
		}

		return stateList;
	}

	/**
	 * This method returns State Details for the given state id
	 */

	public StateRes getState(String id) {

		States states = (States) dao.getByKey(States.class, id);

		StateRes stateRes = new StateRes();
		stateRes.setId(states.getId());
		stateRes.setName(states.getName());
		stateRes.setCountry(states.getCountry().getId());
		return stateRes;
	}

	/**
	 * This method deletes the given role
	 */
	public Boolean deleteState(String stateId) {
		return (dao.delete(States.class, stateId) != 0);
	}

}
