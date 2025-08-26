// 1. Encontre todos os elementos com a classe 'botao-muda-cor'
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

document.getElementById('coment').addEventListener('click', function () {
    window.location.href = '/trans/comentario';
});


document.addEventListener('DOMContentLoaded', () => {
    // Seleciona todos os contêineres principais (as divs com a classe 'div')
    const secoes = document.querySelectorAll('.div');

    // Itera sobre cada seção
    secoes.forEach(secao => {
        // Encontra as estrelas apenas dentro desta seção
        const estrelasClicaveis = secao.querySelectorAll('.estrela');
        // Encontra as divs de informação apenas dentro desta seção
        const divsInfo = secao.querySelectorAll('.info');

        estrelasClicaveis.forEach(estrela => {
            estrela.addEventListener('click', () => {
                // Oculta todas as divs de informação apenas dentro desta seção
                divsInfo.forEach(div => {
                    div.classList.add('oculto');
                });

                // Pega o ID da div de informação a partir do data-target da estrela clicada
                const targetId = estrela.getAttribute('data-target');
                // Encontra a div de informação correspondente
                const divAlvo = document.getElementById(targetId);

                // Se a div de destino existir, remove a classe 'oculto' para mostrá-la
                if (divAlvo) {
                    divAlvo.classList.remove('oculto');
                }
            });
        });
    });
});

let meuBotao = document.getElementById("btnTopo");

// Quando o botão é clicado, rola a página de volta ao topo
meuBotao.addEventListener('click', topFunction);

function topFunction() {
    document.body.scrollTop = 0; // Para navegadores Safari
    document.documentElement.scrollTop = 0; // Para Chrome, Firefox, IE e Opera
}