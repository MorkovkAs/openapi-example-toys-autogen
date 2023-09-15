package ru.morkovka.openapi.test.model

import java.time.LocalDate
import java.util.*

data class ToyDto(val id: UUID, var name: String, var status: String, var note: String?, var createdAt: LocalDate) {
}