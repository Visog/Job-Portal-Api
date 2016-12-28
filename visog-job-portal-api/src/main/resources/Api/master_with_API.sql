CREATE TABLE ROLES(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID) 
);
/*
1. Create ROLE
=====================================
url : /master/role
ex url : /master/role
method : POST
data : 

{
  "name" : "admin", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role Created sucessfully/ Failed to create role"
	"data" : null
} 

2 Edit  role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : PUT
data : 

{
  "name" : "admin", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : null
} 

3. Get All role
=====================================
url : /master/role
ex url : /master/role

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : [
		{"id" : 1, "name" : "admin", "description" : " master data description……"}, {},...
	]
} 

4. Get role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : {"id" : 2, "name" : "admin", "description" : " master data description…"}
	
} 

5. Delete role
=====================================
url : /master/role/<ROLE_ID>
ex url : /master/role/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role deleted sucessfully/ failed to update role"
	"data" : NULL
	
} 

*/

CREATE TABLE GENDER(
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR(3) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	DESCRIPTION VARCHAR (250),
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create GENDER
=====================================
url : /master/gender
ex url : /master/gender
method : POST
data : 

{
  "name" : "male", 
  "code" : "M",
  "description" : " master description…", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender Created sucessfully/ failed to create gender"
	"data" : null
} 

2 Edit  gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : PUT
data : 

{
  "name" : "male", 
  "code" : "M",
  "description" : "sdkjchsjk", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : null
} 

3. Get All gender
=====================================
url : /master/gender
ex url : /master/gender

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : [
		{"id" : 1, "name" : "male", "code" : "M",  "description" : "master description…"}, {},...
	]
} 

4. Get gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender updated sucessfully/ failed to update gender"
	"data" : {"id" : 2, "name" : "male",  "code" : "M", "description" : " master description…"}
	
} 

5. Delete gender
=====================================
url : /master/gender/<GENDER_ID>
ex url : /master/gender/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "gender deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 

*/

CREATE TABLE COUNTRY(
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR(9) NOT NULL,
	NAME VARCHAR(200) NOT NULL,
	ORDER_NUM INT,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create COUNTRY
=====================================
url : /master/country
ex url : /master/country
method : POST
data : 

{
  "name" : "india", 
  "code" : "123", 
  "orderNum" = "123",
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country Created sucessfully/ failed to create country"
	"data" : null
} 

2 Edit  country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : PUT
data : 

{
  "name" : "india", 
 "code" : "123", 
  "orderNum" = "123",
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : null
} 

3. Get All country
=====================================
url : /master/country
ex url : /master/country

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : [
		{"id" : 1, "name" : "india", "code" : "123","orderNum" = "123"}, {},...
	]
} 

4. Get country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country updated sucessfully/ failed to update country"
	"data" : {"id" : 2, "name" : "india", "code" : "123","orderNum" = "123"}
	
} 

5. Delete country
=====================================
url : /master/country/<COUNTRY_ID>
ex url : /master/country/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "country deleted sucessfully/ failed to update country"
	"data" : NULL
	
} 

*/



CREATE TABLE STATES(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (200) NOT NULL,
	COUNTRY_ID VARCHAR(37) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (COUNTRY_ID) REFERENCES COUNTRY (ID)
);


/*
1. Create STATE
=====================================
url : /master/state
ex url : /master/state
method : POST
data : 

{
  "name" : "rajasthan", 
  "country_id" :"123" , 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state created sucessfully/ failed to create state"
	"data" : null
} 

2 Edit  state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : PUT
data : 

{
  "name" : "rajasthan",  
  "country_id" :"123" , 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : null
} 

3. Get All state
=====================================
url : /master/state
ex url : /master/state

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : [
		{"id" : 1, "name" : "rajasthan", "country_id" :"123" , "code" : "123","orderNum" = "123"}, {},...
	]
} 

4. Get state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state updated sucessfully/ failed to update state"
	"data" : {"id" : 2, "name" : "rajasthan", "country_id" :"123" ,  "description" : " master data description…"}
	
} 

5. Delete state
=====================================
url : /master/state/<STATE_ID>
ex url : /master/state/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "state deleted sucessfully/ failed to update state"
	"data" : NULL
	
} 

*/

