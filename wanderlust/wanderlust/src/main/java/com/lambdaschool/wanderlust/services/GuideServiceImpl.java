package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.repository.GuideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

}
