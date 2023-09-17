package com.osckorea.openmsa.admin.asset.service;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.asset.dto.AssetDto;
import com.osckorea.openmsa.admin.asset.feign.AssetFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class AssetService {
    private final AssetFeignClient assetFeignClient;

    public Object getAssetList(String name) {
        ArrayList<Object> assetItems = new ArrayList<Object>();

        // Initial Response
        AssetDto response = this.assetFeignClient.getAssetList(name);

        while(true) {
            Stream.of(response.getItems()).forEach(item -> assetItems.add(item));

            if(response.getContinuationToken() == null) {
                break;
            }

            response = this.assetFeignClient.getAssetList(response.getContinuationToken(), name);
        }

        return assetItems;
    }

    public Integer countAmountOfAsset(String name) {
        Integer count = 0;

        AssetDto response = this.assetFeignClient.getAssetList(name);

        while(true) {
            count += response.getItems().length;

            if(response.getContinuationToken() == null) {
                break;
            }

            response = this.assetFeignClient.getAssetList(response.getContinuationToken(), name);
        }

        return count;
    }
}
