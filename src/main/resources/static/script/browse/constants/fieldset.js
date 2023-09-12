export const fieldset_default_info = `
        <legend><b>기본정보</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="repo-name" class="col-sm-2 col-form-label"><b>Name</b></label>
            <div class="col-sm-10">
                <input id="repo-name" class="form-control" type="text" value="Readonly input here..." aria-label="readonly input example" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-format" class="col-sm-2 col-form-label"><b>Format</b></label>
            <div class="col-sm-10">
                <input id="repo-format" class="form-control" type="text" value="Readonly input here..." aria-label="readonly input example" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-type" class="col-sm-2 col-form-label"><b>Type</b></label>
            <div class="col-sm-10">
                <input id="repo-type" class="form-control" type="text" value="Readonly input here..." aria-label="readonly input example" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-url" class="col-sm-2 col-form-label"><b>URL</b></label>
            <div class="col-sm-10">
                <input id="repo-url" class="form-control" type="text" value="Readonly input here..." aria-label="readonly input example" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-online" class="col-sm-2 col-form-label"><b>Online</b></label>
            <div class="col-sm-10 mt-2">
                <div class="d-flex align-items-center form-check form-switch">
                    <input id="repo-online" class="form-check-input" type="checkbox" role="switch" checked disabled>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="components" class="col-sm-2 mt-1"><b>Component 수</b></label>
            <div class="col-sm-10">
                <input id="components" class="form-control" type="text" value="1024">
            </div>
        </div>
        <div class="row mb-3">
            <label for="assets" class="col-sm-2 mt-1"><b>Asset 수</b></label>
            <div class="col-sm-10">
                <input id="assets" class="form-control" type="text" value="1024">
            </div>
        </div>
`

export const fieldset_proxy = `
        <legend><b>Proxy 정보</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="repo-remote-storage" class="col-sm-3 mt-1" text-truncate><b>Remote storage</b></label>
            <div class="col-sm-9">
                <input id="repo-remote-starge" class="form-control" type="text">
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-blocked" class="col-sm-3 mt-1"><b>Blocked</b></label>
            <div class="col-sm-9">
                <div class="d-flex align-items-center form-check form-switch">
                    <input id="repo-blocked" class="form-check-input" type="checkbox" role="switch" checked disabled>
                    <label for="repo-blocked">저장소의 외부 연결을 차단합니다.</label>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-auto-blocking-enabled" class="col-sm-3 mt-1"><b>Auto blocking enabled</b></label>
            <div class="col-sm-9">
                <div class="d-flex align-items-center form-check form-switch">
                    <input id="repo-auto-blocking-enabled" class="form-check-input" type="checkbox" role="switch" checked disabled>
                    <label for="repo-auto-blocking-enabled">원격 저장소가 반응이 없거나 도달 할 수 없는 경우, 외부 연결을 자동적으로 차단합니다.</label>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-maximum-component-age" class="col-sm-3 mt-1"><b>Maximum component age</b></label>
            <div class="col-sm-9">
                <input id="repo-maximum-component-age" class="form-control" type="number">
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-maximum-metadata-age" class="col-sm-3 mt-1"><b>Maximum metadata age</b></label>
            <div class="col-sm-9">
                <input id="repo-maximum-metadata-age" class="form-control" type="number">
            </div>
        </div>
`

export const fieldset_storage = `
        <legend><b>Storage 정보</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="repo-blobstore" class="col-sm-4 mt-1"><b>Blob store</b></label>
            <div class="col-sm-8">
                <input id="repo-blobstore" class="form-control" type="text" value="default" aria-label="readonly input example" readonly>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-strict-content-type-validation" class="col-sm-4 mt-1"><b>Strict Content Type Validation</b></label>
            <div class="col-sm-8">
                <div class="d-flex align-items-center form-check form-switch">
                    <input id="repo-strict-content-type-validation" class="form-check-input" type="checkbox" role="switch" checked disabled>
                    <label for="repo-strict-content-type-validation">
                        업로드 되는 모든 컨텐츠가 알맞는 형태로 되어있는지 유효성을 검사합니다.
                    </label>
                </div>
            </div>
        </div>
`

export const fieldset_group = `
        <legend><b>Group</b></legend>
        <hr>
        <div id="group-field" class="mb-3">

        </div>
`

export const fieldset_hosted = `
        <legend><b>Hosted</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="deployment-policy" class="col-sm-3 mt-1" text-truncate><b>Remote storage</b></label>
            <div class="col-sm-9">
                <input id="deployment-policy" class="form-control" type="text">
            </div>
        </div>
        <div class="row mb-3">
            <label for="proprietary-components" class="col-sm-3 mt-1" text-truncate><b>Remote storage</b></label>
            <div class="col-sm-9">
                <input id="proprietary-components" class="form-control" type="text">
            </div>
        </div>
`

export const fieldset_http = `
        <legend><b>HTTP</b></legend>
        <hr>
        <div id="http-field" class="mb-3">

        </div>
`

export const fieldset_cleanup = `
        <legend><b>Cleanup</b></legend>
        <hr>
        <div id="cleanup-field" class="mb-3">

        </div>
`

export const fieldset_routing_rule = `
        <legend><b>Routing Rule 정보</b></legend>
        <hr>
        <select class="form-select" aria-label="Default select example">
            <option selected>None</option>
        </select>
`

export const fieldset_negative_cache = `
        <legend><b>Negative Cache 정보</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="repo-not-found-cache-enabled" class="col-sm-3 mt-1"><b>Not found cache enabled</b></label>
            <div class="col-sm-9">
                <div class="d-flex align-items-center form-check form-switch">
                    <input id="repo-not-found-cache-enabled" class="form-check-input" type="checkbox" role="switch" checked disabled>
                    <label for="repo-not-found-cache-enabled">데이터가 캐싱되어있지 않는 경우, 프록시 된 저장소에서 가져옵니다.</label>
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="repo-not-found-cache-ttl" class="col-sm-3 mt-1"><dt>Not found cache TTL</dt></label>
            <dd class="col-sm-9">
                <input id="repo-not-found-cache-ttl" class="form-control" type="number">
            </dd>
        </div>
`

export const fieldset_maven2 = `
        <legend><b>Maven 2</b></legend>
        <hr>
        <div class="row mb-3">
            <label for="version-policy" class="col-sm-3 mt-1"><b>Version Policy</b></label>
            <div class="col-sm-9">
                <div class="col-sm-9">
                    <input id="version-policy" class="form-control" type="text">
                </div>
            </div>
        </div>
        <div class="row mb-3">
            <label for="layout-policy" class="col-sm-3 mt-1"><b>Layout Policy</b></label>
            <div class="col-sm-9">
                <input id="latout-policy" class="form-control" type="text">
            </div>
        </div>
        <div class="row mb-3">
            <label for="content-disposition" class="col-sm-3 mt-1"><b>Content Disposition</b></label>
            <div class="col-sm-9">
                <input id="content-disposition" class="form-control" type="text">
            </div>
        </div>
`