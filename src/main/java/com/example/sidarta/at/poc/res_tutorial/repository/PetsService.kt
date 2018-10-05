package com.example.sidarta.at.poc.res_tutorial.repository

import io.leangen.graphql.annotations.GraphQLQuery
import org.bson.types.ObjectId
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.Optional

@Service
class PetsService(private val petsRepository: PetsRepository) {

    @GraphQLQuery(name = "pets")
    fun listPets(): List<Pets> {
        return petsRepository.findAll()
    }

    @GraphQLQuery(name = "pet")
    fun getPetsById(id: ObjectId): Pets { //TODO object id does not work with GraphQL
        return petsRepository.findBy_id(id)
    }

    @GraphQLQuery(name = "savePets")
    fun savePet(pets: Pets): Pets {
        return petsRepository.save(pets)
    }

    @GraphQLQuery(name = "deletePets")
    fun deletePets(pets: Pets) {
        petsRepository.delete(pets)
    }
}
