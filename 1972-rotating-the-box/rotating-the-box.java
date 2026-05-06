class Solution {
    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        // Apply gravity: stones fall to the right
        for (int i = 0; i < m; i++) {
            int lastAvailable = n - 1;
            for (int j = n - 1; j >= 0; j--) {
                if (boxGrid[i][j] == '#') {
                    boxGrid[i][j] = '.';
                    boxGrid[i][lastAvailable] = '#';
                    lastAvailable--;
                } else if (boxGrid[i][j] == '*') {
                    // Obstacle: reset available slot to just left of it
                    lastAvailable = j - 1;
                }
                // '.' : do nothing, lastAvailable stays
            }
        }

        // Rotate 90° clockwise: transpose + reverse each row
        char[][] res = new char[n][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res[j][m - 1 - i] = boxGrid[i][j];
            }
        }
        return res;
    }
}