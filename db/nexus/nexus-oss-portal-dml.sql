-- Maven2 - [Component / Asset / Vulnerability Report] Dummy Data DML
INSERT INTO maven2_component (
    component_id,
    repository_id,
    group_id,
    format,
    name,
    version,
    package_url
) VALUES (
    'Test_Component_Id_1',
    'maven-central',
    'com.example.group',
    'maven2',
    'example-component',
    '0.0.1',
    'pkg:maven/com.example.group/example-component@0.0.1'
);

INSERT INTO maven2_asset (
    asset_id,
    component_id,
    repository_id,
    download_url,
    format,
    content_type,
    last_modified_date,
    last_downloaded_date,
    uploader,
    uploader_ip,
    file_size,
    blob_created_date
) VALUES (
    'Test_Asset_Id_1',
    'Test_Component_Id_1',
    'maven-central',
    'http://example.com',
    'maven2',
    'application/xml',
    '2023-09-13T01:45:31.535+00:00',
    '2023-09-13T01:45:31.535+00:00',
    'ray',
    '127.0.0.1',
    4148,
    '2023-09-13T01:45:31.535+00:00'
);

INSERT INTO maven2_vulnerability_header (
    component_package_url,
    component_description,
    component_reference_url,
    vulnerability_critical_count,
    vulnerability_severe_count,
    vulnerability_moderate_count,
    last_modified_date
) VALUES (
    'Test_Component_Id_1',
    'DESCRIPTION',
    'REFERENCE_URL',
    1,
    2,
    3,
    '2023-09-13T01:45:31.535+00:00'
);

INSERT INTO maven2_vulnerability_detail (
    component_package_url,
    id,
    display_name,
    title,
    description,
    cvss_score,
    cvss_vector,
    cwe,
    cve,
    reference_url,
    external_references_url
) VALUES (
    'Test_Component_Id_1',
    'Test_Vulnerability_Report_Id_1',
    'Test_Vulnerability_Report_Display_Name',
    '[CVE-20xx-xx] CWE-xxx: Deserialization of Untrusted Data',
    'Test Vulnerability Report Descroption, This Column Display Recommand Data to User',
    9.6,
    'CVSS:3.1/DA:DS:D:EQ',
    'CWE-xxx',
    'CVE-20xx-xx',
    'https://ossindex.sonatype.org/vulnerability/CWE-xxx?component-type=maven&component-name=example-component-name...',
    '{
        http://example.external.reference.url1,
        http://example.external.reference.url2
    }'
);