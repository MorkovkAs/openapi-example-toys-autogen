package ru.morkovka.openapi.test.model

import org.springframework.stereotype.Component
import ru.morkovka.openapi.gen.model.Toy
import java.time.LocalDate
import java.time.LocalDateTime.now
import java.time.format.DateTimeFormatter
import java.util.*

@Component
class ToyMapper : BiDirectionalMapper<ToyDto, Toy> {
    override fun mapEntity(entity: Toy): ToyDto {
        return ToyDto(
            id = entity.toyId!!.also { UUID.randomUUID() },
            name = entity.name,
            status = entity.status.value,
            note = entity.note,
            createdAt = LocalDate.parse(entity.createdAt?.let { now().format(DateTimeFormatter.ISO_DATE) }, DateTimeFormatter.ISO_DATE)
        )
    }

    override fun mapDto(dto: ToyDto): Toy {
        return Toy(
            toyId = dto.id,
            name = dto.name,
            status = Toy.Status.valueOf(dto.status),
            note = dto.note,
            createdAt = dto.createdAt.format(DateTimeFormatter.ISO_DATE)
        )
    }

    override val entityClass: Class<Toy> = Toy::class.java
}