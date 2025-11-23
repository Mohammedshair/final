async function startScan() {
    const codeReader = new ZXing.BrowserQRCodeReader();
    const videoElement = document.getElementById("cameraPreview");

    try {
        await codeReader.decodeFromVideoDevice(null, videoElement, (result, err) => {
            if (result) {
                const usn = result.getText();
                document.getElementById("usnText").innerText = usn;

                fetch("http://localhost:8080/api/checkUSN?usn=" + usn)
                    .then(res => res.text())
                    .then(status => {
                        document.getElementById("statusText").innerText = status;
                    });
            }
        });
    } catch (e) {
        console.error(e);
    }
}
