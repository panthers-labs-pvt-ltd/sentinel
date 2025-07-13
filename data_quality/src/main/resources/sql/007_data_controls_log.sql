CREATE TABLE data_controls_log (
	log_id 			   bigserial,
	batch_id           varchar(250),
    control_type       varchar(250),
    control_dimension  varchar(250),
    process_type       varchar(250),
    database_name      varchar(250),
    schema_name        varchar(250),
    table_name         varchar(250),
    partition_keys     varchar(500),
    business_date     date,
    rule_column        varchar(250),
    rule_name          varchar(250),
    rule_value         varchar(500),
    check_level        varchar(50),
    constraint_desc    TEXT,
    constraint_msg     TEXT,
    status             varchar(50),
    execution_ts       TIMESTAMPTZ,
    reserved_5 varchar(50) NULL, -- dummy column for future use
	reserved_4 varchar(50) NULL, -- dummy column for future use
	reserved_3 varchar(50) NULL, -- dummy column for future use
	reserved_2 varchar(50) NULL, -- dummy column for future use
	reserved_1 varchar(50) NULL, -- dummy column for future use
    CONSTRAINT data_controls_log_pkey PRIMARY KEY (log_id)
);