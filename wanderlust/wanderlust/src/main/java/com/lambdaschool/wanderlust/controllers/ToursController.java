package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/tours")
public class ToursController
{

    @Autowired
    private TourService tourService;


    @GetMapping(value = "/tours",produces = {"application/json"})
    public ResponseEntity<?> listAllTours()
    {
        ArrayList<Tour> myTours=tourService.findAll();
        return new ResponseEntity<>(myTours, HttpStatus.OK);
    }

    @GetMapping(value = "/tour/{tourid}",
            produces = {"application/json"})
    public ResponseEntity<?> getStudentById(
            @PathVariable
                    Long tourid)
    {
        Tour t = tourService.findTourById(tourid);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }


    @DeleteMapping(value = "/data/{id}")
    public ResponseEntity<?> deleteTourById(@PathVariable long id)
    {
        tourService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping(value = "/data/tours/{id}")
    public ResponseEntity<?> updateTour(@RequestBody Tour updateTour,@PathVariable long id)
    {
        tourService.update(updateTour,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping(value = "/data/tours/add")
    public ResponseEntity<?> addTour(@RequestBody Tour addTour)
    {
        tourService.save(addTour);
        return new ResponseEntity<>(HttpStatus.OK);
    }





}
