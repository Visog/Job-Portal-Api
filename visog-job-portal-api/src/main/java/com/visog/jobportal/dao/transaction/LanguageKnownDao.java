package com.visog.jobportal.dao.transaction;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.transaction.LanguageKnown;

public interface LanguageKnownDao extends AbstractDaoI {

	public List<LanguageKnown> getLanguagesKnown();

}
