CREATE SEQUENCE data_quality_rules_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;

    CREATE TABLE data_quality_rules (
	rule_id  varchar(30) default ('DQR-'||lpad(((nextval('data_quality_rules_seq')::text)),20,'0')) ,
	dimension_id varchar(30) NOT NULL, -- foreign key from dq_dimensions
	rule_name varchar(100) NOT NULL, -- meaningful name
	rule_desc varchar(500) NOT NULL, -- short description of the rule
	rule_example text NOT NULL, -- example to help understand the rule and its implementation
	rule_owner varchar(50) NOT NULL, -- owner of the rule
	check_level varchar(20) NOT NULL, -- Whether this rule is applied at Dataset or Column level$1
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP ,
	expiry_date timestamp default '9999-12-31',
	reserved_5 varchar(50) NULL, -- dummy column for future use
	reserved_4 varchar(50) NULL, -- dummy column for future use
	reserved_3 varchar(50) NULL, -- dummy column for future use
	reserved_2 varchar(50) NULL, -- dummy column for future use
	reserved_1 varchar(50) NULL, -- dummy column for future use
	active_flg varchar(1) DEFAULT 'Y'::character varying NOT NULL, -- if the rule is still active Y/N
	created_by varchar(50) DEFAULT CURRENT_USER NOT NULL, -- creator
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- create timestamp
	updated_by varchar(50) NULL, -- last updated by
	updated_ts timestamp NULL, -- last updated timestamp
	CONSTRAINT dq_rules_pkey PRIMARY KEY (rule_id),
	CONSTRAINT dq_rules_rule_name_key UNIQUE (rule_name),
	CONSTRAINT dq_rules_dimension_id_fkey FOREIGN KEY (dimension_id) REFERENCES data_control_dimensions(dimension_id)
);
COMMENT ON COLUMN data_quality_rules.rule_id IS 'Should this be incremental seq';
COMMENT ON COLUMN data_quality_rules.rule_name IS 'meaningful name';
COMMENT ON COLUMN data_quality_rules.rule_desc IS 'short description of the rule';
COMMENT ON COLUMN data_quality_rules.rule_example IS 'example to help understand the rule and its implementation';
COMMENT ON COLUMN data_quality_rules.rule_owner IS 'owner of the rule';
COMMENT ON COLUMN data_quality_rules.dimension_id IS 'foreign key from dq_dimensions';
COMMENT ON COLUMN data_quality_rules.check_level IS 'Whether this rule is applied at Dataset or Column level?';
COMMENT ON COLUMN data_quality_rules.reserved_5 IS 'dummy column for future use';
COMMENT ON COLUMN data_quality_rules.reserved_4 IS 'dummy column for future use';
COMMENT ON COLUMN data_quality_rules.reserved_3 IS 'dummy column for future use';
COMMENT ON COLUMN data_quality_rules.reserved_2 IS 'dummy column for future use';
COMMENT ON COLUMN data_quality_rules.reserved_1 IS 'dummy column for future use';
COMMENT ON COLUMN data_quality_rules.active_flg IS 'if the rule is still active Y/N';
COMMENT ON COLUMN data_quality_rules.created_by IS 'creator';
COMMENT ON COLUMN data_quality_rules.created_ts IS 'create timestamp';
COMMENT ON COLUMN data_quality_rules.updated_by IS 'last updated by';
COMMENT ON COLUMN data_quality_rules.updated_ts IS 'last updated timestamp';




