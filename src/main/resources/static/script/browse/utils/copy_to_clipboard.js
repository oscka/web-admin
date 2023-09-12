// 저장소 URL 복사버튼 동작 Script
async function copy_to_clipboard(event) {
    const targetElement = event.target.parentNode.querySelector(".url");

    if(navigator.clipboard && window.isSecureContext) {
        await navigator.clipboard.writeText(targetElement.value);
    } else {
        const textArea = document.createElement("textarea");

        textArea.value = targetElement.value;

        textArea.style.position = "absolute";
        textArea.style.left = "-999999px";

        document.body.prepend(textArea);
        textArea.select();

        try {
            document.execCommand('copy');
        } catch (err) {
            console.error(err);
        } finally {
            textArea.remove();
        }
    }

    const toastTrigger = event.target;
    const toastPanel = document.getElementById('browseToast')

    if (toastTrigger) {
        bootstrap.Toast.getOrCreateInstance(toastPanel).show()
    }
}