package com.insurance.pricing.controller

import com.insurance.pricing.model.ConfigResponse
import com.insurance.pricing.model.QuoteRequest
import com.insurance.pricing.model.QuoteResponse
import com.insurance.pricing.service.PricingService
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Post

@Controller("/api" )
class PricingController(
    private val pricingService: PricingService
) {

    @Get("/config")
    fun getConfig(): ConfigResponse {
        return pricingService.getConfig()
    }

    @Post("/quote")
    fun calculateQuote(@Body request: QuoteRequest): QuoteResponse {
        return pricingService.calculateQuote(request)
    }
}