INSERT INTO data_quality_rules(dimension_id,rule_name,rule_desc,rule_owner,rule_example,check_level)
 VALUES
	 ('DCD-00000000000000000007','isComplete','Conformity(isComplete)','AWS Deeque','isComplete(ColumnName)','Dataset'),
	 ('DCD-00000000000000000005','isUnique','Uniqueness(isUnique)','AWS Deeque','isUnique(ColumnName)','Dataset'),
	 ('DCD-00000000000000000001','isNonNegative','Completeness(isNonNegative)','AWS Deeque','isNonNegative(ColumnName)','Dataset'),
	 ('DCD-00000000000000000007','isContainedIn','Conformity(isContainedIn)','AWS Deeque','.isContainedIn(“ColumnName”, Array(array list comma separated))','Dataset'),
	 ('DCD-00000000000000000005','hasUniqueness','Uniqueness(hasUniqueness)','AWS Deeque','hasUniqueness(“ColumnName”, _ ==1.0)','Dataset'),
	 ('DCD-00000000000000000005','hasDistinctness','Uniqueness(hasDistinctness)','AWS Deeque','hasDistinctness(“ColumnName”, _ ==1.0)','Dataset'),
	 ('DCD-00000000000000000005','hasUniqueValueRatio','Uniqueness(hasUniqueValueRatio)','AWS Deeque','hasUniqueValueRatio()','Dataset'),
	 ('DCD-00000000000000000005','hasMutualInformation','Uniqueness(hasMutualInformation)','AWS Deeque','hasMutualInformation()','Dataset'),
	 ('DCD-00000000000000000007','hasApproxQuantile','Conformity(hasApproxQuantile)','AWS Deeque','hasApproxQuantile()','Dataset'),
	 ('DCD-00000000000000000001','hasMinLength','Completeness(hasMinLength)','AWS Deeque','hasMinLength()','Dataset'),
	 ('DCD-00000000000000000001','hasMaxLength','Completeness(hasMaxLength)','AWS Deeque','hasMaxLength()','Dataset'),
	 ('DCD-00000000000000000001','hasMin','Completeness(hasMin)','AWS Deeque','hasMin(“ColumnName”, _ ==1.0)','Dataset'),
	 ('DCD-00000000000000000001','hasMax','Completeness(hasMax)','AWS Deeque','hasMax(“ColumnName”, _ ==5.0)','Dataset'),
	 ('DCD-00000000000000000001','hasMean','Completeness(hasMean)','AWS Deeque','hasMean(“ColumnName”, _ ==5.0)','Dataset'),
	 ('DCD-00000000000000000001','hasSum','Completeness(hasSum)','AWS Deeque','hasSum(“ColumnName”, _ ==5.0)','Dataset'),
	 ('DCD-00000000000000000001','hasStandardDeviation','Completeness(hasStandardDeviation)','AWS Deeque','hasStandardDeviation()','Dataset'),
	 ('DCD-00000000000000000001','hasApproxCountDistinct','Completeness(hasApproxCountDistinct)','AWS Deeque','hasApproxCountDistinct()','Dataset'),
	 ('DCD-00000000000000000001','containsCreditCardNumber','Completeness(containsCreditCardNumber)','AWS Deeque','containsCreditCardNumber("ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','containsEmail','Completeness(containsEmail)','AWS Deeque','containsEmail("ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','containsURL','Completeness(containsURL)','AWS Deeque','containsURL("ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','containsSocialSecurityNumber','Completeness(containsSocialSecurityNumber)','AWS Deeque','containsSocialSecurityNumber()','Dataset'),
	 ('DCD-00000000000000000007','hasDataType','Conformity(hasDataType)','AWS Deeque','hasDataType(“ColumnName”, Boolean)','Dataset'),
	 ('DCD-00000000000000000001','isPositive','Completeness(isPositive)','AWS Deeque','isPositive()','Dataset'),
	 ('DCD-00000000000000000001','isLessThan','Completeness(isLessThan)','AWS Deeque','isLessThan(“ColumnName”, “ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','isLessThanOrEqualTo','Completeness(isLessThanOrEqualTo)','AWS Deeque','isLessThanOrEqualTo(“ColumnName”, “ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','isGreaterThan','Completeness(isGreaterThan)','AWS Deeque','isGreaterThan(“ColumnName”, “ColumnName”)','Dataset'),
	 ('DCD-00000000000000000001','isGreaterThanOrEqualTo','Completeness(isGreaterThanOrEqualTo)','AWS Deeque','isGreaterThanOrEqualTo(“ColumnName”, “ColumnName”)','Dataset'),
	 ('DCD-00000000000000000007','hasSize','Conformity(hasSize)','AWS Deeque','hasSize(_ == 5)','Dataset');
