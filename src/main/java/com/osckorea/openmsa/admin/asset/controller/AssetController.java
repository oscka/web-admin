package com.osckorea.openmsa.admin.asset.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.tags.Tag;

import com.osckorea.openmsa.admin.asset.service.AssetService;

import lombok.RequiredArgsConstructor;

@Tag(name = "Asset API", description = "Nexus Asset 관련 RESTful API")
@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @GetMapping("assets/list/{repositoryName}")
    public Object getAssetList(@PathVariable("repositoryName") String name) {
        return this.assetService.getAssetList(name);
    }


    @GetMapping("assets/count/{repositoryName}")
    public Integer getAmountOfAsset(@PathVariable("repositoryName") String name) {
        return this.assetService.countAmountOfAsset(name);
    }
}
