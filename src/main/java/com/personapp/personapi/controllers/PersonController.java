package com.personapp.personapi.controllers;

import com.personapp.personapi.dtos.request.PersonDTO;
import com.personapp.personapi.dtos.response.MessageResponse;
import com.personapp.personapi.services.PersonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1/people")
public class PersonController {

   private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public ResponseEntity<List<PersonDTO>> listPeople(){
       return ResponseEntity.ok(this.personService.listAll());
    }

   @PostMapping
   public ResponseEntity<MessageResponse> registerPerson(@RequestBody @Valid PersonDTO personDTO){
      return ResponseEntity.status(HttpStatus.CREATED).body(personService.save(personDTO));
  }

  @DeleteMapping(path = "{id}")
  public ResponseEntity<Void> deleteById(@PathVariable Long id){
      MessageResponse messageResponse = this.personService.removePerson(id);
      return ResponseEntity.noContent().build();

  }
 @PutMapping(path="/{id}")
 public ResponseEntity<MessageResponse> updatePerson(@PathVariable Long id,@RequestBody @Valid PersonDTO personDTO){
      MessageResponse messageResponse=this.personService.updatePerson(id,personDTO);
      return ResponseEntity.ok(messageResponse);
 }

  @GetMapping(path = "/{id}")
  public ResponseEntity<PersonDTO> findPerson( @PathVariable Long id){
   return ResponseEntity.ok(this.personService.getPerson(id));
  }


}
