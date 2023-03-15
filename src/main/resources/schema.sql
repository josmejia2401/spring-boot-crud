
DROP TABLE IF EXISTS tasks;
DROP TABLE IF EXISTS status;
DROP TABLE IF EXISTS piority;

CREATE TABLE status (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE piority (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL
);

CREATE TABLE tasks (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  description VARCHAR(250) NOT NULL,
  name VARCHAR(250) NOT NULL,
  status INT DEFAULT 1,
  piority INT DEFAULT 1,
  child_id INT,
  CONSTRAINT `tasks_childrens`
    FOREIGN KEY (`child_id` )
    REFERENCES `tasks` (`id` )
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `tasks_status`
    FOREIGN KEY (`status` )
    REFERENCES `status` (`id` ),
  CONSTRAINT `tasks_piority`
    FOREIGN KEY (`piority` )
    REFERENCES `piority` (`id` )
);




INSERT INTO piority(id, name, description) values (1, 'BAJA', 'BAJA');
INSERT INTO status(id, name, description) values (1, 'EN PROCESO', '		EN PROCESO');