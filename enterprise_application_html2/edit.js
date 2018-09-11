function editCheck() {
    var ed = document.getElementById("edit");
    var fname=  document.getElementById("FirstName");
    fname.removeAttribute("readonly");   document.getElementById("LastName").removeAttribute("readonly");
    document.getElementById("Email").removeAttribute("readonly");
    document.getElementById("number").removeAttribute("readonly");
}