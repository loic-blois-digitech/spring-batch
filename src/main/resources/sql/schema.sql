--CREATE DATABASE springbatch /*!40100 DEFAULT CHARACTER SET utf8 */;
CREATE SCHEMA IF NOT EXISTS sch_spring_batch;
DROP TABLE IF EXISTS sch_spring_batch.user;

CREATE TABLE sch_spring_batch.user
(
    id   Integer     NOT NULL,
    name varchar(45) NOT NULL default '',
    PRIMARY KEY (id)
);

INSERT INTO sch_spring_batch.user
VALUES (1, 'Jack Rutorial demo 1');
INSERT INTO sch_spring_batch.user
VALUES (2, 'Jack Rutorial demo 2');
INSERT INTO sch_spring_batch.user
VALUES (3, 'Jack Rutorial demo 3');