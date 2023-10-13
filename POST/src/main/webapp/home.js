document
  .querySelector(".btn-createPost")
  .addEventListener("click", function (e) {
    e.preventDefault();
    document.querySelector(".post-create-container").classList.toggle("hidden");
  });

  