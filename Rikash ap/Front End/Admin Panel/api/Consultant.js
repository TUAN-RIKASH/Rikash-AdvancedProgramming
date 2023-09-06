getAllProduct();
function saveEmp() {
    let name = $("#input2").val();
    let email = $("#input3").val();
    let nic = $("#input4").val();
    let s_time = $("#input5").val();
    let e_time = $("#input6").val();
    let password = $("#input7").val();

    $.ajax({
        method: "POST",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/consult/saveconsult",
        async: true,
        data: JSON.stringify({
            id: "",
            name: name,
            email: email,
            nic: nic,
            start_time: s_time,
            end_time: e_time,
            password: password,
        }),
        success: function (data) {
            alert("Consultant Added Successfully");
            window.location.href = '?refresh=true';
        },
        error: function (xhr, exception) {
            alert("Error");
        },
    });
}

function updateEmp() { 

    let id = $("#input1").val();
    let name = $("#input2").val();
    let email = $("#input3").val();
    let nic = $("#input4").val();
    let s_time = $("#input5").val();
    let e_time = $("#input6").val();
    let password = $("#input7").val();

    $.ajax({
        method: "PUT",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/consult/getconsult/"+id,
        async: true,
        data: JSON.stringify({
            id: "",
            name: name,
            email: email,
            nic: nic,
            start_time: s_time,
            end_time: e_time,
            password: password,
        }),
        success: function (data) {
            alert("Consultant Updated Successfully");
            window.location.href = '?refresh=true';
        },
        error: function (xhr, exception) {
            alert("Error");
        },
    });

}

function deleteEmp() {
    let id = $("#input1").val();

    $.ajax({
        method: "DELETE",
        contentType: "application/json",
        url: "http://localhost:8080/api/v1/consult/getconsult/" + id,
        async: true,
        success: function (data) {
            alert("Consultant Deleted Successfully");
            getAllProduct();
            window.location.href = '?refresh=true';
        },
        error: function (xhr, exception) {
            alert("Error");
        },
    });
}

function getAllProduct() {
    $.ajax({
        method: "GET",
        url: "http://localhost:8080/api/v1/consult/getconsult",
        async: true,
        success: function (data) {
            populateTable(data);
        },
        error: function (xhr, exception) {
            alert("Error");
        },
    });
}

function populateTable(data) {
    var tableBody = $("#prodTable");
    // Clear the existing table body
    tableBody.empty();
    // Loop through the data and append rows to the table
    $.each(data, function (index, element) {
        var row = $("<tr>");
        row.append($("<td>").text(element.id));
        row.append($("<td>").text(element.name));
        row.append($("<td>").text(element.email));
        row.append($("<td>").text(element.nic));
        row.append($("<td>").text(element.start_time));
        row.append($("<td>").text(element.end_time));
        row.append($("<td>").text(element.password));
        tableBody.append(row);
    });
}



function resetEmp() { 
    let id = $("#input1").val("");
    let name = $("#input2").val("");
    let email = $("#input3").val("");
    let nic = $("#input4").val("");
    let s_time = $("#input5").val("");
    let e_time = $("#input6").val("");
    let password = $("#input7").val("");
}



$(document).ready(function () {
    $(document).on('click','#prodTable tr',function(){
        var col0= $(this).find('td:eq(0)').text();
        var col1= $(this).find('td:eq(1)').text();
        var col2= $(this).find('td:eq(2)').text();
        var col3= $(this).find('td:eq(3)').text();
        var col4= $(this).find('td:eq(4)').text();
        var col5= $(this).find('td:eq(5)').text();
        var col6= $(this).find('td:eq(6)').text();


        $('#input1').val(col0);
        $('#input2').val(col1);
        $('#input3').val(col2);
        $('#input4').val(col3);
        $('#input5').val(col4);
        $('#input6').val(col5);
        $('#input7').val(col6);
    })
})