CREATE TABLE CITY(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (200) NOT NULL,
	STATE_ID VARCHAR(37),
	COUNTRY_ID VARCHAR(37),
	ORDER_NUM INT,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID),
	FOREIGN KEY (STATE_ID) REFERENCES STATES  (ID)	
);

/*
1. Create CITY
=====================================
url : /master/city
ex url : /master/city
method : POST
data : 

{
  "name" : "jaipur", 
  "country_id" : "234", 
  "state_id" : "123" ,
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city created sucessfully/ failed to create city"
	"data" : null
} 

2 Edit  city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : PUT
data : 

{
  "name" : "jaipur", 
  "country_id" : "234", 
  "state_id" : "123" , 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : null
} 

3. Get All city
=====================================
url : /master/city
ex url : /master/city

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : [
		{"id" : 1, "name" : "jaipur", "country_id" : "234", "state_id" : "123"}, {},...
	]
} 

4. Get city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city updated sucessfully/ failed to update city"
	"data" : {"id" : 2, "name" : "jaipur","country_id" : "234", "state_id" : "123" }
	
} 

5. Delete city
=====================================
url : /master/city/<CITY_ID>
ex url : /master/city/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "city deleted sucessfully/ failed to update city"
	"data" : NULL
	
} 

*/


 
CREATE TABLE ADDRESS_TYPE (
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,/* Permanent/Residence */
	DESCRIPTION VARCHAR (500) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create ADDRESS_TYPE 
=====================================
url : /master/address_type
ex url : /master/address_type
method : POST
data : 

{
  "name" : "permanent", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type Created sucessfully/ Failed to create address type"
	"data" : null
} 

2 Edit  ADDRESS_TYPE
=====================================
url : /master/address_type/<ADDRESS_TYPE _ID>
ex url : /master/address_type/2

method : PUT
data : 

{
  "name" : "permanent", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type updated sucessfully/ Failed to update address type"
	"data" : null
} 

3. Get All ADDRESS_TYPE
=====================================
url : /master/address_type
ex url : /master/address_type

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type updated sucessfully/ Failed to update address type"
	"data" : [
		{"id" : 1, "name" : "permanent", "description" : " master data description……"}, {},...
	]
} 

4. Get ADDRESS_TYPE
=====================================
url : /master/address_type/<ADDRESS_TYPE _ID>
ex url : /master/address_type/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type updated sucessfully/ Failed to update address type"
	"data" : {"id" : 2, "name" : "permanent", "description" : " master data description…"}
	
} 

5. Delete ADDRESS_TYPE =====================================
url : /master/address_type/<ADDRESS_TYPE _ID>
ex url : /master/address_type/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type deleted sucessfully/ failed to update address type"
	"data" : NULL
	
} 

*/


CREATE TABLE COURSES( 
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,/*Btech/MTech*/
	DESCRIPTION VARCHAR (500) NOT NULL,
    CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create COURSES
=====================================
url : /master/courses
ex url : /master/courses
method : POST
data : 

{
  "name" : "BTECH", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "courses created sucessfully/ failed to create courses"
	"data" : null
} 

2 Edit  courses
=====================================
url : /master/courses/<COURSES_ID>
ex url : /master/courses/2

method : PUT
data : 

{
  "name" : "BTECH", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "courses updated sucessfully/ failed to update courses"
	"data" : null
} 

3. Get All courses
=====================================
url : /master/courses
ex url : /master/courses

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "courses updated sucessfully/ failed to update courses"
	"data" : [
		{"id" : 1, "name" : "BTECH", "description" : " master data description……"}, {},...
	]
} 

4. Get courses
=====================================
url : /master/courses/<COURSES_ID>
ex url : /master/courses/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "courses updated sucessfully/ failed to update courses"
	"data" : {"id" : 2, "name" : "BTECH", "description" : " master data description…"}
	
} 

5. Delete courses
=====================================
url : /master/courses/<COURSES_ID>
ex url : /master/courses/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "courses deleted sucessfully/ failed to update courses"
	"data" : NULL
	
} 

*/


