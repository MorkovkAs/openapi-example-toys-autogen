package ru.morkovka.openapi.test.model

interface DtoMapper<DTO, ENTITY> {
    fun mapDto(dto: DTO) : ENTITY
}