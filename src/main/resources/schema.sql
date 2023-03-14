DROP TABLE IF EXISTS tasks;
  
CREATE TABLE tasks (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  status INT DEFAULT 0,
  child_id INT,
  CONSTRAINT `tasks_childrens`
    FOREIGN KEY (`child_id` )
    REFERENCES `tasks` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);