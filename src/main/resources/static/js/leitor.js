function lerProduto(){
    $("#camera-container").removeClass('d-none');

	let lastCodes = []; // Armazena as últimas leituras
	let requiredMatches = 5; // Número de leituras idênticas necessárias

	Quagga.init({
		inputStream: {
			name: "Live",
			type: "LiveStream",
			target: $('#camera')[0],
			constraints: {
			    width: 640,
			    height: 200,
			}
		},
		decoder: {
			readers: ['code_128_reader','ean_reader']
		},
		debug: true
	}, function(err) {
		if (err) {
			console.log(err);
			return;
		}
		console.log("Initialization finished. Ready to start");
		Quagga.start();
	});

	Quagga.onDetected(function(data) {
		const currentCode = data.codeResult.code;
		if (lastCodes.length === 0 || lastCodes[lastCodes.length - 1] === currentCode) {
			// Adiciona o código se for o primeiro ou igual ao anterior
			lastCodes.push(currentCode);
		} else {
			// Reinicia a contagem se o código for diferente
			lastCodes = [currentCode];
		}

		if (lastCodes.length >= requiredMatches) {        
			insereProduto(currentCode);
			lastCodes = []; // Reinicia para novas leituras									
		}
	});
}

function insereProduto(codigo){
	$("#codBarras").val(codigo);
    selecionarProdutoPorCodigoBarras(codigo)
}

function selecionarProdutoPorCodigoBarras(codBarras) {
    // Obter todos os itens do datalist
    const options = document.querySelectorAll('#produtos option');

    // Loop para verificar cada opção
    options.forEach(option => {
        if (option.getAttribute('data-cod-barras') === codBarras) {
            const input = document.getElementById('produto');
            input.value = option.value;
            const event = new Event('change');
            input.dispatchEvent(event);
        }
    });
}