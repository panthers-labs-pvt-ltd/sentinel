INSERT INTO public.data_sources (data_source_type,data_source_sub_type,description,data_source_template,default_read_config,default_write_config,created_timestamp,created_by,updated_timestamp,updated_by,active_flag) VALUES
	 ('Relational','Postgres','Postgres Database',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Relational','MySql','MYSQL Database',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','Parquet','File Format Parquet',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','Avro','File Format Avro',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','Csv','File Format CSV',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','Json','File Format Json',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','ORC','File Format ORC',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Files','PDF','File Format PDF',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('NoSql','Neo4j','Neqo4J DB',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('NoSql','Redis','Redis DB',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y');
INSERT INTO public.data_sources (data_source_type,data_source_sub_type,description,data_source_template,default_read_config,default_write_config,created_timestamp,created_by,updated_timestamp,updated_by,active_flag) VALUES
	 ('NoSql','Cassandra','Cassandra DB',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Stream','Kafka','Streaming - Kafka',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('Stream','Pulsar','Streaming - Pulsar',NULL,NULL,NULL,'2025-05-28 16:25:37.08102','PK',NULL,NULL,'Y'),
	 ('NoSql','Mongodb','Mongo DB','Updated',NULL,NULL,'2025-05-28 16:25:37.08102','PK','2025-05-28 16:47:12.39','PK','Y');
