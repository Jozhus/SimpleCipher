package Cipher;

public class Client {
    public static void main(String[] args) {
        int[] key = {3, 1, 7, 4, 2, 5};
        simpleCipher sc = new simpleCipher(key);

        System.out.println("Should print out the key: " + sc.encode("000000"));
        System.out.println("Should print out '000000': " + sc.decode("317425"));
        System.out.println(sc.decode(sc.encode("This message has been encoded then decoded.")));
    }
}
