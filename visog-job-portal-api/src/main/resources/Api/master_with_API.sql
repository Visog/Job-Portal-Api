
1. Create ROLE
=====================================
url : /master/roles
ex url : /master/roles
method : POST
data : 

{
  "name" : "admin", 
  "description" : "master data description.."
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
url : /master/roles/<ROLE_ID>
ex url : /master/roles/2

method : PUT
data : 

{
  "name" : "admin", 
  "description" : " master data description.."
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
url : /master/roles
ex url : /master/roles

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : [
		{"id" : 1, "name" : "admin", "description" : " master data description"}, {},...
	]
} 

4. Get role
=====================================
url : /master/roles/<ROLE_ID>
ex url : /master/roles/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "role updated sucessfully/ Failed to update role"
	"data" : {"id" : 2, "name" : "admin", "description" : " master data description"}
	
} 

5. Delete role
=====================================
url : /master/roles/<ROLE_ID>
ex url : /master/roles/2

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



1. Create GENDER
=====================================
url : /master/gender
ex url : /master/gender
method : POST
data : 

{
  "name" : "male", 
  "code" : "M",
  "description" : " master description"
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
  "description" : "sdkjchsjk"
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
		{"id" : 1, "name" : "male", "code" : "M",  "description" : "master description"}, {},...
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
	"data" : {"id" : 2, "name" : "male",  "code" : "M", "description" : " master description"}
	
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



1. Create COUNTRY
=====================================
url : /master/country
ex url : /master/country
method : POST
data : 

{
  "name" : "india", 
  "code" : "123"
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
    "code" : "123"
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







1. Create STATE
=====================================
url : /master/state
ex url : /master/state
method : POST
data : 

{
  "name" : "rajasthan", 
  "country" :"123"  
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
  "country" :"123" 
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
		{"id" : 1, "name" : "rajasthan", "country" :"123" , "code" : "123","orderNum" = "123"}, {},...
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
	"data" : {"id" : 2, "name" : "rajasthan", "country" :"123" ,  "description" : " master data description"}
	
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




1. Create CITY
=====================================
url : /master/city
ex url : /master/city
method : POST
data : 

{
  "name" : "jaipur", 
  "country" : "234", 
  "state" : "123" 
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
  "country" : "234", 
  "state" : "123"  
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


 


1. Create ADDRESS_TYPE 
=====================================
url : /master/addressType
ex url : /master/addressType
method : POST
data : 

{
  "name" : "permanent", 
  "description" : "master data description.."
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
url : /master/addressType/<ADDRESS_TYPE _ID>
ex url : /master/addressType/2

method : PUT
data : 

{
  "name" : "permanent", 
  "description" : " master data description.."
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
url : /master/addressType
ex url : /master/addressType

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type updated sucessfully/ Failed to update address type"
	"data" : [
		{"id" : 1, "name" : "permanent", "description" : " master data description"}, {},...
	]
} 

4. Get ADDRESS_TYPE
=====================================
url : /master/addressType/<ADDRESS_TYPE _ID>
ex url : /master/addressType/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "address type updated sucessfully/ Failed to update address type"
	"data" : {"id" : 2, "name" : "permanent", "description" : " master data description"}
	
} 

5. Delete ADDRESS_TYPE =====================================
url : /master/addressType/<ADDRESS_TYPE _ID>
ex url : /master/addressType/2

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
  "description" : " master data description..", 
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
		{"id" : 1, "name" : "BTECH", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "name" : "BTECH", "description" : " master data description"}
	
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





1. Create SPECILIZATION
=====================================
url : /master/specialization
ex url : /master/specialization
method : POST
data : 

{
  "name" : "computer science", 
   "description" : "master data description..", 
   "course" : "445"
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
url : /master/specialization/<SPECILIZATION_ID>
ex url : /master/specialization/2

method : PUT
data : 

{
    "name" : "computer science", 
   "description" : "master data description..", 
   "course" : "445"
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
url : /master/specialization
ex url : /master/specialization

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization updated sucessfully/ failed to update specilization"
	"data" : [
		{ "name" : "computer science","course_id":"101", "description" : " master data description"}, {},...
	]
} 

4. Get specilization
=====================================
url : /master/specialization/<SPECILIZATION_ID>
ex url : /master/specialization/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "specilization updated sucessfully/ failed to update specilization"
	"data" : {"name" : "computer science","course_id":"101", "description" : " master data description"}
	
} 

5. Delete specilization
=====================================
url : /master/specialization/<SPECILIZATION_ID>
ex url : /master/specialization/2

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





1. Create UNIVERSITY
=====================================
url : /master/universities
ex url : /master/universities
method : POST
data : 

{
  "name" : "delhi /universities", 
  "description" : "master data description..", 
}

response : 

{
	"statusCode" : 200/300 /500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "/universities created sucessfully/ failed to create /universities"
	"data" : null
} 

2 Edit  university
=====================================
url : /master/universities/<UNIVERSITY_ID>
ex url : /master/universities/2

method : PUT
data : 

{
  "name" : "delhi university", 
  "description" : " master data description..", 
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
url : /master/universities
ex url : /master/universities

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university updated sucessfully/ failed to update university"
	"data" : [
		{"id" : 1, "name" : "delhi university", "description" : " master data description"}, {},...
	]
} 

4. Get university
=====================================
url : /master/universities/<UNIVERSITY_ID>
ex url : /master/universities/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "university updated sucessfully/ failed to update university"
	"data" : {"id" : 2, "name" : "delhi university", "description" : " master data description"}
	
} 

5. Delete university
=====================================
url : /master/universities/<UNIVERSITY_ID>
ex url : /master/universities/2

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





1. Create EDUCATION_TYPE


data : 

{
  "name" : "full time", 
  "description" : "master data description.."
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
url : /master/educationtype/<EDUCATION_TYPE_ID>
ex url : /master/educationtype/2

method : PUT
data : 

{
  "name" : "full time", 
  "description" : " master data description.."
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
url : /master/educationtype
ex url : /master/educationtype

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type updated sucessfully/ failed to update education type"
	"data" : [
		{"name" : "full time", "description" : " master data description"}, {},...
	]
} 

4. Get education_type
=====================================
url : /master/educationtype/<EDUCATION_TYPE_ID>
ex url : /master/educationtype/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "education type updated sucessfully/ failed to update education type"
	"data" : {"id" : 2, "name" : "full time", "description" : " master data description"}
	
} 

5. Delete education_type
=====================================
url : /master/educationtype/<EDUCATION_TYPE_ID>
ex url : /master/educationtype/2

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






1. Create LANGUAGE
=====================================
url : /master/languages
ex url : /master/languages
method : POST
data : 

{
  "code" : "12",
  "name" : "english"
   
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
url : /master/languages/<LANGUAGE_ID>
ex url : /master/languages/2

method : PUT
data : 

{
  "name" : "english", 
  "description" : " master data description..", 
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
url : /master/languages
ex url : /master/languages

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language updated sucessfully/ failed to update language"
	"data" : [
		{"id" : 1, "name" : "english", "description" : " master data description"}, {},...
	]
} 

4. Get LANGUAGE
=====================================
url : /master/languages/<LANGUAGE_ID>
ex url : /master/languages/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "language updated sucessfully/ failed to update language"
	"data" : {"id" : 2, "name" : "english", "description" : " master data description"}
	
} 

5. Delete LANGUAGE
=====================================
url : /master/languages/<LANGUAGE_ID>
ex url : /master/languages/2

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






1. Create CURRENCY
=====================================
url : /master/currency
ex url : /master/currency
method : POST
data : 

{
  "name" : " indian rupees ", 
  "description" : "master data description..", 	
  "symbol" :  " INR"
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
   "name" : " indian rupees ", 
  "description" : "master data description..", 	
  "symbol" :  " INR"
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
		{"id" : 1, "name" : " indian rupees ", "description" : " master data description","currency_code" :  " INR"}, {},...
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
	"data" : {"id" : 2, "name" : " indian rupees ", "description" : " master data description","currency_code" :  " INR"}
	
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






1. Create INDUSTRY
=====================================
url : /master/industry
ex url : /master/industry
method : POST
data : 

{
  "name" : "IT Software/Software Services", 
  "description" : "master data description.." 
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
  "description" : " master data description..", 
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
		{"id" : 1, "name" : "IT Software/Software Services", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "name" : "IT Software/Software Services", "description" : " master data description"}
	
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
  "description" : " master data description..", 
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
		{"id" : 1, "name" : "ITSoftware-Tester ", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "name" : "ITSoftware-Tester ", "description" : " master data description"}
	
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
	"statusDesc" : "domain deleted sucessfully/ failed to delete Domain"
	"data" : NULL
	
} 

*/










1. Create JOB_ROLE
=====================================
url : /master/jobRole
ex url : /master/jobRole
method : POST
data : 

{
  "name" : "team leader", 
  "description" : "master data description.."
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
url : /master/jobRole/<JOB_ROLE_ID>
ex url : /master/jobRole/2

method : PUT
data : 

{
  "name" : "team leader", 
  "description" : " master data description.."
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
url : /master/jobRole
ex url : /master/jobRole

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role updated sucessfully/ failed to update job role"
	"data" : [
		{"id" : 1, "name" : "team leader", "description" : " master data description"}, {},...
	]
} 

4. Get job_role
=====================================
url : /master/jobRole/<JOB_ROLE_ID>
ex url : /master/jobRole/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "job role updated sucessfully/ failed to update job role"
	"data" : {"id" : 2, "name" : "team leader", "description" : " master data description"}
	
} 

5. Delete job_role
=====================================
url : /master/jobRole/<JOB_ROLE_ID>
ex url : /master/jobRole/2

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


1. Create STATUS
=====================================
url : /master/status
ex url : /master/status
method : POST
data : 

 { 
 	
 	"code":"A",
 	"name":"Active",
 	"description":"Active description"
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
 	
 	"code":"A",
 	"name":"Active",
 	"description":"Active description"
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
		{"id" : 1, "name" : "error", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "name" : "error", "description" : " master data description"}
	
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



1. Create EMPLOYMENTTYPE
=====================================
url : /master/employmentType/
ex url : /master/employmentType
method : POST
data : 

{
  "name" : "full time", 
  "description" : "master data description.."
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
  "description" : " master data description.."
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
		{"id" : 1, "name" : "full time", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "name" : "full time", "description" : " master data description"}
	
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




/*

1. Create EMPLOYER_TYPE
=====================================
url : /master/employerType
ex url : /master/employerType
method : POST
data : 

{
  "name" : "consultant", 
  "description" : "master data description.."
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
  "description" : " master data description.."
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
		{"id" : 1, "name" : "consultant", "description" : " master data description"}, {},...
	]
} 

4. Get employer_type
=====================================
url : /master/employerType/<EMPLOYER_TYPE_ID>
ex url : /master/employerType/2

method : GET
data : 


response : 

{
	"statusCode" : 200/300/500, 
	"status" : "SUCCESS/FAILURE/ERROR", 
	"statusDesc" : "employer type updated sucessfully/ failed to update employer type"
	"data" : {"id" : 2, "name" : "consultant", "description" : " master data description"}
	
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


  "extension"  :  ".txt"
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
		{"id" : 1, "extension" : ".txt", "description" : " master data description"}, {},...
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
	"data" : {"id" : 2, "extension" : ".txt", "description" : " master data description"}
	
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



