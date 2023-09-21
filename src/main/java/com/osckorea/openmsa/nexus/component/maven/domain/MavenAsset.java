package com.osckorea.openmsa.nexus.component.maven.domain;

import java.sql.Timestamp;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;

@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Table("maven2_asset")
public class MavenAsset implements Persistable<String> {
    @Id
    @Column("asset_id")
    private String assetId;

    @Column("component_id")
    private String componentId;

    @Column("repository_id")
    private String repositoryId;
    
    @Column("download_url")
    private String downloadUrl;

    @Column("format")
    private String format;

    @Column("content_type")
    private String contentType;

    @Column("last_modified_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp lastModifiedDate;

    @Column("last_downloaded_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp lastDownloadedDate;

    @Column("uploader")
    private String uploader;

    @Column("uploader_ip")
    private String uploaderIp;

    @Column("file_size")
    private Long fileSize;

    @Column("blob_created_date")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "Asia/Seoul")
    private Timestamp blobCreatedDate;

    @Setter
    @Transient
    @Builder.Default
    private boolean isNew = true;

    public String getId() {
        return this.assetId;
    }
}
