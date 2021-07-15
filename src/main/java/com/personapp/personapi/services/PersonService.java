package com.personapp.personapi.services;

import com.personapp.personapi.dtos.request.PersonDTO;
import com.personapp.personapi.dtos.response.MessageResponse;
import com.personapp.personapi.entity.Person;
import com.personapp.personapi.mapper.PersonMapper;
import com.personapp.personapi.repository.PersonRepository;
import org.springframework.stereotype.Service;
import com.personapp.personapi.services.exceptions.PersonNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

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

    public List<PersonDTO> listAll(){
        List<Person> people =this.personRepository.findAll();
        return people.stream()
                .map(mapper::toDTO)
                .collect(Collectors.toList());

    }

    public PersonDTO getPerson(Long id) {
      Person p=this.personRepository.findById(id).orElseThrow(()->new PersonNotFoundException("Não foi possível encontrar uma pessoa com o id:"+id));
      return mapper.toDTO(p);
    }
    public MessageResponse removePerson(Long id){
        Person p=verifyIfExist(id);
        this.personRepository.delete(p);
        return new MessageResponse(String.format("A pessoa com id:%x foi excluida",id));
    }
    public MessageResponse updatePerson(Long id,PersonDTO personDTO){
      verifyIfExist(id);
      Person p =mapper.toModel(personDTO);
      this.personRepository.save(p);
      return new MessageResponse(String.format("A pessoa com id:%x foi atualizada",id));
    }

    private Person verifyIfExist(Long id){
      return  this.personRepository.findById(id)
              .orElseThrow(()->new PersonNotFoundException("Não foi possível encontrar uma pessoa com o id:"+id));
    }


}
