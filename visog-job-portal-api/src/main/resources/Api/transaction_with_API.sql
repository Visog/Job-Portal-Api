

CREATE TABLE USERS 
(
	ID VARCHAR(37) NOT NULL,
	FIRST_NAME VARCHAR(200) NOT NULL,
	MIDDLE_NAME VARCHAR(200),
	LAST_NAME VARCHAR(200),
	ROLE_ID VARCHAR(37) NOT NULL,
	EMAIL VARCHAR(400) UNIQUE NOT NULL,
	ALTERNATIVE_EMAIL VARCHAR (400) ,
	GENDER_ID VARCHAR(37) NOT NULL,
	DOB TIMESTAMP,
	PASSWORD TEXT NOT NULL,
	PHONE_NO   VARCHAR(15),
	LANDLINE  VARCHAR(30),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (GENDER_ID) REFERENCES GENDER(ID),
	FOREIGN KEY (ROLE_ID) REFERENCES ROLES (ID)
) ;


/*
1. Register Employer
=====================================
url : /employer/registration
ex url :  /employer/registration
method : POST
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "ROLE_ID" : "112232",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
  }

response : 
{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Employer  Profile Created Successfully/ Failed to Create Employer profile"
	"data" : null
} 


2 Edit Employer Profile
=====================================
url : /employer/registration/<EMPLOYER_ID>
ex url : /employer/registration/1

method : PUT
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Employer Profile Updated Successfully/Employer Profile failed to update profile"
	"data" : null
} 

3. Get All Employer Profile
=====================================
url : /employer/registration
ex url : /employer/registration

method : GET
data : 
response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Employer Profile Updated Successfully/Failed to update Employer Profile"
	"data" : [
		{
		      "id" : 1,
			  "FIRST_NAME" : "Divya",
			  "MIDDLE_NAME" : "", 
			  "LAST_NAME" : "SHARMA",
			  "EMAIL" : "divyasharma@gmail.com",
			  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
			  "GENDER" : "112",
			  "DOB" : "17-08-2090",
			  "PASSWORD" : "********",
			  "PHONE_NO" :"12345",
			  "LANDLINE" : "0401236444"
		}, {},...
	]
} 

4. Get Employer Profile
=====================================
url : /employer/registration/<EMPLOYER_ID>
ex url : /employer/registration/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Employer profile Updated Successfully/Employer profile failed to update"
	"data" : {
	              "id" : 1,
				  "FIRST_NAME" : "Divya",
				  "MIDDLE_NAME" : "", 
				  "LAST_NAME" : "SHARMA",
				  "EMAIL" : "divyasharma@gmail.com",
				  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
				  "GENDER" : "112",
				  "DOB" : "17-08-2090",
				  "PASSWORD" : "********",
				  "PHONE_NO" :"12345",
				  "LANDLINE" : "0401236444"
	}
	
} 


5. Delete Employer Profile
=====================================
url : /employer/registration/<EMPLOYER_ID>
ex url : /employer/registration/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Employer profile Deleted Successfully/Employer failed to update profile"
	"data" : NULL
	
} 
  ---------------Job Seeker---------------------------
  1. Register Job Seeker
=====================================
url : /jobseeker/registration
ex url :  /jobseeker/registration
method : POST
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
  }

response : 
{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "JobSeeker  Profile Created Successfully/ Failed to Create JobSeeker profile"
	"data" : null
} 


2 Edit  JobSeeker Profile
=====================================
url : /jobseeker/registration/<JobSeeker_ID>
ex url : /jobseeker/registration/1

method : PUT
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "JobSeeker profile Updated Successfully/JobSeeker failed to update profile"
	"data" : null
} 

3. Get All JobSeeker Profile
=====================================
url : /jobseeker/registration
ex url : /jobseeker/registration

method : GET
data : 
response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "JobSeeker Profile Updated Successfully/Failed to update JobSeeker Profile"
	"data" : [
		{
		      "id" : 1,
			  "FIRST_NAME" : "Divya",
			  "MIDDLE_NAME" : "", 
			  "LAST_NAME" : "SHARMA",
			  "EMAIL" : "divyasharma@gmail.com",
			  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
			  "GENDER" : "112",
			  "DOB" : "17-08-2090",
			  "PASSWORD" : "********",
			  "PHONE_NO" :"12345",
			  "LANDLINE" : "0401236444"
		}, {},...
	]
} 

4. Get JobSeeker Profile
=====================================
url : /jobseeker/registration/<JobSeeker_ID>
ex url : /jobseeker/registration/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "JobSeeker profile Updated Successfully/JobSeeker profile failed to update"
	"data" : {
	              "id" : 1,
				  "FIRST_NAME" : "Divya",
				  "MIDDLE_NAME" : "", 
				  "LAST_NAME" : "SHARMA",
				  "EMAIL" : "divyasharma@gmail.com",
				  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
				  "GENDER" : "112",
				  "DOB" : "17-08-2090",
				  "PASSWORD" : "********",
				  "PHONE_NO" :"12345",
				  "LANDLINE" : "0401236444"
	}
	
} 


5. Delete JobSeeker Profile
=====================================
url : /jobseeker/registration/<JobSeeker_ID>
ex url : /jobseeker/registration/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "JobSeeker profile Deleted Successfully/JobSeeker failed to update profile"
	"data" : NULL
	
} 

-------------------------------Admin-----------------

Register Admin
=====================================
url : /admin/registration
ex url :  /admin/registration
method : POST
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
  }

response : 
{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Admin  Profile Created Successfully/ Failed to Create Admin profile"
	"data" : null
} 


2 Edit Admin Profile
=====================================
url : /admin/registration/<Admin_ID>
ex url : /admin/registration/1

method : PUT
data : 

{
		  "FIRST_NAME" : "Divya",
		  "MIDDLE_NAME" : "", 
		  "LAST_NAME" : "SHARMA",
		  "EMAIL" : "divyasharma@gmail.com",
		  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
		  "GENDER" : "112",
		  "DOB" : "17-08-2090",
		  "PASSWORD" : "********",
		  "PHONE_NO" :"12345",
		  "LANDLINE" : "0401236444"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Admin Profile Updated Successfully/Admin Profile failed to update profile"
	"data" : null
} 

3. Get All Admin Profile
=====================================
url : /admin/registration
ex url : /admin/registration

method : GET
data : 
response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Admin Profile Updated Successfully/Failed to update Admin Profile"
	"data" : [
		{
		      "id" : 1,
			  "FIRST_NAME" : "Divya",
			  "MIDDLE_NAME" : "", 
			  "LAST_NAME" : "SHARMA",
			  "EMAIL" : "divyasharma@gmail.com",
			  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
			  "GENDER" : "112",
			  "DOB" : "17-08-2090",
			  "PASSWORD" : "********",
			  "PHONE_NO" :"12345",
			  "LANDLINE" : "0401236444"
		}, {},...
	]
} 

4. Get Admin Profile
=====================================
url : /admin/registration/<Admin_ID>
ex url : /admin/registration/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Admin profile Updated Successfully/Admin profile failed to update"
	"data" : {
	              "id" : 1,
				  "FIRST_NAME" : "Divya",
				  "MIDDLE_NAME" : "", 
				  "LAST_NAME" : "SHARMA",
				  "EMAIL" : "divyasharma@gmail.com",
				  "ALTERNATIVE_EMAIL" : "divyasharma123@gmail.com",
				  "GENDER" : "112",
				  "DOB" : "17-08-2090",
				  "PASSWORD" : "********",
				  "PHONE_NO" :"12345",
				  "LANDLINE" : "0401236444"
	}
	
} 


5. Delete Admin Profile
=====================================
url : /admin/registration/<Admin_ID>
ex url : /admin/registration/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Admin profile Deleted Successfully/Admin failed to update profile"
	"data" : NULL
	
} 
*/

