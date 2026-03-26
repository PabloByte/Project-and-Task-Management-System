// dashboard.js
console.log("Dashboard JS cargado.");

// ─── Sign Out ─────────────────────────────────────────────────────────────────
const signOutBtn = document.getElementById("signOut");

if (signOutBtn) {
  signOutBtn.addEventListener("click", async (e) => {
    e.preventDefault();

    // TODO: cuando implementes Spring Security, reemplaza el bloque de abajo por:
    // await fetch('/logout', { method: 'POST' });

    window.location.href = "login.html";
  });
}

// ─── Modal ────────────────────────────────────────────────────────────────────
const modal = document.getElementById("modal");
const closeBtn = document.querySelector(".close");

if (closeBtn) {
  closeBtn.addEventListener("click", () => {
    modal.style.display = "none";
  });
}
