CREATE SEQUENCE data_management_processes_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;


CREATE TABLE data_management_processes (
	process_id varchar(30) default ('DMP-'||lpad(((nextval('data_management_processes_seq')::text)),20,'0')) ,
	process_name varchar(100) NOT NULL, -- name of the governance process
	process_short_desc varchar(500) NOT NULL, -- short description of the process
	process_long_desc text NOT NULL, -- Long description, can be used by AI or UI to share notes
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP ,
	expiry_date timestamp default '9999-12-31',
	created_by varchar(50) DEFAULT CURRENT_USER , -- creator
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP , -- create timestamp
	updated_by varchar(50) NULL, -- last updated by
	updated_ts timestamp NULL, -- last updated timestamp
	CONSTRAINT data_management_processes_pkey PRIMARY KEY (process_id),
	CONSTRAINT data_management_processes_process_name_key UNIQUE (process_name)
);

COMMENT ON COLUMN data_management_processes.process_id IS 'Unique Process Identification Number (Primary Key) ';
COMMENT ON COLUMN data_management_processes.process_name IS 'name of the governance process (Unique Key)';
COMMENT ON COLUMN data_management_processes.process_short_desc IS 'short description of the process';
COMMENT ON COLUMN data_management_processes.process_long_desc IS 'Long description, can be used by AI or UI to share notes';
COMMENT ON COLUMN data_management_processes.created_by IS 'creator';
COMMENT ON COLUMN data_management_processes.created_ts IS 'create timestamp';
COMMENT ON COLUMN data_management_processes.updated_by IS 'last updated by';
COMMENT ON COLUMN data_management_processes.updated_ts IS 'last updated timestamp';
COMMENT ON COLUMN data_management_processes.effective_from IS 'Date from which this process will be effective';
COMMENT ON COLUMN data_management_processes.expiry_date IS 'Date on Which this process was discontinued';

INSERT INTO "data_management_processes" (process_id,process_name,process_short_desc,process_long_desc,effective_from,expiry_date,created_by,created_ts,updated_by,updated_ts)
     VALUES ('DMP-00000000000000000001','CoarseDQService',
             'Coarse Data Quality refers to a high-level or surface-level evaluation of data quality—focusing on basic checks or summary statistics rather than deep, granular validation. It''s often used as a first-pass filter to quickly identify obviously bad or problematic data before investing time in detailed analysis.',
             'Coarse Data Quality refers to a high-level or surface-level evaluation of data quality—focusing on basic checks or summary statistics rather than deep, granular validation. It''s often used as a first-pass filter to quickly identify obviously bad or problematic data before investing time in detailed analysis.
             Characteristics of Coarse Data Quality Checks:
                1. Broad scope(Checks apply to the dataset as a whole or at the column level.)
                2.Lightweight validation	(Fast to compute and useful for early data profiling.)
                3. Low granularity	(Does not focus on individual records or complex business logic.)
                4. Heuristic-based	(Often based on statistical profiling or simple heuristics.)',
             TO_TIMESTAMP('07/11/2025 16:44:36.950', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
             TO_TIMESTAMP('12/31/9999 00:00:00.00', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
             'chimera_user',TO_TIMESTAMP('07/11/2025 16:44:36.950', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),NULL,NULL);
INSERT INTO "data_management_processes" (process_id,process_name,process_short_desc,process_long_desc,effective_from,expiry_date,created_by,created_ts,updated_by,updated_ts)
     VALUES ('DMP-00000000000000000002','DetailedDQService',
             'A DetailedDQService refers to a Data Quality (DQ) microservice or module designed to perform fine-grained, rule-based, and contextual validations on datasets. It goes beyond basic or "coarse" checks and focuses on business-critical data quality validations, covering multiple dimensions like accuracy, consistency, integrity, and trust.',
             'A DetailedDQService is a software service that: Executes complex data quality checks (row-level, cross-field, cross-table). Supports custom business rules. Returns detailed diagnostics on failures (e.g., which rows, which fields, why they failed).Can be scheduled, triggered via API, or run as part of a data pipeline.
             Components of DetailedDQService
            Component	Description
            Rule Engine	Evaluates DQ rules (e.g., "age must be > 18", "status must match invoice")
            Execution Engine	Connects to data sources (e.g., S3, RDS, Snowflake) to run checks
            Rule Repository	Stores reusable, versioned rules (YAML/JSON or DB)
            Result Engine	Collects metrics, logs failures, and produces reports
            API Layer	Allows external systems to trigger and query results
            UI (optional)	Interface to configure rules and review results',
             TO_TIMESTAMP('07/11/2025 17:01:55.422', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
             TO_TIMESTAMP('12/31/9999 00:00:00.00', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),
             'chimera_user',TO_TIMESTAMP('07/11/2025 17:01:55.422', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),NULL,NULL);
COMMIT;