CREATE TABLE ADDRESS( 
	ID VARCHAR(37) NOT NULL,
	ADDRESS_LINE1 VARCHAR(500),
	ADDRESS_LINE2 VARCHAR(500),
	COUNTRY_ID VARCHAR(37) NOT NULL,
	STATE_ID VARCHAR(37),
	CITY_ID VARCHAR(37) NOT NULL,
	ZIPCODE VARCHAR(40) NOT NULL,
	ASSOCIATED_TYPE VARCHAR(100), -- USER/EMPLOYER/JOB SEEKER/INTERVIEW LOCATION
	ASSOCIATED_ID VARCHAR(37) NOT NULL,-- USERID/EMPLOYERID/JOBSEEKERID/JOBID
	ADDRESS_TYPE_ID  VARCHAR(37) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATE_ID) REFERENCES STATES (ID),
	FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID),
	FOREIGN KEY (CITY_ID) REFERENCES CITY (ID),
	FOREIGN KEY (ADDRESS_TYPE_ID) REFERENCES ADDRESS_TYPE(ID)
) ;
/*

1. Job Seeker ADDRESS
=====================================
url : /jobseeker/address
ex url : /jobseeker/address
method : POST
data : 

{
		"ADDRESS_LINE1" : "FLAT 301,SAI RESIDENCY " ,
		"ADDRESS_LINE2" : "NEAR WORLD ONE SCHOOL",
		"COUNTRY ":"101" ,
		"STATE " :"102" ,
		"CITY " :"103" ,
		"ZIPCODE" : "10001",
		"ASSOCIATED_TYPE" : "INTERVIEW LOCATION",
		"ADDRESS_TYPE "  : "001"

}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "user address Created Successfully/ failed to create user address"
	"data" : null
} 

2 Edit Job Seeker  address
=====================================
url : /jobseeker/address/<USER_ADDRESS_ID>
ex url : /jobseeker/address/2

method : PUT
data : 

{
		"ADDRESS_LINE1" : "FLAT 301,SAI RESIDENCY " ,
		"ADDRESS_LINE2" : "NEAR WORLD ONE SCHOOL",
		"COUNTRY ":"101" ,
		"STATE " :"102" ,
		"CITY " :"103" ,
		"ZIPCODE" : "10001",
		"ASSOCIATED_TYPE" : "INTERVIEW LOCATION",
		"ADDRESS_TYPE "  : "001"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "user address Updated Successfully/ failed to update user address"
	"data" : null
} 

3. Get All Job Seeker address
=====================================
url : /jobseeker/address
ex url : /jobseeker/address

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "user address Updated Successfully/ failed to update user address"
	"data" : [
		{
		        "id" : 1,
				"ADDRESS_LINE1" : "FLAT 301,SAI RESIDENCY " ,
				"ADDRESS_LINE2" : "NEAR WORLD ONE SCHOOL",
				"COUNTRY ":"101" ,
				"STATE " :"102" ,
				"CITY " :"103" ,
				"ZIPCODE" : "10001",
				"ASSOCIATED " : "2"  ,
				"ASSOCIATED_TYPE" : "INTERVIEW LOCATION",
				"ADDRESS_TYPE "  : "001"
}, {},...
	]
} 

4. Get Job Seeker address
=====================================
url : /jobseeker/address/<USER_ADDRESS_ID>
ex url : /jobseeker/address/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "user address updated Successfully/ failed to update user address"
	"data" : {
	            "id" : 1,
				"ADDRESS_LINE1" : "FLAT 301,SAI RESIDENCY " ,
				"ADDRESS_LINE2" : "NEAR WORLD ONE SCHOOL",
				"COUNTRY ":"101" ,
				"STATE " :"102" ,
				"CITY " :"103" ,
				"ZIPCODE" : "10001",
				"ASSOCIATED " : "2"  ,
				"ASSOCIATED_TYPE" : "INTERVIEW LOCATION",
				"ADDRESS_TYPE "  : "001"
	}
	
} 

5. Delete Job Seeker address
=====================================
url : /jobseeker/address/<USER_ADDRESS_ID>
ex url : /jobseeker/address/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "user address Deleted Successfully/ failed to update user address"
	"data" : NULL
	
} 




*/


