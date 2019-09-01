package micronaut.doma.test

import org.seasar.doma.*
import org.seasar.doma.Annotation
import org.seasar.doma.AnnotationTarget
import org.seasar.doma.experimental.Sql
import org.seasar.doma.jdbc.Result
import javax.inject.Inject
import javax.inject.Singleton

//@Dao(config = AppConfig2::class)
@Dao
@AnnotateWith(annotations = [
    Annotation(target = AnnotationTarget.CLASS, type = Singleton::class),
    Annotation(target = AnnotationTarget.CONSTRUCTOR, type = Inject::class)
])
interface CatDao2 {

    @Sql("""
  select * from cat where id = /*id*/0
  """)
    @Select
    fun selectById(id: Int): Cat

    @Insert
    fun insert(cat: Cat): Result<Cat>

    @Update
    fun update(cat: Cat): Result<Cat>
}