package encode;
import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA_256 
{
	public static byte[] setUp(String input) throws NoSuchAlgorithmException
	{
		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
	}

	public static String toHexString(byte[] hashCode)
	{
		BigInteger number = new BigInteger(1, hashCode);

		StringBuilder hexString = new StringBuilder(number.toString(16));

		while(hexString.length() < 32)
		{
			hexString.insert(0, '0');
		}
		
		return hexString.toString();
	}

	public static String getSHA256HashCode(String input) throws NoSuchAlgorithmException
	{
		return SHA_256.toHexString(SHA_256.setUp(input));
	}
}
