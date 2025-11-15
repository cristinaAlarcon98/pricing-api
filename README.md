# Pricing API

A simple backend API for travel insurance pricing, inspired by SafetyWing's pricing model.

Built with Kotlin and Micronaut.

## What it does

This API provides two endpoints:

1. **GET /api/config** - Returns available age bands and extra coverages with prices
2. **POST /api/quote** - Calculates the total price based on user selection

## Tech Stack

- Kotlin 1.9+
- Micronaut 4.10.2
- Gradle 8.14.3
- JDK 21

## Running locally

```bash
./gradlew run
