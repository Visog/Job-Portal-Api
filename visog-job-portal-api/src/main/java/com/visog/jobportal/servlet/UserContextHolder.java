package com.visog.jobportal.servlet;

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

		userContext.setId(user.getId());
		userContext.setFirstName(user.getFirstName());
		userContext.setMiddleName(user.getMiddleName());
		userContext.setLastName(user.getLastName());
		userContext.setRole(user.getRole().getId());
		userContext.setEmail(user.getEmail());
		userContext.setAlternativeEmail(user.getAlternativeEmail());
		userContext.setGender(user.getGender().getId());
		userContext.setDob(user.getDob());
		userContext.setPassword(user.getPassword());
		userContext.setPhone(user.getPhone());
		userContext.setLandline(user.getLandline());

	}

}