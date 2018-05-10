package org.projectargus.argus_server.controller;

import org.projectargus.argus_server.tags.StreetTagDto;
import org.projectargus.argus_server.tags.StreetTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ApiController {

    private StreetTagService streetTagService;

    @Autowired
    public ApiController(StreetTagService streetTagService) {
        this.streetTagService = streetTagService;
    }

    @GetMapping(path = "/api/get-private/{id}")
    public ResponseEntity getPrivateTags(@PathVariable Long id) {
        return ResponseEntity.ok(streetTagService.getPrivateTags(id));
    }

    @PostMapping(path = "/api/save-image", consumes = "application/json")
    public ResponseEntity saveNewTag(@RequestBody StreetTagDto streetTagDto) {
        System.out.println("running");
        System.out.println(streetTagDto.getUserName());
        System.out.println(streetTagDto.getImageData());
        streetTagService.savePic(streetTagDto);
        return ResponseEntity.ok("OK");
    }
}
