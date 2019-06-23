package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Guide;
import com.lambdaschool.wanderlust.model.Tourist;

import java.util.ArrayList;

public interface TouristService
{
    ArrayList<Tourist> findAll();
}
