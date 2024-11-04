package com.github.kdomo.paymentservice.payment.application.port.out

import com.github.kdomo.paymentservice.payment.domain.Product
import reactor.core.publisher.Flux

interface LoadProductPort {
    fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product>
}