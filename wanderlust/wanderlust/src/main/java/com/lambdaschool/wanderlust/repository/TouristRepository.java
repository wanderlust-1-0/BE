package com.lambdaschool.wanderlust.repository;

import com.lambdaschool.wanderlust.model.Tourist;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TouristRepository extends CrudRepository<Tourist,Long>
{
    List<Tourist> findByTouristNameContainingIgnoreCase(String name);

}
