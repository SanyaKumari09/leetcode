class Solution {
    public boolean squareIsWhite(String coordinates) {
        // Extract column (letter) and row (digit)
        char column = coordinates.charAt(0);
        int row = coordinates.charAt(1) - '0';
        
        // Convert column 'a'..'h' to 1..8
        int colIndex = column - 'a' + 1;
        
        // Check parity
        return (colIndex + row) % 2 != 0;
    }
}
