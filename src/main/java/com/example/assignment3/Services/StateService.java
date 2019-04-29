package com.example.assignment3.Services;

import com.example.assignment3.models.State;
import com.example.assignment3.repository.StateRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StateService {

    private StateRepository stateRepository;

    public StateService(StateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public Iterable<State> list() {
        return stateRepository.findAll();
    }

    public Iterable<State> save(List<State> state){
        return stateRepository.saveAll(state);
    }

    public State save(State state){
        return stateRepository.save(state);
    }
    public State findFirstByName(String name){
        return stateRepository.findFirstByName(name);
    }
    public State findFirstByCode(String abbreviation){
        return stateRepository.findFirstByAbbreviation(abbreviation);
    }

}

