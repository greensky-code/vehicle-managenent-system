INSERT INTO public."STATION"(
	"ID", "LONGITUDE", "LATITUDE", "COMPANY_ID", "NAME")
	VALUES (1, '23.2344', '35.6678', '1', 'station1');
	
	INSERT INTO public."STATION"(
	"ID", "LONGITUDE", "LATITUDE", "COMPANY_ID", "NAME")
	VALUES (2, '24.9966', '69.8866', '1', 'station2');
	
	INSERT INTO public."STATION"(
	"ID", "LONGITUDE", "LATITUDE", "COMPANY_ID", "NAME")
	VALUES (3, '56.8855', '66.1256', '2', 'station3');
	
-----------------------------------------------------------------------	
	
	INSERT INTO public."COMPANY"(
	"ID", "PARENT_COMPANY_ID", "NAME")
	VALUES ('1', '1', 'company 1');
	
	INSERT INTO public."COMPANY"(
	"ID", "PARENT_COMPANY_ID", "NAME")
	VALUES ('2', '1', 'company 2');