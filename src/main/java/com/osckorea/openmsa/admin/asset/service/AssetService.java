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

        String token = response.getContinuationToken();

        Stream.of(response.getItems()).forEach(item -> assetItems.add(item));

        while(true) {
            response = this.assetFeignClient.getAssetList(token, name);
            token = response.getContinuationToken();

            Stream.of(response.getItems()).forEach(item -> assetItems.add(item));

            if(token == null) {
                break;
            }
        }

        return assetItems;
    }

    public Integer countAmountOfAsset(String name) {
        Integer count = 0;

        AssetDto response = this.assetFeignClient.getAssetList(name);

        String token = response.getContinuationToken();
        count += response.getItems().length;

        while(true) {
            response = this.assetFeignClient.getAssetList(token, name);
            
            token = response.getContinuationToken();
            count += response.getItems().length;

            if(token == null) {
                break;
            }
        }

        return count;
    }
}