CREATE TABLE EMPLOYER
(
	ID VARCHAR(37) NOT NULL,
	USER_ID  VARCHAR(37) NOT NULL,
	INDUSTRY_ID  VARCHAR(37) NOT NULL,
	EMPLOYER_TYPE_ID  VARCHAR(37) NOT NULL,-- CONSULTANT/HR/...
	PREMIUM_EMPLOYER CHAR(1),-- here we placed 0 or 1 if no than 0 otherwise 1
	COMPANY_NAME  VARCHAR(200),
	REGISTERED_DATE TIMESTAMP, 
	REGISTRATION_NUMBER VARCHAR(40),
	CIN  VARCHAR(50),  -- UNIQUE NUMBER FOR COMPANY PROVIDED Y GOVERMENT
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (EMPLOYER_TYPE_ID) REFERENCES EMPLOYER_TYPE(ID),
	FOREIGN KEY (USER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (INDUSTRY_ID) REFERENCES INDUSTRY(ID)
);
/*
1. Create EMPLOYER
=====================================
url : /employer/details
ex url : /employer/details
method : POST
data : 

{
		"USER_ID" : "101",
		"INDUSTRY" : "098",
		"EMPLOYER_TYPE" : "099",
		"PREMIUM_EMPLOYER"  : "1"
		"COMPANY_NAME" : "visog global",
		"REGISTERED_DATE" : "10-10-2016",
		"REGISTRATION_NUMBER": "112244",
		"CIN" : "0JGJ99",  
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "created employer profile successfully/ failed to create employer profile"
	"data" : null
} 

2 Edit  employer
=====================================
url : /employer/details
ex url : /employer/details

method : PUT
data : 

{
		"USER" : "101",
		"INDUSTRY" : "098",
		"EMPLOYER_TYPE" : "099",
		"PREMIUM_EMPLOYER"  : "1"
		"COMPANY_NAME" : "visog global",
		"REGISTERED_DATE" : "10-10-2016",
		"REGISTRATION_NUMBER": "112244",
		"CIN" : "0JGJ99"
} 

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "updated employer profile successfully/ failed to update employer profile"
	"data" : null
} 


3. Get ALL EMPLOYERS
=====================================
url : /employer/details
ex url : /employer/details

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer profile Updated Successfully/ failed to update employer profile"
	"data" : 
	[	{
		        "id" : 1,
				"USER" : "101",
				"INDUSTRY" : "098",
				"EMPLOYER_TYPE" : "099",
				"PREMIUM_EMPLOYER"  : "1"
				"COMPANY_NAME" : "visog global",
				"REGISTERED_DATE" : "10-10-2016",
				"REGISTRATION_NUMBER": "112244",
				"CIN" : "0JGJ99"
        } ,{}
     ]
4. Get EMPLOYERS
=====================================
url : /employer/details
ex url : /employer/details
method : GET
data : 


response : 

{

"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer profile Deleted Successfully/ failed to update employer profile"
	"data" : 
	{
	            "id" : 1,
				"USER" : "101",
				"INDUSTRY" : "098",
				"EMPLOYER_TYPE" : "099",
				"PREMIUM_EMPLOYER"  : "1"
				"COMPANY_NAME" : "visog global",
				"REGISTERED_DATE" : "10-10-2016",
				"REGISTRATION_NUMBER": "112244",
				"CIN" : "0JGJ99"
	} 

5. Delete EMPLOYER
=====================================
url : /employer/details
ex url : /employer/details

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer profile Deleted Successfully/ failed to update employer profile"
	"data" : NULL
	
} 

 

*/


CREATE TABLE POST_JOB(
	ID VARCHAR(37) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,
	JOB_TITLE VARCHAR(250),
	JOB_DESCRIPTION VARCHAR(4000),
	ANNUAL_PACKAGE_FROM  DOUBLE,
	ANNUAL_PACKAGE_TO  DOUBLE,  
	CURRENCY_ID VARCHAR(37) NOT NULL,
	COMPANY VARCHAR(50) NOT NULL,
	EFFECTED_DATE_FROM TIMESTAMP,
	EFFECTED_DATE_TO  TIMESTAMP,
	STATUS_ID  VARCHAR(37),
	MIN_EXPERIENCE INT(2),
	PHONE_NO   VARCHAR(20),
	WALKIN  TEXT,-- is job post is walkin here 0 for no and 1 for yes
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID),
	FOREIGN KEY (CURRENCY_ID) REFERENCES  CURRENCY(ID )
);


/*
1. Create POST_JOB
=====================================
url : /employer/post_job
ex url : /employer/post_job
method : POST
data : 

{
		"USER" : "1213"
		"JOB_TITLE" : "Looking for a Lead IT Recruiter - 6 plus Years",
		"JOB_DESCRIPTION": "End to End IT recruitment,Team Handling ",
		"ANNUAL_PACKAGE_FROM":"450000",
		"ANNUAL_PACKAGE_TO":600000",
		"CURRENCY":"INR",
		"COMPANY" : "VISOG GLOBAL",
		"EFFECTED_DATE":"01-01-16",
		"EFFECTED_DATE_TO":"10-10-16",
		"STATUS":"ACTIVE",
		"MIN_EXPERIENCE":"5",
		"PHONE_NO":"8142233888",
		"WALKIN":"0",
  
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : " Created POST JOB Successfully/ Failed to create POST JOB"
	"data" : null
} 

2 Edit  POST_JOB
=====================================
url : /employer/post_job
ex url : /employer/post_job

method : PUT
data : 

{
		"USER" : "1213"
		"JOB_TITLE" : "Looking for a Lead IT Recruiter - 6 plus Years",
		"JOB_DESCRIPTION": "End to End IT recruitment,Team Handling ",
		"ANNUAL_PACKAGE_FROM":"450000",
		"ANNUAL_PACKAGE_TO":600000",
		"CURRENCY":"INR",
		"COMPANY" : "VISOG GLOBAL",
		"EFFECTED_DATE":"01-01-16",
		"EFFECTED_DATE_TO":"10-10-16",
		"STATUS":"ACTIVE",
		"MIN_EXPERIENCE":"5",
		"PHONE_NO":"8142233888",
		"WALKIN":"0"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "POST JOB Updated Successfully/ Failed to update POST JOB"
	"data" : null
} 

3. Get ALL POST_JOB
=====================================
url : /employer/post_job
ex url : /employer/post_job

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "POST JOB Updated Successfully/ Failed to update POST JOB"
	"data" : [
			{ 
			        "id" : 1,
					"USER" : "1213"
					"JOB_TITLE" : "Looking for a Lead IT Recruiter - 6 plus Years",
					"JOB_DESCRIPTION": "End to End IT recruitment,Team Handling ",
					"ANNUAL_PACKAGE_FROM":"450000",
					"ANNUAL_PACKAGE_TO":600000",
					"CURRENCY":"INR",
					"COMPANY" : "VISOG GLOBAL",
					"EFFECTED_DATE":"01-01-16",
					"EFFECTED_DATE_TO":"10-10-16",
					"STATUS":"ACTIVE",
					"MIN_EXPERIENCE":"5",
					"PHONE_NO":"8142233888",
					"WALKIN":"0"
           } 

4. Get POST_JOB
=====================================
url : /employer/post_job
ex url : /employer/post_job

method : GET
data : 


response : 

{

"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "POST JOB updated Successfully/ Failed to update POST JOB"
	"data" : 
	        "id" : 1,
			"USER" : "1213"
			"JOB_TITLE" : "Looking for a Lead IT Recruiter - 6 plus Years",
			"JOB_DESCRIPTION": "End to End IT recruitment,Team Handling ",
			"ANNUAL_PACKAGE_FROM":"450000",
			"ANNUAL_PACKAGE_TO":600000",
			"CURRENCY":"INR",
			"COMPANY" : "VISOG GLOBAL",
			"EFFECTED_DATE":"01-01-16",
			"EFFECTED_DATE_TO":"10-10-16",
			"STATUS":"ACTIVE",
			"MIN_EXPERIENCE":"5",
			"PHONE_NO":"8142233888",
			"WALKIN":"0"
	
} 

5. Delete POST_JOB
=====================================
url : /employer/post_job
ex url : /employer/post_job

method : DELETE
data : 

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details deleted successfully/ failed to update details"
	"data" : NULL
	
	} 

*/

