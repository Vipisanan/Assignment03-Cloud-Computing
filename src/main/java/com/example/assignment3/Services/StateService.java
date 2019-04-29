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
    public String findFirstByName(String name){
        State state = stateRepository.findFirstByName(name);
        if (isEmpty(state))
            return "not matching Abbreviation";
        return stateRepository.findFirstByName(name).getAbbreviation();


    }
    public String findFirstByCode(String abbreviation){
        State state = stateRepository.findFirstByAbbreviation(abbreviation);
        if (isEmpty(state))
            return "not matching name";
        return stateRepository.findFirstByAbbreviation(abbreviation).getName();
    }

    public boolean isEmpty(State  state){
        return state == null;
    }

}

