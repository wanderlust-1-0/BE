package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.model.Tourist;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TouristRepository extends CrudRepository<Tourist,Long>
{
//    List<Tourist> findByTouristNameContainingIgnoreCase(String name);

    @Modifying
    @Query(value = "INSERT INTO bookedtours(touristid, tourid) VALUES (:touristid, :tourid)", nativeQuery = true)
    void assignTouristToTour(long touristid, long tourid);

//    @Modifying
//    @Query(value = "DELETE FROM bookedtours WHERE tourid=:tourid",nativeQuery = true)
//    void deleteTourFromTouristTours(long tourid);

    @Modifying
    @Query(value = "INSERT INTO favoritedtours(touristid, tourid) VALUES (:touristid, :tourid)", nativeQuery = true)
    void addFavoritedTours(long touristid, long tourid);


}
