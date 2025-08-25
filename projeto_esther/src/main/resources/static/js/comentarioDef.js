const areas = document.getElementsByClassName('digitar');
for (let i = 0; i < areas.length; i++) {
    areas[i].addEventListener('input', function () {
        this.style.height = 'auto';
        this.style.height = this.scrollHeight + 'px';
    });
}