package com.lambdaschool.wanderlust.services;

import com.lambdaschool.wanderlust.model.Guide;

import java.util.ArrayList;

public interface GuideService
{
    ArrayList<Guide> findAll();

    Guide findGuideById(long id);

    void delete(long id);

    Guide save (Guide guide);

    Guide update(Guide guide, long id);

}
