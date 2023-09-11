package com.osckorea.openmsa.admin.component.service;

import java.util.ArrayList;
import java.util.stream.Stream;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.nexus.dto.component.ComponentDto;
import com.osckorea.openmsa.admin.nexus.feign.component.NexusComponentPublicFeignClient;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ComponentService {
    private final NexusComponentPublicFeignClient nexusComponentPublicFeignClient;

    public Object getComponentList(String name) {
        ArrayList<Object> componentItems = new ArrayList<Object>();

        ComponentDto response = this.nexusComponentPublicFeignClient.getComponentList(name);

        String token = response.getContinuationToken();

        Stream.of(response.getItems()).forEach(item -> componentItems.add(item));

        while(true) {
            response = this.nexusComponentPublicFeignClient.getComponentList(token, name);
            token = response.getContinuationToken();

            Stream.of(response.getItems()).forEach(item -> componentItems.add(item));

            if(token == null) {
                break;
            }
        }

        return componentItems;
    }

    // public Object getComponentList(String name) {
    //     ArrayList<Object> componentItems = new ArrayList<Object>();

    //     ComponentDto response = this.nexusComponentPublicFeignClient.getComponentList(name);

    //     Object[] items = response.getItems();
    //     String token = response.getContinuationToken();

    //     for(Object item : items) {
    //         componentItems.add(item);
    //     }

    //     while(true) {
    //         response = this.nexusComponentPublicFeignClient.getComponentList(token, name);
    //         items = response.getItems();
    //         token = response.getContinuationToken();

    //         for(Object item : items) {
    //             componentItems.add(item);
    //         }

    //         if(token == null) {
    //             break;
    //         }
    //     }

    //     return componentItems;
    // }

    public Integer countAmountOfComponent(String name) {
        Integer count = 0;

        ComponentDto response = this.nexusComponentPublicFeignClient.getComponentList(name);

        String token = response.getContinuationToken();
        count += response.getItems().length;

        while(true) {
            response = this.nexusComponentPublicFeignClient.getComponentList(token, name);

            token = response.getContinuationToken();
            count += response.getItems().length;

            if(token == null) {
                break;
            }
        }
        
        return count;
    }
}
