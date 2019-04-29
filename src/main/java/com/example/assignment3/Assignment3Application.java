package com.example.assignment3;

import com.example.assignment3.Services.StateService;
import com.example.assignment3.models.State;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;



@SpringBootApplication
public class Assignment3Application {

    public static void main(String[] args) {
        SpringApplication.run(Assignment3Application.class, args);
    }

    @Bean
    CommandLineRunner runner(StateService userService) {
        return args -> {
            // read json and write to db
            ObjectMapper mapper = new ObjectMapper();
            TypeReference<List<State>> typeReference = new TypeReference<List<State>>(){};
            InputStream inputStream = TypeReference.class.getResourceAsStream("/json/state.json");
            try {
                List<State> users = mapper.readValue(inputStream,typeReference);
                userService.save(users);
                System.out.println("Users Saved!");
            } catch (IOException e){
                System.out.println("Unable to save users: " + e.getMessage());
            }
        };
    }


}

