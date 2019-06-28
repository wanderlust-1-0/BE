//package com.lambdaschool.wanderlust.controllers;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import com.lambdaschool.wanderlust.model.Tour;
//import com.lambdaschool.wanderlust.model.Tourist;
//import com.lambdaschool.wanderlust.services.TourService;
//import com.lambdaschool.wanderlust.services.TouristService;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.mockito.Mockito;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.http.MediaType;
//import org.springframework.test.context.junit4.SpringRunner;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.MvcResult;
//import org.springframework.test.web.servlet.RequestBuilder;
//import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
//import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
//
//import java.util.ArrayList;
//
//import static org.junit.Assert.*;
//import static org.junit.jupiter.api.Assertions.assertEquals;
//import static org.mockito.ArgumentMatchers.any;
//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
//
//@RunWith(SpringRunner.class)
//@WebMvcTest(value = ToursController.class, secure = false)
//public class ToursControllerTest
//{
//
//    @Autowired
//    private MockMvc mockMvc;
//
//    @MockBean
//    private TourService tourService;
//
//    private ArrayList<Tour> toursList;
//
//    @Before
//    public void setUp() throws Exception
//    {
//        toursList = new ArrayList<>();
//
//        toursList.addAll(tourService.findAll());
//    }
//
//    @After
//    public void tearDown() throws Exception
//    {
//    }
//
//    @Test
//    public void listAllTours() throws Exception
//    {
//        String apiUrl = "/tours/tours";
//
//        Mockito.when(tourService.findAll()).thenReturn(toursList);
//
//        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);
//
//        MvcResult r = mockMvc.perform(rb).andReturn();
//        String tr = r.getResponse().getContentAsString();
//
//        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
//        String er = mapper.writeValueAsString(toursList);
//
//        assertEquals(er, tr);
//    }
//
//    @Test
//    public void getTourById()
//    {
//    }
//
//    @Test
//    public void deleteTourById()
//    {
//    }
//
//    @Test
//    public void updateTour()
//    {
//    }
//
//    @Test
//    public void addTour() throws Exception
//    {
//        String apiUrl = "/tours/data/tours/add";
//
//        String tourName = "Adding new Tour";
//        Tour newTour = new Tour(tourName);
//        newTour.setTourid(100);
//
//        ObjectMapper mapper = new ObjectMapper();
//        String courseString = mapper.writeValueAsString(newTour);
//
//        Mockito.when(tourService.save(any(Tour.class))).thenReturn(newTour);
//
//        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
//                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
//                .content(courseString);
//        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
//    }
//}