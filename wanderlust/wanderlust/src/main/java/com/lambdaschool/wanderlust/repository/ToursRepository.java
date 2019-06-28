package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.view.CountTouristInTour;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;


public interface ToursRepository extends CrudRepository<Tour,Long>
{
//    ArrayList<Tour> findTourByTourNameEquals(String name);


    @Modifying
    @Query(value = "DELETE FROM bookedtours WHERE tourid=:tourid",nativeQuery = true)
    void deleteTourFromTouristTours(long tourid);


    @Modifying
    @Query(value = "DELETE FROM favoritedtours WHERE tourid=:tourid",nativeQuery = true)
    void deleteFavoritedTourFromTouristTours(long tourid);
//
//
//    @Modifying
//    @Query(value = "DELETE FROM tour WHERE tourid=:tourid",nativeQuery = true)
//    void deleteTourFromTour(long tourid);




}
