// import java.util.ArrayList;
// import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        // Map each alphabet letter (a-z) to its row index (0, 1, or 2)
        // Keyboard rows: 
        // 0: qwertyuiop
        // 1: asdfghjkl
        // 2: zxcvbnm
        int[] letterToRowMap = {
            1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 1, 1, 2, 
            2, 0, 0, 0, 0, 1, 0, 0, 2, 0, 2, 0, 2
        };
        
        List<String> validWords = new ArrayList<>();
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            // Get the row index of the first character (case-insensitive)
            int targetRow = letterToRowMap[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean isValid = true;
            
            // Check if all subsequent characters belong to the same row
            for (int i = 1; i < word.length(); i++) {
                if (letterToRowMap[Character.toLowerCase(word.charAt(i)) - 'a'] != targetRow) {
                    isValid = false;
                    break;
                }
            }
            
            if (isValid) {
                validWords.add(word);
            }
        }
        
        // Convert the list back to an array
        return validWords.toArray(new String[0]);
    }
}
