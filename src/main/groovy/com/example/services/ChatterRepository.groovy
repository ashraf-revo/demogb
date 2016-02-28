package com.example.services

import com.example.entities.Chatter
import org.springframework.data.repository.CrudRepository

/**
 * Created by revo on 2/28/16.
 */
interface ChatterRepository extends CrudRepository<Chatter, String> {
    Collection<Chatter> findAll();
}