CREATE TABLE SPECILIZATION( 
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL, /*IT/Mechanical*/
	DESCRIPTION VARCHAR (500) NOT NULL,
	COURSE_ID VARCHAR(37) NOT NULL,
    CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID), 
	FOREIGN KEY (COURSE_ID) REFERENCES COURSES (ID)
);
/*

1. Create SPECILIZATION
=====================================
url : /master/specilization
ex url : /master/specilization
method : POST
data : 

{
  "name" : "computer science", 
   "description" : "master data description..", 
   "course_id" : "445"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization created sucessfully/ failed to create specilization"
	"data" : null
} 

2 Edit  specilization
=====================================
url : /master/specilization/<SPECILIZATION_ID>
ex url : /master/specilization/2

method : PUT
data : 

{
    "name" : "computer science", 
	"course_id" : "101",
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization updated sucessfully/ failed to update specilization"
	"data" : null
} 

3. Get All specilization
=====================================
url : /master/specilization
ex url : /master/specilization

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization updated sucessfully/ failed to update specilization"
	"data" : [
		{ "name" : "computer science","course_id":"101", "description" : " master data description……"}, {},...
	]
} 

4. Get specilization
=====================================
url : /master/specilization/<SPECILIZATION_ID>
ex url : /master/specilization/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization updated sucessfully/ failed to update specilization"
	"data" : {"name" : "computer science","course_id":"101", "description" : " master data description…"}
	
} 

5. Delete specilization
=====================================
url : /master/specilization/<SPECILIZATION_ID>
ex url : /master/specilization/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization deleted sucessfully/ failed to update specilization"
	"data" : NULL
	
} 


*/

CREATE TABLE UNIVERSITY(
	ID  VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,/*OU/JNTU*/
	DESCRIPTION VARCHAR (500) NOT NULL,
    CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);


/*

1. Create UNIVERSITY
=====================================
url : /master/university
ex url : /master/university
method : POST
data : 

{
  "name" : "delhi university", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university created sucessfully/ failed to create university"
	"data" : null
} 

2 Edit  university
=====================================
url : /master/university/<UNIVERSITY_ID>
ex url : /master/university/2

method : PUT
data : 

{
  "name" : "delhi university", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university updated sucessfully/ failed to update university"
	"data" : null
} 

3. Get All university
=====================================
url : /master/university
ex url : /master/university

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university updated sucessfully/ failed to update university"
	"data" : [
		{"id" : 1, "name" : "delhi university", "description" : " master data description……"}, {},...
	]
} 

4. Get university
=====================================
url : /master/university/<UNIVERSITY_ID>
ex url : /master/university/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university updated sucessfully/ failed to update university"
	"data" : {"id" : 2, "name" : "delhi university", "description" : " master data description…"}
	
} 

5. Delete university
=====================================
url : /master/university/<UNIVERSITY_ID>
ex url : /master/university/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university deleted sucessfully/ failed to update university"
	"data" : NULL
	
} 


*/


CREATE TABLE  EDUCATION_TYPE(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL, /*Regular/Distance*/
	DESCRIPTION VARCHAR (500) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);

/*

1. Create EDUCATION_TYPE
=====================================
url : /master/education_type
ex url : /master/education_type
method : POST
data : 

{
  "name" : "full time", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type created sucessfully/ failed to create education type"
	"data" : null
} 

2 Edit  education_type
=====================================
url : /master/education_type/<EDUCATION_TYPE_ID>
ex url : /master/education_type/2

method : PUT
data : 

{
  "name" : "full time", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type updated sucessfully/ failed to update education type"
	"data" : null
} 

3. Get All education_type
=====================================
url : /master/education_type
ex url : /master/education_type

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type updated sucessfully/ failed to update education type"
	"data" : [
		{"name" : "full time", "description" : " master data description……"}, {},...
	]
} 

4. Get education_type
=====================================
url : /master/education_type/<EDUCATION_TYPE_ID>
ex url : /master/education_type/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type updated sucessfully/ failed to update education type"
	"data" : {"id" : 2, "name" : "full time", "description" : " master data description…"}
	
} 

5. Delete education_type
=====================================
url : /master/education_type/<EDUCATION_TYPE_ID>
ex url : /master/education_type/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type deleted sucessfully/ failed to update education type"
	"data" : NULL
	
} 



*/



CREATE TABLE LANGUAGES( 
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR (100) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*

1. Create LANGUAGE
=====================================
url : /master/language
ex url : /master/language
method : POST
data : 

{
  "name" : "english", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language created sucessfully/ failed to create language"
	"data" : null
} 

2 Edit  LANGUAGE
=====================================
url : /master/language/<LANGUAGE_ID>
ex url : /master/language/2

method : PUT
data : 

{
  "name" : "english", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language updated sucessfully/ failed to update language"
	"data" : null
} 

3. Get All LANGUAGE
=====================================
url : /master/language
ex url : /master/language

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language updated sucessfully/ failed to update language"
	"data" : [
		{"id" : 1, "name" : "english", "description" : " master data description……"}, {},...
	]
} 

