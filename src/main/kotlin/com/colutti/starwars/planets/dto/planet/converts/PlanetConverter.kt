package com.colutti.starwars.planets.dto.planet.converts

import com.colutti.starwars.planets.dto.planet.PlanetDto
import com.colutti.starwars.planets.model.Planet
import org.springframework.stereotype.Component

@Component
class PlanetConverter {

    fun dtoToPlanet(planetDto: PlanetDto): Planet {
        var planet = Planet(planetDto.id, planetDto.name, planetDto.description, planetDto.url_image)
        return planet
    }

    fun planetToDto(planet: Planet): PlanetDto{
        var planetDto = PlanetDto(planet.id, planet.name, planet.description, planet.url_image)
        return planetDto
    }

    fun planetListToDtoList(planet: List<Planet>): List<PlanetDto>{
        var planetDto: List<PlanetDto> = planet.map { planetResp ->
            PlanetDto(planetResp.id, planetResp.name, planetResp.description, planetResp.url_image)
        }
        return planetDto
    }

}