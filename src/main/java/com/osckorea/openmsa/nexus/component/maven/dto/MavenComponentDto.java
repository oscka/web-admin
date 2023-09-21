package com.osckorea.openmsa.nexus.component.maven.dto;

import java.util.List;
import java.util.stream.Stream;
import com.osckorea.openmsa.nexus.component.common.dto.ComponentDto;
import com.osckorea.openmsa.nexus.component.maven.domain.MavenAsset;
import com.osckorea.openmsa.nexus.component.maven.domain.MavenComponent;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MavenComponentDto extends ComponentDto{
    private MavenAssetDto[] assets;

    private String convertToPackageUrl(String group, String name, String version) {
        StringBuilder packageUrl = new StringBuilder("pkg:maven");

        packageUrl.append("/");
        packageUrl.append(group);
        packageUrl.append("/");
        packageUrl.append(name);
        packageUrl.append("@");
        packageUrl.append(version);

        return packageUrl.toString();
    }

    public MavenComponent toComponentEntity() {
        return MavenComponent.builder()
                                .componentId(this.getId())
                                .repositoryId(this.getRepository())
                                .groupId(this.getGroup())
                                .format(this.getFormat())
                                .name(this.getName())
                                .version(this.getVersion())
                                .packageUrl(convertToPackageUrl(this.getGroup(), this.getName(), this.getVersion()))
                                .build();
    }

    public List<MavenAsset> toAssetEntityList() {
        return Stream.of(this.assets).parallel().map(asset -> MavenAsset.builder()
                                                        .assetId(asset.getId())
                                                        .componentId(this.getId())
                                                        .repositoryId(asset.getRepository())
                                                        .downloadUrl(asset.getDownloadUrl())
                                                        .format(asset.getFormat())
                                                        .contentType(asset.getContentType())
                                                        .lastModifiedDate(asset.getLastModified())
                                                        .lastDownloadedDate(asset.getLastDownloaded())
                                                        .uploader(asset.getUploader())
                                                        .uploaderIp(asset.getUploaderIp())
                                                        .fileSize(asset.getFileSize())
                                                        .blobCreatedDate(asset.getBlobCreated())
                                                        .build()).toList();
    }
}
