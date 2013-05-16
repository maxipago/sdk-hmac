<?php
class hmachHash {
	
	public function getRequestSignature($hp_sig_timestamp,$hp_sig_id,$hp_amount,$hp_sig_itemid,$secretKey) {
		$toHash = $hp_sig_timestamp."*".$hp_sig_id."*".$hp_amount."*".$hp_sig_itemid;
		return hash_hmac("MD5", $toHash, $secretKey);
	}
	
	public function getResponseSignature($hp_refnum,$hp_amount,$hp_responsemsg,$secretKey) {
		$toHash = $hp_refnum."*".$hp_amount."*".$hp_responsemsg;
		return hash_hmac("MD5", $toHash, $secretKey);
	}
	
}
?>