CREATE TABLE POST_JOB_DOMAINS(
	ID VARCHAR(37) NOT NULL,
	POST_JOB_ID VARCHAR(37) NOT NULL,
	DOMAIN_ID VARCHAR(37) NOT NULL, 
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (POST_JOB_ID) REFERENCES POST_JOB(ID),
	FOREIGN KEY (DOMAIN_ID) REFERENCES DOMAINS(ID)
);
/*
1. Create POST_JOB_DOMAINS
=====================================
url : /employer/post_job_domains
ex url : /employer/post_job_domains
method : POST
data : 

{
		  "POST_JOB" : "1212", 
		  "DOMAIN" : "1212", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "deltails created sucessfully/ failed to create details"
	"data" : null
} 

2 Edit  post_job_domains
=====================================
url : /employer/post_job_domains/<POST_JOB_DOMAINS_ID>
ex url : /employer/post_job_domains/2

method : PUT
data : 

{
		  "POST_JOB" : "1212", 
		  "DOMAIN" : "1212", 
  }

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : " deltails created sucessfully/ failed to create details"
	"data" : null
} 

3. Get All post_job_domains
=====================================
url : /employer/post_job_domains
ex url : /employer/post_job_domains

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "post_job_domains updated sucessfully/ Failed to update post_job_domains"
	"data" : [
		{  
		   "id" :"1",
		  "POST_JOB" : "1212", 
		  "DOMAIN" : "1212", 
		}, {},...
	]
} 

4. Get post_job_domains
=====================================
url : /employer/post_job_domains/<POST_JOB_DOMAINS_ID>
ex url : /employer/post_job_domains/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "post_job_domains updated sucessfully/ Failed to update post_job_domains"
	"data" : {
			   "id" :"1",
			  "POST_JOB" : "1212", 
			  "DOMAIN" : "1212", 
	}
	
} 

5. Delete post_job_domains
=====================================
url : /employer/post_job_domains/<POST_JOB_DOMAINS_ID>
ex url : /employer/post_job_domains/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : " deltails created sucessfully/ failed to create details"
	"data" : NULL
	
} 

*/


CREATE TABLE FILES(
	ID VARCHAR(37) NOT NULL,
	FILE_PATH VARCHAR(500) NOT NULL,
	FILE_TYPE_ID VARCHAR(37) NOT NULL,
	ASSOCIATED_TYPE VARCHAR(100), -- USERPROFILE/JOBPOST/
	ASSOCIATED_ID VARCHAR(37) NOT NULL,-- USERID/JOBID
	PRIMARY KEY (ID),
	FOREIGN KEY (FILE_TYPE_ID) REFERENCES FILE_TYPE(ID)
);

/*

1. Create FILES
=====================================
url : /attachment/files
ex url : /attachment/files
method : POST
data : 

{  
	  "FILE_PATH" :"c/folderA/",
	  "FILE_TYPE:"111",
	  "ASSOCIATED_TYPE":"JOBPOST",
	  "ASSOCIATED":"1112"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "files details Created Successfully/ Failed to create files details"
	"data" : null
} 

2 Edit  files
=====================================
url : /attachment/files/<FILE_ID>
ex url : /attachment/files/2

method : PUT
data : 

{
	"FILE_PATH" :"c/folderA/",
	"FILE_TYPE:"111",
	"ASSOCIATED_TYPE":"JOBPOST",
	 "ASSOCIATED":"1112"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "files details Updated Successfully/ Failed to update files details"
	"data" : null
} 

3. Get All files
=====================================
url : /attachment/files
ex url : /attachment/files

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "files details Updated Successfully/ Failed to update files details"
	"data" : [
		{
{    
       "ID":"12",
      "FILE_PATH" :"c/folderA/",
	  "FILE_TYPE:"111",
	   "ASSOCIATED_TYPE":"JOBPOST",
	  "ASSOCIATED":"1112"
	  }, {},...
	]
} 

4. Get files
=====================================
url : /attachment/files/<FILE_ID>
ex url : /attachment/files/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "files details Updated Successfully/ Failed to update files details"
	"data" : {
	         "ID":"12",
			"FILE_PATH" :"c/folderA/",
			 "FILE_TYPE:"111",
			 "ASSOCIATED_TYPE":"JOBPOST",
	         "ASSOCIATED":"1112"
	         }
	
} 

5. Delete files
=====================================
url : /attachment/files/<FILE_ID>
ex url : /attachment/files/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "files details deleted successfully/ Failed to update files details"
	"data" : NULL
	
} 


*/

