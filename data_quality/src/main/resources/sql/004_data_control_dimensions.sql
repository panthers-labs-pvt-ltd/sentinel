CREATE SEQUENCE data_control_dimensions_seq
    START WITH 1
    INCREMENT BY 1
    MINVALUE 1
    MAXVALUE 9999999999
    CYCLE -- start again after hitting max
    CACHE 20;


CREATE TABLE data_control_dimensions (
	dimension_id varchar(30) default ('DCD-'||lpad(((nextval('data_control_dimensions_seq')::text)),20,'0')) ,
	control_id varchar(30) NOT NULL, --foreign key from data_controls
	dimension_name varchar(100) NOT NULL, -- Name of the data quality dimensions
	dimension_short_desc varchar(500) NOT NULL, -- Description of the data quality
	dimension_long_desc text NOT NULL, -- Long description, can be used by AI or UI to share notes
	calculated_field bool DEFAULT false NOT NULL, -- Is this dimension a calculated field
	calculation_function varchar(500) NULL, -- Relevant only when calculated_field is true
	effective_from timestamp DEFAULT CURRENT_TIMESTAMP ,
	expiry_date timestamp default '9999-12-31',
	created_by varchar(50) DEFAULT CURRENT_USER NOT NULL, -- creator
	created_ts timestamp DEFAULT CURRENT_TIMESTAMP NOT NULL, -- create timestamp
	updated_by varchar(50) NULL, -- last updated by
	updated_ts timestamp NULL, -- last updated timestamp
	CONSTRAINT dq_dimensions_dimension_name_key UNIQUE (dimension_name),
	CONSTRAINT dq_dimensions_pkey PRIMARY KEY (dimension_id),
	CONSTRAINT dq_dimensions_control_id_fkey FOREIGN KEY (control_id) REFERENCES data_controls(control_id)
);

-- Column comments

COMMENT ON COLUMN data_control_dimensions.dimension_id IS 'Id';
COMMENT ON COLUMN data_control_dimensions.dimension_name IS 'Name of the data quality dimensions';
COMMENT ON COLUMN data_control_dimensions.dimension_short_desc IS 'Description of the data quality';
COMMENT ON COLUMN data_control_dimensions.dimension_long_desc IS 'Long description, can be used by AI or UI to share notes';
COMMENT ON COLUMN data_control_dimensions.calculated_field IS 'Is this dimension a calculated field';
COMMENT ON COLUMN data_control_dimensions.calculation_function IS 'Relevant only when calculated_field is true';
COMMENT ON COLUMN data_control_dimensions.control_id IS 'foreign key from data_controls';
COMMENT ON COLUMN data_control_dimensions.created_by IS 'creator';
COMMENT ON COLUMN data_control_dimensions.created_ts IS 'create timestamp';
COMMENT ON COLUMN data_control_dimensions.updated_by IS 'last updated by';
COMMENT ON COLUMN data_control_dimensions.updated_ts IS 'last updated timestamp';


select * from data_control_dimensions;

INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Data Completeness', 'Completeness measures how much of the required data is present in a dataset. Complete data contains all the necessary information and is not missing any values.', 'Completeness measures how much of the required data is present in a dataset. Complete data contains all the necessary information and is not missing any values. In mathematical terms, completeness is the ratio of the number of non-missing values to the total number of values in a dataset, or alternatively, ');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Data Accuracy', 'Accuracy measures how well data reflects the real-world objects or events it represents. Accurate data is free from errors, inconsistencies, and inaccuracies.', 'Accuracy measures how well data reflects the real-world objects or events it represents. Accurate data is free from errors, inconsistencies, and inaccuracies.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Comprehensiveness', 'A measure of the degree to which a dataset used for a report contains all material areas that are relevant to that report.', 'A measure of the degree to which a dataset used for a report contains all material areas that are relevant to that report.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Immutability', 'A measure of the degree to which a dataset has not changed post its creation.', 'A measure of the degree to which a dataset has not changed post its creation.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Uniqueness', 'A measure of the degree to which a data attribute, or combination of attributes, meet the expectation that no duplicate values are present in a data set.', 'A measure of the degree to which a data attribute, or combination of attributes, meet the expectation that no duplicate values are present in a data set.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Timeliness', 'A measure of how up-to-date data is and how quickly it is available for analysis', 'A measure of how up-to-date data is and how quickly it is available for analysis');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Conformity', 'A measure of the degree of how well data conforms to the rules, standards, and constraints of its data model or schema.', 'A measure of the degree of how well data conforms to the rules, standards, and constraints of its data model or schema.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Consistency', 'A measure of the equivalence of comparable data attributes stored across different sources and systems, or in different locations within the same dataset, at comparable points in time.', 'A measure of the equivalence of comparable data attributes stored across different sources and systems, or in different locations within the same dataset, at comparable points in time.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Usability', 'A measure of how easy it is to access, understand, and use data. Usable data is accessible, user-friendly, and well-documented', 'A measure of how easy it is to access, understand, and use data. Usable data is accessible, user-friendly, and well-documented');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Relevance', 'A measure of how well data meets the needs of its users and stakeholders', 'A measure of how well data meets the needs of its users and stakeholders');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Integrity', 'TBD', 'TBD');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Validity', 'A measure of how well data conforms to the rules, standards, and constraints of its data model or schema. Valid data is accurate, complete, and consistent with its data model', 'A measure of how well data conforms to the rules, standards, and constraints of its data model or schema. Valid data is accurate, complete, and consistent with its data model');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000003', 'Trustworthiness', 'TBD', 'TBD');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000004', 'Business Lineage', 'High-level flow of data across systems (e.g., from CRM to Data Warehouse).', 'Business lineage provides a high-level, human-readable view of how data flows across business systems, from source to destination, without showing complex code or technical logic.

 To help business users, data stewards, and compliance teams understand where data comes from, where it goes, and why it matters — in business terms.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000004', 'Technical Lineage', 'Detailed transformation logic (e.g., SQL joins, filters, aggregations).
