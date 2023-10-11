package com.osckorea.openmsa.nexus.asset.maven.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

import com.osckorea.openmsa.nexus.asset.maven.dto.MavenAssetDto;
import com.osckorea.openmsa.nexus.asset.maven.dto.MavenAssetPagingDto;
import com.osckorea.openmsa.nexus.asset.maven.feign.MavenAssetFeignClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MavenAssetService {
    private final MavenAssetFeignClient mavenAssetFeignClient;

    public List<MavenAssetDto> getMavenAssetList(String name) {
        ArrayList<MavenAssetDto> assetList = new ArrayList<MavenAssetDto>();

        MavenAssetPagingDto response = this.mavenAssetFeignClient.getAssetList(name);

        do {
            for(MavenAssetDto item : response.getItems()) {
                assetList.add(item);
            }

            response = this.mavenAssetFeignClient.getAssetList(response.getContinuationToken(), name);
        } while (response.getContinuationToken() != null);

        return assetList;
    }

    public Integer getNumberOfMavenAsset(String name) {
        Integer count = 0;

        MavenAssetPagingDto response = this.mavenAssetFeignClient.getAssetList(name);

        do {
            count += response.getItems().length;
    
            response = this.mavenAssetFeignClient.getAssetList(response.getContinuationToken(), name);
        } while(response.getContinuationToken() != null);

        return count;
    }
}
