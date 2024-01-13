-- Steps:
-- 1.run externalconfig/sql/DDL.sql
-- 2.run application
CREATE KEYSPACE test_ch
WITH replication = {'class': 'SimpleStrategy', 'replication_factor': 1};
