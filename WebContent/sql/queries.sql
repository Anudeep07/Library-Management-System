CREATE DATABASE Library;

CREATE TABLE LOGIN
(
	Username varchar(255) NOT NULL,
	Password varchar(255),
	Role varchar(20) NOT NULL,
	PRIMARY KEY(Username)		
);

INSERT INTO LOGIN VALUES('admin','86e5794301c6293b557393ccf456ba5d7e21ce31','ADMIN');

CREATE TABLE ADMIN
(
	Admin_id varchar(255) NOT NULL,
	Admin_name varchar(255) NOT NULL,
	FOREIGN KEY(Admin_id) REFERENCES LOGIN(Login_id) ON DELETE CASCADE ON UPDATE CASCADE
);

INSERT INTO ADMIN VALUES('admin1','Anudeep');

CREATE TABLE LIBRARIAN
(
    Librarian_id varchar(255) NOT NULL,
    Librarian_name varchar(255) NOT NULL,
    Librarian_join_date date NOT NULL,
    FOREIGN KEY(Librarian_id) REFERENCES LOGIN(Login_id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE STUDENT
(
    Student_id varchar(255) NOT NULL,
    Student_name varchar(255) NOT NULL,
    Num_of_books varchar(255) NOT NULL DEFAULT 0
);