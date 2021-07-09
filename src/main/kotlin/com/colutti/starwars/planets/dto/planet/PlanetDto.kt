package com.colutti.starwars.planets.dto.planet


data class PlanetDto(

        var id: Long = 0,
        var name: String = "",
        var description: String = "",
        var url_image: String = "",

)