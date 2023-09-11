package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.osckorea.openmsa.admin.browse.service.BrowseExternalService;
import com.osckorea.openmsa.admin.browse.service.BrowsePublicService;
import com.osckorea.openmsa.admin.nexus.dto.repository.GroupDto;
import com.osckorea.openmsa.global.util.JsonUtil;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseRestController {
    private final BrowsePublicService browsePublicService;
    private final BrowseExternalService browseExternalService;

    /**
     * 모든 저장소 정보를 조회합니다.
     * 
     * @return 모든 저장소의 정보
     */
    @GetMapping("repository/all")
    public Object getRepositories() {
        return this.browseExternalService.getRepositoryReferences();
    }
    
    /**
     * 특정 저장소의 하위 노드들을 조회합니다.
     * 
     * @param repositoryName : 대상 저장소 이름
     * @param nodeId : 상위 노드 경로
     * 
     * @return 노드 목록
     */
    @GetMapping("repository/nodes")
    public Object getNodes(
        @RequestParam(value = "name", required = false) String repositoryName,
        @RequestParam(value = "node", required = false) String nodeId
    ) {
        if(repositoryName != null && nodeId != null) {
            return this.browseExternalService.getBrowseTreeNodes(repositoryName, nodeId);
        }

        return null;
    }

    /**
     * 특정 저장소에 대한 설정 정보를 조회합니다.
     * 
     * @param format : 저장소의 format입니다. EX) maven2
     * @param type : 저장소의 type입니다. EX) hosted
     * @param name : 저장소의 이름입니다. EX) maven-central
     * 
     * @return 특정 저장소의 설정 정보를 반환합니다.
     * @exception 500
     */
    @GetMapping("repository/{format}/{type}/{name}")
    public Object getRepositorySetting(
        @PathVariable("format") String format,
        @PathVariable("type") String type,
        @PathVariable("name") String name
    ) {
        switch(type) {
            case "group":
                return this.browsePublicService.getGroupRepository(format, name);
            case "hosted":
                return this.browsePublicService.getHostedRepository(format, name);
            case "proxy":
                return this.browsePublicService.getProxyRepository(format, name);
            default:
                return 500;
        }
    }

    /**
     * 새로운 저장소 정보를 저장합니다.
     * 
     * @param format : 저장소의 format입니다. EX) maven2
     * @param type : 저장소의 type입니다. EX) proxy
     * @param data : 새로운 저장소의 등록 될 설정 정보입니다.
     * 
     * @return HttpStatusCode
     * @exception 500
     */
    @PostMapping("repository/{format}/{type}")
    public Integer createRepository(
        @PathVariable("format") String format,
        @PathVariable("type") String type,
        @RequestBody Object data
    ) {
        switch(type) {
            case "group":
                return this.browsePublicService.createGroupRepository(format, JsonUtil.convertValue(data, GroupDto.Request.class));
            case "hosted":
                return this.browsePublicService.createHostedRepository(format, data);
            case "proxy":
                return this.browsePublicService.createProxyRepository(format, data);
            default:
                return 500;
        }
    }

    /**
     * 기존의 저장소 설정 정보를 갱신합니다.
     * 
     * @param format : 저장소의 format입니다. EX) maven2
     * @param type : 저장소의 type입니다. EX) proxy
     * @param name : 대상 저장소의 이름입니다. EX) maven-central
     * @param data : 갱신시킬 저장소 설정 정보입니다.
     * 
     * @return HttpStatusCode
     * @exception 500
     */
    @PutMapping("repository/{format}/{type}/{name}")
    public Integer updateRepository(
        @PathVariable("format") String format,
        @PathVariable("type") String type,
        @PathVariable("name") String name,
        @RequestBody Object data
    ) {
        switch(type) {
            case "group":
                return this.browsePublicService.updateGroupRepository(format, name, JsonUtil.convertValue(data, GroupDto.Request.class));
            case "hosted":
                return this.browsePublicService.updateHostedRepository(format, name, data);
            case "proxy":
                return this.browsePublicService.updateProxyRepository(format, name, data);
            default:
                return 500;
        }
    }

    /**
     * 기존에 존재하는 특정 저장소를 삭제합니다.
     * @param name : 삭제하려는 대상 저상소 이름입니다. EX) maven-central
     * 
     * @return HttpStatusCode 
     */
    @DeleteMapping("repository/{name}")
    public Integer deleteRepository(@PathVariable("name") String name) {
        return this.browsePublicService.deleteSpecificRepository(name);
    }
}
