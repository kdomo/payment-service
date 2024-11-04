package com.github.kdomo.paymentservice.payment.adpater.`in`.web.view

import com.github.kdomo.paymentservice.common.IdempotencyCreator
import com.github.kdomo.paymentservice.common.WebAdapter
import com.github.kdomo.paymentservice.payment.adpater.`in`.web.reuqest.CheckoutRequest
import com.github.kdomo.paymentservice.payment.application.port.`in`.CheckoutCommand
import com.github.kdomo.paymentservice.payment.application.port.`in`.CheckoutUseCase
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import reactor.core.publisher.Mono

@Controller
@WebAdapter
class CheckoutController(
    private val checkoutUseCase: CheckoutUseCase
) {

    @GetMapping("/")
    fun checkoutPage(requset: CheckoutRequest, model: Model): Mono<String> {
        val command = CheckoutCommand(
            cartId = requset.cartId,
            buyerId = requset.buyerId,
            productIds = requset.productIds,
            idempotencyKey = IdempotencyCreator.create(requset)
        )

        return checkoutUseCase.checkout(command)
            .map {
                model.addAttribute("orderId", it.orderId)
                model.addAttribute("orderName", it.orderName)
                model.addAttribute("amount", it.amount)
                "checkout"
            }
    }
}