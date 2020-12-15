CREATE DATABASE process;
USE process;

CREATE TABLE process(
	id INT PRIMARY KEY AUTO_INCREMENT,
    external_id VARCHAR(50),
    process_class VARCHAR(200),
    locked_by VARCHAR(50),
    complete_by DATE,
    process_state VARCHAR(15),
    failure_count INT
)

