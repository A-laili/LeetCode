// 1455. Check If a Word Occurs As a Prefix of Any Word in a Sentence 

 class Solution {
    public int isPrefixOfWord(String sentence, String searchWord) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Iterate through the words
        for (int i = 0; i < words.length; i++) {
            // Check if the current word starts with the searchWord
            if (words[i].startsWith(searchWord)) {
                // Return the index (1-indexed)
                return i + 1;
            }
        }
        
        // If no word starts with the searchWord, return -1
        return -1;
    }
}