DROP TABLE IF EXISTS users;

CREATE TABLE poem (
  id INT PRIMARY KEY,
  content VARCHAR(250) NOT NULL
);

INSERT INTO poem (ID, CONTENT) VALUES
  (1, 'Best poem 1'),
  (2, 'Best poem 2'),
  (3, 'Best poem 3');