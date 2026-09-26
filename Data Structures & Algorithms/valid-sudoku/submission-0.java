class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer,Set<Character>> rowSeen = new HashMap<>();
        Map<Integer,Set<Character>> columnSeen = new HashMap<>();
        Map<String,Set<Character>> boxSeen = new HashMap<>();

        for(int row=0;row<9;row++){
            for(int col=0; col<9;col++){
                if(board[row][col] =='.') continue;
                String box = (row/3) +","+(col/3);
                if(
                    rowSeen.computeIfAbsent(row,k -> new HashSet<>()).contains(board[row][col]) ||
                    columnSeen.computeIfAbsent(col,k -> new HashSet<>()).contains(board[row][col]) ||
                    boxSeen.computeIfAbsent(box, k-> new HashSet<>()).contains(board[row][col])
                )
                 {
                    return false;
                }            
                rowSeen.get(row).add(board[row][col]);
                columnSeen.get(col).add(board[row][col]);
                boxSeen.get(box).add(board[row][col]);
            }
        }
            return true;
    }
}
