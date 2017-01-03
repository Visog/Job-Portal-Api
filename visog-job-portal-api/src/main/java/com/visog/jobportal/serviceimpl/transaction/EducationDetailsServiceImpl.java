package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.EducationDetailsDao;
import com.visog.jobportal.req.transaction.EducationDetailsReq;
import com.visog.jobportal.res.transaction.EducationDetailsRes;
import com.visog.jobportal.service.transaction.EducationDetailsService;
import com.visog.jobportal.utils.DaoUtils;

public abstract class EducationDetailsServiceImpl implements EducationDetailsService {
	
	
	private static final Logger logger=Logger.getLogger(EducationDetailsServiceImpl.class);
	
	@Inject
	EducationDetailsDao dao;
	
	
	/**
	 * @author Bala
	 */
	
	public void saveEducationDetails(EducationDetailsReq req){
		return;
	}
	
	 public void updateEducationDetails(EducationDetailsReq req,String EducationDetailsId) {
		 return;
	 }
	 
	 public List<EducationDetailsRes> getEducationDetailsRes(){
		 return null;
	 }

	 public EducationDetailsReq geEducationDetails(String id){
		 return null;
	 }
	
	 public Boolean deleteEducationDetails(String EducationDetailsId){
		 return null;
	 }
}
