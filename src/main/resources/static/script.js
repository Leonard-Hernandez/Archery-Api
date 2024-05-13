const apiUrl = apiUrlConst;

// document.addEventListener("DOMContentLoaded", function() {
//   if (localStorage.getItem('token')) {
//     showLoggedInView();
//     getTrainings();
//   } else if (window.location.pathname.includes('register.html')) {
//     showRegisterForm();
//   } else {
//     showLoginForm();
//   }
// });

function registerUser() {
  const username = document.getElementById('username').value;
  const password = document.getElementById('password').value;
  fetch(`${apiUrl}/login/register`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      login: username,
      password: password
    })
  })
  .then(response => {
    if (response.ok) {
      alert('Usuario registrado correctamente');
      redirectToLogin(); // Redirige a la página de inicio de sesión
    } else {
      alert('Error al registrar usuario');
    }
  })
  .catch(error => {
    console.error('Error al registrar usuario:', error);
  });
}

function login() {
  const username = document.getElementById('loginUsername').value;
  const password = document.getElementById('loginPassword').value;
  fetch(`${apiUrl}/login`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json'
    },
    body: JSON.stringify({
      login: username,
      password: password
    })
  })
  .then(response => response.json())
  .then(data => {
    if (data.JWTToken) {
      localStorage.setItem('token', data.JWTToken);      
      alert('Inicio de sesión exitoso');
      redirectToProfile(); // Redirige a la página principal después del inicio de sesión exitoso
    } else {
      alert('Credenciales inválidas');
    }
  })
  .catch(error => {
    console.error('Error al iniciar sesión:', error);
  });
}

function createArcherProfile() {
  const idDocument = document.getElementById('idDocument').value;
  const name = document.getElementById('archerName').value;
  const birthday = document.getElementById('birthday').value;
  const category = document.getElementById('category').value;
  const gender = document.getElementById('gender').value;
  
  // Verificar que los valores de categoría y género sean válidos
  if (!validateCategory(category) || !validateGender(gender)) {
    alert('Por favor, seleccione una categoría y un género válidos');
    return;
  }

  const token = localStorage.getItem('token');
  fetch(`${apiUrl}/archer`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    },
    body: JSON.stringify({
      idDocument: idDocument,
      name: name,
      birthday: birthday,
      category: category,
      gender: gender
    })
  })
  .then(response => {
    if (response.ok) {
      return response.json(); // Retorna la respuesta para obtener el ID del arquero
    } else {
      throw new Error('Error al crear perfil de arquero');
    }
  })
  .then(data => {
    localStorage.setItem('idArcher', data.id); // Guarda el ID del arquero en el localStorage
    alert('Perfil de arquero creado correctamente');
    redirectToTraining(); // Redirige a la página de registro de entrenamiento
    console.log('Perfil de arquero creado:', data);
  })
  .catch(error => {
    console.error('Error al crear perfil de arquero:', error);
    alert('Error al crear perfil de arquero');
  });
}

function redirectToTraining() {
  window.location.href = 'training.html'; // Redirecciona a la página de registro de entrenamiento
}
function uploadTraining() {
  const idArcher = localStorage.getItem('idArcher');
  const rounds = document.getElementById('rounds').value;
  const arrowsShots = document.getElementById('arrowsShots').value;
  const distance = document.getElementById('distance').value;
  const target = document.getElementById('target').value;
  const recordDate = document.getElementById('recordDate').value;
  const finalScore = document.getElementById('finalScore').value;

  const token = localStorage.getItem('token');
  fetch(`${apiUrl}/training`, {
    method: 'POST',
    headers: {
      'Content-Type': 'application/json',
      'Authorization': `Bearer ${token}`
    },
    body: JSON.stringify({
      id_archer: idArcher,
      rounds: rounds,
      arrowsShots: arrowsShots,
      distance: distance,
      target: target,
      recordDate: `${recordDate}T00:00:00`, // Añade la hora al final de la fecha
      finalScore: finalScore
    })
  })
  .then(response => {
    if (response.ok) {
      alert('Entrenamiento registrado correctamente');
      window.location.href = 'training.html'; // Redirecciona a training.html
    } else {
      throw new Error('Error al registrar el entrenamiento');
    }
  })
  .catch(error => {
    console.error('Error al registrar el entrenamiento:', error);
    alert('Error al registrar el entrenamiento');
  });
}

function getTrainings() {
  const idArcher = localStorage.getItem('idArcher');
  const token = localStorage.getItem('token');
  fetch(`${apiUrl}/training/${idArcher}`, {
    method: 'GET',
    headers: {
      'Authorization': `Bearer ${token}`
    }
  })
  .then(response => {
    if (!response.ok) {
      throw new Error('Error al obtener los entrenamientos');
    }
    return response.json();
  })
  .then(data => {
    showTrainings(data);
  })
  .catch(error => {
    console.error('Error al obtener los entrenamientos:', error);
    alert('Error al obtener los entrenamientos');
  });
}

function showTrainings(trainings) {
  const trainingsContainer = document.getElementById('trainings');
  trainingsContainer.innerHTML = ''; // Limpiar el contenedor de entrenamientos
  
  trainings.forEach(training => {
    const trainingItem = document.createElement('div');
    trainingItem.classList.add('training-item');
    trainingItem.innerHTML = `
      <div>
        <strong>Rondas:</strong> ${training.rounds}
      </div>
      <div>
        <strong>Flechas Disparadas:</strong> ${training.arrowsShots}
      </div>
      <div>
        <strong>Distancia:</strong> ${training.distance}
      </div>
      <div>
        <strong>Objetivo:</strong> ${training.target}
      </div>
      <div>
        <strong>Fecha de Registro:</strong> ${new Date(training.recordDate).toLocaleDateString()}
      </div>
      <div>
        <strong>Puntuación Final:</strong> ${training.finalScore}
      </div>
    `;
    trainingsContainer.appendChild(trainingItem);
  });
}

function validateCategory(category) {
  return ['COMPOUNT', 'RECURVE', 'MONOBLOC'].includes(category);
}

function validateGender(gender) {
  return ['MALE', 'FEMALE', 'OTHER'].includes(gender);
}

function redirectToIndex() {
  window.location.href = 'index.html';
}

function redirectToLogin() {
  window.location.href = 'login.html';
}

function redirectToRegister(){
  window.location.href = 'register.html';
}

function redirectToProfile() {
  window.location.href = 'profile.html';
}

function redirectToTraining() {
  window.location.href = 'training.html';
}