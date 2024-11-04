package com.github.kdomo.paymentservice.payment.adpater.out.web.product

import com.github.kdomo.paymentservice.common.WebAdapter
import com.github.kdomo.paymentservice.payment.adpater.out.web.product.client.ProductClient
import com.github.kdomo.paymentservice.payment.application.port.out.LoadProductPort
import com.github.kdomo.paymentservice.payment.domain.Product
import reactor.core.publisher.Flux

@WebAdapter
class ProductWebAdapter(
    private val productClient: ProductClient
): LoadProductPort {
    override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
        return productClient.getProducts(cartId, productIds)
    }
}