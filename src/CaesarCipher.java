import java.util.*;
public class CaesarCipher {
    public static void main(String[] args)
    {
        System.out.println("Caesar cipher implementation:");

        CaesarCipher caesarCipher = new CaesarCipher();

        //String msg = "HELLO";
        String msg = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        //String msg = "abcdefghijklmnopqrstuvwxyz";
        int key = 29;

        System.out.println("Original message: "+ msg);

        String encrypt = caesarCipher.encryptWithoutNumbers(msg, key%26);

        System.out.println("Encrypted message: "+ encrypt);

        String decrypt = caesarCipher.encryptWithoutNumbers(encrypt, 26 - (key%26));
        System.out.println("Decrypted message: "+ decrypt);
    }

    public String encrypt(String msg, int key)
    {
        char[] c = msg.toCharArray();
        char[] e = new char[msg.length()];

        for(int i=0; i<c.length; i++)
        {
            if((int)c[i] >= 65 && (int)c[i] <= 90)
            {
                int enc = ((int)c[i] % 65 + key)%26 + 65;
                e[i] = (char)enc;
            }
            else if((int)c[i] >= 97 && (int)c[i] <= 122)
            {
                int enc = ((int)c[i] % 97 + key)%26 + 97;
                e[i] = (char)enc;
            }
            else
            {
                e[i] = c[i];
            }
        }
        return String.valueOf(e);
    }

    public String encryptWithoutNumbers(String msg, int key)
    {
        char[] c = msg.toCharArray();
        char[] e = new char[c.length];

        for(int i=0;i<c.length;i++) {

            if (c[i] >= 'A' && c[i] <= 'Z')
            {
                int originalPosition = c[i] - 'A';
                int newPosition = (originalPosition + key) % 26;
                e[i] = (char) (newPosition + 'A');
            }
            else if (c[i] >= 'a' && c[i] <= 'z')
            {
                int originalPosition = c[i] - 'a';
                int newPosition = (originalPosition + key) % 26;
                e[i] = (char) (newPosition + 'a');
            }
            else
            {
                e[i] = c[i];
            }
        }
        return String.valueOf(e);
    }
}
