package com.example

import io.quarkus.runtime.Quarkus
import io.quarkus.runtime.annotations.QuarkusMain
import org.jboss.logging.Logger

@QuarkusMain
class Application {
    companion object {
        private val log: Logger = Logger.getLogger(Application::class.java)

        @JvmStatic
        fun main(vararg args: String) {
            log.info("Starting Quarkus application")
            Quarkus.run(*args)
        }
    }
}
