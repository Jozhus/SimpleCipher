package Cipher;

import Queue.Queue;

public class simpleCipher {

    private Queue<Integer> key;

    public simpleCipher() {
        this.key = new Queue<Integer>();
    }

    public simpleCipher(int[] key) {
        setKey(key);
    }

    public void setKey(int[] key) {
        this.key = new Queue<Integer>();

        //Load key into queue
        for (int x : key) {
            this.key.enqueue(x);
        }
    }

    public String encode(String msg) {
        String result = "";

        for (char c : msg.toCharArray()) {
            int shift = key.dequeue();
            result += (char) (c + shift);
            key.enqueue(shift);
        }

        //Reset key so it can be used consistently after every use
        resetKey(key.size() - (msg.length() % key.size()));

        return result;
    }

    public String decode(String msg) {
        //This works, but is almost exactly the same as encode()
        String result = "";

        for (char c : msg.toCharArray()) {
        int shift = key.dequeue();
        result += (char) (c - shift);
        key.enqueue(shift);
        }

        //Reset key so it can be used consistently after every use
        resetKey(key.size() - (msg.length() % key.size()));

        return result;
    }

    private void resetKey(int offset) {
        //Key might be offset after each use, so it must be reset back to its original state
        if (offset == key.size()) return;
        for (int i = 0; i < offset; i++) {
            key.enqueue(key.dequeue());
        }
    }
}