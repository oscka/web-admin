package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeDto.Request;
import com.osckorea.openmsa.admin.browse.service.BrowseService;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiRequestDto;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseRestController {
    // private final BrowseService browseService;

    // @GetMapping()
    // public Object[] getRepositorySettings() {
    //     return this.browseService.getRepositorySettings();
    // }
}