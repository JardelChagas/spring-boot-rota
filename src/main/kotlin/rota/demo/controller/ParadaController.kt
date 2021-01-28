package rota.demo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import rota.demo.model.Parada
import rota.demo.model.Rota
import rota.demo.repositorie.ParadaRepository
import rota.demo.repositorie.RotaRepository

@RestController
@RequestMapping("/paradas")
class ParadaController(
    private val paradaRepository: ParadaRepository,
    private val rotaRepository: RotaRepository
) {

    @PostMapping("/{rotaId}")
    fun addStop(@PathVariable rotaId: Int, @RequestBody parada: Parada): ResponseEntity<Parada>{
        return if(rotaRepository.existsById(rotaId)){
            val novaParada = parada.copy(rota = Rota(id = rotaId))
            paradaRepository.save(novaParada)
            ResponseEntity.ok(novaParada)
        }else{
            ResponseEntity(HttpStatus.PRECONDITION_FAILED)
        }
    }

    @DeleteMapping("/{rotaId}/{paradaId}")
    @ResponseStatus(HttpStatus.OK)
    fun deleteStop(@PathVariable rotaId: Int, @PathVariable paradaId: Int){
        if(rotaRepository.existsById(rotaId)){
            paradaRepository.deleteById(paradaId)
        }
    }

}