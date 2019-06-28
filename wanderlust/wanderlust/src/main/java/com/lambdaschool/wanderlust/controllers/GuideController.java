package com.lambdaschool.wanderlust.controllers;


import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.services.GuideService;
import io.swagger.annotations.ApiParam;
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


    @GetMapping(value = "/guide/{guideid}",
            produces = {"application/json"})
    public ResponseEntity<?> getGuideById(
            @PathVariable
                    Long guideid)
    {
        Guide g = guideService.findGuideById(guideid);
        return new ResponseEntity<>(g, HttpStatus.OK);
    }




    @PostMapping(value = "/guide/add",
            consumes = {"application/json"},
            produces = {"application/json"})
    public ResponseEntity<?> addNewGuide(@Valid
                                           @RequestBody
                                                   Guide newGuide) throws URISyntaxException
    {
        newGuide = guideService.save(newGuide);

        // set the location header for the newly created resource
        HttpHeaders responseHeaders = new HttpHeaders();
        URI newStudentURI = ServletUriComponentsBuilder.fromCurrentRequest().path("/{guideid}").buildAndExpand(newGuide.getGuideid()).toUri();
        responseHeaders.setLocation(newStudentURI);

        return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
    }


    @PutMapping(value = "/guide/{guideid}")
    public ResponseEntity<?> updateGuide(
            @RequestBody
                    Guide updateGuide,
            @PathVariable
                    long guideid)
    {
        guideService.update(updateGuide, guideid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


    @DeleteMapping("/guide/{guideid}")
    public ResponseEntity<?> deleteStudentById(
            @PathVariable
                    long guideid)
    {
        guideService.delete(guideid);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
