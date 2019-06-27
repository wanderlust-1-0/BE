package com.lambdaschool.wanderlust.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.services.GuideService;
import com.lambdaschool.wanderlust.services.TouristService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(value = TouristController.class, secure = false)
public class TouristControllerTest
{
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TouristService touristService;

    private ArrayList<Tourist> touristsList;


    @Before
    public void setUp() throws Exception
    {
        touristsList = new ArrayList<>();

        touristsList.addAll(touristService.findAll());
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllTourists() throws Exception
    {
        String apiUrl = "/tourists/tourists";

        Mockito.when(touristService.findAll()).thenReturn(touristsList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(touristsList);

        assertEquals(er, tr);
    }

    @Test
    public void getTouristById()
    {
    }

    @Test
    public void addNewTourist() throws Exception
    {
        String apiUrl = "/tourists/tourist/add";

        String touristName = "Adding new Tourist";
        Tourist newTourist = new Tourist(touristName);
        newTourist.setTouristid(100);

        ObjectMapper mapper = new ObjectMapper();
        String courseString = mapper.writeValueAsString(newTourist);

        Mockito.when(touristService.save(any(Tourist.class))).thenReturn(newTourist);

        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(courseString);
        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateTourist()
    {
    }

    @Test
    public void deleteTouristById()
    {
    }

    @Test
    public void assignTouristToTour()
    {
    }

    @Test
    public void deleteTouristTourById()
    {
    }

    @Test
    public void addFavoritedTours()
    {
    }

    @Test
    public void deleteFavoriteTouristTourById()
    {
    }
}