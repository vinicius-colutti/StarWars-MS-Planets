package com.colutti.starwars.planets.service.impl

import com.colutti.starwars.planets.dto.planet.PlanetDto
import com.colutti.starwars.planets.dto.planet.converts.PlanetConverter
import com.colutti.starwars.planets.exception.PlanetNotFoundException
import com.colutti.starwars.planets.repository.PlanetRepository
import com.colutti.starwars.planets.service.PlanetService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class PlanetServiceImpl: PlanetService {

    @Autowired
    lateinit var repository: PlanetRepository

    @Autowired
    lateinit var converter: PlanetConverter

    override fun create(planetDto: PlanetDto) {
        repository.save(converter.dtoToPlanet(planetDto))
    }

    override fun update(id: Long, planetDto: PlanetDto) {
        if(getById(id) != null){
            planetDto.id = id
            create(planetDto)
        }
    }

    override fun getById(id: Long): PlanetDto =
            converter.planetToDto(repository.findById(id).orElseGet { throw PlanetNotFoundException("Planet ${id} not found") })

    override fun getAll(): List<PlanetDto> =
            converter.planetListToDtoList(repository.findAll().toList())
}