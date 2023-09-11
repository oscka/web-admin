package com.osckorea.openmsa.admin.component.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.component.service.ComponentService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("component")
@RequiredArgsConstructor
public class ComponentController {
    private final ComponentService componentService;
    
    @GetMapping("list/{repositoryName}")
    public Object getComponentList(@PathVariable("repositoryName") String name) {
        return this.componentService.getComponentList(name);
    }

    @GetMapping("count/{repositoryName}")
    public Object getAmountOfComponent(@PathVariable("repositoryName") String name) {
        return this.componentService.countAmountOfComponent(name);
    }
}
