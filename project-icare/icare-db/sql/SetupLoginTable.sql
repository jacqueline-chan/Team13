DROP TABLE IF EXISTS Login;

CREATE TABLE Login(
      username text PRIMARY KEY,
      password text NOT NULL,
      user_access text NOT NULL
);

insert into Login (username, password, user_access) values ('hceresa0', '19j03Wn8qInL', 'DEFAULT');
insert into Login (username, password, user_access) values ('htellett1', 'Lc7mI0DYP', 'DEFAULT');
insert into Login (username, password, user_access) values ('pbernardeschi2', 'mEWvmp', 'DEFAULT');
insert into Login (username, password, user_access) values ('estandingford3', 'JCITIvIV8YK', 'DEFAULT');
insert into Login (username, password, user_access) values ('oabriani4', 'lxtABz4sxK', 'DEFAULT');
insert into Login (username, password, user_access) values ('bolander5', '5QFFSN0H0', 'DEFAULT');
insert into Login (username, password, user_access) values ('rscritch6', 'wA0GqSJVC0B', 'DEFAULT');
insert into Login (username, password, user_access) values ('hadan7', 'IEL2Ozuq1', 'DEFAULT');
insert into Login (username, password, user_access) values ('mod', 'mod', 'MODERATOR');
insert into Login (username, password, user_access) values ('admin', 'admin', 'ADMIN');
