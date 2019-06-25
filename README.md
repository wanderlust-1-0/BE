# Back End Wanderlust

## What is Wanderlust
Wanderlust is an application that connects tour guides and tourists seeking adventure i
Search for tour guides offering unique experiences for people of all ages

Herokuhost deployment link:

## endpoints for registering/login  accessable to all
- guide signup POST "/createnewguide"

- tourist signip POST "/createnewtourist"

## endpoints for tours
- listAllTours     GET "/tours/tours" accessable to all


- getTourById   GET "/tours/tour/{id}" accessable to all


- deleteTourById  DELETE "/tours/data/{id}" accessable to guides


- updateTour     PUT "tours/data/tours/{id}" accessable to guides


- addTour    POST "tours/data/tours/add"accessable to guides




## endpoints for tourists accessable to tourists
- listAllTourists GET "/tourists/tourists"

- getTouristById GET "/tourists/{id}"
 

- addNewTourist   POST   "/tourists/add"


- updateTourist     PUT  "/tourists/tourist{id}"


- deleteTouristById   DELETE "/tourists/tourist/{id}"


- assignTouristToTour PUT "/tourists/tourist/assignTourist/{touristid}/{tourid}" accessable to tourists


- addFavoritedTours PUT   "/tourists/tourist/addFavoritedTours/{touristid}/{tourid}"accessable to tourists

## endpoints for guides accessable to guides
- listAllGuides    GET "/guides/guides" 


- getGuideById  GET "/guides/guide/{id}" 


- addNewGuide   POST "/guides/guide/add" 


- updateGuide   PUT  "/guides/guide/{id}" 


- deleteStudentById    DELETE  "/guides/guide/id" 








