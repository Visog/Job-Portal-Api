	alter TABLE  FILES ADD CREATED_SID   VARCHAR(37) NOT NULL;
	alter TABLE  FILES ADD CREATED_BY    VARCHAR(37) NOT NULL;
	alter TABLE  FILES ADD CREATED_ON    TIMESTAMP NOT NULL;
	alter TABLE  FILES ADD UPDATED_SID   VARCHAR(37);
	alter TABLE  FILES ADD UPDATED_BY    VARCHAR(37);
	alter TABLE  FILES ADD UPDATED_ON    TIMESTAMP;
	
	
	
ALTER TABLE EDUCATION_DETAILS MODIFY DURATION_FROM TIMESTAMP;

ALTER TABLE EDUCATION_DETAILS MODIFY DURATION_TO_DATE TIMESTAMP;

  ALTER TABLE LANGUAGE_KNOWN MODIFY READ_ID TEXT;
   ALTER TABLE LANGUAGE_KNOWN MODIFY WRITE_ID TEXT;
    ALTER TABLE LANGUAGE_KNOWN MODIFY SPEAK TEXT;
    
    ALTER TABLE PROJECT_DETAILS MODIFY DURATION_TO timestamp;
    
    