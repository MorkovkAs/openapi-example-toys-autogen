package ru.morkovka.openapi.test.model

interface BiDirectionalMapper<DTO, ENTITY> : DtoMapper<DTO, ENTITY>, EntityMapper<DTO, ENTITY>