package org.projectargus.argus_server.controller;

import org.projectargus.argus_server.tags.StreetTagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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
}
