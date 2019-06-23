INSERT INTO guide (guideid, firstname) VALUES (1, 'Fiction');
INSERT INTO guide (guideid, firstname) VALUES (2, 'Technology');
INSERT INTO guide (guideid, firstname) VALUES (3, 'Travel');
INSERT INTO guide (guideid, firstname) VALUES (4, 'Business');
INSERT INTO guide (guideid, firstname) VALUES (5, 'Religion');

INSERT INTO tourist (touristid, firstname, lastname) VALUES (1, 'John', 'Mitchell');
INSERT INTO tourist (touristid, firstname, lastname) VALUES (2, 'Dan', 'Brown');
INSERT INTO tourist (touristid, firstname, lastname) VALUES (3, 'Jerry', 'Poe');
INSERT INTO tourist (touristid, firstname, lastname) VALUES (4, 'Wells', 'Teague');
INSERT INTO tourist (touristid, firstname, lastname) VALUES (5, 'George', 'Gallinger');
INSERT INTO tourist (touristid, firstname, lastname) VALUES (6, 'Ian', 'Stewart');

INSERT INTO tour (tourid, tourdescription, tourguidephonenumber, whattobring,durationhrs,likes,price,recommendedage) VALUES (1, 'Flatterland', '9780738206752', '2001',2,23,45,3);
INSERT INTO tour (tourid, tourdescription, tourguidephonenumber, whattobring,durationhrs,likes,price,recommendedage) VALUES (2, 'Digital Fortess', '9788489367012', '2007',3,434,45,4);
INSERT INTO tour (tourid, tourdescription, tourguidephonenumber, whattobring,durationhrs,likes,price,recommendedage) VALUES (3, 'The Da Vinci Code', '9780307474278', '2009',4,45,45,5);
INSERT INTO tour (tourid, tourdescription, tourguidephonenumber, whattobring,durationhrs,likes,price,recommendedage) VALUES (4, 'Essentials of Finance', '1314241651234','78',5, 64,56,65);
INSERT INTO tour (tourid, tourdescription, tourguidephonenumber, whattobring,durationhrs,likes,price,recommendedage) VALUES (5, 'Calling Texas Home', '1885171382134', '2000',5,45,56,56);

INSERT INTO touristtours (tourid, touristid) VALUES (1, 6);
INSERT INTO touristtours (tourid, touristid) VALUES (2, 2);
INSERT INTO touristtours (tourid, touristid) VALUES (3, 2);
INSERT INTO touristtours (tourid, touristid) VALUES (4, 5);
INSERT INTO touristtours (tourid, touristid) VALUES (4, 3);
INSERT INTO touristtours (tourid, touristid) VALUES (5, 4);


INSERT INTO touristtours (tourid, touristid) VALUES (5, 4);



alter sequence hibernate_sequence restart with 25;