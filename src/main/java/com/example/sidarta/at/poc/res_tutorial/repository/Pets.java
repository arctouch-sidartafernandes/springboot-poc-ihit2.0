package com.example.sidarta.at.poc.res_tutorial.repository;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;

/**
 * entity
 */
public class Pets {

    @Id
    private ObjectId _id;

    private String name;
    private String species;
    private String breed;

    public Pets(ObjectId _id, String name, String species, String breed) {
        this._id = _id;
        this.name = name;
        this.species = species;
        this.breed = breed;
    }

    public Pets() {
    }

    public String get_id() {
        return _id.toHexString();
    }

    public void set_id(ObjectId _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        this.breed = breed;
    }
}
