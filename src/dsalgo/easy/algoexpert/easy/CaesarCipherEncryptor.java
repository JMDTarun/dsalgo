package dsalgo.easy.algoexpert.easy;

public class CaesarCipherEncryptor {

	// https://www.geeksforgeeks.org/caesar-cipher-in-cryptography/
	
	public static String getCeaserCipher(String str, int shift) {
		StringBuilder strBuilder = new StringBuilder();
		for (int i = 0; i < str.length(); i++) {
			char ch = (char) (((int) str.charAt(i) + shift - 65) % 26 + 65);
			strBuilder.append(ch);
		}
		return strBuilder.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(getCeaserCipher("ZTTACKATONCE", 4));
		
		
	}

}
