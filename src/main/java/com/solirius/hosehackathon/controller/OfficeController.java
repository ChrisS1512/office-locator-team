package com.solirius.hosehackathon.controller;

import com.solirius.hosehackathon.models.Office;
import com.solirius.hosehackathon.models.OfficeDistance;
import com.solirius.hosehackathon.service.LocationService;
import com.solirius.hosehackathon.service.OfficeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;


@RestController
@Api(tags = "Offices API")
@RequestMapping("/offices")
public class OfficeController {

    @Autowired
    private OfficeService officeService;

    @Autowired
    private LocationService locationService;

    @ApiResponses({@ApiResponse(code = 200, message = "The nearest office string has been returned")})
    @ApiOperation("Find the nearest office to the supplied latitude and longitude along with the distance in either" +
            "miles or kilometres")
    @GetMapping("/find")
    public ResponseEntity<OfficeDistance> findNearestOffice(@RequestParam  double latitude,
                                                            @RequestParam double longitude,
                                                            @RequestParam(required=false) Boolean miles) {
        OfficeDistance outcome = locationService.calculateLocation(latitude, longitude);
        if (miles) {
            outcome.setOfficeDistance(outcome.getOfficeDistance() * 1.621371);
        }
        return ResponseEntity.ok(outcome);
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
    public ResponseEntity<List<Office>> addListOfOffices(@RequestPart MultipartFile officesCsv) throws IOException {
        return ResponseEntity.ok(officeService.addOfficeList(officesCsv));
    }
}
