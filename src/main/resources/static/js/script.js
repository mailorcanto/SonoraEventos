document.addEventListener('DOMContentLoaded', function () {
    const form = document.getElementById('form-orcamento');

    if (form) {
        form.addEventListener('submit', function (event) {
            // Verificar se pelo menos uma checkbox de serviço foi selecionada
            const checkboxes = document.querySelectorAll('input[name="servicos"]:checked');
            
            if (checkboxes.length === 0) {
                // Impedir o envio do formulário
                event.preventDefault();

                // Mostrar mensagem de erro
                const mensagem = document.getElementById('mensagem');
                mensagem.classList.remove('d-none', 'alert-success');
                mensagem.classList.add('alert-danger');
                mensagem.textContent = 'Por favor, selecione ao menos um serviço!';
                return;  // Não prossegue com a execução
            }

            // Coletando os dados dos campos do formulário
            const nome = document.getElementById('nome').value;
            const email = document.getElementById('email').value;
            const telefone = document.getElementById('telefone').value;
            const dataEvento = document.getElementById('dataEvento').value;
            const local = document.getElementById('tipoEvento').value; 
            const numeroConvidados = document.getElementById('convidados').value;
            const observacoes = document.getElementById('observacoes').value;

            // Coletando os serviços desejados como objetos Servico
            const servicos = [];
            document.querySelectorAll('input[name="servicos"]:checked').forEach(function(checkbox) {
                servicos.push({
                    id: null,
                    nome: checkbox.value,
                    descricao: null
                });
            });

            // Criando o objeto Orcamento
            const orcamento = {
                nomeCliente: nome,
                email: email,
                telefone: telefone,
                dataEvento: dataEvento,
                local: local, 
                numeroConvidados: parseInt(numeroConvidados, 10), 
                servicosDesejados: servicos,
                observacoes: observacoes
            };

            // Enviando o objeto Orcamento para a API
            fetch('/api/orcamentos', {
                method: 'POST',
                headers: {
                    'Content-Type': 'application/json'
                },
                body: JSON.stringify(orcamento)
            })
            .then(response => {
                if (response.ok) {
                    const msg = document.getElementById('mensagem');
                    msg.classList.remove('d-none', 'alert-danger');
                    msg.classList.add('alert', 'alert-success');
                    msg.textContent = 'Obrigado por escolher a Sonora Eventos! Retornaremos seu contato o mais rápido possível.';

                    form.reset();
                } else {
                    throw new Error('Erro ao enviar orçamento.');
                }
            })
            .catch(error => {
                console.error(error);
                const msg = document.getElementById('mensagem');
                msg.classList.remove('d-none', 'alert-success');
                msg.classList.add('alert', 'alert-danger');
                msg.textContent = 'Erro ao enviar orçamento. Tente novamente.';
            });
        });
    }
});



