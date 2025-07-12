CREATE SEQUENCE data_controls_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;

CREATE TABLE data_controls (
	control_id varchar(30) default ('DC-'||lpad(((nextval('data_controls_seq')::text)),20,'0')) ,
	control_name varchar(100) NOT NULL, -- meaning name
	control_short_desc varchar(500) NOT NULL, -- data controls description
	control_long_desc text NOT NULL, -- Long description, can be used by AI or UI to share notes
	active_flg varchar(1) DEFAULT 'Y'::character varying NOT NULL, -- if this control is still active
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP ,
	expiry_date timestamp default '9999-12-31',
	reserved_5 varchar(50) NULL, -- dummy column for future use
	reserved_4 varchar(50) NULL, -- dummy column for future use
	reserved_3 varchar(50) NULL, -- dummy column for future use
	reserved_2 varchar(50) NULL, -- dummy column for future use
	reserved_1 varchar(50) NULL, -- dummy column for future use
	created_by varchar(50) DEFAULT CURRENT_USER NOT NULL, -- creator
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- create timestamp
	updated_by varchar(50) NULL, -- last updated by
	updated_ts timestamp NULL, -- last updated timestamp
	CONSTRAINT data_controls_control_name_key UNIQUE (control_name),
	CONSTRAINT data_controls_pkey PRIMARY KEY (control_id)
);


COMMENT ON COLUMN data_controls.control_id IS 'Id';
COMMENT ON COLUMN data_controls.control_name IS 'meaning name';
COMMENT ON COLUMN data_controls.control_short_desc IS 'data controls description';
COMMENT ON COLUMN data_controls.control_long_desc IS 'Long description, can be used by AI or UI to share notes';
COMMENT ON COLUMN data_controls.active_flg IS 'if this control is still active';
COMMENT ON COLUMN data_controls.reserved_5 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls.reserved_4 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls.reserved_3 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls.reserved_2 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls.reserved_1 IS 'dummy column for future use';
COMMENT ON COLUMN data_controls.created_by IS 'creator';
COMMENT ON COLUMN data_controls.created_ts IS 'create timestamp';
COMMENT ON COLUMN data_controls.updated_by IS 'last updated by';
COMMENT ON COLUMN data_controls.updated_ts IS 'last updated timestamp';


INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Operational Controls', 'Ensure proper handling and monitoring of data in daily operations.', 'Ensure proper handling and monitoring of data in daily operations.

Backups and recovery: Protect against data loss.

Monitoring and logging: Track access and usage patterns.

Change management: Control and document data changes in systems.');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Compliance Controls', 'Ensure data handling complies with legal, regulatory, and contractual obligations', 'Ensure data handling complies with legal, regulatory, and contractual obligations.

Audits and assessments: Periodic reviews of data practices.

Policy enforcement: Automated tools to enforce compliance rules');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Quality', 'These are processes and mechanisms used to ensure data is accurate, consistent, and reliable throughout its lifecycle.

', 'These are processes and mechanisms used to ensure data is accurate, consistent, and reliable throughout its lifecycle.

');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Lineage', 'Data lineage is about tracking the origin, movement, and transformation of data through systems. It helps with transparency, debugging, compliance, and governance.

', 'Data lineage is about tracking the origin, movement, and transformation of data through systems. It helps with transparency, debugging, compliance, and governance.

');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Access Controls', 'These regulate who can access data and what actions they can perform.', 'These regulate who can access data and what actions they can perform.

Authentication: Verifying user identity (e.g., passwords, biometrics, two-factor authentication).

Authorization: Granting permissions based on roles (e.g., role-based access control [RBAC], attribute-based access control [ABAC]).

User provisioning: Managing user accounts and their access levels.');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Integrity Controls', 'Ensure data remains accurate, complete, and consistent over its lifecycle.', 'Ensure data remains accurate, complete, and consistent over its lifecycle.

Checksums & Hashing: Detect data corruption.

Input validation: Prevent incorrect or malicious data entry.

Audit trails: Record data changes and user actions.');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Security Controls', 'Protect data from unauthorized access, breaches, and leaks.', 'Protect data from unauthorized access, breaches, and leaks.

Encryption: Secures data at rest and in transit.

Tokenization: Replaces sensitive data with non-sensitive equivalents.

Firewalls & Intrusion Detection Systems (IDS): Prevent unauthorized access.

Data Loss Prevention (DLP): Monitors and protects data from accidental or intentional leaks.');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Privacy Controls', 'Ensure compliance with privacy regulations (e.g., GDPR, HIPAA).', 'Ensure compliance with privacy regulations (e.g., GDPR, HIPAA).

Data anonymization/pseudonymization: Protect personal data.

Consent management: Capture and enforce user preferences.

Data minimization: Collect only what is necessary');
INSERT INTO data_controls (control_name, control_short_desc, control_long_desc) VALUES('Data Governance Controls', 'Establish rules and standards for managing data across an organization.', 'Establish rules and standards for managing data across an organization.

Data classification: Categorize data based on sensitivity and usage.

Data stewardship: Assign responsibility for data quality and compliance.

Policies and procedures: Documented rules for data handling.');


