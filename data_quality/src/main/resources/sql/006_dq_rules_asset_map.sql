CREATE SEQUENCE if not exists dq_rules_asset_map_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;


CREATE TABLE dq_rules_asset_map (
	asset_map_id varchar(30) DEFAULT (('DQRM-'::text || lpad(nextval('dq_rules_asset_map_seq'::regclass)::text, 20, '0'::text))) NOT NULL, -- Should be incremental
	rule_id varchar(30) NOT NULL, -- Rule Id
	database_name varchar(255) NOT NULL,
	schema_name varchar(255) NULL,
	table_name varchar(255) NOT NULL,
	partition_keys varchar(500) NULL,
	rule_column varchar(255) NULL,
	rule_value varchar(1000) NULL,
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP NULL, -- Date from which this process will be effective
	expiry_date timestamp DEFAULT '9999-12-31 00:00:00'::timestamp without time zone NULL, -- Date on Which this process was discontinued
	check_level varchar(30) default 'Warning',
	reserved_5 varchar(50) NULL, -- dummy column for future use
	reserved_4 varchar(50) NULL, -- dummy column for future use
	reserved_3 varchar(50) NULL, -- dummy column for future use
	reserved_2 varchar(50) NULL, -- dummy column for future use
	reserved_1 varchar(50) NULL, -- dummy column for future use
	active_flg varchar(1) DEFAULT 'Y'::character varying NOT NULL, -- whether this record is still valid
	created_by varchar(50) DEFAULT CURRENT_USER NOT NULL,
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL,
	updated_ts timestamp NULL, -- last updated by
	updated_by varchar(50) NULL, -- last updated timestamp
	CONSTRAINT dq_rules_asset_map_pkey PRIMARY KEY (asset_map_id)
);

-- Column comments

COMMENT ON COLUMN dq_rules_asset_map.asset_map_id IS 'Should be incremental';
COMMENT ON COLUMN dq_rules_asset_map.rule_id IS 'Rule Id';
COMMENT ON COLUMN dq_rules_asset_map.database_name IS 'database_name';
COMMENT ON COLUMN dq_rules_asset_map.effective_from IS 'Date from which this process will be effective';
COMMENT ON COLUMN dq_rules_asset_map.expiry_date IS 'Date on Which this process was discontinued';
COMMENT ON COLUMN dq_rules_asset_map.active_flg IS 'whether this record is still valid';
COMMENT ON COLUMN dq_rules_asset_map.reserved_5 IS 'dummy column for future use';
COMMENT ON COLUMN dq_rules_asset_map.reserved_4 IS 'dummy column for future use';
COMMENT ON COLUMN dq_rules_asset_map.reserved_3 IS 'dummy column for future use';
COMMENT ON COLUMN dq_rules_asset_map.reserved_2 IS 'dummy column for future use';
COMMENT ON COLUMN dq_rules_asset_map.reserved_1 IS 'dummy column for future use';
COMMENT ON COLUMN dq_rules_asset_map.updated_ts IS 'last updated by';
COMMENT ON COLUMN dq_rules_asset_map.updated_by IS 'last updated timestamp';

-- Permissions

ALTER TABLE dq_rules_asset_map OWNER TO chimera_user;
GRANT ALL ON TABLE dq_rules_asset_map TO chimera_user;


-- dq_rules_asset_map foreign keys

ALTER TABLE dq_rules_asset_map ADD CONSTRAINT dq_rules_asset_map_rule_id_fkey FOREIGN KEY (rule_id) REFERENCES data_quality_rules(rule_id);



