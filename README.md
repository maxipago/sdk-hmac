## PORTUGUÊS ##

O HMAC-MD5 é usado para autenticar as requisições feitas pela **Lightbox maxiPago!** e pela **smartPage maxiPago!**.

Como medida de segurança, para termos certeza que a transação está vindo de um cliente válido da **maxiPago!**, você precisará nos enviar, juntamente com as informações da transação, a **_signature_** para autenticar o pedido.

As informações de transação devem ser concatenadas na ordem abaixo, os valores deverão ser separados por um asterisco. A **secret key** é usada no hash de função e não é incluida no string concatenado.

**Valores concatenados:**

		Valores: timestamp*sig_id*amount*item_id

**Exemplo usando "_jM13K8hdbWi2V9ab_" como secret key:**

		Exemplo: 1325248408*5038*15,00*123123
		Assinatura: 799074cdb40ce532ed97bf11a9e7963f


A **_secret key_** é criada pela maxiPago! durante o processo de configuração da loja.

## ENGLISH ##

The HMAC-MD5 hash is used to authenticate requests made from both the **maxiPago! Lightbox** and the **maxiPago! smartPage**.

As a security measure to make sure that a transaction is coming from a valid **maxiPago!** merchant you'll need to send, along with the transaction information, a **_signature_** to authenticate the request.

The transaction information must be concatenated in the order below, with the values being separated by an asterisk. The **secret key** is used in the hash function and is not included in the concatenated string.

**Concatenated values:**

		Values: timestamp*sig_id*amount*item_id

**Example using "_jM13K8hdbWi2V9ab_" as secret key:**

		Example: 1325248408*5038*15,00*123123
		Signature: 799074cdb40ce532ed97bf11a9e7963f


The **_secret key_** is assigned by **maxiPago!** during boarding and setup.
