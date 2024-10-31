package com.github.kdomo.paymentservice.payment.adpater.`in`.web.view

import com.github.kdomo.paymentservice.common.WebAdapter
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import reactor.core.publisher.Mono

@Controller
@WebAdapter
class PaymentController {

    @GetMapping("/success")
    fun successPage(): Mono<String> {
        return Mono.just("success")
    }

    @GetMapping("/fail")
    fun failPage(): Mono<String> {
        return Mono.just("fail")
    }
}