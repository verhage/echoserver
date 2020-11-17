package com.github.verhage.echoserver.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.*;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author verhage
 */
@RestController
@RequestMapping(path = "/", produces = APPLICATION_JSON_VALUE)
public class EchoController {
    @GetMapping
    public ResponseEntity<Map<String, Object>> echo(@RequestBody(required = false) byte[] body,
                                                    HttpServletRequest request) throws UnknownHostException {
        Map<String, String> headers = new HashMap<>();
        Collections.list(request.getHeaderNames()).forEach(
                header -> headers.put(header, request.getHeader(header))
        );

        InetAddress server = InetAddress.getLocalHost();

        return ResponseEntity.ok(Map.of(
                "protocol", request.getProtocol(),
                "method", request.getMethod(),
                "headers", headers,
                "cookies", Arrays.toString(request.getCookies()),
                "parameters", request.getParameterMap(),
                "path", request.getServletPath(),
                "body", body != null ? Base64.getEncoder().encodeToString(body) : "",
                "server", server.toString()
        ));
    }
}
