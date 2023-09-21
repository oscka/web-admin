package com.osckorea.openmsa.nexus.component.maven.service;

import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.osckorea.openmsa.nexus.component.maven.dto.MavenComponentDto;
import com.osckorea.openmsa.nexus.component.maven.dto.MavenComponentPagingDto;
import com.osckorea.openmsa.nexus.component.maven.feign.MavenComponentFeignClient;
import com.osckorea.openmsa.nexus.component.maven.repository.MavenAssetRepository;
import com.osckorea.openmsa.nexus.component.maven.repository.MavenComponentRepository;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MavenComponentService {
    private final MavenComponentFeignClient mavenComponentFeignClient;
    private final MavenComponentRepository mavenComponentRepository;
    private final MavenAssetRepository mavenAssetRepository;

    @Transactional
    public List<MavenComponentDto> getMavenComponentList(String name) {
        ArrayList<MavenComponentDto> componentList = new ArrayList<MavenComponentDto>();

        MavenComponentPagingDto response = this.mavenComponentFeignClient.getComponentList(name);

        while (response.getContinuationToken() != null) {
            for(MavenComponentDto item : response.getItems()) {
                componentList.add(item);

                if(!this.mavenComponentRepository.findById(item.getId()).isPresent() ) {
                    this.mavenComponentRepository.save(item.toComponentEntity());

                    this.mavenAssetRepository.saveAll(item.toAssetEntityList());
                }
            }

            response = this.mavenComponentFeignClient.getComponentList(response.getContinuationToken(), name);
        }

        return componentList;
    }

    public Integer getNumberOfMavenComponent(String name) {
        Integer count = 0;

        MavenComponentPagingDto response = this.mavenComponentFeignClient.getComponentList(name);

        while (response.getContinuationToken() != null) {
            count += response.getItems().length;

            response = this.mavenComponentFeignClient.getComponentList(response.getContinuationToken(), name);
        }

        return count;
    }
}
