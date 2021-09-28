package encode;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import assets.ColorText;

public class SHA_256 
{
	public static byte[] setUp(String input)
	{
		try
		{
			MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
			return messageDigest.digest(input.getBytes(StandardCharsets.UTF_8));
		}
		catch(NoSuchAlgorithmException exception)
		{
			exception.printStackTrace();
			System.err.println(ColorText.TEXT_RED + "Can't even copy code right!" + ColorText.TEXT_RESET);
		}
		
		return null;
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

	public static String getSHA256HashCode(String input)
	{
		return SHA_256.toHexString(SHA_256.setUp(input));
	}
}

//https://www.geeksforgeeks.org/sha-256-hash-in-java/