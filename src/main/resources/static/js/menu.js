const toggle = document.querySelector(".toggle")
const menuDashboard = document.querySelector(".menu-dashboard")
const iconoMenu = toggle.querySelector("i")
const enlacesMenu = document.querySelectorAll(".enlace")

toggle.addEventListener("click", () => {
    menuDashboard.classList.toggle("open")

    if(iconoMenu.classList.contains("bx-menu")){
        iconoMenu.classList.replace("bx-menu", "bx-x")
    }else {
        iconoMenu.classList.replace("bx-x", "bx-menu")
    }
})

enlacesMenu.forEach(enlace => {
    enlace.addEventListener("click", () => {
        menuDashboard.classList.add("open")
        iconoMenu.classList.replace("bx-menu", "bx-x")
    })
})

// Espera a que el contenido del DOM esté completamente cargado antes de ejecutar el script
document.addEventListener("DOMContentLoaded", function () {
    // Selecciona el botón de usuario (imagen) y el menú desplegable
    const userButton = document.querySelector(".user-img");
    const dropdownMenu = document.querySelector(".dropdown-menu");

    // Añade un evento de clic al botón de usuario
    userButton.addEventListener("click", function (event) {
        // Alterna la clase 'show' en el menú desplegable para mostrarlo u ocultarlo
        dropdownMenu.classList.toggle("show");
        // Evita que el evento de clic se propague a otros elementos
        event.stopPropagation();
    });

    // Añade un evento de clic a la ventana (documento)
    window.addEventListener("click", function () {
        // Si el menú desplegable está visible, lo oculta removiendo la clase 'show'
        if (dropdownMenu.classList.contains('show')) {
            dropdownMenu.classList.remove('show');
        }
    });

    // Añade un evento de clic al menú desplegable
    dropdownMenu.addEventListener("click", function (event) {
        // Evita que el evento de clic se propague a otros elementos
        event.stopPropagation();
    });
});