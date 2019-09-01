package micronaut.doma.test

import org.seasar.doma.*

@Entity(immutable = true)
data class Cat(
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        val id: Long,
        val name: String,
//        @Column(name = "is_slept")
        val isSlept: String,
        @Version
        val version: Int
)