CREATE TABLE EMPLOYER_JOBSEEKER(
	ID VARCHAR(37) NOT NULL,
	EMPLOYER_ID VARCHAR(37) NOT NULL,
	JOB_SEEKER_ID  VARCHAR(37) NOT NULL,
	STATUS_ID  VARCHAR(37),
	ACTION_DONE_BY VARCHAR(50), -- EMPLOYER/JOBSEEKER
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (JOB_SEEKER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (EMPLOYER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (STATUS_ID) REFERENCES STATUS(ID)
);
/*
1. Create EMPLOYER_JOBSEEKER
=====================================
url : /transaction/employer_jobseeker
ex url : /transaction/employer_jobseeker
method : POST
data : 

		{
					"EMPLOYER" : "141",
					"JOB_SEEKER" : "101",
					"STATUS" : "ACTIVE"
					"ACTION_DONE_BY" : "employer"
		}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : " Created EMPLOYER ACTION Successfully/ Failed to create EMPLOYER ACTION"
	"data" : null
} 

2 Edit  employer_jobseeker
=====================================
url : /transaction/employer_jobseeker
ex url : /transaction/employer_jobseeker
method : PUT
data : 

		{
				
				"JOB_SEEKER" : "101",//fk from users
				"EMPLOYER" : "141",//fk from users
				"FOR_POST_JOB" : "121",//fk FROM POST_JOB
				"STATUS" : "ACTIVE"
		} 

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : " UPDATED EMPLOYER ACTION Successfully/ Failed to UPDATE EMPLOYER ACTION"
	"data" : null
} 


3. Get ALL employer_jobseeker
=====================================
url : /transaction/employer_jobseeker
ex url : /transaction/employer_jobseeker

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "EMPLOYERS ACTION Updated Successfully/ Failed to update EMPLOYERS ACTION"
	"data" : 
		{ 
			 "ID" : "1",
			"JOB_SEEKER" : "101",//fk from users
			"EMPLOYER" : "141",//fk from users
			"FOR_POST_JOB" : "121",//fk FROM POST_JOB
			"STATUS" : "ACTIVE"
        } 

4. Get employer_jobseeker
=====================================
url : /transaction/employer_jobseeker
ex url : /transaction/employer_jobseeker

method : GET
data : 


response : 

{

"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "EMPLOYERS ACTION updated Successfully/ Failed to update EMPLOYERS ACTION"
	"data" : 
{
		"ID" : "1",
		"JOB_SEEKER" : "101",//fk from users
		"EMPLOYER" : "141",//fk from users
		"FOR_POST_JOB" : "121",//fk FROM POST_JOB
		"STATUS" : "ACTIVE" 
} 

5. Delete employer_jobseeker
=====================================
url : /transaction/employer_jobseeker
ex url : /transaction/employer_jobseeker

method : DELETE
data : 

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "profile deleted successfully/ failed to update profile"
	"data" : NULL
	
} 

*/
CREATE TABLE POSTJOB_SEEKER(
	ID VARCHAR(37) NOT NULL,
	JOB_SEEKER_ID  VARCHAR(37) NOT NULL,
	EMPLOYER_ID VARCHAR(37) NOT NULL,
	POST_JOB_ID VARCHAR(37) NOT NULL,
	STATUS_ID  VARCHAR(37),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (JOB_SEEKER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (EMPLOYER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (POST_JOB_ID) REFERENCES POST_JOB(ID)
);
/*
1. Create POSTJOB_SEEKER
=====================================
url : /transaction/postjob_seeker
ex url : /transaction/postjob_seeker
method : POST
data : 

{
	 "JOB_SEEKER " : "1234", 
	 "EMPLOYER " : "134", 
	 "POST_JOB " : "121DF", 
	 "STATUS  " : "2323"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "details Created sucessfully/ Failed to create details"
	"data" : null
} 

2 Edit  postjob_seeker
=====================================
url : /transaction/postjob_seeker/<POSTJOB_SEEKER_ID>
ex url : /transaction/postjob_seeker/2

method : PUT
data : 

{
		 "JOB_SEEKER " : "1234", 
		 "EMPLOYER " : "134", 
		 "POST_JOB " : "121DF", 
		 "STATUS  " : "2323"
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "details updated sucessfully/ Failed to update details"
	"data" : null
} 

3. Get All postjob_seeker
=====================================
url : /transaction/postjob_seeker
ex url : /transaction/postjob_seeker

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "details updated sucessfully/ Failed to update details"
	"data" : [
{
  "ID" : "1",
 "JOB_SEEKER " : "1234", 
 "EMPLOYER " : "134", 
 "POST_JOB " : "121DF", 
 "STATUS  " : "2323"
}, {},...
	]
} 

4. Get postjob_seeker
=====================================
url : /transaction/postjob_seeker/<POSTJOB_SEEKER_ID>
ex url : /transaction/postjob_seeker/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "details updated sucessfully/ Failed to update details"
	"data" : {
	             "ID" : "1",
				 "JOB_SEEKER " : "1234", 
				 "EMPLOYER " : "134", 
				 "POST_JOB " : "121DF", 
				 "STATUS  " : "2323"
             }
	
} 

5. Delete postjob_seeker
=====================================
url : /transaction/postjob_seeker/<POSTJOB_SEEKER_ID>
ex url : /transaction/postjob_seeker/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "details deleted sucessfully/ failed to update details"
	"data" : NULL
	
} 

*/

CREATE TABLE JOB_SEEKER
(
	ID VARCHAR(37) NOT NULL,
	RESUME_HEADLINE  VARCHAR(300),
	DOMAIN_ID VARCHAR(37) NOT NULL,
	COMPANY_NAME VARCHAR(100),
	USER_ID VARCHAR(37) NOT NULL,
	KEY_SKILLS VARCHAR(250) NOT NULL,
	WORK_EXPERIENCE_YEARS INT,
	WORK_EXPERIENCE_MONTHS INT,
	HOBBIES_AND_INTEREST  VARCHAR(250),
	JOB_ROLE_ID VARCHAR(37),
	OTHER_JOB_ROLE VARCHAR(500),
	INDUSTRY_ID VARCHAR(37),
	PROFILE_SUMMERY TEXT,
	EMPLOYMENT_TYPE_ID VARCHAR(37) NOT NULL,-- full time /part time
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (INDUSTRY_ID) REFERENCES INDUSTRY(ID),
	FOREIGN KEY (DOMAIN_ID) REFERENCES DOMAINS(ID),
	FOREIGN KEY (USER_ID) REFERENCES  USERS(ID),
	FOREIGN KEY (JOB_ROLE_ID)REFERENCES JOB_ROLE(ID),
	FOREIGN KEY (EMPLOYMENT_TYPE_ID) REFERENCES EMPLOYMENT_TYPE(ID)
) ;

/*

1. Create JOB_SEEKER
=====================================
url : /job_seeker/details
ex url : /job_seeker/details
method : POST
data : 

{ 

		"USER": "1",
		"RESUME_HEADLINE": "JAVA DEVELOPER RESUME",
		"DOMAINS": "001",
		"COMPANY_NAME": "visog global", 
		"USER": "102",  
		"KEY_SKILLS": "JSP,SERVLET", 
		"WORK_EXPERIENCE_YEARS": "01", 
		"WORK_EXPERIENCE_MONTHS": "08",
		"HOBBIES_AND_INTEREST": "PLAYING CARROM,", 
		"JOB_ROLE": "101", 
		"OTHER_JOB_ROLE": " testing ,documentation", 
		"INDUSTRY": "101", 
		"PROFILE_SUMMERY": "JAVA DEVELOPER HAVIBG 2 YEAR OF EXPERIENCE", 
		"EMPLOYMENT_TYPE": "121", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job seeker details fill Created Successfully/ Failed to create job seeker details "
	"data" : null
} 

2 Edit  job_seeker
=====================================
url : /job_seeker/details/<JOB_SEEKER_ID>
ex url : /job_seeker/details/2

method : PUT
data : 

{ 
		"USER": "1",
		"RESUME_HEADLINE": "JAVA DEVELOPER RESUME",
		"DOMAINS": "001",
		"COMPANY_NAME": "visog global", 
		"USER": "102",  
		"KEY_SKILLS": "JSP,SERVLET", 
		"WORK_EXPERIENCE_YEARS": "01", 
		"WORK_EXPERIENCE_MONTHS": "08",
		"HOBBIES_AND_INTEREST": "PLAYING CARROM,", 
		"JOB_ROLE": "101", 
		"OTHER_JOB_ROLE": " testing ,documentation", 
		INDUSTRY": "101", 
		"PROFILE_SUMMERY": "JAVA DEVELOPER HAVIBG 2 YEAR OF EXPERIENCE", 
		"EMPLOYMENT_TYPE": "121", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job seeker details profile Updated Successfully/ Failed to update job seeker details profile"
	"data" : null
} 

3. Get All job_seeker
=====================================
url : /job_seeker/details
ex url : /job_seeker/details

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job_seeker Updated Successfully/ Failed to update job_seeker"
	"data" : [
		{
		    "ID" : "1",
			"USER": "1",
			"RESUME_HEADLINE": "JAVA DEVELOPER RESUME",
			"DOMAINS": "001",
			"COMPANY_NAME": "visog global", 
			"USER": "102",  
			"KEY_SKILLS": "JSP,SERVLET", 
			"WORK_EXPERIENCE_YEARS": "01", 
			"WORK_EXPERIENCE_MONTHS": "08",
			"HOBBIES_AND_INTEREST": "PLAYING CARROM,", 
			"JOB_ROLE": "101", 
			"OTHER_JOB_ROLE": " testing ,documentation", 
			INDUSTRY": "101", 
			"PROFILE_SUMMERY": "JAVA DEVELOPER HAVIBG 2 YEAR OF EXPERIENCE", 
			"EMPLOYMENT_TYPE": "121",
		}, {},...
	]
} 

4. Get job_seeker
=====================================
url : /job_seeker/details/<JOB_SEEKER_ID>
ex url : /job_seeker/details/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job_seeker Updated Successfully/ Failed to update job_seeker"
	"data" : { 
	            "ID":"76",
				"USER": "1",
				"RESUME_HEADLINE": "JAVA DEVELOPER RESUME",
				"DOMAINS": "001",
				"COMPANY_NAME": "visog global", 
				"USER": "102",  
				"KEY_SKILLS": "JSP,SERVLET", 
				"WORK_EXPERIENCE_YEARS": "01", 
				"WORK_EXPERIENCE_MONTHS": "08",
				"HOBBIES_AND_INTEREST": "PLAYING CARROM,", 
				"JOB_ROLE": "101", 
				"OTHER_JOB_ROLE": " testing ,documentation", 
				INDUSTRY": "101", 
				"PROFILE_SUMMERY": "JAVA DEVELOPER HAVIBG 2 YEAR OF EXPERIENCE", 
				"EMPLOYMENT_TYPE": "121", 	
			}
	
} 

5. Delete job_seeker
=====================================
url : /job_seeker/details/<JOB_SEEKER_ID>
ex url : /job_seeker/details/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job seeker details Deleted Successfully/ Failed to update job seeker details"
	"data" : NULL
	
} 


*/


CREATE TABLE EDUCATION_DETAILS(
	ID  VARCHAR(37) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,
	COURSES_ID VARCHAR(37) NOT NULL,
	EDUCATION_TYPE_ID VARCHAR(37) NOT NULL,
	SPECILIZATION_ID  VARCHAR(300),
	UNIVERSITY_ID  VARCHAR(37) NOT NULL,
	DURATION_FROM DATE,
	DURATION_TO_DATE DATE,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (COURSES_ID) REFERENCES COURSES(ID),
	FOREIGN KEY (SPECILIZATION_ID) REFERENCES SPECILIZATION(ID),
	FOREIGN KEY (UNIVERSITY_ID) REFERENCES UNIVERSITY(ID),
	FOREIGN KEY (EDUCATION_TYPE_ID) REFERENCES EDUCATION_TYPE(ID),
	FOREIGN KEY (COURSES_ID) REFERENCES COURSES(ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
) ;

/*

1. Create EDUCATION_DETAILS
=====================================
url : /education/details
ex url : /education/details
method : POST
data : 

{
	 "USER" : "101",
	 "COURSES" : "101",
	 "EDUCATION_TYPE" : "101",
	 "SPECILIZATION" : "101",
	 "UNIVERSITY" : "101",
	 "DURATION_FROM" : "01/06/2001",
	 "DURATION_TO_DATE" : "01/07/2004", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education details Created Successfully/ Failed to create education details"
	"data" : null
} 

2 Edit  EDUCATION_DETAILS
=====================================
url : /education/details/<EDUCATION>
ex url : /education/details/2

method : PUT
data : 

{
 	 "USER": "101",
	 "COURSES": "101",//FK FROM COURSES BTECH
	 "EDUCATION_TYPE" : "101",//FK FROM EDUCATION_TYPE LIKE FULL TIME,OPEN
	 "SPECILIZATION" : "101",//FK FROM SPECILIZATION INFORMATION TECHNOLOGY
	 "UNIVERSITY" : "101",//FK FROM UNIVERSITY LIKE RAJASTHAN TECHNICAL UNIVERSITY
	 "DURATION_FROM" : "01/06/2001",
	 "DURATION_TO_DATE" : "01/07/2004", 

}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education details Updated Successfully/ Failed to update education details "
	"data" : null
} 

3. Get All EDUCATION_DETAILS
=====================================
url : /education/details
ex url : /education/details

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education details Updated Successfully/ Failed to update education details"
	"data" : [
		{ 
	 "ID":"123",	
	 "USER" : "101",
	 "COURSES" : "101",//FK FROM COURSES BTECH
	 "EDUCATION_TYPE" : "101",//FK FROM EDUCATION_TYPE LIKE FULL TIME,OPEN
	 "SPECILIZATION" : "101",//FK FROM SPECILIZATION INFORMATION TECHNOLOGY
	 "UNIVERSITY": "101",//FK FROM UNIVERSITY LIKE RAJASTHAN TECHNICAL UNIVERSITY
	 "DURATION_FROM" : "01/06/2001",
	 "DURATION_TO_DATE" : "01/07/2004", 
		}, {},...
	]
} 

4. Get EDUCATION_DETAILS
=====================================
url : /education/details/<EDUCATION>
ex url : /education/details/2

method : GET
data : 


response : 

{
    "id":"57",
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education details Updated Successfully/ Failed to update education details"
	"data" : { 
	 "USER": "101",
	 "COURSES" : "101",//FK FROM COURSES BTECH
	 "EDUCATION_TYPE" : "101",//FK FROM EDUCATION_TYPE LIKE FULL TIME,OPEN
	 "SPECILIZATION" : "101",//FK FROM SPECILIZATION INFORMATION TECHNOLOGY
	 "UNIVERSITY": "101",//FK FROM UNIVERSITY LIKE RAJASTHAN TECHNICAL UNIVERSITY
	 "DURATION_FROM" : "01/06/2001",
	 "DURATION_TO_DATE" : "01/07/2004", 
	}
	
} 

5. Delete EDUCATION_DETAILS
=====================================
url : /education/details/<EDUCATION_ID>
ex url : /education/details/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education details Deleted Successfully/ Failed to update education details"
	"data" : NULL
	
} 


*/



CREATE TABLE LANGUAGE_KNOWN(
	ID  VARCHAR(37) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,
	LANGUAGE_ID VARCHAR(37) NOT NULL,
	READ_ID CHAR(1), -- here 0 for no and 1 for yes
	WRITE_ID CHAR(1), -- here 0 for no and 1 for yes
	SPEAK CHAR(1), -- here 0 for no and 1 for yes
	PROFICENCY_LEVEL  INT(2),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (LANGUAGE_ID) REFERENCES LANGUAGES(ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID)
) ;
/*

1. Create LANGUAGE_KNOWN
=====================================
url : /language/known
ex url : /language/known
method : POST
data : 

{
"USER" : "101",
"LANGUAGE" : "102",
"READ" : "0",
"WRITE" : "1",
"SPEAK" : "1",
"PROFICENCY" : "5",
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language details Created Successfully/ Failed to create language details"
	"data" : null
} 

2 Edit  LANGUAGE_KNOWN
=====================================
url : /language/known/<LANGUAGE_ID>
ex url : /language/known/2

method : PUT
data : 

{
"USER" : "101",
"LANGUAGE" : "102",
"READ" : "0",
"WRITE" : "1",
"SPEAK" : "1",
"PROFICENCY" : "5",
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language details Updated Successfully/ Failed to update language details"
	"data" : null
} 

3. Get All LANGUAGE_KNOWN
=====================================
url : /language/known
ex url : /language/known

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language details Updated Successfully/ Failed to update language details"
	"data" : [
		{ 
"ID" : "1",
"USER" : "101",
"LANGUAGE" : "102",
"READ" : "0",
"WRITE" : "1",
"SPEAK" : "1",
"PROFICENCY" : "5",
		}, {},...
	]
} 

4. Get language
=====================================
url : /language/known/<LANGUAGE_ID>
ex url : /language/known/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language details Updated Successfully/ Failed to update language details"
	"data" : { 
"ID":"45",
"USER" : "101",
"LANGUAGE" : "102",
"READ" : "0",
"WRITE" : "1",
"SPEAK" : "1",
"PROFICENCY" : "5",
	}
	
} 

5. Delete language
=====================================
url : /language/known/<LANGUAGE_ID>
ex url : /language/known/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language details Deleted Successfully/ Failed to update language details"
	"data" : NULL
	
} 


*/
CREATE TABLE PROJECT_DETAILS(
	ID  VARCHAR(37) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,
	JOB_RESPONSIBILITIES VARCHAR(1000),
	PROJECT_DETAILS TEXT,
	PROJECT_TITLE VARCHAR(500),
	EMPLOYMENT_TYPE_ID VARCHAR(37) NOT NULL,-- contractual/permanent
	CLINT_NAME VARCHAR(37),
	DURATION_FROM DATE,
	DURATION_TO DATE,
	TEAM_SIZE INT(2),
	TECHNOLOGIES_USED  VARCHAR(250),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID),	
	FOREIGN KEY (EMPLOYMENT_TYPE_ID) REFERENCES EMPLOYMENT_TYPE(ID)
) ;
/*

1. Create PROJECT_DETAILS
=====================================
url : /project/details
ex url : /project/details
method : POST
data : 

{
"JOB_SEEKER" : "101",
"ID" : "121",
"PROJECT_DETAILS" : "JOB PORTAL PROJECT",
"PROJECT_TITLE" : "JOB PORTTAL",
"EMPLOYMENT_TYPE" : "123",
"EMPLOYER_NAME" : "ABC",
"DURATION_FROM" : "01/01/2004",
"DURATION_TO" : "01/01/2006",
"PROJECT_LOCATION" : " SRI KRISHNA RESIDENDCY ,HYDERABAD",
"JOB_PROFILE" : "TEAM LEADER",
"TEAM_SIZE" : "4",
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "project details Created Successfully/ Failed to create project details"
	"data" : null
} 

2 Edit  PROJECT_DETAILS
=====================================
url : /project/details/<PROJECT_ID>
ex url : /project/details/2

method : PUT
data : 

{
 "JOB_SEEKER" : "101",
"ID" : "121",
"PROJECT_DETAILS" : "JOB PORTAL PROJECT",
"PROJECT_TITLE" : "JOB PORTTAL",
"EMPLOYMENT_TYPE" : "123",
"EMPLOYER_NAME" : "ABC",
"DURATION_FROM" : "01/01/2004",
"DURATION_TO" : "01/01/2006",
"PROJECT_LOCATION" : " SRI KRISHNA RESIDENDCY ,HYDERABAD",
"JOB_PROFILE" : "TEAM LEADER",
"TEAM_SIZE" : "4",
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "project details Updated Successfully/ Failed to update project details"
	"data" : null
} 

3. Get All PROJECT_DETAILS
=====================================
url : /project/details
ex url : /project/details

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "project details Updated Successfully/ Failed to update project details"
	"data" : [
		{
		    "ID":"545",
			"JOB_SEEKER" : "101",
			"ID" : "121",
			"PROJECT_DETAILS" : "JOB PORTAL PROJECT",
			"PROJECT_TITLE" : "JOB PORTTAL",
			"EMPLOYMENT_TYPE" : "123",
			"EMPLOYER_NAME" : "ABC",
			"DURATION_FROM" : "01/01/2004",
			"DURATION_TO" : "01/01/2006",
			"PROJECT_LOCATION" : " SRI KRISHNA RESIDENDCY ,HYDERABAD",
			"JOB_PROFILE" : "TEAM LEADER",
			"TEAM_SIZE" : "4",
		}, {},...
	]
} 

4. Get PROJECT_DETAILS
=====================================
url : /project/details/<PROJECT_ID>
ex url : /project/details/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "project details Updated Successfully/ Failed to update project details"
	"data" : {
	        "ID":"122",
			"JOB_SEEKER" : "101",
			"ID" : "121",
			"PROJECT_DETAILS" : "JOB PORTAL PROJECT",
			"PROJECT_TITLE" : "JOB PORTTAL",
			"EMPLOYMENT_TYPE" : "123",
			"EMPLOYER_NAME" : "ABC",
			"DURATION_FROM" : "01/01/2004",
			"DURATION_TO" : "01/01/2006",
			"PROJECT_LOCATION" : " SRI KRISHNA RESIDENDCY ,HYDERABAD",
			"JOB_PROFILE" : "TEAM LEADER",
			"TEAM_SIZE" : "4",
	}
	
} 

5. Delete PROJECT_DETAILS
=====================================
url : /project/details/<PROJECT_ID>
ex url : /project/details/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "project details Deleted Successfully/ Failed to update project details"
	"data" : NULL
	
} 


*/
CREATE TABLE EXPERIENCE_DETAILS
(
	ID  VARCHAR(37) NOT NULL,
	USER_ID VARCHAR(37) NOT NULL,
	COMPANY_NAME VARCHAR(250) NOT NULL,
	EMPLOYMENT_TYPE VARCHAR(37) NOT NULL,-- contractual/permanent 
	DURATION_FROM DATE,
	DURATION_TO DATE,
	DESIGNATION  VARCHAR(250) NOT NULL,
	JOB_PROFILE VARCHAR(500),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (USER_ID) REFERENCES USERS(ID)) ;
	/*

1. Create EXPERIENCE_DETAILS
=====================================
url : /experience/details
ex url : /experience/details
method : POST
data : 

{
"USER" : " 101", 
"COMPANY_NAME" : "visog global", 
"EMPLOYEE_TYPE" : "302",  
"DURATION_FROM" : "01/01/2001", 
"DURATION_TO" : "01/09/2001", 
"DESIGNATION" : "DEVELOPER", 
"JOB_PROFILE" : "JOB PORTALS", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details Created Successfully/ Failed to create Details"
	"data" : null
} 

2 Edit  JS_EXPERIENCE_DETAILS
=====================================
url : /experience/details/<EXPERIENCE_ID>
ex url : /experience/details/2

method : PUT
data : 

{
 "USER" : " 101", 
"COMPANY_NAME" : "visog global", 
"EMPLOYEE_TYPE" : "302",  
"DURATION_FROM" : "01/01/2001", 
"DURATION_TO" : "01/09/2001", 
"DESIGNATION" : "DEVELOPER", 
"JOB_PROFILE" : "JOB PORTALS", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details Updated Successfully/ Failed to update Details"
	"data" : null
} 

3. Get All JS_EXPERIENCE_DETAILS
=====================================
url : /experience/details
ex url : /experience/details

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details Updated Successfully/ Failed to update Details"
	"data" : [
		{
"ID" : "1",
"USER" : " 101", 
"COMPANY_NAME" : "visog global", 
"EMPLOYEE_TYPE" : "302",  
"DURATION_FROM" : "01/01/2001", 
"DURATION_TO" : "01/09/2001", 
"DESIGNATION" : "DEVELOPER", 
"JOB_PROFILE" : "JOB PORTALS", 
		}, {},...
	]
} 

4. Get JS_EXPERIENCE_DETAILS
=====================================
url : /experience/details/<EXPERIENCE_ID>
ex url : /experience/details/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details Updated Successfully/ Failed to update Details"
	"data" : {
"ID" : "1",
"USER" : " 101", 
"COMPANY_NAME" : "visog global", 
"EMPLOYEE_TYPE" : "302",  
"DURATION_FROM" : "01/01/2001", 
"DURATION_TO" : "01/09/2001", 
"DESIGNATION" : "DEVELOPER", 
"JOB_PROFILE" : "JOB PORTALS", 
	}
	
} 

5. Delete JS_EXPERIENCE_DETAILS
=====================================
url : /experience/details/<EXPERIENCE_ID>
ex url : /experience/details/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "Details Deleted Successfully/ Failed to update Details"
	"data" : NULL
	
} 


*/