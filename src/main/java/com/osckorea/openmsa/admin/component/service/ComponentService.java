package com.osckorea.openmsa.admin.component.service;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.component.dto.ComponentDto;
import com.osckorea.openmsa.admin.component.feign.ComponentFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ComponentService {
    private final ComponentFeignClient componentFeignClient;

    public Object getComponentList(String name) {
        ArrayList<Object> componentItems = new ArrayList<Object>();

        ComponentDto response = this.componentFeignClient.getComponentList(name);

        while(true) {
            Stream.of(response.getItems()).forEach(item -> componentItems.add(item));

            if(response.getContinuationToken() == null) {
                break;
            }

            response = this.componentFeignClient.getComponentList(response.getContinuationToken(), name);
        }

        return componentItems;
    }

    public Integer countAmountOfComponent(String name) {
        Integer count = 0;

        ComponentDto response = this.componentFeignClient.getComponentList(name);

        while(true) {
            count += response.getItems().length;

            if(response.getContinuationToken() == null) {
                break;
            }

            log.info(String.valueOf(count));

            response = this.componentFeignClient.getComponentList(response.getContinuationToken(), name);
        }
        
        return count;
    }
}
