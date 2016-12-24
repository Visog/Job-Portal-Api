package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.StateReq;
import com.visog.jobportal.res.master.StateRes;

public interface StateService {
	
	public Boolean saveState(StateReq req);
	
	public Boolean updateState(StateReq req, String stateId);
	
	public List<StateRes> getStates();
	
	public StateRes getState(String id);
	
	public Boolean deleteState(String stateId);

}
