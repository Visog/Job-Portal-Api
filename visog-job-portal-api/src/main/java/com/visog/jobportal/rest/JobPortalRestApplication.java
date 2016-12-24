package com.visog.jobportal.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.visog.jobportal.rest.controller.AdminController;
import com.visog.jobportal.rest.controller.SuperAdminController;
import com.visog.jobportal.rest.controller.master.AddressTypeController;
import com.visog.jobportal.rest.controller.master.CityController;
import com.visog.jobportal.rest.controller.master.CountryController;
import com.visog.jobportal.rest.controller.master.CoursesController;
import com.visog.jobportal.rest.controller.master.CurrencyController;
import com.visog.jobportal.rest.controller.master.DomainController;
import com.visog.jobportal.rest.controller.master.EducationTypeController;
import com.visog.jobportal.rest.controller.master.EmployerTypeController;
import com.visog.jobportal.rest.controller.master.EmploymentTypeController;
import com.visog.jobportal.rest.controller.master.FileTypeController;
import com.visog.jobportal.rest.controller.master.GenderController;
import com.visog.jobportal.rest.controller.master.IndustryController;
import com.visog.jobportal.rest.controller.master.JobRoleController;
import com.visog.jobportal.rest.controller.master.LanguagesController;
import com.visog.jobportal.rest.controller.master.RolesController;
import com.visog.jobportal.rest.controller.master.SpecilizationController;
import com.visog.jobportal.rest.controller.master.StateController;
import com.visog.jobportal.rest.controller.master.StatusController;
import com.visog.jobportal.rest.controller.master.UniversityController;


public class JobPortalRestApplication extends Application {
	
	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public JobPortalRestApplication() {
		classes.add(AdminController.class);
		classes.add(SuperAdminController.class);
		classes.add(RolesController.class);
		classes.add(CountryController.class);
		classes.add(StateController.class);
		classes.add(CityController.class);
		classes.add(AddressTypeController.class);
		classes.add(RolesController.class);
		classes.add(JobRoleController.class);
		classes.add(DomainController.class);
		classes.add(StatusController.class);
		classes.add(GenderController.class);
		classes.add(EducationTypeController.class);
		classes.add(CoursesController.class);
		classes.add(UniversityController.class);
		classes.add(SpecilizationController.class);
		classes.add(IndustryController.class);
		classes.add(CurrencyController.class);
		classes.add(LanguagesController.class);
		classes.add(EmployerTypeController.class);
		classes.add(FileTypeController.class);
		classes.add(EmploymentTypeController.class);
	}

	public Set<Object> getSingletons() {
		return singletons;
	}

	public Set<Class<?>> getClasses() {
		return classes;
	}

	public void setClasses(Set<Class<?>> classes) {
		this.classes = classes;
	}
}