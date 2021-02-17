package com.coverter.gregdate.rest;

import com.coverter.gregdate.model.HebrewDate;
import com.coverter.gregdate.service.ConvertService;
import com.mashape.unirest.http.exceptions.UnirestException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("api/")
@CrossOrigin(origins = "*", allowedHeaders = "*")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class GregDateController {
    private ConvertService convertService;

    @PostMapping(value = "{gy}/{gm}/{gd}")
    public ResponseEntity<HebrewDate> convertGregToJew(@PathVariable int gy, @PathVariable int gm,
                                                       @PathVariable int gd) throws UnirestException {
        return ResponseEntity.ok(new HebrewDate(convertService.gregToHebrew(gy, gm, gd)));
    }
}


