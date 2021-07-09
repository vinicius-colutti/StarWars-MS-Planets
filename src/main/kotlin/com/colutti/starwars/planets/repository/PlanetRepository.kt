package com.colutti.starwars.planets.repository

import com.colutti.starwars.planets.model.Planet
import org.springframework.data.repository.PagingAndSortingRepository

interface PlanetRepository: PagingAndSortingRepository<Planet, Long> {
}