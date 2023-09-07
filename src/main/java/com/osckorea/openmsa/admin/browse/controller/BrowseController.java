package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto;
import com.osckorea.openmsa.admin.browse.service.BrowseService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseController {
    private final BrowseService browseService;
    
    // @GetMapping("repositories")
    // public String browseRepositories(Model model) {
    //     RepositoryDto.ResponseDetail[] data1 = this.browseService.getResponseDetails();
    //     Object[] data = this.browseService.getRepositorySettings();

    //     model.addAttribute("repositoryList", data1);
    //     model.addAttribute("repositorySettingList", data);

    //     return "pages/browse/browse";
    // }

    // @GetMapping("")
    // public String browseRepository(Model model) {
    //     return "";
    // }

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
