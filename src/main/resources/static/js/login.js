// Evento submit del formulario
document.getElementById('loginForm').addEventListener('submit', function(e) {
  e.preventDefault(); // Evita que se recargue la página

  const username = document.getElementById('username').value.trim();
  const password = document.getElementById('password').value;

  // LOGIN DE PRUEBA
  if (username === 'StarkIngenieria' && password === 'Stark') {
    localStorage.setItem('isLoggedIn', 'true');
    localStorage.setItem('username', username);

    // Redirige al dashboard estático
    window.location.href = '/dashboard.html';
  } else {
    alert('Credenciales inválidas. Usa StarkIngenieria / Stark');
  }
});
