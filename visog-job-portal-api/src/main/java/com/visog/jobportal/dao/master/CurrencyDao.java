package com.visog.jobportal.dao.master;

import java.util.List;

import com.visog.jobportal.dao.AbstractDaoI;
import com.visog.jobportal.model.master.Currency;

public interface CurrencyDao extends AbstractDaoI {
	
	public List<Currency> getCurrencies();
	
}
