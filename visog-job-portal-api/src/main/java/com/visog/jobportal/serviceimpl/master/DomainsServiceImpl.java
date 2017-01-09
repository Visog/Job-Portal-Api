package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.DomainDao;
import com.visog.jobportal.model.master.Domains;
import com.visog.jobportal.model.master.Roles;
import com.visog.jobportal.req.master.DomainReq;
import com.visog.jobportal.res.master.DomainRes;
import com.visog.jobportal.service.master.DomainService;
import com.visog.jobportal.utils.DaoUtils;


public class DomainServiceImpl implements DomainService{
	private static final Logger logger = Logger.getLogger(RolesSeviceImpl.class);

	@Inject
	DomainDao dao;

	/**
	 * This method saves the Domain
	 * @author Raghava
	 */
	public void saveDomain(DomainReq req) {
		Domains domain = new Domains();
		domain.setName(req.getName());
		domain.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(domain);
		
		dao.save(domain);

		logger.info("Domain created successfully : " + domain.getId());
	}

	/**
	 * This method updates the Domain
	 * @author Raghava
	 */
	public void updateDomain(DomainReq req, String domainId) {
		Domains domain = (Domains) dao.getByKey(Domains.class, domainId);
		domain.setName(req.getName());
		domain.setDescription(req.getDescription());
		dao.update(domain);
		logger.info("Domain updated successfully : " + domain.getId());
	}

	/**
	 * This method returns all the Domains
	 * @author Raghava
	 */
	public List<DomainRes> getDomains() {

		List<Domains> domains = dao.getDomains();

		List<DomainRes> domainList = new ArrayList<>();
		DomainRes domainRes = null;

		for (Domains domain : domains) {
			domainRes = new DomainRes();
			domainRes.setId(domain.getId());
			domainRes.setName(domain.getName());
			domainRes.setDescription(domain.getDescription());
			domainList.add(domainRes);
		}

		return domainList;
	}


	/**
	 * This method returns Domain Details for the given Domain id  
	 * @author Raghava
	 */
	
	public DomainRes getDomain(String id) {
		Domains domains = (Domains) dao.getByKey(Roles.class, id);
		DomainRes domainRes = new DomainRes();
		domainRes.setId(domains.getId());
		domainRes.setName(domains.getName());
		domainRes.setDescription(domains.getDescription());
		return domainRes;
		
	}



	/**
	 * This method deletes the given Domain id
	 * @author Raghava
	 */
	public Boolean deleteDomain(String domainId) {

		return  (dao.delete(Domains.class, domainId) != 0);
	}

}
