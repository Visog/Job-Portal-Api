package com.visog.jobportal.serviceimpl.transaction;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.transaction.LanguageKnownDao;
import com.visog.jobportal.model.master.Languages;
import com.visog.jobportal.model.transaction.LanguageKnown;
import com.visog.jobportal.model.transaction.Users;
import com.visog.jobportal.req.transaction.LanguageKnownReq;
import com.visog.jobportal.res.transaction.LanguageKnownRes;
import com.visog.jobportal.service.transaction.LanguageKnownService;
import com.visog.jobportal.utils.DaoUtils;

public class LanguageKnownServiceImpl implements LanguageKnownService{

	private static final Logger logger=Logger.getLogger(LanguageKnownServiceImpl.class);
	
	@Inject
	LanguageKnownDao dao;
	
	/**
	 * This method saves the LanguageKnown
	 */
	public void saveLanguageKnown(LanguageKnownReq req) {

		LanguageKnown languageknown=new LanguageKnown();
		languageknown.setRead(req.getRead());
		languageknown.setWrite(req.getWrite());
		languageknown.setSpeak(req.getSpeak());
		languageknown.setProficencylevel(req.getProficencylevel());
		
		Languages languages=new Languages();
		languages.setId(req.getLANGUAGE());
		
		Users users=new Users();
		users.setId(req.getUSER());
		
		DaoUtils.setEntityCreateAuditColumns(languageknown);
		dao.save(languageknown);
		logger.info(" languageknown saved Successfully"+languageknown.getId());
		
	}

	/**
	 * This method updates the LanguageKnown
	 */
	public void updateLanguageKnown(LanguageKnownReq req, String lanhguageKnownId) {

		LanguageKnown languageKnown=(LanguageKnown) dao.getByKey(LanguageKnown.class, lanhguageKnownId);
		languageKnown.setRead(req.getRead());
		languageKnown.setWrite(req.getWrite());
		languageKnown.setSpeak(req.getSpeak());
		languageKnown.setProficencylevel(req.getProficencylevel());
		
		Languages languages=new Languages();
		languages.setId(req.getLANGUAGE());
		
		Users users=new Users();
		users.setId(req.getUSER());
		
		dao.update(languageKnown);
		logger.info(" languageKnown updated Successfully"+languageKnown.getId());
		
	}


	/**
	 * This method returns all the languageKnown
	 */
	public List<LanguageKnownRes> getLanguageKnown() {
		
		List<LanguageKnown> languageKnowns=dao.getLanguagesKnown();
		List<LanguageKnownRes> languageKnownList=new ArrayList<>();
		LanguageKnownRes languageKnownRes=null;
		Languages languages=new Languages();
		for(LanguageKnown languageKnown:languageKnowns){
		languageKnownRes =new LanguageKnownRes();
		languageKnownRes.setId(languageKnown.getId());
		languageKnownRes.setRead(languageKnown.getRead());
		languageKnownRes.setSpeak(languageKnown.getSpeak());
		languageKnownRes.setProficencylevel(languageKnown.getProficencylevel());
		languageKnownRes.setWrite(languageKnown.getWrite());
		languageKnownRes.setLanguage(languageKnown.getLanguage().getId());
		languageKnownRes.setUser(languageKnown.getUser().getId());
		
		languageKnownList.add(languageKnownRes);
		
		
			
		}
		return languageKnownList;
	}

	/**
	 * This method returns LanguageKnown Details for the given LanguageKnown id  
	 */
	public LanguageKnownRes getLanguageKnown(String id) {
		return null;
	}

	@Override
	public Boolean deleteLanguageKnown(String lanhguageKnownId) {
		// TODO Auto-generated method stub
		return null;
	}
	
	

}
