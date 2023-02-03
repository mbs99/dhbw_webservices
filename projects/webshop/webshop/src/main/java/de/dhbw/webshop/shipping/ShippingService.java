package de.dhbw.webshop.shipping;

import de.dhbw.webshop.cart.OrderDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class ShippingService {
    private final RestTemplate restTemplate;
    private final String shippingHostname;
    private final int shippingPort;
    private final String shippingBaseUrl;

    public ShippingService(RestTemplate restTemplate,
                           @Value("${shipping.host}") String shippingHostname,
                           @Value("${shipping.port}") int shippingPort,
                           @Value("${shipping.base}") String shippingBaseUrl) {
        this.restTemplate = restTemplate;
        this.shippingHostname = shippingHostname;
        this.shippingPort = shippingPort;
        this.shippingBaseUrl = shippingBaseUrl;
    }

    public String submitOrderAndGetTrackingId(OrderDto orderDto) {

        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(shippingHostname)
                .port(shippingPort)
                .pathSegment(shippingBaseUrl)
                .build();

        ResponseEntity<StatusDto> status = restTemplate.postForEntity(url.toUri(), orderDto, StatusDto.class);

        return status.getBody().id();
    }

    public String getStatus(String trackingId) {
        UriComponents url = UriComponentsBuilder
                .newInstance()
                .scheme("http")
                .host(shippingHostname)
                .port(shippingPort)
                .pathSegment(shippingBaseUrl, trackingId, "status")
                .build();

        ResponseEntity<StatusDto> status = restTemplate.getForEntity(url.toUri(), StatusDto.class);

        return status.getBody().status();
    }
}
