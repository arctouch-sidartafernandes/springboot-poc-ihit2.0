package com.example.sidarta.at.poc.res_tutorial.repository

import io.leangen.graphql.annotations.GraphQLQuery
import org.bson.types.ObjectId
import org.springframework.data.annotation.Id

/**
 * entity
 */
class Pets {

    @Id
    @GraphQLQuery(name = "id", description = "A pet's id")
    private var _id: ObjectId? = null

    @GraphQLQuery(name = "name", description = "A pets name")
    var name: String? = null

    @GraphQLQuery(name = "species", description = "A pets specie")
    var species: String? = null

    @GraphQLQuery(name = "breed", description = "A pets breed")
    var breed: String? = null

    constructor(_id: ObjectId, name: String, species: String, breed: String) {
        this._id = _id
        this.name = name
        this.species = species
        this.breed = breed
    }

    constructor() {}

    fun get_id(): String {
        return _id!!.toHexString()
    }

    fun set_id(_id: ObjectId) {
        this._id = _id
    }
}
