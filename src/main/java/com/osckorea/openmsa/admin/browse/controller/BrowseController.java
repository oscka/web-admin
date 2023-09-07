package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeDto.Request;
import com.osckorea.openmsa.admin.browse.dto.BrowseTreeDto.Response;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto.ResponseDetail;
import com.osckorea.openmsa.admin.browse.service.BrowseService;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiRequestDto;
import com.osckorea.openmsa.admin.nexus.dto.external.ExternalApiResponseDto;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseController {
    private final BrowseService browseService;
    
    @GetMapping("repositories")
    public String browseRepositories(Model model) {
        ResponseDetail[] data1 = this.browseService.getResponseDetails();
        Object[] data = this.browseService.getRepositorySettings();

        model.addAttribute("repositoryList", data1);
        model.addAttribute("repositorySettingList", data);

        return "pages/browse/repositories/repositories";
    }

    @GetMapping("tree")
    public String browseRepositoryChildTree(Model model) {
        Request data = Request.builder().repositoryName("maven-central").node("ch").build();
        ExternalApiRequestDto<Request> requestData = ExternalApiRequestDto.<Request>builder()
                                                                            .action("coreui-Browse")
                                                                            .method("read")
                                                                            .data(new Request[] {data})
                                                                            .type("rpc")
                                                                            .tid(1)
                                                                            .build();

        ExternalApiResponseDto<Response> responseData = this.browseService.getBrowseTree(requestData);

        model.addAttribute("repositoryChildList", responseData);

        return "pages/browse/childTree/childTree";
    }

    /**
     * 단건의 저장소 삭제 요청을 처리하는 View Controller Method입니다.
     * 
     * @param repositoryName : 저장소 이름을 URL Query Parameter로 받아옵니다.
     * 
     * @return browse.html : 저장소 목록 리스트를 갱신해서 보여줍니다.
     */
    @GetMapping("/delete")
    public String deleteRepository(@RequestParam String repositoryName) {
        return "";
    }
}
