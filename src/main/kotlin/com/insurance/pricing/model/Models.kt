package com.insurance.pricing.model
import io.micronaut.serde.annotation.Serdeable


enum class AgeBand(val label: String, val basePrice: Double) {
    UNDER_10("Age Under 10", 40.0),
    AGE_10_39("Age 10–39", 70.0),
    AGE_40_49("Age 40–49", 90.0),
    AGE_50_59("Age 50–59", 120.0)
}

enum class Extra(val label: String, val price: Double) {
    US_COVERAGE("US Coverage", 30.0),
    ADVENTURE_SPORTS("Adventure Sports", 10.0)
}

@Serdeable
data class AgeBandDto(
    val id: String,
    val label: String,
    val basePrice: Double
)

@Serdeable
data class ExtraDto(
    val id: String,
    val label: String,
    val price: Double
)

@Serdeable
data class ConfigResponse(
    val ageBands: List<AgeBandDto>,
    val extras: List<ExtraDto>
)

@Serdeable
data class QuoteRequest(
    val ageBandId: String,
    val extraIds: List<String> = emptyList()
)

@Serdeable
data class ExtraItemDto(
    val id: String,
    val price: Double
)

@Serdeable
data class QuoteResponse(
    val basePrice: Double,
    val extras: List<ExtraItemDto>,
    val total: Double
)

@Serdeable
data class ErrorResponse(
    val error: String,
    val message: String,
    val status: Int
)
