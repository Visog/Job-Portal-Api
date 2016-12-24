package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.LanguageDao;
import com.visog.jobportal.model.master.Languages;
import com.visog.jobportal.req.master.LanguagesReq;
import com.visog.jobportal.res.master.LanguagesRes;
import com.visog.jobportal.service.master.LanguagesService;
import com.visog.jobportal.utils.DaoUtils;

public class LanguagesServiceImpl implements LanguagesService {
	private static final Logger logger = Logger.getLogger(LanguagesServiceImpl.class);

	@Inject
	LanguageDao dao;

	/**
	 * This method saves the Language
	 */
	public void saveLanguage(LanguagesReq req) {
		Languages languages = new Languages();
		languages.setName(req.getName());
		languages.setCode(req.getCode());

		DaoUtils.setEntityCreateAuditColumns(languages);
		
		dao.save(languages);

		logger.info("Language created successfully : " + languages.getId());
	}

	/**
	 * This method updates the Language
	 */
	public void updateLanguage(LanguagesReq req, String languageId) {
		Languages languages = (Languages) dao.getByKey(Languages.class, languageId);
		languages.setName(req.getName());
		languages.setCode(req.getCode());
		dao.update(languages);
		logger.info("Language updated successfully : " + languages.getId());
	}

	/**
	 * This method returns all the languages
	 */
	public List<LanguagesRes> getLanguages() {

		List<Languages> languages = dao.getLanguages();

		List<LanguagesRes> languagesList = new ArrayList<>();
		LanguagesRes languagesRes = null;

		for (Languages language : languages) {
			languagesRes = new LanguagesRes();
			languagesRes.setId(language.getId());
			languagesRes.setName(language.getName());
			languagesRes.setCode(language.getCode());
			languagesList.add(languagesRes);
		}

		return languagesList;
	}

	/**
	 * This method returns Language Details for the given language id  
	 */
	public LanguagesRes getLanguage(String id) {
		Languages language = (Languages) dao.getByKey(Languages.class, id);
		LanguagesRes languagesRes = new LanguagesRes();
		languagesRes.setId(language.getId());
		languagesRes.setName(language.getName());
		languagesRes.setCode(language.getCode());
		return languagesRes;
	}

	/**
	 * This method deletes the given language  
	 */
	public Boolean deleteLanguage(String languageId) {
		return (dao.delete(Languages.class, languageId) != 0);
		
	}

}



