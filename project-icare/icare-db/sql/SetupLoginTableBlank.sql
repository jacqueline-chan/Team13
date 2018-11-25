DROP TABLE IF EXISTS Login;

CREATE TABLE Login(
      username text PRIMARY KEY,
      password text NOT NULL,
      user_access text NOT NULL
);
