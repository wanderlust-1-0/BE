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
    @Query(value = "DELETE FROM touristtours WHERE tourid=:tourid",nativeQuery = true)
    void deleteTourFromTouristTours(long tourid);



}
