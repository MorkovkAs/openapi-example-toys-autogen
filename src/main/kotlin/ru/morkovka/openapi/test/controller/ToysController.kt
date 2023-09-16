package ru.morkovka.openapi.test.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.RestController
import ru.morkovka.openapi.test.model.BiDirectionalMapper
import ru.morkovka.openapi.test.model.ToyDto
import ru.morkovka.openapi.gen.api.ToysApi
import ru.morkovka.openapi.gen.model.Toy
import java.util.*

@RestController
@CrossOrigin
class ToysController(
    val mapper: BiDirectionalMapper<ToyDto, Toy>
) : ToysApi {
    var toysMap = HashMap<UUID, ToyDto>()

    override fun createToy(toy: Toy): ResponseEntity<Toy> {
        val toyDto = mapper.mapEntity(toy)
        toysMap[toyDto.id] = toyDto

        return ResponseEntity.ok(mapper.mapDto(toyDto))
    }

    override fun deleteToyById(id: UUID): ResponseEntity<Unit> {
        return if (toysMap.containsKey(id)) {
            toysMap.remove(id)

            ResponseEntity.noContent().build()
        } else
            ResponseEntity.notFound().build()
    }

    override fun getToyById(id: UUID): ResponseEntity<Toy> {
        return if (toysMap.containsKey(id))
            ResponseEntity.ok(mapper.mapDto(toysMap[id]!!))
        else
            ResponseEntity.notFound().build()
    }

}