-- Table: public.COMPANY

-- DROP TABLE IF EXISTS public."COMPANY";

CREATE TABLE IF NOT EXISTS public."COMPANY"
(
    "ID" character varying(36) COLLATE pg_catalog."default" NOT NULL,
    "PARENT_COMPANY_ID" character varying(150) COLLATE pg_catalog."default",
    "NAME" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "COMPANY_pkey" PRIMARY KEY ("ID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."COMPANY"
    OWNER to postgres;
	
	-----------------------------------------------------------------------------------------------------
	
	-- Table: public.STATION

-- DROP TABLE IF EXISTS public."STATION";

CREATE TABLE IF NOT EXISTS public."STATION"
(
    "ID" character varying(36) COLLATE pg_catalog."default" NOT NULL,
    "LONGITUDE" character varying(150) COLLATE pg_catalog."default",
    "LATITUDE" character varying(150) COLLATE pg_catalog."default",
    "COMPANY_ID" character varying(150) COLLATE pg_catalog."default",
    "NAME" character varying(100) COLLATE pg_catalog."default",
    CONSTRAINT "STATION_pkey" PRIMARY KEY ("ID")
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public."STATION"
    OWNER to postgres;