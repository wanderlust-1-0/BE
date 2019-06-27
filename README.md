# Back End Wanderlust

## What is Wanderlust
Wanderlust is an application that connects tour guides and tourists seeking adventure 
Search for tour guides offering unique experiences for people of all ages

Herokuhost deployment link: https://roger-wanderlust.herokuapp.com

## endpoints for registering/login  accessable to all
- guide register POST "/createnewguide"

- tourist register POST "/createnewtourist"

- both signin POST "/oauth/token"

## endpoints for tours
- listAllTours     GET "/tours/tours" accessable to all


- getTourById   GET "/tours/tour/{id}" accessable to all


- deleteTourById  DELETE "/tours/data/{id}" accessable to guides


- updateTour     PUT "tours/data/tours/{id}" accessable to guides


- addTour    POST "tours/data/tours/add"accessable to guides




## endpoints for tourists accessable to tourists
- listAllTourists GET "/tourists/tourists"

- getTouristById GET "/tourists/tourist/{id}"
 

- addNewTourist   POST   "tourists/tourist/add"


- updateTourist     PUT  "/tourists/tourist/{touristid}"


- deleteTouristById   DELETE "/tourists/tourist/{touristid}"


- assignTouristToTour PUT "/tourists/tourist/assignTourist/{touristid}/{tourid}" accessable to tourists


- addFavoritedTours PUT   "/tourists/tourist/addFavoritedTours/{touristid}/{tourid}"accessable to tourists

- delete assigned/bookedtours from user DELETE "/tourists/tourist/deltour/{touristid}/{tourid}"

- delete favorited tours from user DELETE "/tourists/tourist/delfavoritedTours/{touristid}/{tourid}"

## endpoints for guides accessable to guides
- listAllGuides    GET "/guides/guides" 


- getGuideById  GET "/guides/guide/{id}" 


- addNewGuide   POST "/guides/guide/add" 


- updateGuide   PUT  "/guides/guide/{guideid}" 


- deleteStudentById    DELETE  "/guides/guide/{guideid}" 





