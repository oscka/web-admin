package com.osckorea.openmsa.admin.search.maven.service;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.search.maven.dto.MavenAssetDto;
import com.osckorea.openmsa.admin.search.maven.dto.MavenComponentDto;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenAssetDto;
import com.osckorea.openmsa.admin.search.maven.dto.SearchMavenComponentDto;
import com.osckorea.openmsa.admin.search.maven.feign.MavenSearchFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MavenSearchService {
    private final MavenSearchFeignClient mavenSearchFeignClient;

    public SearchMavenComponentDto searchMavenComponents(String name, String keyword) {
        ArrayList<MavenComponentDto> componentList = new ArrayList<MavenComponentDto>();

        SearchMavenComponentDto response = this.mavenSearchFeignClient.searchMavenComponents(null, "asc", name, keyword);

        while(true) {
            Stream.of(response.getItems()).forEach(item -> componentList.add(item));

            if(response.getContinuationToken() == null) {
                break;
            }

            response = this.mavenSearchFeignClient.searchMavenComponents(response.getContinuationToken(), "asc", name, keyword);
        }

        return response;
    }

    public SearchMavenAssetDto searchMavenAssets(String name, String keyword) {
        ArrayList<MavenAssetDto> componentList = new ArrayList<MavenAssetDto>();

        SearchMavenAssetDto response = this.mavenSearchFeignClient.searchMavenAssets(null, "asc", name, keyword);

        while(true) {
            Stream.of(response.getItems()).forEach(item -> componentList.add(item));

            if(response.getContinuationToken() == null) {
                break;
            }

            response = this.mavenSearchFeignClient.searchMavenAssets(response.getContinuationToken(), "asc", name, keyword);
        }

        return response;
    }
}
