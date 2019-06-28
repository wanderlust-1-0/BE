package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.services.TouristService;
import com.lambdaschool.wanderlust.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

@RestController
@RequestMapping(value="/tourists")
public class TouristController
{
    @Autowired
    private TouristService touristService;


    @GetMapping(value = "/tourists",produces = {"application/json"})
    public ResponseEntity<?> listAllTourists()
    {
        ArrayList<Tourist> myTours=touristService.findAll();
        return new ResponseEntity<>(myTours, HttpStatus.OK);
    }

    @GetMapping(value = "/tourist/{touristid}",
            produces = {"application/json"})
    public ResponseEntity<?> getTouristById(
            @PathVariable
                    Long touristid)
    {
        Tourist t = touristService.findTouristById(touristid);
        return new ResponseEntity<>(t, HttpStatus.OK);
    }



    @PostMapping(value = "/tourist/add",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewTourist(@Valid
                                         @RequestBody
                                                 Tourist newTourist) throws URISyntaxException
    {
        newTourist = touristService.save(newTourist);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStudentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{touristid}").buildAndExpand(newTourist.getTouristid()).toUri();
        responseHeaders.setLocation(newStudentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/tourist/{touristid}")
    public ResponseEntity<?> updateTourist(
            @RequestBody
                    Tourist updateTourist,
            @PathVariable
                    long touristid)
    {
        touristService.update(updateTourist, touristid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/tourist/{touristid}")
    public ResponseEntity<?> deleteTouristById(
            @PathVariable
                    long touristid)
    {
        touristService.delete(touristid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping(value = "/tourist/assignTourist/{touristid}/{tourid}",
            produces = {"application/json"})
    public ResponseEntity<?> assignTouristToTour(@PathVariable
                                                           long touristid,
                                                   @PathVariable
                                                            long tourid) {
        touristService.assignTouristToTour(touristid, tourid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping(value = "/tourist/deltour/{touristid}/{tourid}")
    public ResponseEntity<?> deleteTouristTourById(
            @PathVariable
                    long touristid,
            @PathVariable
                    long tourid)
    {
        touristService.deleteTourFromSelf(touristid,tourid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @PutMapping("/tourist/addFavoritedTours/{touristid}/{tourid}")
    public ResponseEntity<?> addFavoritedTours(@PathVariable
                            long touristid,
                            @PathVariable
                            long tourid)
    {
        touristService.addFavoritedtoTour(touristid, tourid);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/tourist/delfavoritedTours/{touristid}/{tourid}")
    public ResponseEntity<?> deleteFavoriteTouristTourById(
            @PathVariable
                    long touristid,
            @PathVariable
                    long tourid)
    {
        touristService.deleteFavTourFromSelf(touristid,tourid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
