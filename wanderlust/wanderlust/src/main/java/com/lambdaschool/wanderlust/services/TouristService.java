package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tourist;

import java.util.ArrayList;

public interface TouristService
{

    ArrayList<Tourist> findAll();

    Tourist findTouristById(long id);

    void delete(long id);

    Tourist save (Tourist tourist);

    Tourist update(Tourist tourist, long id);

    void  assignTouristToTour(long touristid, long tourid);

    void addFavoritedtoTour(long touristid, long tourid);

  void deleteTourFromSelf(long touristid, long tourid);

    void deleteFavTourFromSelf(long touristid,long tourid);
}
