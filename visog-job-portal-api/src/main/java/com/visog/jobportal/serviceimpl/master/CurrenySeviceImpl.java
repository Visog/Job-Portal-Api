package com.visog.jobportal.serviceimpl.master;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.visog.jobportal.dao.master.CurrencyDao;
import com.visog.jobportal.model.master.Currency;
import com.visog.jobportal.req.master.CurrencyReq;
import com.visog.jobportal.res.master.CurrencyRes;
import com.visog.jobportal.service.master.CurrencyService;
import com.visog.jobportal.utils.DaoUtils;

public class CurrenySeviceImpl implements CurrencyService {

	private static final Logger logger = Logger.getLogger(CurrenySeviceImpl.class);

	@Inject
	CurrencyDao dao;

	/**
	 * This method saves the Currency
	 */
	public void saveCurrency(CurrencyReq req) {
		Currency currencies= new Currency();
		currencies.setName(req.getName());
		currencies.setCode(req.getCode());
        currencies.setSymbol(req.getSymbol());
		DaoUtils.setEntityCreateAuditColumns(currencies);
		
		dao.save(currencies);

		logger.info("Currency created successfully : " + currencies.getId());
	}

	/**
	 * This method updates the Currency
	 */
	public void updateCurrency(CurrencyReq req, String currencyId) {
		Currency currencies = (Currency) dao.getByKey(Currency.class, currencyId);
		currencies.setName(req.getName());
		currencies.setCode(req.getCode());
        currencies.setSymbol(req.getSymbol());
		dao.update(currencies);
		logger.info("Currency updated successfully : " + currencies.getId());
	}

	/**
	 * This method returns all the currency
	 */
	public List<CurrencyRes> getCurrency() {

		List<Currency> currencies = dao.getCurrencies();

		List<CurrencyRes> currenciesList = new ArrayList<>();
		CurrencyRes currenciesRes = null;

		for (Currency currency : currencies) {
			currenciesRes = new CurrencyRes();
			currenciesRes.setId(currency.getId());
			currenciesRes.setName(currency.getName());
			currenciesRes.setCode(currency.getCode());
	        currenciesRes.setSymbol(currency.getSymbol());
			currenciesList.add(currenciesRes);
		}

		return currenciesList;
	}

	/**
	 * This method returns Currency Details for the given currency id  
	 */
	public CurrencyRes getCurrency(String id) {
		Currency currency = (Currency) dao.getByKey(Currency.class, id);
		CurrencyRes currenciesRes = new CurrencyRes();
		currenciesRes.setId(currency.getId());
		currenciesRes.setName(currency.getName());
		currenciesRes.setCode(currency.getCode());
        currenciesRes.setSymbol(currency.getSymbol());
		return currenciesRes;
	}

	/**
	 * This method deletes the given currency  
	 */
	public Boolean deleteCurrency(String currencyId) {
		return (dao.delete(Currency.class, currencyId) != 0);
		
	}

}
