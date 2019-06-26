package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.WanderlustApplication;
import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tour;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityNotFoundException;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.*;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = WanderlustApplication.class)
public class TourServiceImplTest
{

    @Autowired
    private TourService tourService;



    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown() throws Exception
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(2, tourService.findAll().size());
    }

    @Test
    public void findTourById()
    {
        assertEquals("The  One", tourService.findTourById(3).getTourname());
    }

    @Test
    public void deleteFound()
    {
        tourService.delete(2);
        assertEquals(2,tourService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        tourService.delete(209);
        assertEquals(2,tourService.findAll().size());
    }

    @Test
    public void save()
    {
        Tour tour= new Tour("the best tour");

        Tour addTour=tourService.save(tour);

        assertNotNull(addTour);

        Tour foundTour = tourService.findTourById(addTour.getTourid());
        assertEquals(addTour.getTourname(),foundTour.getTourname());
    }

    @Test
    public void update()
    {
        Tour tour = new Tour("Its a tour");
        tour.setTourid(1);

        Tour updatedtour= tourService.update(tour,1);
        assertEquals("Its a tour",updatedtour.getTourname());
    }
}