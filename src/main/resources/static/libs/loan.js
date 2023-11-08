function checkDate() {
    let startDate = document.getElementById("startDate").value;
    let endDate = document.getElementById("endDate").value;
    let curDate = new Date();
    curDate = curDate.toISOString().split('T')[0];
    let startDateError = document.getElementById("start");
    let endDateError = document.getElementById("end");
    let stringStartError = "Vui lòng nhập ngày khởi hành";
    let stringEndError = "Vui lòng nhập ngày kết thúc";
    startDateError.innerText = "";
    endDateError.innerText = "";

    switch (true) {
        case !startDate && !endDate:
            startDateError.innerText = "Vui lòng nhập ngày khơi hành";
            endDateError.innerText = "Vui lòng nhập ngày kết thúc";
            return;
        case !startDate && endDate < curDate:
            startDateError.innerText = "Vui lòng nhập ngày khơi hành";
            endDateError.innerText = "Vui lòng không nhập ngày ở quá khứ";
            return;
        case !endDate && startDate < curDate:
            startDateError.innerText = "Vui lòng không nhập ngày ở quá khứ";
            endDateError.innerText = "Vui lòng nhập ngày kết thúc";
            return;
        case  startDate < curDate && endDate < curDate:
            startDateError.innerText = "Vui lòng không nhập ngày ở quá khứ";
            endDateError.innerText = "Vui lòng không nhập ngày ở quá khứ";
            return;
        case startDate < curDate:
            startDateError.innerText = "Vui lòng không nhập ngày ở quá khứ";
            return;
        case startDate > endDate:
            endDateError.innerText = "Vui lòng nhập ngày khởi hành lớn hơn ngày kết thúc";
            return;
    }
    showEmployeeList(startDate, endDate);
}

function showEmployeeList(startDate, endDate) {
    $.ajax({
        url: `http://localhost:8080/show-list-employee?startDate=${startDate}&endDate=${endDate}`,
        type: "GET",
        dataType: "json",
        success: function (data) {
            $("tbody").empty();
            let tr = [];
            for (let i = 0; i < data.length; i++) {
                tr.push("<tr>");
                tr.push("<td>" + (i + 1) + "</td>");
                // tr.push("<td>" + data[i].accountId + "</td>");
                tr.push("<td>" + data[i].employeeName + "</td>");
                tr.push("<td>" + data[i].phoneNumber + "</td>");
                tr.push("<td>" + data[i].email + "</td>");
                tr.push(`<td><button type="button" class="btn btn-default" data-dismiss="modal" onclick="bindingValue(${data[i].accountId},'${data[i].employeeName}','${data[i].phoneNumber}','${data[i].email}')">Chọn</button></td>`);
                tr.push("</tr>");
            }
            $("table").append(tr.join(""));
        }
    })
    document.getElementById("modal-btn").click();
}

function bindingValue(id, name, phone, email) {
    document.getElementById("employeeName").value = name;
    document.getElementById("accountId").value = id;
    document.getElementById("employeePhone").value = phone;
    document.getElementById("employeeEmail").value = email;
}