', 'Technical lineage maps the detailed, code-level transformations and logic that data undergoes as it moves through systems.

Purpose:
To help data engineers and architects trace data transformations and understand exact dependencies between fields, tables, and pipelines.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000004', 'Operational Lineage', 'Data processing events, job schedules, and runtime history.

', 'Operational lineage captures the real-time execution and runtime behavior of data pipelines, showing how and when data was processed, and by which jobs or workflows.

Purpose:
To give data teams visibility into runtime events — what happened, when, and whether it was successful — for troubleshooting and audit purposes.');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000005', 'Authentication', 'Verifies user identity using credentials.	', 'Authentication ensures that only valid, identified users can access systems by verifying their identity through passwords, biometrics, tokens, or multi-factor methods. It is the first gatekeeper in access control mechanisms.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000005', 'Authorization', 'Defines what actions a user can perform.	', 'Authorization determines a user’s permissions once authenticated. It restricts access to data, features, or actions based on roles, policies, or attributes, and enforces the principle of least privilege.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000005', 'Role Management', 'Assigns access permissions based on roles or attributes.	', 'Role-Based Access Control (RBAC) grants access based on job responsibilities, while Attribute-Based Access Control (ABAC) uses dynamic rules tied to user and environmental attributes. This simplifies large-scale permission management.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000005', 'Access Logging	', 'Tracks who accessed what data and when.	', 'Access logs document every access request, user action, and system response, helping organizations detect misuse, meet audit requirements, and trace incidents during investigations.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000005', 'Access Reviews	', 'Regular checks to validate access permissions.	', 'Periodic access reviews confirm that users only have access needed for their current roles, and remove outdated or unnecessary permissions to maintain security and compliance.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000007', 'Encryption', 'Converts data into unreadable formats for protection.	', 'Encryption secures sensitive data by encoding it so only authorized parties with the decryption key can read it, protecting data at rest and in transit from breaches or leaks.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000007', 'Tokenization', 'Replaces sensitive data with non-sensitive substitutes.	', 'Tokenization masks real data using placeholder values or tokens, reducing exposure of sensitive elements like credit card numbers during storage or processing.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000007', 'Firewalls/IDS	', 'Protect networks by filtering traffic and detecting threats.	', 'Firewalls block unauthorized access while Intrusion Detection Systems (IDS) monitor for unusual or malicious activity, serving as barriers between secure and untrusted networks.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000007', 'Data Masking	', 'Hides original data with fictional but realistic values.	', 'Masking is used in development or testing environments to prevent exposure of sensitive data by replacing it with artificial, but structurally similar data.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000007', 'Data Loss Prevention (DLP)	', 'Prevents unauthorized sharing or export of data.	', 'DLP solutions monitor and control data flows to prevent accidental or malicious leaks by applying content inspection, keyword detection, and policy enforcement.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000006', 'Validation Rules	', 'Enforce correct data input formats.	', 'Input validation rules ensure data entered into systems adheres to predefined formats and constraints, reducing entry errors and ensuring downstream data quality.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000006', 'Checksums & Hashes	', 'Detect unauthorized data changes.	', 'By generating and comparing cryptographic checksums or hashes, systems can detect whether data has been tampered with or corrupted during transmission or storage.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000006', 'Audit Trails	', 'Record history of data changes.	', 'Audit trails maintain detailed logs of data modifications, identifying what was changed, who changed it, and when, supporting traceability and compliance.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000006', 'Referential Integrity	', 'Ensures data relationships remain intact.	', 'This ensures that relationships between tables (e.g., foreign key constraints) are consistent, preventing orphan records or broken links in databases.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000006', 'Error Detection	', 'Identifies corrupt or inconsistent data.	', 'Mechanisms such as data profiling or anomaly detection are used to identify inconsistencies or corrupt records within datasets.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000008', 'Data Minimization	', 'Collect only data necessary for a purpose.	', 'Privacy policies enforce collecting the least amount of personal data necessary to fulfill a task, reducing risk exposure and improving regulatory compliance.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000008', 'Anonymization', 'Irreversibly removes identifiable elements.	', 'Anonymization strips or modifies personal identifiers in datasets so individuals cannot be re-identified, commonly used in data sharing or analytics.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000008', 'Pseudonymization', 'Replaces real identifiers with fictitious substitutes.	', 'Pseudonymization reduces identification risks by replacing personally identifiable information with fictional tokens while retaining the possibility of reverse mapping when authorized.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000008', 'Consent Management	', 'Captures and enforces user consent preferences.	', 'Systems ensure individuals are informed and give consent to data collection, processing, and sharing, and manage opt-in/opt-out choices in line with privacy laws.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000008', 'Privacy Notices	', 'Inform users about how their data is used.	', 'Transparency tools like privacy policies and pop-ups disclose data use practices, improving trust and enabling informed decisions by users.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000009', 'Data Classification', 'Categorizes data by sensitivity and usage.	', 'Data is grouped (e.g., public, internal, confidential) to define handling requirements, access levels, and protection measures, aligning with business and compliance goals.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000009', 'Data Stewardship	', 'Assigns accountability for data quality and usage.	', 'Data stewards are responsible for defining, maintaining, and enforcing standards to ensure data is accurate, consistent, and used correctly across business processes.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000009', 'Policies & Standards	', 'Establish data usage rules and guidelines.	', 'Governance policies define how data should be handled, accessed, retained, and shared, ensuring compliance with internal and external regulations.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000009', 'Metadata Management	', 'Maintains structured data about the data.	', 'Metadata includes definitions, lineage, data types, and ownership, enabling better discovery, understanding, and governance of enterprise data assets.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000009', 'Data Ownership	', 'Identifies who is responsible for datasets.	', 'Every critical data asset should have an assigned owner accountable for its quality, security, and compliance, enabling decentralized governance.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000001', 'Backup & Recovery', 'Ensures data is recoverable after loss.	', 'Regular backups and tested recovery procedures ensure that data can be restored after accidental deletion, corruption, or system failure.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000001', 'Monitoring & Alerts	', 'Observes systems and notifies on anomalies.	', 'Tools monitor the status of data systems and pipelines, triggering alerts for failures, unusual patterns, or breaches to enable timely response.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000001', 'Change Management	', 'Controls and tracks system and data changes.	', 'Structured processes control changes to data schemas, pipelines, or applications, minimizing risk and ensuring all modifications are logged and approved.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000001', 'Incident Response	', 'Prepares for and manages data incidents.	', 'Defined plans guide how to detect, respond to, and recover from data breaches or failures, ensuring fast containment and communication.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000001', 'Job Scheduling	', 'Automates data processes and workflows.	', 'Data workflows (e.g., ETL jobs) are scheduled and orchestrated to run at defined intervals, ensuring consistency and reducing manual error.

');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000002', 'Audit Readiness	', 'Ensures data practices are verifiable.	', 'Systems and documentation are prepared to demonstrate compliance with legal, regulatory, or contractual requirements during audits or inspections.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000002', 'Policy Enforcement	', 'Applies rules to ensure adherence to standards.	', 'Automated enforcement tools ensure that regulatory and organizational policies (e.g., retention limits, access rights) are followed across all systems.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000002', 'Regulatory Mapping	', 'Aligns data practices to laws and frameworks.	', 'Compliance teams map internal policies and data flows to regulations such as GDPR, HIPAA, or SOX, ensuring all legal obligations are met.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000002', 'Training & Awareness	', 'Educates staff on compliance responsibilities.	', 'Regular training programs ensure that employees understand data policies, privacy rights, and security practices relevant to their roles.
');
INSERT INTO data_control_dimensions (control_id, dimension_name, dimension_short_desc, dimension_long_desc) VALUES('DC-00000000000000000002', 'Retention & Disposal	', 'Ensures data is kept only as long as needed.	', 'Data retention policies specify how long to keep different types of data and ensure secure disposal afterward to reduce liability and cost.

');