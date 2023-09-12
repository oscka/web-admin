package com.osckorea.openmsa.admin.repository.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import com.osckorea.openmsa.admin.repository.common.dto.RepositoryDto;
import com.osckorea.openmsa.admin.repository.common.service.RepositoryExternalService;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class RepositoryViewController {
    private final RepositoryExternalService repositoryExternalService;

    @GetMapping("repositories")
    public String viewRepositories(Model model) {
        RepositoryDto.Response[] repositories = this.repositoryExternalService.getRepositoryReferences();

        model.addAttribute("repositoryList", repositories);

        return "pages/browse/repositories/repositories";
    }
}
