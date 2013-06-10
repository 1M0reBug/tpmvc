var showSpectacles = function (spectacles) {
    var html = "<table class='table table-bordered'><tr>" +
        "<th>Artist</th>" +
        "<th>Title</th>" +
        "<th></th>" +
        "</tr>";
    spectacles.forEach(function (spectacle) {
        html += "<tr>" +
            "<td>" + spectacle.artiste + "</td>" +
            "<td>" + spectacle.titre + "</td>" +
            "<td><a class='btn' onclick='detail(" + spectacle.id + ")'><i class='icon-search'></i></a></td>" +
            "</tr>"
    });
    html += "</table>"
    $("#spectacles").html(html);
};

var showSpectacle = function (spectacle) {
    var html = "<h3>" + spectacle.artiste + " - " + spectacle.titre + "</h3>" +
        "<div>" + spectacle.type + "</div>" +
        "<div><a onclick='list()'>Liste</a></div>";
    $("#spectacles").html(html);
};

var list = function () {
    $.getJSON("http://localhost:8080/tpmvc/api/spectacles", function (data) {
        showSpectacles(data);
    });
    /*
     showSpectacles([
     {"id": 1000, "titre": "Iron", "artiste": "Woodkid", "type": "CONCERT", "version": 0},
     {"id": 1001, "titre": "Get Lucky", "artiste": "Daft Punk", "type": "CONCERT", "version": 0}
     ]);
     */
};

var detail = function (id) {
    $.getJSON("http://localhost:8080/tpmvc/api/spectacles/" + id, function (data) {
        showSpectacle(data);
    });
    //showSpectacle({"id": 1000, "titre": "Iron", "artiste": "Woodkid", "type": "CONCERT", "version": 0});
};

list();
