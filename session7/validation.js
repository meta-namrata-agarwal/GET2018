function FNameValidate() {
    first = document.getElementById("firstname");
    var letters = /^([a-zA-Z]){3,}$/;
    if (first.value.match(letters)) {
        first.style.border = "2px solid green";
        return true;
    } else {
        first.style.border = "2px solid red";
        return false;
    }
}

function LNameValidate() {
    last = document.getElementById("lastname");
    var letters = /^([a-zA-Z]){3,}$/;
    if (last.value.match(letters)) {
        last.style.border = "2px solid green";
        return true;
    } else {
        last.style.border = "2px solid RED";
    }
}

function ContatctNumberValidate() {
    var letters = /^([0-9]){11}$/;
    phone = document.getElementById("phone");
    if (phone.value.match(letters)) {
        phone.style.border = "2px solid green";
        return true;
    } else {
        phone.style.border = "2px solid red";
        return false;
    }
}

function validateEmail() {
    email = document.getElementById("email");
    var letters = /^([a-zA-Z])([a-zA-Z0-9_.-])*@([a-zA-Z0-9_.-])+\.([a-zA-Z])+([a-zA-Z])+$/;
    if (email.value.match(letters)) {
        email.style.border = "2px solid green";
        return true;
    } else {
        email.style.border = "2px solid red";
        return false;
    }
}

function validateProject() {
    validProj = document.getElementById("project");
    if (validProj.value == "")
        return false;
    else
        return true;
}

function validateZipCode() {
    valid = document.getElementById("zipcode");
    if (valid.value == "")
        return false;
    else
        return true;
}

function validateSubmit() {
    //    debugger;
    errormsg = "";
    if (!FNameValidate())
        errormsg += "FirstName is invalid! \n";
    if (!LNameValidate())
        errormsg += "LastName is invalid! \n";
    if (!validateEmail())
        errormsg += "Email is invalid! \n";
    if (!ContatctNumberValidate())
        errormsg += "phonenumber is invalid! \n";
    if (state.value == "Rajasthan") {
        if (!validateProject())
            errormsg += "Project  is null! \n";
    }
    if (state.value == "Haryana") {
        if (!validateZipCode())
            errormsg += "zipcode  is null! \n";
    }

    if (errormsg != "") {
        //        debugger;
        alert(errormsg);
        return false;
    } else {
        localStorage.setItem("firstname", first.value);
        localStorage.setItem("lastname", last.value);
        localStorage.setItem("phone", phone.value);
        localStorage.setItem("email", email.value);
        localStorage.setItem("address", document.getElementById("address").value);
        localStorage.setItem("city", document.getElementById("city").value);

        state = document.getElementById("state");
        localStorage.setItem("state", state.value);
        if (state.value == "Rajasthan") {
            localStorage.setItem("website", document.getElementById("website").value);
            localStorage.setItem("project", document.getElementById("project").value);
        }
        if (state.value == "Haryana") {
            localStorage.setItem("zipcode", document.getElementById("zipcode").value);
            localStorage.setItem("hosting", document.querySelector("input[name='hosting']:checked").value);
        }
        if (state.value == "Maharashtra") {
            localStorage.setItem("zipcode", document.getElementById("zipcode").value);
            localStorage.setItem("project", document.getElementsByName("project").value);
        }
    }
}
