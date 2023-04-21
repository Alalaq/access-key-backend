package com.example.accesskeybackend.template.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.net.Inet6Address;
import java.net.InetAddress;
import java.net.UnknownHostException;

@RestController
public class Ipv6SupportController {

    @GetMapping("/api/web/checkIpv6Support")
    public ResponseEntity<Boolean> checkIpv6Support(@RequestParam String siteUrl) {
        try {
            InetAddress address = InetAddress.getByName(siteUrl);
            boolean supportsIpv6 = address instanceof Inet6Address;
            return ResponseEntity.ok().body(supportsIpv6);
        } catch (UnknownHostException e) {
            return ResponseEntity.badRequest().build();
        }
    }

}
