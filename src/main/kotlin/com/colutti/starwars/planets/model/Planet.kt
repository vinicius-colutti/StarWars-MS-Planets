package com.colutti.starwars.planets.model

import javax.persistence.*

@Entity
@Table(name="planet")
data class Planet (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        var id: Long = 0,

        var name: String = "",
        var description: String = "",
        var url_image: String = "",

)