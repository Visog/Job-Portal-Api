package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.DomainsReq;
import com.visog.jobportal.res.master.DomainsRes;

public interface DomainsService {

	public void saveDomain(DomainsReq req);

	public void updateDomain(DomainsReq req, String domainId);

	public List<DomainsRes> getDomains();

	public DomainsRes getDomain(String id);

	public Boolean deleteDomain(String domainId);	

}
