function handleClick() {
    const input = document.getElementById('input-ref')
    console.log(input.files)
}
window.onload = function () {
    handleFallBackPreview()
}
let previewFiles = []
const input = document.getElementById('input-ref')
const handlePreviewImage = (target) => {
    const dt = new DataTransfer()
    previewFiles = previewFiles.filter(function (element) {
        return element !== undefined;
    });
    let newFiles = [...target.files];
    if (ex(newFiles, previewFiles)) {
        alert("Ảnh đã tồn tại!")
    } else {
        if (previewFiles.length + newFiles.length <= 6) {
            previewFiles = [...previewFiles, ...target.files]
            for (let i = 0; i < previewFiles.length; i++) {
                const file = previewFiles[i]
                if (file && !exists([...dt.files], file.name)) {
                    if (typeof file !== "string") {
                        dt.items.add(file)
                    }
                }
            }
        } else {
            alert("Tối đa 6 ảnh!")
        }
    }
    input.files = dt.files;
    previewImages(previewFiles);
}
const ex = (arr, previewFiles) => {
    return arr.some(file => {
        if (file && exists(previewFiles, file.name)) {
            return true;
        }
    })
}
const exists = (objArray, name) => {
    return objArray.some(obj => {
        if (obj) {
            return obj.name === name
        }
    })
};
const previewImages = (fileArr) => {
    let imgTag = `<div class="row w-100" >`
    fileArr.forEach((file, index) => {
        console.log(file)
        const check = (typeof file !== "string" && file);
        if (file) {
            imgTag += `
            <span class="col-lg-4" style="position: relative" id="drop-${index}">
                <figure class="figure">
                  <img
                    src="${check && file ? URL.createObjectURL(file) : file}"
                    class="figure-img img-fluid rounded shadow-3 mb-3"
                    alt="${file && file.name}"
                  />
                    <figcaption class="figure-caption">${file && file.name ? file.name : ""}</figcaption>
                </figure>

                <button id="preview-${index}" onclick="handleDeleteImage('${file.name}', ${index})" type="button" class="btn btn-danger btn-floating btn-sm" style="position: absolute; top: 0; right: 15px" >
<!--                Icon delete-->
                    <i class='bx bxs-x-square'></i>
                </button>
            </span>`
        }
    })
    imgTag += `</div> `;
    document.getElementById("preview-root").innerHTML = imgTag;
}
const handleDeleteImage = (name, index) => {
    let dt = new DataTransfer()
    const input = document.getElementById('input-ref')
    const {files} = input
    if (name !== 'undefined') {
        index = [...files].findIndex(file => file.name === name);
    }
    const fileInput = document.getElementById(`image-${index}`)
    for (let i = 0; i < [...files].length; i++) {
        const file = files[i]
        if (index !== i) {
            dt.items.add(file)
        }
    }
    input.files = dt.files
    previewFiles[index] = undefined;
    fileInput.value = "";
    URL.revokeObjectURL(previewFiles[index])
    document.getElementById(`drop-${index}`).remove();
    if (name !== 'undefined') {
        previewFiles.splice(index, 1)
        previewImages(previewFiles)
    }
};
const handleFallBackPreview = () => {
    const arr = [];
    for (let i = 0; i < 6; i++) {
        if (document.getElementById(`image-${i}`) && document.getElementById(`image-${i}`).value) {
            let inputValue = document.getElementById(`image-${i}`).value;
            arr.push(inputValue)
        }
    }
    previewFiles = [...previewFiles, ...arr]
    previewImages(previewFiles)
}