package dio.listaPessoas2.controllers;

import dio.listaPessoas2.entities.Person;
import dio.listaPessoas2.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/persons")
public class PersonController {

    @Autowired
    private PersonRepository personRep;

    @GetMapping
    public List<Person> getAll(){
        return personRep.findAll();
    }

    @GetMapping(value = "/persons/{id}")
    public ResponseEntity<Person> GetById(@PathVariable(value = "id") Long id){
        Optional<Person> person = personRep.findById(id);
        if (person.isPresent()){
            return new ResponseEntity<Person>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public Person Post(@RequestBody Person person){
        return (Person) personRep.save(person);
    }

    @PutMapping(value = "/persons/{id}")
    public void Put(@RequestBody Person person, Long id){
        Optional<Person> newPerson = personRep.findById(id);

        if (newPerson.isPresent()){
            personRep.save(newPerson.get());
        }

    }
}
