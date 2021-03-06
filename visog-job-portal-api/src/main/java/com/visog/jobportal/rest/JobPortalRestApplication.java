package com.visog.jobportal.rest;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.core.Application;

import com.visog.jobportal.rest.controller.AdminController;
import com.visog.jobportal.rest.controller.admin.RegistrationAdminController;
import com.visog.jobportal.rest.controller.common.AddressController;
import com.visog.jobportal.rest.controller.common.EmployerJobSeekerController;
import com.visog.jobportal.rest.controller.common.FilesController;
import com.visog.jobportal.rest.controller.common.ForInterceptorController;
import com.visog.jobportal.rest.controller.common.LoginController;
import com.visog.jobportal.rest.controller.employer.EmployerController;
import com.visog.jobportal.rest.controller.employer.PostJobController;
import com.visog.jobportal.rest.controller.employer.PostJobDomainsController;
import com.visog.jobportal.rest.controller.employer.RegistrationEmployerController;
import com.visog.jobportal.rest.controller.jobseeker.EducationDetailsController;
import com.visog.jobportal.rest.controller.jobseeker.ExperienceDetailsController;
import com.visog.jobportal.rest.controller.jobseeker.JobSeekerController;
import com.visog.jobportal.rest.controller.jobseeker.LanguageKnownController;
import com.visog.jobportal.rest.controller.jobseeker.PostJobSeekerController;
import com.visog.jobportal.rest.controller.jobseeker.ProjectDetailsController;
import com.visog.jobportal.rest.controller.jobseeker.RegistrationJobSeekerController;
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
import com.visog.jobportal.servlet.RestInterceptor;
public class JobPortalRestApplication extends Application {

	private Set<Object> singletons = new HashSet<>();
	private Set<Class<?>> classes = new HashSet<>();

	public JobPortalRestApplication() {
		classes.add(AdminController.class);
		/* classes.add(SuperAdminController.class); */
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
		classes.add(RegistrationJobSeekerController.class);
		classes.add(RegistrationEmployerController.class);
		classes.add(PostJobController.class);
		classes.add(PostJobDomainsController.class);
		classes.add(EmployerJobSeekerController.class);
		classes.add(FilesController.class);
		classes.add(ProjectDetailsController.class);
		classes.add(ExperienceDetailsController.class);
		classes.add(LanguageKnownController.class);
		classes.add(PostJobSeekerController.class);
		classes.add(AddressController.class);
		classes.add(EmployerController.class);
		classes.add(JobSeekerController.class);
		classes.add(RegistrationAdminController.class);
		classes.add(EducationDetailsController.class);
		classes.add(LoginController.class);
		classes.add(ForInterceptorController.class);
		classes.add(RestInterceptor.class);
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