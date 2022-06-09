package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.service.OfficeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "Offices API")
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @ApiResponses({@ApiResponse(code = 200, message = "The nearest office string has been returned")})
    @ApiOperation("Find the nearest office to the supplied latitude and longitude")
    @GetMapping("/find")
    public ResponseEntity<String> findNearestOffice() {
        return ResponseEntity.ok("Find nearest office");
    }

    @ApiResponses({@ApiResponse(code = 200, message = "A message confirming the status of adding the location")})
    @ApiOperation("Add a single office location")
    @PostMapping("/add/single")
    public ResponseEntity<String> addOffice(@RequestBody Office office) {
        return ResponseEntity.ok(officeService.addSingleOffice(office));
    }

    @ApiResponses({@ApiResponse(code = 200, message = "A message confirming the status of adding the list of locations")})
    @ApiOperation("Add a list of office locations")
    @PostMapping("/add/list")
    public ResponseEntity<String> addListOfOffices() {
        return ResponseEntity.ok("Add list of offices");
    }
}
