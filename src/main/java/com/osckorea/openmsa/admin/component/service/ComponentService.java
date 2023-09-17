package com.osckorea.openmsa.admin.component.service;

import java.util.ArrayList;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.component.dto.ComponentApiDto;
import com.osckorea.openmsa.admin.component.dto.ComponentPagingDto;
import com.osckorea.openmsa.admin.component.feign.ComponentFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponentService {
    private final ComponentFeignClient componentFeignClient;

    public ComponentApiDto[] getComponentList(String name) {
        ArrayList<ComponentApiDto> componentList = new ArrayList<ComponentApiDto>();

        ComponentPagingDto response = this.componentFeignClient.getComponentList(name);

        while(response.getContinuationToken() != null) {
            for(ComponentApiDto item : response.getItems()) {
                componentList.add(item);
            }

            response = this.componentFeignClient.getComponentList(response.getContinuationToken(), name);
        }

        return componentList.toArray(ComponentApiDto[]::new);
    }

    public Integer countAmountOfComponent(String name) {
        Integer count = 0;

        ComponentPagingDto response = this.componentFeignClient.getComponentList(name);

        while(response.getContinuationToken() != null) {
            count += response.getItems().length;

            response = this.componentFeignClient.getComponentList(response.getContinuationToken(), name);
        }

        return count;
    }
}
