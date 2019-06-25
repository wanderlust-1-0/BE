package com.lambdaschool.wanderlust.services;


import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import javax.persistence.OneToMany;
import java.util.ArrayList;

@Service(value = "touristService")
public class TouristServiceImpl implements TouristService
{
     @Autowired
     private TouristRepository touristrepo;

     @Override
     public ArrayList<Tourist> findAll()
     {
         ArrayList<Tourist> list= new ArrayList<>();
         touristrepo.findAll().iterator().forEachRemaining(list::add);
         return list;
     }


    @Override
    public Tourist findTouristById(long id) throws EntityNotFoundException
    {
        return touristrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }



    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (touristrepo.findById(id).isPresent())
        {
            touristrepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Tourist save(Tourist tourist)
    {
        Tourist newTourist = new Tourist();

        newTourist.setFirstname(tourist.getFirstname());
        newTourist.setLastname(tourist.getLastname());
        newTourist.setPhonenumber(tourist.getPhonenumber());
        newTourist.setEmail(tourist.getEmail());


        return touristrepo.save(newTourist);
    }

    @Override
    public Tourist update(Tourist tourist, long id)
    {
        Tourist currentStudent = touristrepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (tourist.getFirstname() != null)
        {
            currentStudent.setFirstname(tourist.getFirstname());
        }
        if (tourist.getLastname() != null)
        {
            currentStudent.setLastname(tourist.getLastname());
        }
        if (tourist.getPhonenumber() != null)
        {
            currentStudent.setPhonenumber(tourist.getPhonenumber());
        }
        if (tourist.getEmail() != null)
        {
            currentStudent.setEmail(tourist.getEmail());
        }



        return touristrepo.save(currentStudent);
    }


    @Transactional
    @Override
    public void assignTouristToTour(long touristid, long tourid)
    {
        touristrepo.assignTouristToTour(touristid,tourid);
    }


    @Transactional
    @Override
    public void addFavoritedtoTour(long touristid, long tourid)
    {
        touristrepo.addFavoritedTours(touristid,tourid);
    }

    @Transactional
    @Override
    public void deleteTourFromSelf(long touristid,long tourid)
    {
        touristrepo.deleteTouristTourById(tourid);
        touristrepo.deleteTouristTourById2(touristid);
    }




}
