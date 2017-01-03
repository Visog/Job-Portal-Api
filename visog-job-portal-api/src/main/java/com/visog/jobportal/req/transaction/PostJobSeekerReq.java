package com.visog.jobportal.req.transaction;

public class PostJobSeekerReq {

	private String jobSeeker;

	private String employer;

	private String postJob;

	private String status;

	public String getJobSeeker() {
		return jobSeeker;
	}

	public void setJobSeeker(String jobSeeker) {
		this.jobSeeker = jobSeeker;
	}

	public String getEmployer() {
		return employer;
	}

	public void setEmployer(String employer) {
		this.employer = employer;
	}

	public String getPostJob() {
		return postJob;
	}

	public void setPostJob(String postJob) {
		this.postJob = postJob;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
