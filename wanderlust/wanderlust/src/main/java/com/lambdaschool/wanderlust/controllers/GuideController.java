package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.services.GuideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping(value="/guides")
public class GuideController
{

    @Autowired
    private GuideService guideService;


    @GetMapping(value = "/guides",produces = {"application/json"})
    public ResponseEntity<?> listAllGuides()
    {
        ArrayList<Guide> myGuides=guideService.findAll();
        return new ResponseEntity<>(myGuides, HttpStatus.OK);
    }


}
