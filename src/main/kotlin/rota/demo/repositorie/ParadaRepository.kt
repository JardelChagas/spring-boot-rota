package rota.demo.repositorie

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import rota.demo.model.Parada

@Repository
interface ParadaRepository: JpaRepository<Parada, Int>