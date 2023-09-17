
-- Maven2 - [ Component / Asset / Vulnerability Report ] Tables DDL

-- Drop Tables & Data Types
DROP TABLE IF EXISTS maven2_component;
DROP TABLE IF EXISTS maven2_asset;
DROP TABLE IF EXISTS maven2_vulnerability_header;
DROP TABLE IF EXISTS maven2_vulnerability_detail;

-- Create Table & Data Types
CREATE TABLE IF NOT EXISTS maven2_component(
    component_id                VARCHAR  NOT NULL,
    repository_id               VARCHAR  NOT NULL,
    group_id                    VARCHAR  NOT NULL,
    format                      VARCHAR  NOT NULL DEFAULT 'maven2',
    name                        VARCHAR  NOT NULL,
    version                     VARCHAR  NOT NULL,
    package_url                 VARCHAR  NOT NULL,
    vulnerbility_critical_count INT      NOT NULL DEFAULT 0,
    vulnerbility_severe_count   INT      NOT NULL DEFAULT 0,
    vulnerbility_moderate_count INT      NOT NULL DEFAULT 0
    -- CONSTRAINT PK_MAVEN_COMP_ID PRIMARY KEY(component_id)
);

CREATE TABLE IF NOT EXISTS maven2_asset(
    asset_id                VARCHAR     NOT NULL, 
    component_id            VARCHAR     NOT NULL,
    repository_id           VARCHAR     NOT NULL,
    download_url            VARCHAR     NOT NULL,
    format                  VARCHAR     NOT NULL DEFAULT 'maven2',
    content_type            VARCHAR     NOT NULL,
    last_modified_date      TIMESTAMP   NOT NULL,
    last_downloaded_date    TIMESTAMP   NULL,
    uploader                VARCHAR     NOT NULL,
    uploader_ip             CIDR        NOT NULL,
    file_size               INT8        NOT NULL,
    blob_created_date       TIMESTAMP   NULL
    -- CONSTRAINT PK_MAVEN_ASSET_ID PRIMARY KEY(asset_id)
);

-- Maven 2 Vulnerability Report Detail Table
CREATE TABLE IF NOT EXISTS maven2_vulnerability_detail(
    component_package_url   VARCHAR         NOT NULL,
    id                      VARCHAR         NOT NULL,
    display_name            VARCHAR         NOT NULL,
    title                   VARCHAR         NOT NULL,
    description             VARCHAR         NOT NULL,
    cvss_score              DECIMAL(2,1)    NOT NULL,
    cvss_vector             VARCHAR         NOT NULL,
    cwe                     VARCHAR         NOT NULL,
    cve                     VARCHAR         NOT NULL,
    reference_url           VARCHAR         NOT NULL,
    external_references_url VARCHAR[]       NULL,
    CONSTRAINT PK_MAVEN_VULNERABILITY_DETAIL PRIMARY KEY(component_package_url, id)
);

-- Maven 2 Vulnerability Report Header Table
CREATE TABLE IF NOT EXISTS maven2_vulnerability_header(
    component_package_url        VARCHAR     NOT NULL,
    component_description        VARCHAR     NOT NULL,
    component_reference_url      VARCHAR     NOT NULL,
    vulnerability_critical_count INT         NOT NULL,
    vulnerability_severe_count   INT         NOT NULL,
    vulnerability_moderate_count INT         NOT NULL,
    last_modified_date           TIMESTAMP   NOT NULL    DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT PK_MAVEN_VULNERABILITY_HEADER PRIMARY KEY(component_package_url)
);