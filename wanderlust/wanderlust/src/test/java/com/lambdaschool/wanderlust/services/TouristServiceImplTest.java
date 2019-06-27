package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.WanderlustApplication;
import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.model.Tourist;
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
public class TouristServiceImplTest
{



    @Autowired
    private TouristService touristService;

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
        assertEquals(2, touristService.findAll().size());
    }

    @Test
    public void findTouristById()
    {
        assertEquals("Jerry", touristService.findTouristById(3).getFirstname());
    }

    @Test
    public void deleteFound()
    {
        touristService.delete(2);
        assertEquals(2,touristService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        touristService.delete(209);
        assertEquals(2,touristService.findAll().size());
    }

    @Test
    public void save()
    {
        Tourist tourist= new Tourist("carl");

        Tourist addTourist=touristService.save(tourist);

        assertNotNull(addTourist);

        Tourist foundTourist = touristService.findTouristById(addTourist.getTouristid());
        assertEquals(addTourist.getFirstname(),foundTourist.getFirstname());
    }

    @Test
    public void update()
    {
        Tourist tourist = new Tourist("Jonny");
        tourist.setTouristid(1);

        Tourist updatedTourist= touristService.update(tourist,1);
        assertEquals("Jonny",updatedTourist.getFirstname());
    }

//    @Test
//    public void assignTouristToTour()
//    {
//
//
//
//    }
//
//    @Test
//    public void addFavoritedtoTour()
//    {
//
//
//
//    }
//
//    @Test
//    public void deleteTourFromSelf()
//    {
//
//
//    }
//
//    @Test
//    public void deleteFavTourFromSelf()
//    {
//
//
//
//
//    }


}