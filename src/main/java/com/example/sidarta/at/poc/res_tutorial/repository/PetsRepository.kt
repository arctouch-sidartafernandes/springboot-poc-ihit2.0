package com.example.sidarta.at.poc.res_tutorial.repository

import org.bson.types.ObjectId
import org.springframework.data.mongodb.repository.MongoRepository

interface PetsRepository : MongoRepository<Pets, String> {
    fun findBy_id(_id: ObjectId): Pets
}
