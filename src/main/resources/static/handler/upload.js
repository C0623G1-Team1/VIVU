import firebase from "../config/firebase-config.js"

const uploadedURLs = [];

async function handleUpload(files) {
    if (files.length === 0) {
        document.getElementById("submit-form").submit();
    } else {
        const ref = firebase.storage().ref();

        for (const file of files) {
            const name = +new Date() + "-" + file.name;
            const metadata = {
                contentType: file.type
            };

            try {
                const snapshot = await ref.child(name).put(file, metadata);
                const url = await snapshot.ref.getDownloadURL();
                uploadedURLs.push(url);
                if (uploadedURLs.length === files.length) {
                    for (let i = 0; i < 6; i++) {
                        if (!document.getElementById(`image-${i}`).value) {
                            document.getElementById(`image-${i}`).value = uploadedURLs[0];
                            uploadedURLs.splice(0, 1)
                        }
                    }
                    document.getElementById("submit-form").submit();
                }
            } catch (error) {
                console.error(error);
            }
        }
    }

}

document.getElementById("btn-upload").addEventListener("click", function (e) {
    document.getElementById("btn-upload").setAttribute("disabled", "disabled");
    document.getElementById("btn-upload").innerHTML =
        (`<span class="spinner-grow spinner-grow-sm" role="status" aria-hidden="true"></span>`)
    const files = document.getElementById("input-ref").files;
    handleUpload(files).then().catch(err => console.log(err))
});





