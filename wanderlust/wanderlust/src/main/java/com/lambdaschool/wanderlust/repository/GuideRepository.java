package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.model.Guide;
import org.springframework.data.repository.CrudRepository;

import java.util.ArrayList;

public interface GuideRepository extends CrudRepository<Guide,Long>
{
//    ArrayList<Guide> findGuideBynameEquals(String name);
}
