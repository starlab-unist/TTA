import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HumanEval_162 {

    public static String convertTextToHash(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return null;
        }

        try {
            // Encode the input string to ASCII bytes
            byte[] encodedBytes = inputString.getBytes("ASCII");

            // Create a MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Compute the hash
            byte[] hashBytes = md.digest(encodedBytes);

            // Convert the hash bytes to a hexadecimal string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) {
                    hexString.append('0');
                }
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}