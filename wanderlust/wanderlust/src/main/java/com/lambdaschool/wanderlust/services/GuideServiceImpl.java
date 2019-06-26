package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;



@Service(value = "guideService")
public class GuideServiceImpl implements GuideService
{
    @Autowired
    private GuideRepository guiderepo;


    @Override
    public ArrayList<Guide> findAll()
    {
        ArrayList<Guide> list= new ArrayList<>();
        guiderepo.findAll().iterator().forEachRemaining(list::add);
        return list;
    }


    @Override
    public Guide findGuideById(long id) throws EntityNotFoundException
    {
        return guiderepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));
    }



    @Override
    public void delete(long id) throws EntityNotFoundException
    {
        if (guiderepo.findById(id).isPresent())
        {
            guiderepo.deleteById(id);
        } else
        {
            throw new EntityNotFoundException(Long.toString(id));
        }
    }

    @Transactional
    @Override
    public Guide save(Guide guide)
    {
        Guide newGuide = new Guide();

        newGuide.setFirstname(guide.getFirstname());
        newGuide.setLastname(guide.getLastname());
        newGuide.setPhonenumber(guide.getPhonenumber());
        newGuide.setEmail(guide.getEmail());


        return guiderepo.save(newGuide);
    }

    @Override
    public Guide update(Guide guide, long id)
    {
        Guide currentStudent = guiderepo.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(Long.toString(id)));

        if (guide.getFirstname() != null)
        {
        currentStudent.setFirstname(guide.getFirstname());
        }
        if (guide.getLastname() != null)
        {
            currentStudent.setLastname(guide.getLastname());
        }
        if (guide.getPhonenumber() != null)
        {
            currentStudent.setPhonenumber(guide.getPhonenumber());
        }
        if (guide.getEmail() != null)
        {
            currentStudent.setFirstname(guide.getEmail());
        }



        return guiderepo.save(currentStudent);
    }

}
