package com.personapp.personapi.controllers;

import com.personapp.personapi.dtos.request.PersonDTO;
import com.personapp.personapi.dtos.response.MessageResponse;
import com.personapp.personapi.enums.Type;
import com.personapp.personapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

   private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
   public List<String> createPerson(){
       return Arrays.stream(Type.values()).
                map((t->t.getType()))
                 .collect(Collectors.toList());
    }

   @PostMapping
   public ResponseEntity<MessageResponse> registerPerson(@RequestBody @Valid PersonDTO personDTO){
      return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
  }



}
