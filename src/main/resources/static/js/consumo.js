$("#produto").on('change', function(){
    let valorSelecionado = $(this).val();
    let optionSelecionado = $("#produtos option").filter(function () {
        return $(this).val() === valorSelecionado;
    });

    let produtoId = optionSelecionado.data("id");
    let codBarras = optionSelecionado.data("cod-barras");
    let produtoPreco = parseFloat(optionSelecionado.data("preco")).toFixed(2);

    $("#codBarras").val(codBarras);
    $("#valorProduto").text(" R$ "+produtoPreco);
    $("#valorTotalProduto").text(" R$ " + produtoPreco);
    $("#qtdProduto").val(1);
    $(".infoProduto").removeClass("d-none");
});

$("#qtdProduto").on('change',function () {
    let a = parseInt($(this).val());
    let b =(parseFloat($("#valorProduto").text().replace(/\D/g, ''))/100);

    $("#valorTotalProduto").text(" R$ " + (a*b).toFixed(2));
});