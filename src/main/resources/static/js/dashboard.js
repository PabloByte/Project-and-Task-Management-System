// dashboard.js
console.log("Dashboard JS cargado.");

// Ejemplo: cerrar modal
const modal = document.getElementById("modal");
const closeBtn = document.querySelector(".close");

if (closeBtn) {
  closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
  });
}
