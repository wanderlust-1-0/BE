package com.lambdaschool.wanderlust.services;


import com.lambdaschool.wanderlust.model.Tourist;
import com.lambdaschool.wanderlust.repository.TouristRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    }
