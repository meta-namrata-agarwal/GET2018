function removeFunction() {
    var element = document.getElementsByTagName("div")[9];
    var element1 = document.getElementsByTagName("div")[10];
    if (element != null && element1 != null) {
        element.parentNode.removeChild(element);
        element1.parentNode.removeChild(element1);
    }
}

function addHosting() {
    var z = document.createElement("div");
    z.id = "hostdiv";
    var label = document.createElement("label");
    var radioDiv = document.createElement("div");
    var yes = document.createElement("input");
    var no = document.createElement("input");

    z.appendChild(label);
    label.appendChild(document.createTextNode("Do you have hosting"));

    z.setAttribute("class", "input-container");
    radioDiv.setAttribute("id", "radio");
    yes.setAttribute("type", "radio");
    yes.setAttribute("value", "yes");
    yes.setAttribute("name", "hosting");


    no.setAttribute("type", "radio");
    no.setAttribute("value", "no");
    no.setAttribute("name", "hosting");
    no.checked = "true";

    z.appendChild(radioDiv);
    document.getElementById("fields").appendChild(z);

    var labelNo = document.createElement("label");
    var labelyes = document.createElement("label");
    labelyes.appendChild(yes);
    labelNo.appendChild(no);
    labelyes.appendChild(document.createTextNode("Yes"));
    labelNo.appendChild(document.createTextNode("No"));
    radioDiv.appendChild(labelyes);
    radioDiv.appendChild(document.createElement('br'));
    radioDiv.appendChild(labelNo);

}

function addProject() {
    var z = document.createElement("div");
    var labelproject = document.createElement("label");
    var project = document.createTextNode("Project Description");
    var penicon = document.createElement("i");
    var inputproject = document.createElement("textarea");
    z.appendChild(labelproject);
    z.setAttribute("class", "input-container");
    labelproject.appendChild(project);
    penicon.setAttribute("class", "fas fa-pencil-alt icon");
    z.appendChild(penicon);
    inputproject.setAttribute("placeholder", "Project Description");
    inputproject.id = "project";
    inputproject.setAttribute("row", "2");
    inputproject.setAttribute("cols", "29");
    z.appendChild(inputproject);
    document.getElementById("fields").appendChild(z);
}

function addWebsite() {
    var z = document.createElement("div");
    z.setAttribute("class", "input-container");
    var labeldomain = document.createElement("label");
    var domain = document.createTextNode("Website or domain name");
    z.appendChild(labeldomain);
    labeldomain.appendChild(domain);
    var webicon = document.createElement("i");
    webicon.setAttribute("class", "fas fa-globe-americas icon");
    z.appendChild(webicon);

    var inputdomain = document.createElement("INPUT");
    inputdomain.id = "website";
    inputdomain.setAttribute("type", "text");
    inputdomain.setAttribute("placeholder", "Website or domain name");

    z.appendChild(inputdomain);
    document.getElementById("fields").appendChild(z);

}

function addZipCode() {
    var z = document.createElement("div");
    z.setAttribute("class", "input-container");
    var labelZip = document.createElement("label");
    var zip = document.createTextNode("ZipCode");
    z.appendChild(labelZip);
    labelZip.appendChild(zip);
    document.getElementById("fields").appendChild(z);

    var zipicon = document.createElement("i");
    zipicon.setAttribute("class", "fas fa-home icon");
    z.appendChild(zipicon);

    var inputZip = document.createElement("INPUT");
    z.appendChild(inputZip);
    inputZip.setAttribute("type", "number");
    inputZip.id = "zipcode";
    inputZip.setAttribute("placeholder", "ZipCode");
    document.getElementById("fields").appendChild(z);
}

function myfunction() {
    var value = document.getElementById("state").value;
    if (value == "Rajasthan") {
        removeFunction();
        addWebsite();
        addProject();

    } else if (value == "Haryana") {
        removeFunction();
        addZipCode();
        addHosting();
    } else if (value == "Maharashtra") {
        removeFunction();
        addZipCode();
        addProject();
    }
}
