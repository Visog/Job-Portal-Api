package com.visog.jobportal.service.master;

import java.util.List;

import com.visog.jobportal.req.master.CurrencyReq;
import com.visog.jobportal.res.master.CurrencyRes;


public interface CurrencyService {
	
	public void saveCurrency(CurrencyReq req);
	
	public void updateCurrency(CurrencyReq req, String currencyId);
	
	public List<CurrencyRes> getCurrency();
	
	public CurrencyRes getCurrency(String id);
	
	public Boolean deleteCurrency(String currencyId);
	
}
