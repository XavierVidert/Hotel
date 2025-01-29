function lerProduto(){
    $("#camera-container").removeClass('d-none');

	let lastCodes = []; // Armazena as últimas leituras
	let requiredMatches = 5; // Número de leituras idênticas necessárias

	Quagga.init({
		inputStream: {
			name: "Live",
			type: "LiveStream",
			target: $('#camera')[0]
		},
		decoder: {
			readers: ['ean_reader']
		}
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
	$("#fake").removeClass("d-none");
}