let previewFiles = []
const dt = new DataTransfer()
const input = document.getElementById('input-ref')
const handlePreviewImage = (target) => {
    const newFiles = [...target.files];
    if (ex(newFiles, previewFiles)) {
        alert("Ảnh đã tồn tại!")
    } else {
        if (previewFiles.length + newFiles.length <= 6) {
            previewFiles = [...previewFiles, ...target.files]
            for (let i = 0; i < previewFiles.length; i++) {
                const file = previewFiles[i]
                if (!exists([...dt.files], file.name)) {
                    dt.items.add(file)
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
        if (exists(previewFiles, file.name)) {
            return true;
        }
    })
}
const exists = (objArray, name) => objArray.some(obj => obj.name === name);
const previewImages = (fileArr) => {
    let imgTag = `<div class="row w-100" >`
    fileArr.forEach((file, index) => {
        imgTag += `
            <span class="col-4 row" style="position: relative">
                <figure class="figure">
                  <img
                    src="${URL.createObjectURL(file)}"
                    class="figure-img img-fluid rounded shadow-3 mb-3"
                    alt="${file.name}"
                  />
                  <figcaption class="figure-caption">${file.name}</figcaption>
                </figure>
                <button id="preview-${index}" onclick="handleDeleteImage(${index})" type="button" class="btn btn-danger btn-floating btn-sm" style="position: absolute; top: 0; left: 10px" >
                    <i class="fas fa-lg fa-circle-xmark"></i>
                </button>
            </span>`
    })
    imgTag += `</div> `;

    document.getElementById("preview-root").innerHTML = imgTag;
}
const handleDeleteImage = (index) => {
    const dt = new DataTransfer()
    const input = document.getElementById('input-ref')
    const {files} = input

    for (let i = 0; i < files.length; i++) {
        const file = files[i]
        if (index !== i) {
            dt.items.add(file)
        }
    }

    input.files = dt.files
    previewFiles.splice(index, 1)
    URL.revokeObjectURL(previewFiles[index])
    previewImages(previewFiles)
}