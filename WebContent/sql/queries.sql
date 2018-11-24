CREATE DATABASE Library;

CREATE TABLE LOGIN
(
	Username varchar(255) NOT NULL,
	Password varchar(255),
	Role varchar(20) NOT NULL,
	PRIMARY KEY(Username)		
);

INSERT INTO LOGIN VALUES('admin','86e5794301c6293b557393ccf456ba5d7e21ce31','ADMIN'); -- username: admin, password: admin

CREATE  TABLE LIBRARIAN
(
    FirstName varchar(50),
   	LastName varchar(50),
    Librarian_id varchar(50),
    Address varchar(100),
    City varchar(15),
    State varchar(30),
    FOREIGN KEY(Librarian_id) REFERENCES LOGIN(username) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE STUDENT
(
    Student_id varchar(255) NOT NULL,
    FirstName varchar(30) NOT NULL,
    SecondName varchar(30) NOT NULL,
    Semester int NOT NULL,
    Department varchar(40) NOT NULL,
    PRIMARY KEY(Student_id),
    FOREIGN KEY(Student_id) REFERENCES LOGIN(Username) ON UPDATE CASCADE ON DELETE CASCADE
);

CREATE TABLE AUTHOR
(
    AuthorID int NOT NULL AUTO_INCREMENT,
    FirstName varchar(50) NOT NULL,
    LastName varchar(50) NOT NULL,
    PRIMARY KEY(AuthorID)
);

CREATE TABLE BOOK 
(
    ISBN varchar(50) NOT NULL,
    BookTitle varchar(50) NOT NULL,
    AvailableQuantity int NOT NULL DEFAULT 0,
    AuthorID int NOT NULL,
    PRIMARY KEY(ISBN),
    FOREIGN KEY(AuthorID) REFERENCES AUTHOR(AuthorID) ON DELETE CASCADE ON UPDATE CASCADE
);
CREATE TABLE `BORROW` (
  `Borrow_id` int(11) NOT NULL AUTO_INCREMENT,
  `Bookid` varchar(50) NOT NULL,
  `Librarianid` varchar(50) NOT NULL,
  `Studentid` varchar(255) NOT NULL,
  `Issuedate` date NOT NULL,
  `Returndate` date NOT NULL,
   PRIMARY KEY(Borrow_id),
    FOREIGN KEY(Bookid) REFERENCES BOOK(ISBN) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Librarianid) REFERENCES LIBRARIAN(Librarian_id) ON DELETE CASCADE ON UPDATE CASCADE,
    FOREIGN KEY(Studentid) REFERENCES STUDENT(Student_id) ON DELETE CASCADE ON UPDATE CASCADE    
);
