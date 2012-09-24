import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class HmacMd5 {

	private static final String SEP = "*"; // Separator. DO NOT CHANGE
	
	// Hashes the values
	public static String maxiPago(String sKey, String gmt_ts, String sig_id, String amount, String item_id) throws Exception {
	
		SecretKey secretKey = new SecretKeySpec(sKey.getBytes(), "HmacMD5");
		
		Mac mac = Mac.getInstance("HmacMD5");
		mac.init(secretKey);
		String concat = gmt_ts + SEP + sig_id + SEP + amount + SEP + item_id;
		byte[] result = mac.doFinal(concat.getBytes());
		
		StringBuffer buf = new StringBuffer(result.length * 2);
		
		for(int i=0; i< result.length; i++) {
			if(((int) result[i] & 0xff) < 0x10)
			buf.append("0");
			buf.append(Long.toString((int) result[i] & 0xff, 16));
		}
		return buf.toString();
	}
	
	// Prints the HMAC hash
	public static void main(String args[]) {
	
		String signature;
		
		try {
			signature = HmacMd5.maxiPago(
				"secret_key", // Secret key assigned by maxiPago!
				"gmt_ts", // Timestamp in epoch format
				"sig_id", // Random 4-digit number
				"amount", // Transaction amount
				"item_id" // SKU or Item ID
			);
			System.out.println(signature);
		}
		catch (Exception e) { e.printStackTrace(); }
	}
}
