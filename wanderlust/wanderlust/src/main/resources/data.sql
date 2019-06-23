

--
-- DELETE
-- FROM touristtours;
--
-- DELETE
-- FROM tour;
--
-- DELETE
-- FROM tourist;
--
-- DELETE
-- FROM guide;

INSERT INTO guide (guideid, firstname)
    VALUES(2, 'Sally'),
          (3, 'Lucy'),
          (4, 'Charlie');


INSERT INTO tour (tourid, tourname)
	VALUES (5, 'sfdf' ),
           (6, 'sfdj'),



INSERT INTO tourist (touristid, firstname)
    VALUES (7, 'John'),
           (8, 'Julian');



INSERT INTO touristtours (touristid, tourid)
    VALUES (7, 5),
           (7, 5),
           (8, 6);


alter sequence hibernate_sequence restart with 25;