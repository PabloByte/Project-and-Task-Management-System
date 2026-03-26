const form = document.getElementById("loginForm");
const usernameInput = document.getElementById("username");
const passwordInput = document.getElementById("password");
const submitButton = form?.querySelector("button[type='submit']");
const messageBox = document.getElementById("loginMessage");
const LOGIN_ENDPOINT = "/login";
const DASHBOARD_URL = "/pages/dashboard.html";

if (localStorage.getItem("authToken")) {
  window.location.replace(DASHBOARD_URL);
}

const setMessage = (message, isError = false) => {
  if (!messageBox) {
    return;
  }

  messageBox.textContent = message;
  messageBox.style.color = isError ? "#ff6b6b" : "#cde8ff";
  messageBox.style.minHeight = "1.5rem";
};

form?.addEventListener("submit", async (event) => {
  event.preventDefault();

  const userName = usernameInput.value.trim();
  const password = passwordInput.value;

  if (!userName || !password) {
    setMessage("Debes ingresar usuario y contraseÃ±a.", true);
    return;
  }

  submitButton.disabled = true;
  setMessage("Validando credenciales...");

  try {
    const response = await fetch(LOGIN_ENDPOINT, {
      method: "POST",
      headers: {
        "Content-Type": "application/json"
      },
      body: JSON.stringify({ userName, password })
    });

    const data = await response.json().catch(() => ({}));

    if (!response.ok) {
      const errorMessage = data.message || data.error || "No fue posible iniciar sesiÃ³n.";
      throw new Error(errorMessage);
    }

    const token = data.token;

    if (!token) {
      throw new Error("La respuesta del servidor no incluyÃ³ el token JWT.");
    }

    localStorage.setItem("authToken", token);
    localStorage.setItem("authorizationHeader", `Bearer ${token}`);
    localStorage.setItem("isLoggedIn", "true");
    localStorage.setItem("username", data.UserName || userName);

    setMessage("Inicio de sesiÃ³n exitoso. Redirigiendo...");
    window.location.assign(DASHBOARD_URL);
  } catch (error) {
    setMessage(error.message || "OcurriÃ³ un error al iniciar sesiÃ³n.", true);
    passwordInput.value = "";
    passwordInput.focus();
  } finally {
    submitButton.disabled = false;
  }
});
