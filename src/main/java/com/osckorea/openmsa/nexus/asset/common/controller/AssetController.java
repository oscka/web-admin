package com.osckorea.openmsa.nexus.asset.common.controller;

import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.nexus.asset.common.service.AssetDownloadService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("v1")
@RequiredArgsConstructor
public class AssetController {
    private final AssetDownloadService assetDownloadService;

    @GetMapping(value = "assets/download", params = {"url"}, produces = MediaType.APPLICATION_OCTET_STREAM_VALUE)
    public ResponseEntity<Resource> downloadSpecificAsset(@RequestParam("url") String url) {
        return this.assetDownloadService.downloadSpecificAsset(url);
    }
}
