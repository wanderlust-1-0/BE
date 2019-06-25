




INSERT INTO guide (guideid, firstname,lastname,phonenumber,email,istourguide) VALUES (1, 'bob','bobby','555 55555','ok@email.com',true);
INSERT INTO guide (guideid, firstname,lastname,phonenumber,email,istourguide) VALUES (2, 'rogg','roggy','555 5555 ','ok@email.com',true);
INSERT INTO guide (guideid, firstname,lastname,phonenumber,email,istourguide) VALUES (3, 'em','emmuy','555 5 555','ok@email.com',true);



INSERT INTO tourist (touristid, firstname, lastname,phonenumber,email,istourguide) VALUES (1, 'John', 'Mitchell','55 55 555','ok@email.com', false);
INSERT INTO tourist (touristid, firstname, lastname,phonenumber,email,istourguide) VALUES (2, 'Dan', 'Brown','55 55 555','ok@email.com',false );
INSERT INTO tourist (touristid, firstname, lastname,phonenumber,email,istourguide) VALUES (3, 'Jerry', 'Poe','55 55 555','ok@email.com',false );


INSERT INTO tour (tourid,tourname, tourdescription, tourguidephonenumber, whattobring,category,durationhrs,area,price,recommendedage,meetingaddress,guideid) VALUES (1, 'The Tour', 'cruise to anywhere', '9780738206752', 'bring alot of stuff','outdoor',5,'jungle',23.00,45,'calabasas',3);
INSERT INTO tour (tourid,tourname, tourdescription, tourguidephonenumber, whattobring,category,durationhrs,area,price,recommendedage,meetingaddress,guideid) VALUES (2, 'The Other Tour','wherever we want', '9788489367012', 'dont bring alot ','trek',3,'desert',434.00,14,'san diego',2);
INSERT INTO tour (tourid,tourname, tourdescription, tourguidephonenumber, whattobring,category,durationhrs,area,price,recommendedage,meetingaddress,guideid) VALUES (3,'The  One' ,'over there', '9780307474278', 'bring a hat','dangerous',45,'swamp',45.00,5,'there',2);



INSERT INTO bookedtours (tourid, touristid) VALUES (1, 1);
INSERT INTO bookedtours (tourid, touristid) VALUES (2, 2);
INSERT INTO bookedtours (tourid, touristid) VALUES (3, 2);


INSERT INTO favoritedtours (tourid, touristid,) VALUES (1,1);
INSERT INTO favoritedtours (tourid, touristid,) VALUES (1,1);
INSERT INTO favoritedtours (tourid, touristid,) VALUES (3,3);







alter sequence hibernate_sequence restart with 25;