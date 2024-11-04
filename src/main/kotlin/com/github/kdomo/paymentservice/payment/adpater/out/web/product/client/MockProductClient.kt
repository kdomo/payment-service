package com.github.kdomo.paymentservice.payment.adpater.out.web.product.client

import com.github.kdomo.paymentservice.payment.domain.Product
import org.springframework.stereotype.Component
import reactor.core.publisher.Flux
import java.math.BigDecimal

@Component
class MockProductClient: ProductClient {
    override fun getProducts(cartId: Long, productIds: List<Long>): Flux<Product> {
        return Flux.fromIterable(
            productIds.map {
                Product(
                    id = it,
                    amount = BigDecimal(it * 50),
                    quantity = 2,
                    name = "test_product_$it",
                    sellerId = 1
                )
            }
        )
    }

}