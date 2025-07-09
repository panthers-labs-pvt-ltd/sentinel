INSERT INTO public.dq_rules (rule_name,rule_desc,rule_example,rule_owner,dimension_id,check_level,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,active_flg,created_by,created_ts,updated_by,updated_ts) VALUES
	 ('isComplete','Conformity(isComplete)','isComplete(ColumnName)','Chimera DQ',7,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isUnique','Uniqueness(isUnique)','isUnique(ColumnName)','Chimera DQ',5,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isNonNegative','Completeness(isNonNegative)','isNonNegative(ColumnName)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isContainedIn','Conformity(isContainedIn)','.isContainedIn(“ColumnName”, Array(array list comma separated))','Chimera DQ',7,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasUniqueness','Uniqueness(hasUniqueness)','hasUniqueness(“ColumnName”, _ ==1.0)','Chimera DQ',5,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasDistinctness','Uniqueness(hasDistinctness)','hasDistinctness(“ColumnName”, _ ==1.0)','Chimera DQ',5,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasUniqueValueRatio','Uniqueness(hasUniqueValueRatio)','hasUniqueValueRatio()','Chimera DQ',5,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasMutualInformation','Uniqueness(hasMutualInformation)','hasMutualInformation()','Chimera DQ',5,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasApproxQuantile','Conformity(hasApproxQuantile)','hasApproxQuantile()','Chimera DQ',7,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasMinLength','Completeness(hasMinLength)','hasMinLength()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL);
INSERT INTO public.dq_rules (rule_name,rule_desc,rule_example,rule_owner,dimension_id,check_level,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,active_flg,created_by,created_ts,updated_by,updated_ts) VALUES
	 ('hasMaxLength','Completeness(hasMaxLength)','hasMaxLength()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasMin','Completeness(hasMin)','hasMin(“ColumnName”, _ ==1.0)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasMax','Completeness(hasMax)','hasMax(“ColumnName”, _ ==5.0)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasMean','Completeness(hasMean)','hasMean(“ColumnName”, _ ==5.0)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasSum','Completeness(hasSum)','hasSum(“ColumnName”, _ ==5.0)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasStandardDeviation','Completeness(hasStandardDeviation)','hasStandardDeviation()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasApproxCountDistinct','Completeness(hasApproxCountDistinct)','hasApproxCountDistinct()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('containsCreditCardNumber','Completeness(containsCreditCardNumber)','containsCreditCardNumber("ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('containsEmail','Completeness(containsEmail)','containsEmail("ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('containsURL','Completeness(containsURL)','containsURL("ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL);
INSERT INTO public.dq_rules (rule_name,rule_desc,rule_example,rule_owner,dimension_id,check_level,reserved_5,reserved_4,reserved_3,reserved_2,reserved_1,active_flg,created_by,created_ts,updated_by,updated_ts) VALUES
	 ('containsSocialSecurityNumber','Completeness(containsSocialSecurityNumber)','containsSocialSecurityNumber()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasDataType','Conformity(hasDataType)','hasDataType(“ColumnName”, Boolean)','Chimera DQ',7,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isPositive','Completeness(isPositive)','isPositive()','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isLessThan','Completeness(isLessThan)','isLessThan(“ColumnName”, “ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isLessThanOrEqualTo','Completeness(isLessThanOrEqualTo)','isLessThanOrEqualTo(“ColumnName”, “ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isGreaterThan','Completeness(isGreaterThan)','isGreaterThan(“ColumnName”, “ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('isGreaterThanOrEqualTo','Completeness(isGreaterThanOrEqualTo)','isGreaterThanOrEqualTo(“ColumnName”, “ColumnName”)','Chimera DQ',2,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL),
	 ('hasSize','Conformity(hasSize)','hasSize(_ == 5)','Chimera DQ',7,'WARNING',NULL,NULL,NULL,NULL,NULL,'Y','chimera_user','2025-07-05 21:41:20.791467',NULL,NULL);
