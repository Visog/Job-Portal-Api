package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.DomainReq;
import com.visog.jobportal.res.master.DomainRes;

public interface DomainService {

	public void saveDomain(DomainReq req);

	public void updateDomain(DomainReq req, String domainId);

	public List<DomainRes> getDomains();

	public DomainRes getDomain(String id);

	public Boolean deleteDomain(String domainId);

}
