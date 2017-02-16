package com.visog.jobportal.servlet;

import com.visog.jobportal.constants.AppConstants;
import com.visog.jobportal.model.common.Users;

public class UserContextHolder {

	private static final ThreadLocal<UserContext> userContext = new ThreadLocal<UserContext>() {
		protected UserContext initialValue() {

			return new UserContext();
		}
	};

	public static UserContext getUserContext() {
		return userContext.get();
	}

	public static void setUserContextData(Users user, UserContext userContext) {

		userContext.setUserId(user.getId());
		userContext.setSessionId(user.getId());
		userContext.setFirstName(user.getFirstName());
		userContext.setMiddleName(user.getMiddleName());
		userContext.setLastName(user.getLastName());
		userContext.setRole(user.getRole().getId());
		userContext.setEmail(user.getEmail());
		userContext.setAlternativeEmail(user.getAlternativeEmail());
		userContext.setGender(user.getGender().getId());
		userContext.setDob(user.getDob());
		userContext.setPhone(user.getPhone());
		userContext.setLandline(user.getLandline());

	}

	public static void setUserContextData(UserContext userContext) {

		userContext.setUserId(AppConstants.NO_USER_ID);
		userContext.setSessionId(AppConstants.NO_SESSION_ID);

	}

}