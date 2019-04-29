package com.example.assignment3.Controller;

import com.example.assignment3.Services.StateService;
import com.example.assignment3.models.State;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/")
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
    @GetMapping("stateToCode")
    public State stateToCode(@RequestParam String state){
        return stateService.findFirstByName(state);
            //http://localhost:8080/stateToCode?state=Alabama
    }

    @GetMapping("codeToState")
    public State codeToState(@RequestParam String code){
        return stateService.findFirstByCode(code);
//        http://localhost:8080/codeToState?code=AL

    }

}
