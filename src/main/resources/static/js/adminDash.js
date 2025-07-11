
// Toggle sidebar
document.addEventListener('DOMContentLoaded', function () {
    var sidebarToggle = document.querySelector('.navbar-toggler');
    var sidebar = document.querySelector('.sidebar');
    var mainContent = document.querySelector('main');

    sidebarToggle.addEventListener('click', function () {
        sidebar.classList.toggle('active');
        if (sidebar.classList.contains('active')) {
            sidebar.style.left = '0';
            mainContent.style.paddingLeft = '235px'; // Adjust main content padding
        } else {
            sidebar.style.left = '-220px';
            mainContent.style.paddingLeft = '15px'; // Reset main content padding
        }
    });
});
