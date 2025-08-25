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
        window.location.href = '/esther/deficiencias';
    });
    document.getElementById('meio').addEventListener('click', function () {
        window.location.href = '/def/info';
    });
    document.getElementById('direita').addEventListener('click', function () {
        window.location.href = '/def/comentario';
    });
    document.getElementById('voltar').addEventListener('click', function () {
        window.location.href = '/';
    });
}

// Obtém o botão
let meuBotao = document.getElementById("btnTopo");

// Quando o botão é clicado, rola a página de volta ao topo
meuBotao.addEventListener('click', topFunction);

function topFunction() {
    document.body.scrollTop = 0; // Para navegadores Safari
    document.documentElement.scrollTop = 0; // Para Chrome, Firefox, IE e Opera
}