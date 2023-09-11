package com.osckorea.openmsa.admin.browse.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.osckorea.openmsa.admin.nexus.dto.repository.GroupDto;
import com.osckorea.openmsa.admin.nexus.dto.repository.maven.MavenHostedDto;
import com.osckorea.openmsa.admin.nexus.dto.repository.maven.MavenProxyDto;
import com.osckorea.openmsa.admin.nexus.feign.repository.NexusRepositoryPublicFeignClient;
import com.osckorea.openmsa.admin.nexus.feign.repository.maven.NexusMavenRepositoryPublicFeignClient;
import com.osckorea.openmsa.global.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BrowsePublicService {
    private final NexusRepositoryPublicFeignClient nexusRepositoryPublicFeignClient;
    private final NexusMavenRepositoryPublicFeignClient nexusMavenRepositoryPublicFeignClient;

    // Find
    public GroupDto.Response getGroupRepository(String format, String name) {
        switch(format) {
            case "maven2":
                return this.getMavenGroupRepository(name);
            case "npm":
                return null;
            default:
                return null;
        }
    }

    public Object getHostedRepository(String format, String name) {
        switch(format) {
            case "maven2":
                return this.getMavenHostedRepository(name);
            case "npm":
                return null;
            default:
                return null;
        }
    }

    public Object getProxyRepository(String format, String name) {
        switch(format) {
            case "maven2":
                return this.getMavenProxyRepository(name);
            case "npm":
                return null;
            default:
                return null;
        }
    }
    
    // Create
    public Integer createGroupRepository(String format, GroupDto.Request data) {
        switch(format) {
            case "maven2":
                return this.createMavenGroupRepository(data);
            default:
                return null;
        }
    }

    public Integer createHostedRepository(String format, Object data) {
        switch(format) {
            case "maven2":
                return this.createMavenHostedRepository(JsonUtil.convertValue(data, MavenHostedDto.Request.class));
            default:
                return null;
        }
    }

    public Integer createProxyRepository(String format, Object data) {
        switch(format) {
            case "maven2":
                return this.createMavenProxyRepository(JsonUtil.convertValue(data, MavenProxyDto.Request.class));
            default:
                return null;
        }
    }

    // Update
    public Integer updateGroupRepository(String format, String name, GroupDto.Request data) {
        switch(format) {
            case "maven2":
                return this.updateMavenGroupRepository(name, data);
            default:
                return null;
        }
    }

    public Integer updateHostedRepository(String format, String name, Object data) {
        switch(format) {
            case "maven2":
                return this.updateMavenHostedRepository(name, (MavenHostedDto.Request) data);
            default:
                return null;
        }
    }

    public Integer updateProxyRepository(String format, String name, Object data) {
        switch(format) {
            case "maven2":
                return this.updateMavenProxyRepository(name, (MavenProxyDto.Request) data);
            default:
                return null;
        }
    }

    // Delete
    public Integer deleteSpecificRepository(String name) {
        return this.nexusRepositoryPublicFeignClient.deleteRepository(name).getStatusCodeValue();
    }

    // Logics
    private GroupDto.Response getMavenGroupRepository(String name) {
        ResponseEntity<GroupDto.Response> reponse = this.nexusMavenRepositoryPublicFeignClient.getMavenGroupRepository(name);

        if(reponse.getStatusCodeValue() == 200) {
            return reponse.getBody();
        }
        
        return null;
    }

    private Integer createMavenGroupRepository(GroupDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.createMavenGroupRepository(data).getStatusCodeValue();
    }

    private Integer updateMavenGroupRepository(String name, GroupDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.updateMavenGroupRepository(name, data).getStatusCodeValue();
    }

    private MavenHostedDto.Response getMavenHostedRepository(String name) {
        ResponseEntity<MavenHostedDto.Response> reponse = this.nexusMavenRepositoryPublicFeignClient.getMavenHostedRepository(name);

        if(reponse.getStatusCodeValue() == 200) {
            return reponse.getBody();
        }
        
        return null;
    }

    private Integer createMavenHostedRepository(MavenHostedDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.createMavenHostedRepository(data).getStatusCodeValue();
    }

    private Integer updateMavenHostedRepository(String name, MavenHostedDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.updateMavenHostedRepository(name, data).getStatusCodeValue();
    }

    private MavenProxyDto.Response getMavenProxyRepository(String name) {
        ResponseEntity<MavenProxyDto.Response> reponse = this.nexusMavenRepositoryPublicFeignClient.getMavenProxyRepository(name);

        if(reponse.getStatusCodeValue() == 200) {
            return reponse.getBody();
        }
        
        return null;
    }

    private Integer createMavenProxyRepository(MavenProxyDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.createMavenProxyRepository(data).getStatusCodeValue();
    }

    private Integer updateMavenProxyRepository(String name, MavenProxyDto.Request data) {
        return this.nexusMavenRepositoryPublicFeignClient.updateMavenProxyRepository(name, data).getStatusCodeValue();
    }
}
