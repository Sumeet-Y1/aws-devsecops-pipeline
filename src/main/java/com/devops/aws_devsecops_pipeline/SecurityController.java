package com.devops.aws_devsecops_pipeline;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SecurityController {

    @GetMapping("/hello")
    public Map<String, String> hello() {
        Map<String, String> response = new HashMap<>();
        try {
            response.put("message", "Hello from DevSecOps Pipeline!");
            response.put("server", InetAddress.getLocalHost().getHostName());
            response.put("timestamp", LocalDateTime.now().toString());
            response.put("status", "secure");
        } catch (Exception e) {
            response.put("error", e.getMessage());
        }
        return response;
    }

    @GetMapping("/health")
    public Map<String, String> health() {
        Map<String, String> response = new HashMap<>();
        response.put("status", "healthy");
        response.put("security", "all checks passed");
        return response;
    }
}