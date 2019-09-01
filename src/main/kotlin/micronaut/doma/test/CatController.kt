package micronaut.doma.test

import io.micronaut.context.ApplicationContext
import io.micronaut.context.BeanContext
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get

@Controller("cat")
class CatController(
        private val catService: CatService,
        private val catService2: CatService2
) {

    @Get
    fun get() {

        ApplicationContext.run().allBeanDefinitions.forEach {
            println(it)
            println(it.name)
        }

        println("-------")

        BeanContext.run().allBeanDefinitions.forEach {
            println(it)
            println(it.name)
        }

//        catService.find()
    }

    @Get("/2")
    fun get2() {
        catService2.find()
    }
}