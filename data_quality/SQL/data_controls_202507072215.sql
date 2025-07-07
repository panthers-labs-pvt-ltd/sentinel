INSERT INTO public.data_controls (control_id,control_name,control_short_desc,control_long_desc,active_flg,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,created_by,created_ts,updated_by,updated_ts) VALUES
	 (8,'Operational Controls','Ensure proper handling and monitoring of data in daily operations.','Ensure proper handling and monitoring of data in daily operations.

Backups and recovery: Protect against data loss.

Monitoring and logging: Track access and usage patterns.

Change management: Control and document data changes in systems.','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (9,'Compliance Controls','Ensure data handling complies with legal, regulatory, and contractual obligations','Ensure data handling complies with legal, regulatory, and contractual obligations.

Audits and assessments: Periodic reviews of data practices.

Policy enforcement: Automated tools to enforce compliance rules','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (1,'Data Quality','These are processes and mechanisms used to ensure data is accurate, consistent, and reliable throughout its lifecycle.

','These are processes and mechanisms used to ensure data is accurate, consistent, and reliable throughout its lifecycle.

','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917','manish','2025-07-07 09:47:22.643'),
	 (2,'Data Lineage','Data lineage is about tracking the origin, movement, and transformation of data through systems. It helps with transparency, debugging, compliance, and governance.

','Data lineage is about tracking the origin, movement, and transformation of data through systems. It helps with transparency, debugging, compliance, and governance.

','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (3,'Access Controls','These regulate who can access data and what actions they can perform.','These regulate who can access data and what actions they can perform.

Authentication: Verifying user identity (e.g., passwords, biometrics, two-factor authentication).

Authorization: Granting permissions based on roles (e.g., role-based access control [RBAC], attribute-based access control [ABAC]).

User provisioning: Managing user accounts and their access levels.','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (4,'Data Integrity Controls','Ensure data remains accurate, complete, and consistent over its lifecycle.','Ensure data remains accurate, complete, and consistent over its lifecycle.

Checksums & Hashing: Detect data corruption.

Input validation: Prevent incorrect or malicious data entry.

Audit trails: Record data changes and user actions.','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (5,'Data Security Controls','Protect data from unauthorized access, breaches, and leaks.','Protect data from unauthorized access, breaches, and leaks.

Encryption: Secures data at rest and in transit.

Tokenization: Replaces sensitive data with non-sensitive equivalents.

Firewalls & Intrusion Detection Systems (IDS): Prevent unauthorized access.

Data Loss Prevention (DLP): Monitors and protects data from accidental or intentional leaks.','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (6,'Data Privacy Controls','Ensure compliance with privacy regulations (e.g., GDPR, HIPAA).','Ensure compliance with privacy regulations (e.g., GDPR, HIPAA).

Data anonymization/pseudonymization: Protect personal data.

Consent management: Capture and enforce user preferences.

Data minimization: Collect only what is necessary','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL),
	 (7,'Data Governance Controls','Establish rules and standards for managing data across an organization.','Establish rules and standards for managing data across an organization.

Data classification: Categorize data based on sensitivity and usage.

Data stewardship: Assign responsibility for data quality and compliance.

Policies and procedures: Documented rules for data handling.','Y',NULL,NULL,NULL,NULL,NULL,'Manish','2025-07-01 23:29:14.18917',NULL,NULL);
