package com.osckorea.openmsa.admin.repository.common.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Schema(description = "저장소 상태 DTO")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class RepositoryHealthCheckDto {
    private String repositoryName;
    private Boolean enabled;
    private Boolean eulaAccepted;
    private Boolean analyzing;
    private Boolean detailedReportSupported;
    private Integer iframeHeight;
    private Integer iframeWidth;
    private Integer securityIssueCount;
    private Integer licenseIssueCount;
    private String summaryUrl;
    private Object detailUrl;
    private Object totalCounts;
    private Object vulnerableCounts;
}
