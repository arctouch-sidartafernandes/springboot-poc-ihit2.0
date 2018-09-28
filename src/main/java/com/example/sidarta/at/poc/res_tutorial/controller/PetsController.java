package com.example.sidarta.at.poc.res_tutorial.controller;

import com.example.sidarta.at.poc.res_tutorial.repository.Pets;
import com.example.sidarta.at.poc.res_tutorial.repository.PetsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetsController {
    @Autowired
    private PetsRepository repository;

    /*
    Get methods
     */
    @RequestMapping(method = RequestMethod.GET)
    public List<Pets> getAllPets(){
        return repository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Pets getPetById(@PathVariable("id") ObjectId id){
        return repository.findBy_id(id);
    }

    /*
    Put method
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public void modifyPetsById(@PathVariable("id") ObjectId id, @Valid @RequestBody Pets pets){
        pets.set_id(id);
        repository.save(pets);
    }

    /*
    POST methods
     */
    @RequestMapping(method = RequestMethod.POST)
    public Pets createPet(@Valid @RequestBody Pets pets){
        pets.set_id(ObjectId.get());
        repository.save(pets);
        return pets;
    }

    /*
    DELETE
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void deletePets(@PathVariable ObjectId id){
        repository.delete(repository.findBy_id(id));
    }


}
