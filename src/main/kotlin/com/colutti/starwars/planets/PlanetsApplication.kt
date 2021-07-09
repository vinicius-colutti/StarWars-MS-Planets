package com.colutti.starwars.planets

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class PlanetsApplication

fun main(args: Array<String>) {
	runApplication<PlanetsApplication>(*args)
}
