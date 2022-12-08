CREATE TABLE Student (
     studentNumber varchar(255) not null,
     studentEmail varchar(255) not null,
     studentPassword varchar(255) not null,
     studentName varchar(255) not null,
     studentPhone varchar(255) not null,
     balance int,
     latefee int,
     PRIMARY KEY(studentEmail)
);

create table moneyTransactionInfo(
     studentEmail varchar(255) not null,
     amountTransaction int not null default 0,
     uid varchar(255) not null,
     transactionDate varchar(255) default DATE_FORMAT (current_timestamp(), '%Y-%m-%d'),
     FOREIGN KEY (studentEmail) REFERENCES Student(studentEmail)
)

create table book (
      bookId varchar(255) not null,
      bookTitle varchar(255) not null,
      bookAuthor varchar(255) not null,
      bookQuantity int,
      bookAvailable int,
      bookPrice int,
      primary key(bookId)
);

create table borrowedbook (
      studentEmail varchar(255) not null,
      bookId varchar(255) not null,
      borrowedDate varchar(255) default DATE_FORMAT (current_timestamp(), '%Y-%m-%d'),
      returnedDate varchar(255),
      dueDate varchar(255) default DATE_FORMAT (DATE_ADD(current_timestamp(), INTERVAL 14 DAY), '%Y-%m-%d'),

      FOREIGN KEY (studentEmail) REFERENCES student(studentEmail),
      FOREIGN KEY (bookId) REFERENCES book(bookId)
);

