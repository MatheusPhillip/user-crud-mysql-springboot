const form = document.querySelector("form");

const inputFirstName = document.querySelector(".firstName");
const inputLastName = document.querySelector(".lastName");
const inputEmail = document.querySelector(".email");
const inputPassword = document.querySelector(".password");
const inputPhone = document.querySelector(".phone");

function register(data){

    fetch("http://localhost:8080/users", 
    {
        headers: {
            'Accept': 'application/json',
            'Content-Type': 'application/json'
        },
        method: "POST",
        body: JSON.stringify(data)
    })
    .then(function (res) {console.log(res)})
    .catch(function (res) {console.log(res)})

}

function resetFields(){
    inputFirstName.value = "";
    inputLastName.value = "";
    inputEmail.value = "";
    inputPassword.value = "";
    inputPhone.value = "";
}

form.addEventListener('submit', function(event){
    event.preventDefault();

    const data = {
        firstName: inputFirstName.value,
        lastName: inputLastName.value,
        email: inputEmail.value,
        password: inputPassword.value,
        phone: inputPhone.value
    };
    register(data);
    resetFields();
});