4. Get LANGUAGE
=====================================
url : /master/language/<LANGUAGE_ID>
ex url : /master/language/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language updated sucessfully/ failed to update language"
	"data" : {"id" : 2, "name" : "english", "description" : " master data description…"}
	
} 

5. Delete LANGUAGE
=====================================
url : /master/language/<LANGUAGE_ID>
ex url : /master/language/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language deleted sucessfully/ failed to update language"
	"data" : NULL
	
} 


*/


CREATE TABLE CURRENCY( 
	ID VARCHAR(37) NOT NULL,
	CODE VARCHAR (10) NOT NULL,
	NAME VARCHAR (100) NOT NULL,
	SYMBOL  VARCHAR(30),
    CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);

/*

1. Create CURRENCY
=====================================
url : /master/currency
ex url : /master/currency
method : POST
data : 

{
  "name" : " indian rupees ", 
  "description" : "master data description..", 	
  "currency_code" :  " INR"
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "currency created sucessfully/ failed to create currency"
	"data" : null
} 

2 Edit  currency
=====================================
url : /master/currency/<CURRENCY_ID>
ex url : /master/currency/2

method : PUT
data : 

{
  "name" : "indian rupees", 
  "description" : " master data description…..", 
"currency_code" :  " INR",
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "currency updated sucessfully/ failed to update currency"
	"data" : null
} 

3. Get All currency
=====================================
url : /master/currency
ex url : /master/currency

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "currency updated sucessfully/ failed to update currency"
	"data" : [
		{"id" : 1, "name" : " indian rupees ", "description" : " master data description……","currency_code" :  " INR"}, {},...
	]
} 

4. Get currency
=====================================
url : /master/currency/<CURRENCY_ID>
ex url : /master/currency/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "currency updated sucessfully/ failed to update currency"
	"data" : {"id" : 2, "name" : " indian rupees ", "description" : " master data description…","currency_code" :  " INR"}
	
} 

5. Delete currency
=====================================
url : /master/currency/<CURRENCY_ID>
ex url : /master/currency/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "currency deleted sucessfully/ failed to update currency"
	"data" : NULL
	
} 


*/


CREATE TABLE INDUSTRY( 
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL, /**IT/PHARMA**/
	DESCRIPTION VARCHAR (500) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);

/*

1. Create INDUSTRY
=====================================
url : /master/industry
ex url : /master/industry
method : POST
data : 

{
  "name" : "IT Software/Software Services", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "industry created sucessfully/ failed to create industry"
	"data" : null
} 

2 Edit  industry
=====================================
url : /master/industry/<INDUSTRY_ID>
ex url : /master/industry/2

method : PUT
data : 

{
  "name" : "IT Software/Software Services", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "industry updated sucessfully/ failed to update industry"
	"data" : null
} 

3. Get All industry
=====================================
url : /master/industry
ex url : /master/industry

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "industry updated sucessfully/ failed to update industry"
	"data" : [
		{"id" : 1, "name" : "IT Software/Software Services", "description" : " master data description……"}, {},...
	]
} 

4. Get industry
=====================================
url : /master/industry/<INDUSTRY_ID>
ex url : /master/industry/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "industry updated sucessfully/ failed to update industry"
	"data" : {"id" : 2, "name" : "IT Software/Software Services", "description" : " master data description…"}
	
} 

5. Delete industry
=====================================
url : /master/industry/<INDUSTRY_ID>
ex url : /master/industry/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "industry deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 


*/

CREATE TABLE DOMAINS( 
	ID  VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,/*IT/PHARMA*/
	DESCRIPTION VARCHAR (500) NOT NULL,
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create DOMAINS
=====================================
url : /master/domain
ex url : /master/domain
method : POST
data : 

{
  "name" : "ITSoftware-Tester ", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "domain created sucessfully/ failed to create domain"
	"data" : null
} 

2 Edit  DOMAINS
=====================================
url : /master/domain/<DOMAIN_ID>
ex url : /master/domain/2

method : PUT
data : 

{
  "name" : "ITSoftware-Tester ", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "domain updated sucessfully/ failed to update domain"
	"data" : null
} 

3. Get All DOMAINS
=====================================
url : /master/domain
ex url : /master/domain

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "domain updated sucessfully/ failed to update domain"
	"data" : [
		{"id" : 1, "name" : "ITSoftware-Tester ", "description" : " master data description……"}, {},...
	]
} 

