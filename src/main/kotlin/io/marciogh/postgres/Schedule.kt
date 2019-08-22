package io.marciogh.postgres

import org.slf4j.LoggerFactory
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Component
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.beans.factory.annotation.Autowired

@Component
class Schedule {

    private val logger = LoggerFactory.getLogger(Schedule::class.java)

    @Autowired
    lateinit var jdbcTemplate: JdbcTemplate

    @Scheduled(fixedDelay = 500)
    fun write() {
        jdbcTemplate.execute("INSERT INTO tmp VALUES (random()::text)")
        logger.info("total=" + jdbcTemplate.queryForObject("SELECT COUNT(*) FROM tmp", String::class.java))
    }

}