package com.visog.jobportal.utils;

import java.util.Date;
import java.util.UUID;

import com.visog.jobportal.model.AbstractModel;
import com.visog.jobportal.servlet.UserContextHolder;

public class DaoUtils {
	
	public static void setEntityCreateAuditColumns(AbstractModel model) {
		
		model.setId(getUUID());
		model.setCreatedBy(UserContextHolder.getUserContext().getId());
		model.setCreatedOn(new Date());
		model.setCreatedSid(UserContextHolder.getUserContext().getId());
	}

	public static void setEntityUpdateAuditColumns(AbstractModel model) {
		
		model.setUpdatedBy(UserContextHolder.getUserContext().getId());
		model.setUpdatedOn(new Date());
		model.setUpdatedSid(UserContextHolder.getUserContext().getId());
	}
	
	private static String getUUID() {
		return UUID.randomUUID().toString();
	}

}
 