$(document).ready(function () {
    const $form = $('#form-orcamento');
    if (!$form.length) return;

    $form.on('submit', function (e) {
        e.preventDefault();

        $('#mensagem')
          .removeClass('alert-danger alert-success')
          .addClass('d-none')
          .text('');

        const servicosMarcados = $("input[name='servicos']:checked")
            .map(function () { return this.value; })
            .get();

        if (servicosMarcados.length === 0) {
            $('#mensagem')
              .removeClass('d-none')
              .addClass('alert alert-danger')
              .text('Por favor, selecione pelo menos um serviço desejado.');
            return;
        }

        const novoOrc = {
            nomeCliente: $('#nome').val(),
            emailCliente: $('#email').val(),
            telefoneCliente: $('#telefone').val(),
            dataEvento: $('#dataEvento').val(),
            tipoEvento: $('#tipoEvento').val(),
            numeroConvidados: parseInt($('#convidados').val(), 10),
            observacoes: $('#observacoes').val(),
            servicosDesejados: servicosMarcados.join(", ")
        };

        $.ajax({
            url: '/api/orcamentos',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(novoOrc),
            success: function () {
                $('#mensagem')
                  .removeClass('d-none alert-danger')
                  .addClass('alert alert-success')
                  .text('Orçamento enviado com sucesso!');
                $form[0].reset();
            },
            error: function () {
                $('#mensagem')
                  .removeClass('d-none alert-success')
                  .addClass('alert alert-danger')
                  .text('Erro ao enviar orçamento. Tente novamente.');
            }
        });
    });
});








