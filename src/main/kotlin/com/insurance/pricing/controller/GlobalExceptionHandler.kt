package com.insurance.pricing.controller

import com.insurance.pricing.model.ErrorResponse
import io.micronaut.context.annotation.Requires
import io.micronaut.http.HttpRequest
import io.micronaut.http.HttpResponse
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Produces
import io.micronaut.http.server.exceptions.ExceptionHandler
import jakarta.inject.Singleton

@Produces
@Singleton
@Requires(classes = [IllegalArgumentException::class, ExceptionHandler::class] )
class GlobalExceptionHandler : ExceptionHandler<IllegalArgumentException, HttpResponse<ErrorResponse>> {

    override fun handle(request: HttpRequest<*>, exception: IllegalArgumentException): HttpResponse<ErrorResponse> {
        val errorResponse = ErrorResponse(
            error = "Bad Request",
            message = exception.message ?: "Invalid request",
            status = HttpStatus.BAD_REQUEST.code
        )
        return HttpResponse.badRequest(errorResponse)
    }
}
