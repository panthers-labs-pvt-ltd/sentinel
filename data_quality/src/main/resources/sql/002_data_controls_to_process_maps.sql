CREATE SEQUENCE data_controls_to_process_maps_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;


CREATE TABLE data_controls_to_process_maps (
	control_id varchar(30) default ('DCPM-'||lpad(((nextval('data_controls_to_process_maps_seq')::text)),20,'0')) ,
	process_id varchar(30) NOT NULL, -- Foreign key from data_governance_processes
	ref_metadata varchar NULL, -- Ref Metedata which needs to be used for this control based on Process Type name BatchPipelineOrigin/BatchPipelineDeestination
	check_lvl varchar default 'Warning', -- Error/Warning/Info
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP ,
	expiry_date timestamp default '9999-12-31',
	active_flg varchar(1) DEFAULT 'Y'::character varying NOT NULL, -- if this control is still active
	reserved_5 varchar(50) NULL, -- dummy column for future use
	reserved_4 varchar(50) NULL, -- dummy column for future use
	reserved_3 varchar(50) NULL, -- dummy column for future use
	reserved_2 varchar(50) NULL, -- dummy column for future use
	reserved_1 varchar(50) NULL, -- dummy column for future use
	created_by varchar(50) DEFAULT CURRENT_USER NOT NULL, -- creator
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- create timestamp
	updated_by varchar(50) NULL, -- last updated by
	updated_ts timestamp NULL, -- last updated timestamp
	CONSTRAINT data_controls_to_process_maps_pkey PRIMARY KEY (control_id),
	CONSTRAINT data_controls_to_process_maps_process_id_fkey FOREIGN KEY (process_id) REFERENCES data_management_processes(process_id)
);

COMMENT ON COLUMN data_controls_to_process_maps.control_id IS 'Id';
COMMENT ON COLUMN data_controls_to_process_maps.process_id IS 'Foreign key from data_governance_processes';
COMMENT ON COLUMN data_controls_to_process_maps.ref_metadata IS 'Ref Metadata which needs to be used for this control based on Process Type name BatchPipelineOrigin/BatchPipelineDeestination';
COMMENT ON COLUMN data_controls_to_process_maps.check_lvl IS 'Error/Warning/Info';
COMMENT ON COLUMN data_controls_to_process_maps.active_flg IS 'if this control is still active';
COMMENT ON COLUMN data_controls_to_process_maps.reserved_5 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls_to_process_maps.reserved_4 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls_to_process_maps.reserved_3 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls_to_process_maps.reserved_2 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls_to_process_maps.reserved_1 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls_to_process_maps.created_by IS 'creator';
COMMENT ON COLUMN data_controls_to_process_maps.created_ts IS 'create timestamp';
COMMENT ON COLUMN data_controls_to_process_maps.updated_by IS 'last updated by';
COMMENT ON COLUMN data_controls_to_process_maps.updated_ts IS 'last updated timestamp';
COMMENT ON COLUMN data_controls_to_process_maps.effective_from IS 'Date from which this process will be effective';
COMMENT ON COLUMN data_controls_to_process_maps.expiry_date IS 'Date on Which this process was discontinued';

INSERT INTO "data_controls_to_process_maps" (control_id,process_id,ref_metadata,check_lvl,effective_from,expiry_date,active_flg,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,created_by,created_ts,updated_by,updated_ts)
     VALUES ('DCPM-00000000000000000001','DMP-00000000000000000001',NULL,'Warning',TO_TIMESTAMP('07/11/2025 19:16:00.872', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),TO_TIMESTAMP('12/31/9999 00:00:00.00', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),'Y',NULL,NULL,NULL,NULL,NULL,'chimera_user',TO_TIMESTAMP('07/11/2025 19:16:00.872', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),NULL,NULL);
INSERT INTO "data_controls_to_process_maps" (control_id,process_id,ref_metadata,check_lvl,effective_from,expiry_date,active_flg,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,created_by,created_ts,updated_by,updated_ts)
     VALUES ('DCPM-00000000000000000002','DMP-00000000000000000002',NULL,'Warning',TO_TIMESTAMP('07/11/2025 19:16:13.121', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),TO_TIMESTAMP('12/31/9999 00:00:00.00', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),'Y',NULL,NULL,NULL,NULL,NULL,'chimera_user',TO_TIMESTAMP('07/11/2025 19:16:13.121', 'MM/DD/YYYY fmHH24fm:MI:SS.FF'),NULL,NULL);
COMMIT;