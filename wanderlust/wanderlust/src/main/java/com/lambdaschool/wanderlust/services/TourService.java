package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.view.CountTouristInTour;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

public interface TourService
{
    ArrayList<Tour> findAll();

//    ArrayList<CountTouristInTour> getCountTouristInTour();

    Tour findTourById(long id);

    void delete(long id);

    Tour save(Tour course);

    Tour update(Tour tour,long id);

//    void saveImage(MultipartFile imageFile) throws Exception;

}
