package com.example.mvi_catapi.domain.usecase

abstract class BaseUseCase<T> {
    abstract suspend fun invoke(): T
}