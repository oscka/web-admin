package com.osckorea.openmsa.nexus.asset.common.service;

import java.net.URI;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.nexus.asset.common.feign.AssetDownloadFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetDownloadService {
    private final AssetDownloadFeignClient assetDownloadFeignClient;

    public ResponseEntity<Resource> downloadSpecificAsset(String assetDownloadUrl) {
        String[] splitAssetUrlString = assetDownloadUrl.split("/");

        String fileName = splitAssetUrlString[splitAssetUrlString.length - 1];

        ResponseEntity<byte[]> response = this.assetDownloadFeignClient.assetDownload(URI.create(assetDownloadUrl));

        HttpHeaders headers = new HttpHeaders();

        headers.setContentLength(response.getHeaders().getContentLength());
        headers.setContentType(response.getHeaders().getContentType());
        headers.setContentDispositionFormData("attachment; filename", fileName);

        return ResponseEntity.ok().headers(headers).body(new ByteArrayResource(response.getBody()));
    }
}
