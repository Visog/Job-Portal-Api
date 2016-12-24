package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.IndustryDao;
import com.visog.jobportal.model.master.Industry;
import com.visog.jobportal.req.master.IndustryReq;
import com.visog.jobportal.res.master.IndustryRes;
import com.visog.jobportal.service.master.IndustryService;
import com.visog.jobportal.utils.DaoUtils;

public class IndustryServiceImpl implements IndustryService {
	
	private static final Logger logger = Logger.getLogger(IndustryServiceImpl.class);

	@Inject
	IndustryDao dao;

	/**
	 * This method saves the Industry
	 */
	public void saveIndustry(IndustryReq req) {
		Industry industries = new Industry();
		industries.setName(req.getName());
		industries.setDescription(req.getDescription());

		DaoUtils.setEntityCreateAuditColumns(industries);
		
		dao.save(industries);

		logger.info("Industry created successfully : " + industries.getId());
	}

	/**
	 * This method updates the Industry
	 */
	public void updateIndustry(IndustryReq req, String industryId) {
		
		Industry industries = (Industry) dao.getByKey(Industry.class, industryId);
		
		industries.setName(req.getName());
		industries.setDescription(req.getDescription());
		
		dao.update(industries);
		logger.info("Industry updated successfully : " + industries.getId());
	}

	/**
	 * This method returns all the industries
	 */
	public List<IndustryRes> getIndustry() {

		List<Industry> industries = dao.getIndustries();

		List<IndustryRes> industriesList = new ArrayList<>();
		IndustryRes industriesRes = null;

		for (Industry industry : industries) {
			
			industriesRes = new IndustryRes();
			
			industriesRes.setId(industry.getId());
			industriesRes.setName(industry.getName());
			industriesRes.setDescription(industry.getDescription());
			industriesList.add(industriesRes);
		}

		return industriesList;
	}

	/**
	 * This method returns Industry Details for the given industry id  
	 */
	public IndustryRes getIndustry(String id) {
		Industry industry = (Industry) dao.getByKey(Industry.class, id);
		
		IndustryRes industriesRes = new IndustryRes();
		industriesRes.setId(industry.getId());
		industriesRes.setName(industry.getName());
		industriesRes.setDescription(industry.getDescription());
		return industriesRes;
	}

	/**
	 * This method deletes the given industry  
	 */
	public Boolean deleteIndustry(String industryId) {
		return (dao.delete(Industry.class, industryId) != 0);
		
	}

	
	

}
