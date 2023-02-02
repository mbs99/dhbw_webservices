package de.dhbw.webshop.shipping;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Controller
public class ShippingController {

    private final ShippingService shippingService;

    public ShippingController(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    @GetMapping(path = "/shipping")
    public String shipping(HttpSession httpSession, ShippingDto shippingDto) {

        shippingDto.setTrackingId((String) httpSession.getAttribute("trackingId"));
        shippingDto.setStatus("PENDING");

        return "shipping";
    }

    @PostMapping(path = "/shipping")
    public String updateStatus(HttpSession httpSession, ShippingDto shippingDto) {

        shippingDto.setTrackingId((String) httpSession.getAttribute("trackingId"));
        shippingDto.setStatus(shippingService.getStatus(shippingDto.getTrackingId()));

        return "shipping";
    }
}
