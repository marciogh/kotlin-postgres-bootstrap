package io.marciogh.postgres

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
open class Resource {

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @GetMapping("/healthcheck")
    fun healthcheck() = "ok"

    @GetMapping("/count")
    fun count() = jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tmp", String::class.java)

    @GetMapping("/env")
    fun env() = System.getenv()

}