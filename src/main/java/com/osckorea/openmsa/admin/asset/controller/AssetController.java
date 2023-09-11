package com.osckorea.openmsa.admin.asset.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.asset.service.AssetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("asset")
@RequiredArgsConstructor
public class AssetController {
    private final AssetService assetService;

    @GetMapping("list/{repositoryName}")
    public Object getAssetList(@PathVariable("repositoryName") String name) {
        return this.assetService.getAssetList(name);
    }


    @GetMapping("count/{repositoryName}")
    public Integer getAmountOfAsset(@PathVariable("repositoryName") String name) {
        return this.assetService.countAmountOfAsset(name);
    }
}
