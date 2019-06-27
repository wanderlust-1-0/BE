package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.WanderlustApplication;
import com.lambdaschool.wanderlust.model.Guide;
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



@RunWith(SpringRunner.class)
@SpringBootTest(classes = WanderlustApplication.class)
public class GuideServiceImplTest
{
    @Autowired
    private GuideService guideService;

    @Before
    public void setUp() throws Exception
    {
        MockitoAnnotations.initMocks(this);
    }

    @After
    public void tearDown()
    {
    }

    @Test
    public void findAll()
    {
        assertEquals(2, guideService.findAll().size());
    }

    @Test
    public void findGuideById()
    {
        assertEquals("bob", guideService.findGuideById(1).getFirstname());
    }

    @Test
    public void deleteFound()
    {
        guideService.delete(1);
        assertEquals(2,guideService.findAll().size());
    }

    @Test (expected = EntityNotFoundException.class)
    public void deleteNotFound()
    {
        guideService.delete(209);
        assertEquals(2,guideService.findAll().size());
    }

    @Test
    public void save()
    {
        Guide guide= new Guide("craig");

        Guide addGuide=guideService.save(guide);

        assertNotNull(addGuide);

        Guide foundGuide = guideService.findGuideById(addGuide.getGuideid());
        assertEquals(addGuide.getFirstname(),foundGuide.getFirstname());

    }

    @Test
    public void update()
    {
        Guide guide = new Guide("charles");
        guide.setGuideid(1);

        Guide updatedguide= guideService.update(guide,3);
        assertEquals("charles",updatedguide.getFirstname());


    }
}