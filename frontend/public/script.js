
const form = document.querySelector("form");

const inputFirstName = document.querySelector(".firstName");
const inputLastName = document.querySelector(".lastName");
const inputEmail = document.querySelector(".email");
const inputPassword = document.querySelector(".password");
const inputPhone = document.querySelector(".phone");
const userList = document.getElementById("user-list");


function register(data) {
  fetch("http://localhost:8080/users", {
    headers: {
      Accept: "application/json",
      "Content-Type": "application/json",
    },
    method: "POST",
    body: JSON.stringify(data),
  })
    .then(function (res) {
      console.log(res);
      resetMainPage();
    })
    .catch(function (res) {
      console.log(res);
    });
}

function getUserlist(){
  fetch("http://localhost:8080/users")
    .then((response) => response.json())
    .then((data) => {
      if(listIsEmpty(data)){
        const emptyList = document.createElement("h2");
        emptyList.innerHTML = `
          <div class="userListHeader">
            <h2>There is no users registered.</h2>
          </div>
        `;
      }
      else{

        data.forEach((user) => {
          const userItem = document.createElement("li");
          userItem.innerHTML = `
          <span class="name">${user.firstName}</span>
          <span>${user.email}</span>
          <button class="delete-button">Delete</button>
          `;
          userList.appendChild(userItem);
          
          const deleteButton = userItem.querySelector(".delete-button");
          deleteButton.addEventListener("click", function () {
            fetch(`http://localhost:8080/users/${user.id}`, {
              headers: {
              Accept: "application/json",
              "Content-Type": "application/json",
            },
            method: "DELETE",
            body: JSON.stringify(data),
          })
          .then(function (res) {
            console.log(res);
            resetMainPage();
          })
          .catch(function (res) {
            console.log(res);
          });
        });
      });
    }
    })
    .catch((error) => {
      console.error("Search error:", error);
    });
}

function listIsEmpty(list){
  return list == null
}

function resetFields() {
  inputFirstName.value = "";
  inputLastName.value = "";
  inputEmail.value = "";
  inputPassword.value = "";
  inputPhone.value = "";
}

function resetUserList(list){
  userList.innerHTML = "";
}

function resetMainPage(){
  resetFields();
  resetUserList();
  getUserlist();
}

form.addEventListener("submit", function (event) {
  event.preventDefault();

  const data = {
    firstName: inputFirstName.value,
    lastName: inputLastName.value,
    email: inputEmail.value,
    password: inputPassword.value,
    phone: inputPhone.value,
  };
  register(data);
  resetFields();
});

document.addEventListener("DOMContentLoaded", function () {
  getUserlist();
});
