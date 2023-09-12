package com.osckorea.openmsa.admin.browse.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.osckorea.openmsa.admin.browse.service.BrowseExternalService;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("browse")
@RequiredArgsConstructor
public class BrowseViewController {
    private final BrowseExternalService browseExternalService;

    @GetMapping("nodes")
    public String browseTree(
        @RequestParam(value = "repositoryName", required = false) String repositoryName,
        @RequestParam(value = "nodeId", required = false) String nodeId,
        Model model
    ) {
        // if(repositoryName == null && nodeId == null) {
        //     model.addAttribute("repositoryList", this.browseExternalService.getRepositoryReferences());
        // } else if(repositoryName != null && nodeId != null) {
        //     model.addAttribute("repositoryName", repositoryName);
        //     model.addAttribute("browseNode", this.browseExternalService.getBrowseTreeNodes(repositoryName, nodeId));
        // }

        return "pages/browse/child/child";
    }
}
