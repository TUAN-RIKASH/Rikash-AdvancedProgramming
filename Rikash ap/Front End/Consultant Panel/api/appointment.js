getAllProduct();
function getAllProduct() {
    const userName = sessionStorage.getItem("userName");
    $.ajax({
        method: "POST",
        url: "http://localhost:8080/api/v1/appoinment/consultant-name/" + userName,
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
        row.append($("<td>").text(element.c_name));
        row.append($("<td>").text(element.u_name));
        row.append($("<td>").text(element.book_date));
        row.append($("<td>").text(element.time));
        row.append($("<td>").text(element.contact));

        // Create buttons and add them to the row
        var editButton = $("<button>")
            .text("Approve")
            .addClass("btn btn-primary btn-sm m-2");
        var deleteButton = $("<button>")
            .text("Decline")
            .addClass("btn btn-danger btn-sm");

        // Add click event listeners to the buttons
        // Add click event listener for "Edit" button
        editButton.click(function () {
            editButton.hide();
            deleteButton.hide();
        });
        // Add the buttons to the DOM
        $("body").append(editButton);
        $("body").append(deleteButton);

        deleteButton.click(function () {
            // Handle delete button click
            var confirmDelete = confirm(
                "Are you sure you want to decline this appointment?"
            );
            if (confirmDelete) {
                // Send a delete request to the API endpoint
                $.ajax({
                    url:
                        "http://localhost:8080/api/v1/appoinment/getappoinment/" +
                        element.id, // Update the API endpoint
                    type: "DELETE",
                    success: function () {
                        // Data deleted successfully, you might want to update the UI
                        row.remove(); // Remove the row from the table
                    },
                    error: function (error) {
                        console.error("Error deleting data:", error);
                    },
                });
            }
        });
        // Append the buttons to the row
        row.append($("<td>").append(editButton).append(deleteButton));
        tableBody.append(row);
    });
}
function showUserName() {
    const userName = sessionStorage.getItem("userName");
    if (userName) {
        console.log(`User's name: ${userName}`);
    } else {
        console.log("User's name not found in sessionStorage.");
    }
}
window.onload = showUserName;
