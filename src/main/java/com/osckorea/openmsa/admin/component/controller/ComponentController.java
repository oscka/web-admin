package com.osckorea.openmsa.admin.component.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.admin.component.service.ComponentService;

import lombok.RequiredArgsConstructor;

@Tag(name = "Component API", description = "Nexus Component 관련 RESTful API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class ComponentController {
    private final ComponentService componentService;
    
    @GetMapping("components/list/{repositoryName}")
    public Object getComponentList(@PathVariable("repositoryName") String name) {
        return this.componentService.getComponentList(name);
    }

    @GetMapping("components/count/{repositoryName}")
    public Object getAmountOfComponent(@PathVariable("repositoryName") String name) {
        return this.componentService.countAmountOfComponent(name);
    }
}