4. Get DOMAINS
=====================================
url : /master/domain/<DOMAIN_ID>
ex url : /master/domain/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "domain updated sucessfully/ failed to update domain"
	"data" : {"id" : 2, "name" : "ITSoftware-Tester ", "description" : " master data description…"}
	
} 

5. Delete DOMAINS
=====================================
url : /master/domain/<DOMAIN_ID>
ex url : /master/domain/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "domain deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 

*/






CREATE TABLE JOB_ROLE(
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,/*--Application design/Developer/System Admin*/
	DESCRIPTION VARCHAR (500) NOT NULL,	
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*


1. Create JOB_ROLE
=====================================
url : /master/job_role
ex url : /master/job_role
method : POST
data : 

{
  "name" : "team leader", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role created sucessfully/ failed to create  "
	"data" : null
} 

2 Edit  job_role
=====================================
url : /master/job_role/<JOB_ROLE_ID>
ex url : /master/job_role/2

method : PUT
data : 

{
  "name" : "team leader", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role updated sucessfully/ failed to update job role"
	"data" : null
} 

3. Get All job_role
=====================================
url : /master/job_role
ex url : /master/job_role

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role updated sucessfully/ failed to update job role"
	"data" : [
		{"id" : 1, "name" : "team leader", "description" : " master data description……"}, {},...
	]
} 

4. Get job_role
=====================================
url : /master/job_role/<JOB_ROLE_ID>
ex url : /master/job_role/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role updated sucessfully/ failed to update job role"
	"data" : {"id" : 2, "name" : "team leader", "description" : " master data description…"}
	
} 

5. Delete job_role
=====================================
url : /master/job_role/<JOB_ROLE_ID>
ex url : /master/job_role/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role deleted sucessfully/ failed to update job role "
	"data" : NULL
	
} 


*/





CREATE TABLE STATUS (
	ID VARCHAR(37) NOT NULL,	
	CODE VARCHAR (50) NOT NULL,	
	NAME VARCHAR (100) NOT NULL,-- blocked,active,closed
	CATEGORY VARCHAR (100) NOT NULL,	
	ORDER_NUM INT NOT NULL,	
	DESCRIPTION VARCHAR (500) NOT NULL,	
       CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*


1. Create STATUS
=====================================
url : /master/status
ex url : /master/status
method : POST
data : 

{
  "name" : "error", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status created sucessfully/ failed to create status"
	"data" : null
} 

2 Edit  status
=====================================
url : /master/status/<STATUS_ID>
ex url : /master/status/2

method : PUT
data : 

{
  "name" : "error", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : null
} 

3. Get All status
=====================================
url : /master/status
ex url : /master/status

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : [
		{"id" : 1, "name" : "error", "description" : " master data description……"}, {},...
	]
} 

4. Get status
=====================================
url : /master/status/<STATUS_ ID>
ex url : /master/status/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status updated sucessfully/ failed to update status"
	"data" : {"id" : 2, "name" : "error", "description" : " master data description…"}
	
} 

5. Delete status
=====================================
url : /master/status/<STATUS_ID>
ex url : /master/status/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "status deleted sucessfully/ failed to update gender"
	"data" : NULL
	
} 




*/

