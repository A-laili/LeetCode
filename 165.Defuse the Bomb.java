public class BombDefuser {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] decryptedCode = new int[n];

        if (k == 0) {
            // If k is 0, replace every element with 0
            return decryptedCode; // All elements are already initialized to 0
        }

        for (int i = 0; i < n; i++) {
            int sum = 0;
            if (k > 0) {
                // Sum the next k elements
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n]; // Use modulo for circular indexing
                }
            } else {
                // Sum the previous k elements
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n]; // Use modulo for circular indexing
                }
            }
            decryptedCode[i] = sum;
        }

        return decryptedCode;
    }

    public static void main(String[] args) {
        BombDefuser defuser = new BombDefuser();
        int[] code = {5, 7, 2, 4};
        int k = 3; // Example case
        int[] result = defuser.decrypt(code, k);
        
        // Print the result
        for (int num : result) {
            System.out.print(num + " ");
        }
    }
}