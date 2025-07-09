INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (2,'Data Completeness','Completeness measures how much of the required data is present in a dataset. Complete data contains all the necessary information and is not missing any values.','Completeness measures how much of the required data is present in a dataset. Complete data contains all the necessary information and is not missing any values. In mathematical terms, completeness is the ratio of the number of non-missing values to the total number of values in a dataset, or alternatively, ',false,NULL,1,'chimera_user','2025-07-05 21:24:21.722893',NULL,NULL),
	 (1,'Data Accuracy','Accuracy measures how well data reflects the real-world objects or events it represents. Accurate data is free from errors, inconsistencies, and inaccuracies.','Accuracy measures how well data reflects the real-world objects or events it represents. Accurate data is free from errors, inconsistencies, and inaccuracies.',false,NULL,1,'chimera_user','2025-07-05 21:22:52.748067',NULL,NULL),
	 (3,'Comprehensiveness','A measure of the degree to which a dataset used for a report contains all material areas that are relevant to that report.','A measure of the degree to which a dataset used for a report contains all material areas that are relevant to that report.',false,NULL,1,'chimera_user','2025-07-05 21:29:47.468935',NULL,NULL),
	 (4,'Immutability','A measure of the degree to which a dataset has not changed post its creation.','A measure of the degree to which a dataset has not changed post its creation.',false,NULL,1,'chimera_user','2025-07-05 21:29:47.482508',NULL,NULL),
	 (5,'Uniqueness','A measure of the degree to which a data attribute, or combination of attributes, meet the expectation that no duplicate values are present in a data set.','A measure of the degree to which a data attribute, or combination of attributes, meet the expectation that no duplicate values are present in a data set.',false,NULL,1,'chimera_user','2025-07-05 21:29:47.49585',NULL,NULL),
	 (6,'Timeliness','A measure of how up-to-date data is and how quickly it is available for analysis','A measure of how up-to-date data is and how quickly it is available for analysis',false,NULL,1,'chimera_user','2025-07-05 21:29:47.510891',NULL,NULL),
	 (7,'Conformity','A measure of the degree of how well data conforms to the rules, standards, and constraints of its data model or schema.','A measure of the degree of how well data conforms to the rules, standards, and constraints of its data model or schema.',false,NULL,1,'chimera_user','2025-07-05 21:29:47.527147',NULL,NULL),
	 (8,'Consistency','A measure of the equivalence of comparable data attributes stored across different sources and systems, or in different locations within the same dataset, at comparable points in time.','A measure of the equivalence of comparable data attributes stored across different sources and systems, or in different locations within the same dataset, at comparable points in time.',false,NULL,1,'chimera_user','2025-07-05 21:29:47.541618',NULL,NULL),
	 (9,'Usability','A measure of how easy it is to access, understand, and use data. Usable data is accessible, user-friendly, and well-documented','A measure of how easy it is to access, understand, and use data. Usable data is accessible, user-friendly, and well-documented',false,NULL,1,'chimera_user','2025-07-05 21:29:47.554119',NULL,NULL),
	 (10,'Relevance','A measure of how well data meets the needs of its users and stakeholders','A measure of how well data meets the needs of its users and stakeholders',false,NULL,1,'chimera_user','2025-07-05 21:29:47.568767',NULL,NULL);
INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (11,'Integrity','TBD','TBD',false,NULL,1,'chimera_user','2025-07-05 21:29:47.582132',NULL,NULL),
	 (12,'Validity','A measure of how well data conforms to the rules, standards, and constraints of its data model or schema. Valid data is accurate, complete, and consistent with its data model','A measure of how well data conforms to the rules, standards, and constraints of its data model or schema. Valid data is accurate, complete, and consistent with its data model',false,NULL,1,'chimera_user','2025-07-05 21:29:47.596503',NULL,NULL),
	 (13,'Trustworthiness','TBD','TBD',false,NULL,1,'chimera_user','2025-07-05 21:29:47.609853',NULL,NULL),
	 (14,'Business Lineage','High-level flow of data across systems (e.g., from CRM to Data Warehouse).','Business lineage provides a high-level, human-readable view of how data flows across business systems, from source to destination, without showing complex code or technical logic.

 To help business users, data stewards, and compliance teams understand where data comes from, where it goes, and why it matters — in business terms.

',false,NULL,2,'chimera_user','2025-07-07 21:52:36.117468',NULL,NULL),
	 (15,'Technical Lineage','Detailed transformation logic (e.g., SQL joins, filters, aggregations).
','Technical lineage maps the detailed, code-level transformations and logic that data undergoes as it moves through systems.

Purpose:
To help data engineers and architects trace data transformations and understand exact dependencies between fields, tables, and pipelines.',false,NULL,2,'chimera_user','2025-07-07 21:52:36.130763',NULL,NULL),
	 (16,'Operational Lineage','Data processing events, job schedules, and runtime history.

','Operational lineage captures the real-time execution and runtime behavior of data pipelines, showing how and when data was processed, and by which jobs or workflows.

Purpose:
To give data teams visibility into runtime events — what happened, when, and whether it was successful — for troubleshooting and audit purposes.',false,NULL,2,'chimera_user','2025-07-07 21:52:36.144429',NULL,NULL),
	 (17,'Authentication','Verifies user identity using credentials.	','Authentication ensures that only valid, identified users can access systems by verifying their identity through passwords, biometrics, tokens, or multi-factor methods. It is the first gatekeeper in access control mechanisms.
',false,NULL,3,'chimera_user','2025-07-07 21:57:56.116093',NULL,NULL),
	 (18,'Authorization','Defines what actions a user can perform.	','Authorization determines a user’s permissions once authenticated. It restricts access to data, features, or actions based on roles, policies, or attributes, and enforces the principle of least privilege.
',false,NULL,3,'chimera_user','2025-07-07 21:57:56.130366',NULL,NULL),
	 (19,'Role Management','Assigns access permissions based on roles or attributes.	','Role-Based Access Control (RBAC) grants access based on job responsibilities, while Attribute-Based Access Control (ABAC) uses dynamic rules tied to user and environmental attributes. This simplifies large-scale permission management.
',false,NULL,3,'chimera_user','2025-07-07 21:57:56.142954',NULL,NULL),
	 (20,'Access Logging	','Tracks who accessed what data and when.	','Access logs document every access request, user action, and system response, helping organizations detect misuse, meet audit requirements, and trace incidents during investigations.
',false,NULL,3,'chimera_user','2025-07-07 21:57:56.160054',NULL,NULL);
INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (21,'Access Reviews	','Regular checks to validate access permissions.	','Periodic access reviews confirm that users only have access needed for their current roles, and remove outdated or unnecessary permissions to maintain security and compliance.

',false,NULL,3,'chimera_user','2025-07-07 21:57:56.173657',NULL,NULL),
	 (22,'Encryption','Converts data into unreadable formats for protection.	','Encryption secures sensitive data by encoding it so only authorized parties with the decryption key can read it, protecting data at rest and in transit from breaches or leaks.
',false,NULL,5,'chimera_user','2025-07-07 22:00:01.151679',NULL,NULL),
	 (23,'Tokenization','Replaces sensitive data with non-sensitive substitutes.	','Tokenization masks real data using placeholder values or tokens, reducing exposure of sensitive elements like credit card numbers during storage or processing.
',false,NULL,5,'chimera_user','2025-07-07 22:00:01.180151',NULL,NULL),
	 (24,'Firewalls/IDS	','Protect networks by filtering traffic and detecting threats.	','Firewalls block unauthorized access while Intrusion Detection Systems (IDS) monitor for unusual or malicious activity, serving as barriers between secure and untrusted networks.
',false,NULL,5,'chimera_user','2025-07-07 22:00:01.208581',NULL,NULL),
	 (25,'Data Masking	','Hides original data with fictional but realistic values.	','Masking is used in development or testing environments to prevent exposure of sensitive data by replacing it with artificial, but structurally similar data.
',false,NULL,5,'chimera_user','2025-07-07 22:00:01.255538',NULL,NULL),
	 (26,'Data Loss Prevention (DLP)	','Prevents unauthorized sharing or export of data.	','DLP solutions monitor and control data flows to prevent accidental or malicious leaks by applying content inspection, keyword detection, and policy enforcement.

',false,NULL,5,'chimera_user','2025-07-07 22:00:01.466648',NULL,NULL),
	 (27,'Validation Rules	','Enforce correct data input formats.	','Input validation rules ensure data entered into systems adheres to predefined formats and constraints, reducing entry errors and ensuring downstream data quality.
',false,NULL,4,'chimera_user','2025-07-07 22:01:54.044673',NULL,NULL),
	 (28,'Checksums & Hashes	','Detect unauthorized data changes.	','By generating and comparing cryptographic checksums or hashes, systems can detect whether data has been tampered with or corrupted during transmission or storage.
',false,NULL,4,'chimera_user','2025-07-07 22:01:54.058732',NULL,NULL),
	 (29,'Audit Trails	','Record history of data changes.	','Audit trails maintain detailed logs of data modifications, identifying what was changed, who changed it, and when, supporting traceability and compliance.
',false,NULL,4,'chimera_user','2025-07-07 22:01:54.071512',NULL,NULL),
	 (30,'Referential Integrity	','Ensures data relationships remain intact.	','This ensures that relationships between tables (e.g., foreign key constraints) are consistent, preventing orphan records or broken links in databases.
',false,NULL,4,'chimera_user','2025-07-07 22:01:54.087033',NULL,NULL);
INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (31,'Error Detection	','Identifies corrupt or inconsistent data.	','Mechanisms such as data profiling or anomaly detection are used to identify inconsistencies or corrupt records within datasets.

',false,NULL,4,'chimera_user','2025-07-07 22:01:54.103866',NULL,NULL),
	 (32,'Data Minimization	','Collect only data necessary for a purpose.	','Privacy policies enforce collecting the least amount of personal data necessary to fulfill a task, reducing risk exposure and improving regulatory compliance.
',false,NULL,6,'chimera_user','2025-07-07 22:04:02.196464',NULL,NULL),
	 (33,'Anonymization','Irreversibly removes identifiable elements.	','Anonymization strips or modifies personal identifiers in datasets so individuals cannot be re-identified, commonly used in data sharing or analytics.
',false,NULL,6,'chimera_user','2025-07-07 22:04:02.210381',NULL,NULL),
	 (34,'Pseudonymization','Replaces real identifiers with fictitious substitutes.	','Pseudonymization reduces identification risks by replacing personally identifiable information with fictional tokens while retaining the possibility of reverse mapping when authorized.
',false,NULL,6,'chimera_user','2025-07-07 22:04:02.227689',NULL,NULL),
	 (35,'Consent Management	','Captures and enforces user consent preferences.	','Systems ensure individuals are informed and give consent to data collection, processing, and sharing, and manage opt-in/opt-out choices in line with privacy laws.
',false,NULL,6,'chimera_user','2025-07-07 22:04:02.248013',NULL,NULL),
	 (36,'Privacy Notices	','Inform users about how their data is used.	','Transparency tools like privacy policies and pop-ups disclose data use practices, improving trust and enabling informed decisions by users.

',false,NULL,6,'chimera_user','2025-07-07 22:04:02.263594',NULL,NULL),
	 (37,'Data Classification','Categorizes data by sensitivity and usage.	','Data is grouped (e.g., public, internal, confidential) to define handling requirements, access levels, and protection measures, aligning with business and compliance goals.
',false,NULL,7,'chimera_user','2025-07-07 22:06:06.394199',NULL,NULL),
	 (38,'Data Stewardship	','Assigns accountability for data quality and usage.	','Data stewards are responsible for defining, maintaining, and enforcing standards to ensure data is accurate, consistent, and used correctly across business processes.
',false,NULL,7,'chimera_user','2025-07-07 22:06:06.415082',NULL,NULL),
	 (39,'Policies & Standards	','Establish data usage rules and guidelines.	','Governance policies define how data should be handled, accessed, retained, and shared, ensuring compliance with internal and external regulations.
',false,NULL,7,'chimera_user','2025-07-07 22:06:06.428586',NULL,NULL),
	 (40,'Metadata Management	','Maintains structured data about the data.	','Metadata includes definitions, lineage, data types, and ownership, enabling better discovery, understanding, and governance of enterprise data assets.
',false,NULL,7,'chimera_user','2025-07-07 22:06:06.443036',NULL,NULL);
INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (41,'Data Ownership	','Identifies who is responsible for datasets.	','Every critical data asset should have an assigned owner accountable for its quality, security, and compliance, enabling decentralized governance.

',false,NULL,7,'chimera_user','2025-07-07 22:06:06.458464',NULL,NULL),
	 (42,'Backup & Recovery','Ensures data is recoverable after loss.	','Regular backups and tested recovery procedures ensure that data can be restored after accidental deletion, corruption, or system failure.
',false,NULL,8,'chimera_user','2025-07-07 22:07:55.575454',NULL,NULL),
	 (43,'Monitoring & Alerts	','Observes systems and notifies on anomalies.	','Tools monitor the status of data systems and pipelines, triggering alerts for failures, unusual patterns, or breaches to enable timely response.
',false,NULL,8,'chimera_user','2025-07-07 22:07:55.590149',NULL,NULL),
	 (44,'Change Management	','Controls and tracks system and data changes.	','Structured processes control changes to data schemas, pipelines, or applications, minimizing risk and ensuring all modifications are logged and approved.
',false,NULL,8,'chimera_user','2025-07-07 22:07:55.605243',NULL,NULL),
	 (45,'Incident Response	','Prepares for and manages data incidents.	','Defined plans guide how to detect, respond to, and recover from data breaches or failures, ensuring fast containment and communication.
',false,NULL,8,'chimera_user','2025-07-07 22:07:55.617876',NULL,NULL),
	 (46,'Job Scheduling	','Automates data processes and workflows.	','Data workflows (e.g., ETL jobs) are scheduled and orchestrated to run at defined intervals, ensuring consistency and reducing manual error.

',false,NULL,8,'chimera_user','2025-07-07 22:07:55.633858',NULL,NULL),
	 (47,'Audit Readiness	','Ensures data practices are verifiable.	','Systems and documentation are prepared to demonstrate compliance with legal, regulatory, or contractual requirements during audits or inspections.
',false,NULL,9,'chimera_user','2025-07-07 22:09:55.217089',NULL,NULL),
	 (48,'Policy Enforcement	','Applies rules to ensure adherence to standards.	','Automated enforcement tools ensure that regulatory and organizational policies (e.g., retention limits, access rights) are followed across all systems.
',false,NULL,9,'chimera_user','2025-07-07 22:09:55.316422',NULL,NULL),
	 (49,'Regulatory Mapping	','Aligns data practices to laws and frameworks.	','Compliance teams map internal policies and data flows to regulations such as GDPR, HIPAA, or SOX, ensuring all legal obligations are met.
',false,NULL,9,'chimera_user','2025-07-07 22:09:55.41561',NULL,NULL),
	 (50,'Training & Awareness	','Educates staff on compliance responsibilities.	','Regular training programs ensure that employees understand data policies, privacy rights, and security practices relevant to their roles.
',false,NULL,9,'chimera_user','2025-07-07 22:09:55.429214',NULL,NULL);
INSERT INTO public.dq_dimensions (dimension_id,dimension_name,dimension_short_desc,dimension_long_desc,calculated_field,calculation_function,control_id,created_by,created_ts,updated_by,updated_ts) VALUES
	 (51,'Retention & Disposal	','Ensures data is kept only as long as needed.	','Data retention policies specify how long to keep different types of data and ensure secure disposal afterward to reduce liability and cost.

',false,NULL,9,'chimera_user','2025-07-07 22:09:55.441573',NULL,NULL);
