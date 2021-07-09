package com.colutti.starwars.planets.controller

import com.colutti.starwars.planets.dto.ResponseDefault
import com.colutti.starwars.planets.dto.planet.PlanetDto
import com.colutti.starwars.planets.service.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping(value=["/starwars/planets"])
class PlanetController {

    @Autowired
    lateinit var service: PlanetService

    @PostMapping
    fun create(@RequestBody planetDto: PlanetDto): ResponseEntity<ResponseDefault> {
        service.create(planetDto)
        val responseJson = ResponseDefault("Created planet!", Date())
        return ResponseEntity(responseJson, HttpStatus.CREATED)
    }

    @PutMapping("/{id}")
    fun update(@PathVariable id: Long, @RequestBody planetDto: PlanetDto): ResponseEntity<ResponseDefault> {
        service.update(id, planetDto)
        val responseJson = ResponseDefault("Updated planet!", Date())
        return ResponseEntity(responseJson, HttpStatus.OK)
    }

    @GetMapping("/{id}")
    fun getById(@PathVariable id: Long): ResponseEntity<PlanetDto> =
            ResponseEntity(service.getById(id), HttpStatus.OK)

    @GetMapping()
    fun getAll(): ResponseEntity<List<PlanetDto>> =
            ResponseEntity(service.getAll(), HttpStatus.OK)

}