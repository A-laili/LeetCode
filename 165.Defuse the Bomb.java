/*You have a bomb to defuse, and your time is running out! Your informer will provide you with a circular array code of length of n and a key k.

To decrypt the code, you must replace every number. All the numbers are replaced simultaneously.

If k > 0, replace the ith number with the sum of the next k numbers.
If k < 0, replace the ith number with the sum of the previous k numbers.
If k == 0, replace the ith number with 0.
As code is circular, the next element of code[n-1] is code[0], and the previous element of code[0] is code[n-1].

Given the circular array code and an integer key k, return the decrypted code to defuse the bomb

*/

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