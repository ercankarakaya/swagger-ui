package com.ercan.controller;

import com.ercan.model.Animal;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/animal")
@Api(value = "My Animal API documentation")
public class AnimalController {

    List<Animal> animalList = new ArrayList<>();

    @PostConstruct
    public void init() {
        animalList.add(new Animal(1, "Dog", new Date()));
        animalList.add(new Animal(2, "Eagle", new Date()));
    }

    @PostMapping
    @ApiOperation(value = "New Animal add method", notes = "Use this method carefully.")
    public ResponseEntity<Animal> save(@RequestBody @ApiParam(value = "theAnimal") Animal animal) {
        animalList.add(animal);
        return ResponseEntity.ok(animal);
    }

    @GetMapping
    @ApiOperation(value = "Animal list method", notes = "This method all fetchs.")
    public ResponseEntity<List<Animal>> findAll() {
        return ResponseEntity.ok(animalList);
    }

}
