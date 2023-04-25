package com.example.accesskeybackend.template.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.http.ResponseEntity;
import java.net.*;


@RestController
@RequestMapping("/api/web")
public class WebApiController {

    @GetMapping("/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) {
        try {
            InetAddress inetAddress = InetAddress.getByName(siteUrl);
            boolean isIpv6Supported = inetAddress instanceof Inet6Address;
            return ResponseEntity.ok(isIpv6Supported);
        } catch (UnknownHostException e) {
            return ResponseEntity.badRequest().build();
        }
    }
}
