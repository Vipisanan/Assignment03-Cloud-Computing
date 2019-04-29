package com.example.assignment3.repository;

import com.example.assignment3.models.State;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StateRepository extends CrudRepository<State , Long> {

}
