package com.lambdaschool.wanderlust.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.services.GuideService;
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

//import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.junit.jupiter.api.Assertions.*;


@RunWith(SpringRunner.class)
@WebMvcTest(value = GuideController.class, secure = false)
public class GuideControllerTest
{

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GuideService guideService;

    private ArrayList<Guide> guideList;

    @Before
    public void setUp() throws Exception
    {
        guideList = new ArrayList<>();

        guideList.addAll(guideService.findAll());
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void listAllGuides() throws Exception
    {
        String apiUrl = "/guides/guides";

        Mockito.when(guideService.findAll()).thenReturn(guideList);

        RequestBuilder rb = MockMvcRequestBuilders.get(apiUrl).accept(MediaType.APPLICATION_JSON);

        MvcResult r = mockMvc.perform(rb).andReturn();
        String tr = r.getResponse().getContentAsString();

        com.fasterxml.jackson.databind.ObjectMapper mapper = new ObjectMapper();
        String er = mapper.writeValueAsString(guideList);

        assertEquals(er, tr);
    }

    @Test
    public void getGuideById()
    {
    }

    @Test
    public void addNewGuide() throws Exception
    {

        String apiUrl = "/guides/guide/add";

        String guideName = "Adding new Guide";
        Guide newGuide = new Guide(guideName);
        newGuide.setGuideid(100);

        ObjectMapper mapper = new ObjectMapper();
        String courseString = mapper.writeValueAsString(newGuide);

        Mockito.when(guideService.save(any(Guide.class))).thenReturn(newGuide);

        RequestBuilder rb = MockMvcRequestBuilders.post(apiUrl)
                .contentType(MediaType.APPLICATION_JSON).accept(MediaType.APPLICATION_JSON)
                .content(courseString);
        mockMvc.perform(rb).andExpect(status().isCreated()).andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void updateGuide()
    {
    }

    @Test
    public void deleteStudentById()
    {
    }
}
