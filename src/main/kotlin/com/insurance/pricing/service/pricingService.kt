package com.insurance.pricing.service

import com.insurance.pricing.model.*
import jakarta.inject.Singleton

@Singleton
class PricingService {

    fun getConfig(): ConfigResponse {
        val ageBands = AgeBand.entries.map { band ->
            AgeBandDto(
                id = band.name,
                label = band.label,
                basePrice = band.basePrice
            )
        }

        val extras = Extra.entries.map { extra ->
            ExtraDto(
                id = extra.name,
                label = extra.label,
                price = extra.price
            )
        }

        return ConfigResponse(
            ageBands = ageBands,
            extras = extras
        )
    }

    fun calculateQuote(request: QuoteRequest): QuoteResponse {
        val ageBand = AgeBand.entries.find { it.name == request.ageBandId }
            ?: throw IllegalArgumentException("Invalid age band ID: ${request.ageBandId}")

        val selectedExtras = request.extraIds.mapNotNull { extraId ->
            Extra.entries.find { it.name == extraId }
        }

        val extraItems = selectedExtras.map { extra ->
            ExtraItemDto(
                id = extra.name,
                price = extra.price
            )
        }

        val extrasTotal = selectedExtras.sumOf { it.price }
        val total = ageBand.basePrice + extrasTotal

        return QuoteResponse(
            basePrice = ageBand.basePrice,
            extras = extraItems,
            total = total
        )
    }
}
