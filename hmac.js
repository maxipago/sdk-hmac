function maxipagoHmac(gmt_ts, sig_id, amount, item_id) {

	// WARNING: FOR REFERENCE ONLY!
	// Be very careful about using JavaScript to
	// generate this Hash. Since it runs on the
	// client-side anyone can see the 'secret key'!

	// AVISO: APENAS PARA REFERÊNCIA!
	// Tome cuidado ao utilizar JavaScript para
	// gerar este Hash. Como ele roda no lado
	// do usuário qualquer um pode ver sua 'secret key'!

	// NOTE: Include you must include the 'crypto-js' library located at:
	// http://crypto-js.googlecode.com/svn/tags/3.0.2/build/rollups/hmac-md5.js
	
	// gmt_ts = Timestamp in epoch format
	// sig_id = Random 4-digit number
	// amount = Transaction amount
	// item_id = SKU or Item ID

	var SEP = "*"; // Separator. DO NOT CHANGE
	var secretKey = "secret_key"; // Secret key assigned by maxiPago!
	var toHash = gmt_ts + SEP + sig_id + SEP + amount + SEP + item_id;
	var hash = CryptoJS.HmacMD5(toHash, secretKey);
	
	document.write("Signature: " + hash);
}