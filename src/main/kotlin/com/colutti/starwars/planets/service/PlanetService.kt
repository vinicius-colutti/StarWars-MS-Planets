package com.colutti.starwars.planets.service

import com.colutti.starwars.planets.dto.planet.PlanetDto

interface PlanetService {

    fun create(planetDto: PlanetDto)
    fun update(id: Long, planetDto: PlanetDto)
    fun getById(id: Long): PlanetDto
    fun getAll(): List<PlanetDto>

}