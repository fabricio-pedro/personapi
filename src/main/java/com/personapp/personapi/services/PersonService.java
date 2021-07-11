package com.personapp.personapi.services;

import com.personapp.personapi.dtos.request.PersonDTO;
import com.personapp.personapi.dtos.response.MessageResponse;
import com.personapp.personapi.entity.Person;
import com.personapp.personapi.mapper.PersonMapper;
import com.personapp.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;

@Service
public class PersonService {

    private final PersonMapper mapper=PersonMapper.INSTANCE;
    private final PersonRepository personRepository;

    public PersonService(PersonRepository prs){
        this.personRepository=prs;

    }


    public MessageResponse save(PersonDTO personDto){
      Person person=mapper.toModel(personDto);
      personRepository.save(person);
      return new MessageResponse(String.format("Person with %s id created with success",person.getId()));
    }

}
