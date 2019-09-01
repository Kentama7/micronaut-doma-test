package micronaut.doma.test

import io.micronaut.runtime.Micronaut

object Application {

    @JvmStatic
    fun main(args: Array<String>) {
        Micronaut.build()
                .packages("micronaut.doma.test")
                .mainClass(Application.javaClass)
                .start()
    }
}