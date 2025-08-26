const areas = document.getElementsByClassName('digitar');
for (let i = 0; i < areas.length; i++) {
    areas[i].addEventListener('input', function () {
        this.style.height = 'auto';
        this.style.height = this.scrollHeight + 'px';
    });
}

const botoes = document.getElementsByClassName('botao-header');

// 2. Iterar sobre a coleção de botões
// O loop 'for...of' é uma forma moderna e fácil de fazer isso.
for (const botao of botoes) {
    botao.addEventListener('click', function () {
        const corOriginal = this.style.color;
        this.style.color = '#fde070'; // Muda a cor do texto para amarelo
        setTimeout(() => {
            this.style.color = corOriginal;
        }, 300);
    });
    document.getElementById('esquerda').addEventListener('click', function () {
        window.location.href = '/esther/transtornos';
    });
    document.getElementById('meio').addEventListener('click', function () {
        window.location.href = '/trans/info';
    });
    document.getElementById('direita').addEventListener('click', function () {
        window.location.href = '/trans/comentario';
    });
    document.getElementById('voltar').addEventListener('click', function () {
        window.location.href = '/';
    });
}