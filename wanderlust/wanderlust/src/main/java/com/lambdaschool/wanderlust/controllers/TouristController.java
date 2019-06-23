package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.services.TouristService;
import com.lambdaschool.wanderlust.services.TouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/tourists")
public class TouristController
{
    @Autowired
    private TouristService touristService;


    @GetMapping(value = "/tourists",produces = {"application/json"})
    public ResponseEntity<?> listAllTours()
    {
        ArrayList<Tourist> myTours=touristService.findAll();
        return new ResponseEntity<>(myTours, HttpStatus.OK);
    }



}
