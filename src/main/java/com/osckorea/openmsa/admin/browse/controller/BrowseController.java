package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.browse.dto.RepositoryDto.ResponseDetail;
import com.osckorea.openmsa.admin.browse.service.BrowseService;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseController {
    private final BrowseService browseService;
    
    @GetMapping("repositories")
    public String browseRepositories(Model model) {
        ResponseDetail[] data1 = this.browseService.getRepositoriesDetail();
        Object[] data = this.browseService.getRepositorySettings();

        model.addAttribute("repositoryList", data1);
        model.addAttribute("repositorySettingList", data);

        return "pages/browse/repositories/repositories";
    }

    @GetMapping("tree")
    public String browseTree(
        @RequestParam(value = "repositoryName", required = false) String repositoryName,
        @RequestParam(value = "nodeId", required = false) String nodeId,
        Model model
    ) {
        if(repositoryName == null && nodeId == null) {
            model.addAttribute("repositories", this.browseService.getRepositories());
        } else if(repositoryName != null && nodeId != null){
            model.addAttribute("repository", repositoryName);
            model.addAttribute("browse", this.browseService.getBrowseTreeData(repositoryName, nodeId));
        }

        return "pages/browse/child/child";
    }
}
