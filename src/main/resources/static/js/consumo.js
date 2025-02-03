$("#produto").on('change', function(){
    let valorSelecionado = $(this).val();
    let optionSelecionado = getSelectedItem(valorSelecionado);

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
    let b = (parseFloat($("#valorProduto").text().replace(/\D/g, ''))/100);

    $("#valorTotalProduto").text(" R$ " + (a*b).toFixed(2));
});

$("#btnIncluir").click(function(){
    let locacao = $(this).data("locacao");
    let produto = getSelectedItem($("#produto").val()).data("id");
    let quantidade = $("#qtdProduto").val();

    $.ajax({
        url: "/consumo",
        method: "POST",
        data:{
            locacao: locacao,
            produto: produto,
            quantidade: quantidade
        },
        success: function(data){
            $("#itens-consumo").prepend(data);
        },
        error: function(){
            alert("Deu Ruim!");
        }
    });
});

function getSelectedItem(selectedText){
    return $("#produtos option").filter(function () {
            return $(this).val() === selectedText;
    });
}