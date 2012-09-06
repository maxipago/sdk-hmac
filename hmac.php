<?php
$gmt_ts = ""; // Timestamp in epoch format
$sig_id = ""; // Random 4-digit number
$amount = ""; // Transaction amount
$item_id = ""; // SKU or Item ID

define("hashKey", "your-secret-key-here"); // Secret key assigned by maxiPago!
define("SEP", "*"); // Separator. DO NOT CHANGE

$toHash = $gmt_ts.SEP.$sig_id.SEP.$amount.SEP.$item_id;
$hmac = hash_hmac("MD5", $toHash, hashKey);

echo "Signature: " . $hmac;
?>