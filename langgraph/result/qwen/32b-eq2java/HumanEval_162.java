import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HumanEval_162 {

    public static String convertTextToHash(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return null;
        }
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            byte[] encodedString = inputString.getBytes(java.nio.charset.StandardCharsets.US_ASCII);
            byte[] hashBytes = md.digest(encodedString);
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException(e);
        }
    }
}