package micronaut.doma.test

import org.seasar.doma.AnnotateWith
import org.seasar.doma.Annotation
import org.seasar.doma.AnnotationTarget
import org.seasar.doma.Dao
import org.seasar.doma.Select
import org.seasar.doma.experimental.Sql
import javax.inject.Singleton

@Dao(config = AppConfig::class)
@AnnotateWith(annotations = [
    Annotation(target=AnnotationTarget.CLASS, type = Singleton::class)
])
interface CatDao {

    @Sql("""
  select * from cat where id = /*id*/0
  """)
    @Select
    fun selectById(id: Int): Cat

    @Select
    fun selectByIdWithSqlFile(id: Int): Cat
}
