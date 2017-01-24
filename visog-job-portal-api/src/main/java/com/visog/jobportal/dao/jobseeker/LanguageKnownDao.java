package com.visog.jobportal.dao.jobseeker;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.jobseeker.LanguageKnown;

public interface LanguageKnownDao extends AbstractDaoI {

	public List<LanguageKnown> getLanguagesKnown();

}