CREATE TABLE EMPLOYMENT_TYPE  (
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,-- full time/part time/contractual project
	DESCRIPTION VARCHAR (500) NOT NULL,	
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);
/*
1. Create EMPLOYMENY
=====================================
url : /master/employmentType/
ex url : /master/employmentType
method : POST
data : 

{
  "name" : "full time", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employment type Created successfully / Failed to create employment type"
	"data" : null
} 

2 Edit  employment_type
=====================================
url : /master/employmentType/<EMPLOYMENY_ID>
ex url : /master/employmentType/2

method : PUT
data : 

{
  "name" : "full time", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employment type updated sucessfully/ Failed to update employment type"
	"data" : null
} 

3. Get All employment_type
=====================================
url : /master/employmentType/
ex url : /master/employmentType

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employment type updated sucessfully/ Failed to update employment type"
	"data" : [
		{"id" : 1, "name" : "full time", "description" : " master data description……"}, {},...
	]
} 

4. Get employment_type
=====================================
url : /master/employmentType/<EMPLOYMENY_ID>
ex url : /master/employmentType/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employment type updated sucessfully/ Failed to update employment type"
	"data" : {"id" : 2, "name" : "full time", "description" : " master data description…"}
	
} 

5. Delete employment_type
=====================================
url : /master/employmentType/<EMPLOYMENY_ID>
ex url : /master/employmentType/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employment type deleted sucessfully/ failed to update employment type"
	"data" : NULL
	
} 

*/


CREATE TABLE EMPLOYER_TYPE  (
	ID VARCHAR(37) NOT NULL,
	NAME VARCHAR (100) NOT NULL,-- HR /CONSULTANT
	DESCRIPTION VARCHAR (500) NOT NULL,	
	CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);


/*

1. Create EMPLOYER_TYPE
=====================================
url : /master/employerType
ex url : /master/employerType
method : POST
data : 

{
  "name" : "consultant", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type created sucessfully/ failed to create employer type"
	"data" : null
} 

2 Edit  employer_type
=====================================
url : /master/employerType/<EMPLOYER_TYPE_ID>
ex url : /master/employerType/2

method : PUT
data : 

{
  "name" : "consultant", 
  "description" : " master data description…..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type updated sucessfully/ failed to update employer type"
	"data" : null
} 

3. Get All employer_type
=====================================
url : /master/employerType
ex url : /master/employerType

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type updated sucessfully/ failed to update employer type"
	"data" : [
		{"id" : 1, "name" : "consultant", "description" : " master data description……"}, {},...
	]
} 

4. Get employer_type
=====================================
url : /master/employer_type/<EMPLOYER_TYPE_ID>
ex url : /master/employer_type/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type updated sucessfully/ failed to update employer type"
	"data" : {"id" : 2, "name" : "consultant", "description" : " master data description…"}
	
} 

5. Delete employer_type
=====================================
url : /master/employerType/<EMPLOYER_TYPE_ID>
ex url : /master/employerType/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type deleted sucessfully/ failed to update employer type"
	"data" : NULL
	
} 


*/

CREATE TABLE FILE_TYPE (
	ID VARCHAR(37) NOT NULL,
	EXTENSION VARCHAR(50) NOT NULL,-- txt,pdf,mp4,mp3
	DESCRIPTION VARCHAR (200) NOT NULL,
    CREATED_SID   VARCHAR(37) NOT NULL,
	CREATED_BY    VARCHAR(37) NOT NULL,
	CREATED_ON    TIMESTAMP NOT NULL,
	UPDATED_SID   VARCHAR(37),
	UPDATED_BY    VARCHAR(37),
	UPDATED_ON    TIMESTAMP,
	PRIMARY KEY (ID)
);

/*

1. Create FILE_TYPE
=====================================
url : /master/fileType
ex url : /master/fileType
method : POST
data : 

{
  "Extension"  :  ".txt"
  "description" : "master data description.." , 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "file type created sucessfully/ failed to create file type"
	"data" : null
} 

2 Edit  FILE_TYPE
=====================================
url : /master/fileType/<FILE_TYPE_ID>
ex url : /master/fileType/2

method : PUT
data : 

{
  "Extension"  :  ".txt"
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "file type updated sucessfully/ failed to update file type"
	"data" : null
} 

3. Get All FILE_TYPE
=====================================
url : /master/fileType
ex url : /master/fileType

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "file type updated sucessfully/ failed to update file type"
	"data" : [
		{"id" : 1, "extension" : ".txt", "description" : " master data description……"}, {},...
	]
} 

4. Get FILE_TYPE
=====================================
url : /master/fileType/<FILE_TYPE_ID>
ex url : /master/fileType/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "file type updated sucessfully/ failed to update file type"
	"data" : {"id" : 2, "extension" : ".txt", "description" : " master data description…"}
	
} 

5. Delete file_type
=====================================
url : /master/fileType/<FILE_TYPE_ID>
ex url : /master/fileType/2

method : DELETE
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "file type deleted sucessfully/ failed to update file type"
	"data" : NULL
	
} 


*/



