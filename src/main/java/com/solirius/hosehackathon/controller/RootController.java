package com.solirius.hosehackathon.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Api(tags = "Root API")
@RequestMapping
public class RootController {

    @ApiResponses({@ApiResponse(code = 200, message = "Welcome to the office locator service")})
    @ApiOperation("Root endpoint")
    @GetMapping
    public ResponseEntity<String> sendWelcomeMessage() {
        return ResponseEntity.ok("Welcome to the office locator service");
    }

}
