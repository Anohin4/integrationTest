package com.example.integrationtest.controller;

import com.example.integrationtest.webClient.WebClientImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    final
    WebClientImpl webClientImpl;

    public Controller(WebClientImpl webClientImpl) {
        this.webClientImpl = webClientImpl;
    }

    @GetMapping("/1")
    public ResponseEntity test() throws Exception{
        String URI = "https://www.themealdb.com/api/json/v1/1/random.php";
        return ResponseEntity
                .status(200)
                .body(webClientImpl.callApi(URI));
    }
}
