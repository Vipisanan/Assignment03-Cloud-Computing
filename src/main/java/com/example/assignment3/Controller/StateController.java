package com.example.assignment3.Controller;

import com.example.assignment3.Services.StateService;
import com.example.assignment3.models.State;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("state")
public class StateController {

    private StateService stateService;

    public StateController(StateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping("test")
    public String test(){
        return "testing....";
    }
    @GetMapping("/list")
    public Iterable<State> list() {
        return stateService.list();
    }
}
