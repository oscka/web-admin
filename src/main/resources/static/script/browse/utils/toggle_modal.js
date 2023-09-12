import * as fieldsets from "../constants/fieldset.js";

function create_group_modal(element, format_html) {
    let default_form = document.createElement("fieldset");

    default_form.classList.add("form-fieldset", "mb-3");
    default_form.innerHTML = fieldsets.fieldset_default_info;

    let format_form = document.createElement("fieldset");

    format_form.classList.add("form-fieldset", "mb-3");
    format_form.innerHTML = format_html;

    let storage_form = document.createElement("fieldset");

    storage_form.classList.add("form-fieldset", "mb-3");
    storage_form.innerHTML = fieldsets.fieldset_storage;

    let group_form = document.createElement("fieldset");

    group_form.classList.add("form-fieldset", "mb-3");
    group_form.innerHTML = fieldsets.fieldset_group;

    element.append(default_form, format_form, storage_form, group_form);
}

function create_hosted_modal(element, format_html) {
    let default_form = document.createElement("fieldset");

    default_form.classList.add("form-fieldset", "mb-3");
    default_form.innerHTML = fieldsets.fieldset_default_info;

    let format_form = document.createElement("fieldset");

    format_form.classList.add("form-fieldset", "mb-3");
    format_form.innerHTML = format_html;

    let storage_form = document.createElement("fieldset");

    storage_form.classList.add("form-fieldset", "mb-3");
    storage_form.innerHTML = fieldsets.fieldset_storage;

    let hosted_form = document.createElement("fieldset");

    hosted_form.classList.add("form-fieldset", "mb-3");
    hosted_form.innerHTML = fieldsets.fieldset_hosted;

    let cleanup_form = document.createElement("fieldset");

    cleanup_form.classList.add("form-fieldset", "mb-3")
    cleanup_form.innerHTML = fieldsets.fieldset_cleanup;

    element.append(default_form, format_form, storage_form, hosted_form, cleanup_form);
}

function create_proxy_modal(element, format_html) {
    let default_form = document.createElement("fieldset");

    default_form.classList.add("form-fieldset", "mb-3");
    default_form.innerHTML = fieldsets.fieldset_default_info;

    let format_form = document.createElement("fieldset");

    format_form.classList.add("form-fieldset", "mb-3");
    format_form.innerHTML = format_html;
    
    let proxy_form = document.createElement("fieldset");

    proxy_form.classList.add("form-fieldset", "mb-3");
    proxy_form.innerHTML = fieldsets.fieldset_proxy;

    let storage_form = document.createElement("fieldset");

    storage_form.classList.add("form-fieldset", "mb-3");
    storage_form.innerHTML = fieldsets.fieldset_storage;
    
    let routing_rule_form = document.createElement("fieldset");

    routing_rule_form.classList.add("form-fieldset", "mb-3");
    routing_rule_form.innerHTML = fieldsets.fieldset_routing_rule;

    let negative_cache_form = document.createElement("fieldset");

    negative_cache_form.classList.add("form-fieldset", "mb-3")
    negative_cache_form.innerHTML = fieldsets.fieldset_negative_cache;

    let cleanup_form = document.createElement("fieldset");

    cleanup_form.classList.add("form-fieldset", "mb-3");
    cleanup_form.innerHTML = fieldsets.fieldset_cleanup;

    let http_form = document.createElement("fieldset");

    http_form.classList.add("form-fieldset", "mb-3");
    http_form.innerHTML = fieldsets.fieldset_http;
    
    element.append(default_form, format_form, proxy_form, storage_form, routing_rule_form, negative_cache_form, cleanup_form, http_form);
}

function toggle_modal(repository) {
    const modalTitle = document.getElementsByClassName("modal-title")[0];
    const modalBody = document.getElementById("main-modal-body").querySelector(".form-floating");

    modalTitle.innerHTML = `<i class="bi bi-boxes"></i> ${repository.name}`;
    modalBody.innerHTML = "";

    switch(repository.type) {
        case "group":
            if(repository.format === "maven2") {
                create_group_modal(modalBody, fieldsets.fieldset_maven2);
            }
            break;
        case "hosted":
            if(repository.format === "maven2") {
                create_hosted_modal(modalBody, fieldsets.fieldset_maven2);
            }
            break;
        case "proxy":
            if(repository.format === "maven2") {
                create_proxy_modal(modalBody, fieldsets.fieldset_maven2);
            }
            break;
        default:
            break;
    }

    document.getElementById("repo-name").value = repository.name;
    document.getElementById("repo-format").value = repository.format;
    document.getElementById("repo-type").value = repository.type;
    document.getElementById("repo-url").value = repository.url;
    document.getElementById("repo-online").checked = repository.status.online;

    axios.get(`${protocol}//${hostname}:${port}/v1/repository/${object.format}/${object.type}/${object.name}`)
            .then((res) => {
                if (object.type === "group") {

                } else if (object.type === "hosted") {

                } else if (object.type === "proxy") {

                }
            });

    //             // mainModalRepoRemoteStorage.value = res.data.proxy.remoteUrl;
    //             // mainModalRepoBlocked.checked = res.data.httpClient.blocked;
    //             // mainModalRepoAutoBlockingEnabled.checked = res.data.httpClient.autoBlock
    //             // mainModalRepoMaximumComponentAge.value = res.data.proxy.contentMaxAge;
    //             // mainModalRepoMaximumMetadataAge.value = res.data.proxy.metadataMaxAge
    //             // mainModalRepoBlobStore.value = res.data.storage.blobStoreName;
    //             // mainModalRepoStrictContentTypeValidation.checked = res.data.storage.strictContentTypeValidation
    //             // mainModalRepoNotFoundCacheEnabled.checked = res.data.negativeCache.enabled;
    //             // mainModalRepoNotFoundCacheTTL.value = res.data.negativeCache.timeToLive;
    //         });
}

window.toggle_modal = toggle_modal;