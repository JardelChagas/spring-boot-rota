package rota.demo.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.OneToMany
import javax.persistence.Id

@Entity
data class Rota(
    @Id
    @GeneratedValue
    val id: Int? = null,
    val nome: String? = null,
    @OneToMany(mappedBy = "rota")
    val paradas: List<Parada> = emptyList()
)