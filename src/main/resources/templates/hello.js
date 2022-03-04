$(document).ready(function () {
    $.ajax({
        url: "http://localhost:8080/addressBook?id=1"
    }).then(function (data) {
        if (data) {
            $('.addressBook-id').append("Address Book ID: " + data.addressBookID);
            for (Buddy buddy: data.myBuddies) {
                $('.addressBook-buddies').append("Name: " + buddy.name + ", ").append("Phone Number: " + buddy.phoneNumber).append("<br>").append("\n");
            }
        }
    });
})