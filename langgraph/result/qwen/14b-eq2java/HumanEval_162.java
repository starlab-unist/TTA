import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class HumanEval_162 {
    public static String convertTextToHash(String inputString) {
        if (inputString == null || inputString.isEmpty()) {
            return null;
        }
        try {
            MessageDigest md5Digest = MessageDigest.getInstance("MD5");
            byte[] encodedBytes = inputString.getBytes();
            byte[] digest = md5Digest.digest(encodedBytes);
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b & 0xff));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("MD5 algorithm not found", e);
        }
    }
}