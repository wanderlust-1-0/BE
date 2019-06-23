package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Tour;
import com.lambdaschool.wanderlust.repository.ToursRepository;
import com.lambdaschool.wanderlust.view.CountTouristInTour;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;


@Service(value = "tourService")
public class TourServiceImpl implements TourService
{

    @Autowired
    private ToursRepository tourrepo;


    @Override
    public ArrayList<Tour> findAll()
    {
        ArrayList<Tour> list= new ArrayList<>();
        tourrepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }

    @Override
    public Tour findTourById(long id)
    {
        return tourrepo.findById(id).orElseThrow(()->new EntityNotFoundException(Long.toString(id)));
    }

    @Transactional
    @Override
    public void delete(long id) throws EntityNotFoundException
    {

        if(tourrepo.findById(id).isPresent())
        {
            tourrepo.deleteTourFromTouristTours(id);
            tourrepo.deleteById(id);
        }else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Tour save(Tour tour)
    {
        Tour newTour= new Tour();

        newTour.setTourname(tour.getTourname());
        newTour.setGuide(tour.getGuide());
        newTour.setTourdescription(tour.getTourdescription());
        newTour.setRecommendedage(tour.getRecommendedage());
        newTour.setWhattobring(tour.getWhattobring());
        newTour.setCategory(tour.getCategory());
        newTour.setArea(tour.getArea());
        newTour.setPrice(tour.getPrice());
        newTour.setDurationhrs(tour.getDurationhrs());
        newTour.setMeetingaddress(tour.getMeetingaddress());
        newTour.setLikes(tour.getLikes());
        newTour.setTourgiudephonenumber(tour.getTourgiudephonenumber());


        return tourrepo.save(newTour);
    }

    @Transactional
    @Override
    public Tour update(Tour tour, long id)
    {
        Tour currentTour=tourrepo.findById(id).orElseThrow(()->new EntityNotFoundException(Long.toString(id)));
        if(tour.getTourname()!=null)
        {
            currentTour.setTourname(tour.getTourname());
        }
        if(tour.getGuide()!=null)
        {
            currentTour.setGuide(tour.getGuide());
        }
        if(tour.getTourdescription()!=null)
        {
            currentTour.setTourdescription(tour.getTourdescription());
        }

        if(tour.getRecommendedage()!=0)
        {
            currentTour.setRecommendedage(tour.getRecommendedage());
        }
        if(tour.getWhattobring()!=null)
        {
            currentTour.setWhattobring(tour.getWhattobring());
        }

        if(tour.getCategory()!=null)
        {
            currentTour.setCategory(tour.getCategory());
        }
        if(tour.getArea()!=null)
        {
            currentTour.setArea(tour.getArea());
        }
        if(tour.getPrice()!=0)
        {
            currentTour.setPrice(tour.getPrice());
        }
        if(tour.getDurationhrs()!=0)
        {
            currentTour.setDurationhrs(tour.getDurationhrs());
        }
        if(tour.getMeetingaddress()!=null)
        {
            currentTour.setMeetingaddress(tour.getMeetingaddress());
        }
        if(tour.getLikes()!=0)
        {
            currentTour.setLikes(tour.getLikes());
        }
        if(tour.getTourgiudephonenumber()!=null)
        {
            currentTour.setTourgiudephonenumber(tour.getTourgiudephonenumber());
        }



        return tourrepo.save(currentTour);

    }


}





























