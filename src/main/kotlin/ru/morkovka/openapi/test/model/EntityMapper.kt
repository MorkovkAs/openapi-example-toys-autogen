package ru.morkovka.openapi.test.model

interface EntityMapper<DTO, ENTITY> {
    fun mapEntity(entity: ENTITY): DTO
    val entityClass: Class<ENTITY>
}