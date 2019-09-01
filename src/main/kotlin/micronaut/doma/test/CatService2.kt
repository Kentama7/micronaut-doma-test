package micronaut.doma.test

import javax.inject.Singleton

@Singleton
class CatService2(
        private val catDao2: CatDao2
) {
    fun find() {
        val transactionManager = AppConfig2.transactionManager
        transactionManager.required {


            val cat = catDao2.selectById(1)
            println(cat)

            val result = catDao2.insert(cat.copy(name = "DOMA!!"))

            println(result)

            catDao2.update(result.entity.copy(id=51, name = "DOMA U2"))

        }
    }
}