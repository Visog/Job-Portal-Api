package com.visog.jobportal.serviceimpl.jobseeker;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.jobseeker.LanguageKnownDao;
import com.visog.jobportal.model.common.Users;
import com.visog.jobportal.model.jobseeker.LanguageKnown;
import com.visog.jobportal.model.master.Languages;
import com.visog.jobportal.req.jobseeker.LanguageKnownReq;
import com.visog.jobportal.res.jobseeker.LanguageKnownRes;
import com.visog.jobportal.service.jobseeeker.LanguageKnownService;
import com.visog.jobportal.utils.DaoUtils;

public class LanguageKnownServiceImpl implements LanguageKnownService {

	private static final Logger logger = Logger.getLogger(LanguageKnownServiceImpl.class);

	@Inject
	LanguageKnownDao dao;

	/**
	 * This method saves the LanguageKnown
	 */
	public void saveLanguageKnown(LanguageKnownReq req) {

		LanguageKnown languageknown = new LanguageKnown();
		languageknown.setRead(req.getRead());
		languageknown.setWrite(req.getWrite());
		languageknown.setSpeak(req.getSpeak());
		languageknown.setProficencylevel(req.getProficencylevel());

		Languages languages = new Languages();
		languages.setId(req.getLanguage());
		languageknown.setLanguage(languages);

		Users users = new Users();
		users.setId(req.getUser());
		languageknown.setUser(users);

		DaoUtils.setEntityCreateAuditColumns(languageknown);
		dao.save(languageknown);
		logger.info(" languageknown saved Successfully" + languageknown.getId());

	}

	/**
	 * This method updates the LanguageKnown
	 */
	public void updateLanguageKnown(LanguageKnownReq req, String languageKnownId) {

		LanguageKnown languageknown = (LanguageKnown) dao.getByKey(LanguageKnown.class, languageKnownId);
		languageknown.setRead(req.getRead());
		languageknown.setWrite(req.getWrite());
		languageknown.setSpeak(req.getSpeak());
		languageknown.setProficencylevel(req.getProficencylevel());

		Languages languages = new Languages();
		languages.setId(req.getLanguage());
		languageknown.setLanguage(languages);

		Users users = new Users();
		users.setId(req.getUser());
		languageknown.setUser(users);

		dao.update(languageknown);
		logger.info(" languageKnown updated Successfully" + languageknown.getId());

	}

	/**
	 * This method returns all the languageKnown
	 */
	public List<LanguageKnownRes> getLanguageKnown() {

		List<LanguageKnown> languageknowns = dao.getLanguagesKnown();
		List<LanguageKnownRes> languageKnownList = new ArrayList<>();
		LanguageKnownRes languageKnownRes = null;
		Languages languages = new Languages();

		for (LanguageKnown languageknown : languageknowns) {

			languageKnownRes = new LanguageKnownRes();
			languageKnownRes.setId(languageknown.getId());
			languageKnownRes.setRead(languageknown.getRead());
			languageKnownRes.setSpeak(languageknown.getSpeak());
			languageKnownRes.setProficencylevel(languageknown.getProficencylevel());
			languageKnownRes.setWrite(languageknown.getWrite());
			languageKnownRes.setLanguage(languageknown.getLanguage().getId());
			languageKnownRes.setUser(languageknown.getUser().getId());

			languageKnownList.add(languageKnownRes);

		}
		return languageKnownList;
	}

	/**
	 * This method returns LanguageKnown Details for the given LanguageKnown id
	 */
	public LanguageKnownRes getLanguageKnown(String id) {
		LanguageKnown languageKnown = (LanguageKnown) dao.getByKey(LanguageKnown.class, id);
		LanguageKnownRes languageKnownRes = new LanguageKnownRes();
		languageKnownRes.setId(languageKnown.getId());
		languageKnownRes.setRead(languageKnown.getRead());
		languageKnownRes.setWrite(languageKnown.getWrite());
		languageKnownRes.setProficencylevel(languageKnown.getProficencylevel());
		languageKnownRes.setLanguage(languageKnown.getLanguage().getId());
		languageKnownRes.setSpeak(languageKnownRes.getSpeak());
		languageKnownRes.setUser(languageKnown.getUser().getId());

		return languageKnownRes;
	}

	/**
	 * This method deletes the given languageKnown
	 */
	public Boolean deleteLanguageKnown(String languageKnownId) {

		return (dao.delete(LanguageKnown.class, languageKnownId) != 0);
	}

}
