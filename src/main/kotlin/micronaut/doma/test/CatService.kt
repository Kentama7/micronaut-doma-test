package micronaut.doma.test

import javax.inject.Singleton

@Singleton
class CatService(
        private val catDao: CatDao
) {

    fun find() {
//        val cat = catDao.selectById(1)
//        println(cat)
        val tm = AppConfig.transactionManager
        tm.required {
            val cat = catDao.selectById(1)
            println(cat)
            val cat2 = catDao.selectByIdWithSqlFile(2)
            println(cat2)
        }
    }
}