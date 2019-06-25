package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.services.TourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/tours")
public class ToursController
{

    @Autowired
    private TourService tourService;


    @GetMapping(value = "/tours",
            produces = {"application/json"})
    public ResponseEntity<?> listAllTours()
    {
        ArrayList<Tour> myTours=tourService.findAll();
        return new ResponseEntity<>(myTours, HttpStatus.OK);
    }


    @GetMapping(value = "/tour/{tourid}",
            produces = {"application/json"})
    public ResponseEntity<?> getTourById(
            @PathVariable
                    Long tourid)
    {
        Tour t = tourService.findTourById(tourid);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_GUIDE')")
    @DeleteMapping(value = "/data/{id}")
    public ResponseEntity<?> deleteTourById(@PathVariable long id)
    {
        tourService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_GUIDE')")
    @PutMapping(value = "/data/tours/{id}")
    public ResponseEntity<?> updateTour(@RequestBody Tour updateTour,@PathVariable long id)
    {
        tourService.update(updateTour,id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('ROLE_GUIDE')")
    @PostMapping(value = "/data/tours/add")
    public ResponseEntity<?> addTour(@RequestBody Tour addTour)
    {
        tourService.save(addTour);
        return new ResponseEntity<>(HttpStatus.OK);
    }

//
//    @PostMapping(value= "/uploadImage")
//    public String uploadImage(@RequestParam("imageFile") MultipartFile imageFile)
//    {
//        String returnValue="";
//        tourService.saveImage(imageFile);
//    }



}
