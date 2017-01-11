package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.DomainsReq;
import com.visog.jobportal.res.master.DomainsRes;

public interface DomainsService {

	public void saveDomains(DomainsReq req);

	public void updateDomains(DomainsReq req, String domainsId);

	public List<DomainsRes> getDomains();

	public DomainsRes getDomains(String id);

	public Boolean deleteDomains(String domainsId);	

}
