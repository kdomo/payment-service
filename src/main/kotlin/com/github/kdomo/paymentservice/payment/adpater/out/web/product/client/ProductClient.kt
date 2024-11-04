package com.github.kdomo.paymentservice.payment.adpater.out.web.product.client

import com.github.kdomo.paymentservice.payment.domain.Product
import reactor.core.publisher.Flux

interface ProductClient {
    fun getProducts(cartId:Long, productIds: List<Long>): Flux<Product>
}