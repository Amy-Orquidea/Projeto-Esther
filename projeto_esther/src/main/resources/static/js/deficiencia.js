// 1. Encontre todos os elementos com a classe 'botao-muda-cor'
const botoes = document.getElementsByClassName('botao-header');

// 2. Iterar sobre a coleção de botões
// O loop 'for...of' é uma forma moderna e fácil de fazer isso.
for (const botao of botoes) {
    botao.addEventListener('click', function() {
            const corOriginal = this.style.color;
            this.style.color = '#fde070'; // Muda a cor do texto para amarelo
                setTimeout(() => {
            this.style.color = corOriginal;
        }, 300);
        });
    document.getElementById('esquerda').addEventListener('click', function() {
        window.location.href = 'y';
    });
    document.getElementById('meio').addEventListener('click', function() {      
        window.location.href = 'x';
    });
    document.getElementById('direita').addEventListener('click', function() {
        window.location.href = 'z';
    });
        document.getElementById('voltar').addEventListener('click', function() {
        window.location.href = '/';
    });
}