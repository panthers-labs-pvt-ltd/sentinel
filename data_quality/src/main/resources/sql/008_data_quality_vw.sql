create or replace  view data_quality_vw as select
dmp.process_name,
dc.control_name ,
dcd.dimension_name ,
d.rule_name ,
asm.rule_column,
asm.rule_value  ,
asm.database_name ,
asm.schema_name ,
asm.table_name ,
asm.partition_keys
from sentinel.dq_rules_asset_map asm join sentinel.data_quality_rules d on asm.rule_id=d.rule_id
join sentinel.data_control_dimensions dcd on d.dimension_id =dcd.dimension_id
join sentinel.data_controls dc on dcd.control_id  =dc.control_id
join sentinel.data_control_process_mapping cmp on cmp.control_id =dcd.control_id
join sentinel.data_management_processes dmp  on dmp.process_id =cmp.process_id ;