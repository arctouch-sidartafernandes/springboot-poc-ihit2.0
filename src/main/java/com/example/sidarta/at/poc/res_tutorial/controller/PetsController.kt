package com.example.sidarta.at.poc.res_tutorial.controller

import com.example.sidarta.at.poc.res_tutorial.repository.Pets
import com.example.sidarta.at.poc.res_tutorial.repository.PetsRepository
import com.example.sidarta.at.poc.res_tutorial.repository.PetsService
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*

import javax.validation.Valid

@RestController
@RequestMapping("/pets")
class PetsController {
    @Autowired
    private val service: PetsService? = null

    /*
    Get methods
     */
    val allPets: List<Pets>
        @RequestMapping(method = arrayOf(RequestMethod.GET))
        get() = service!!.listPets()

    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.GET))
    fun getPetById(@PathVariable("id") id: ObjectId): Pets {
        return service!!.getPetsById(id)
    }

    /*
    Put method
     */
    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.PUT))
    fun modifyPetsById(@PathVariable("id") id: ObjectId, @Valid @RequestBody pets: Pets) {
        pets.set_id(id)
        service!!.savePet(pets)
    }

    /*
    POST methods
     */
    @RequestMapping(method = arrayOf(RequestMethod.POST))
    fun createPet(@Valid @RequestBody pets: Pets): Pets {
        pets.set_id(ObjectId.get())
        service!!.savePet(pets)
        return pets
    }

    /*
    DELETE
     */
    @RequestMapping(value = "/{id}", method = arrayOf(RequestMethod.DELETE))
    fun deletePets(@PathVariable id: ObjectId) {
        service!!.deletePets(service.getPetsById(id))
    }


}
