import java.util.Random;

public class MarupekeGame {

    private static char[][] grid;
    private boolean[][] editable;
    private int length;

    public MarupekeGame(int size) {
        if (size < 3) {
            size = 3;
        } else if (size > 10) {
            size = 10;
        }
        grid = new char[size][size];
        editable = new boolean[size][size];
        length = size;
    }

    public int getSize() {
        return grid.length;
    }

    public boolean setSolid(int x, int y) {
        if (x >= length || x < 0 || y >= length || y < 0) {
            System.out.println("Index(s) out of bounds.");
        } else {
            grid[x][y] = '█';
            editable[x][y] = false;
        }
        return !editable[x][y];
    }

    public boolean setX(int x, int y, boolean canEdit) {
        if (x >= length || x < 0 || y >= length || y < 0) {
            System.out.println("Index(s) out of bounds.");
        } else {
            grid[x][y] = 'X';
            if (canEdit) editable[x][y] = !editable[x][y];
        }
        return !editable[x][y];
    }

    public boolean setO(int x, int y, boolean canEdit) {
        if (x >= length || x < 0 || y >= length || y < 0) {
            System.out.println("Index(s) out of bounds.");
        } else {
            grid[x][y] = 'O';
            if (canEdit) editable[x][y] = !editable[x][y];
        }
        return !editable[x][y];
    }

    public boolean isLegalGrid() {
        for (int i = 0; i < length; i++) {
            char current = grid[i][0];
            int count = 0;
            for (int j = 0; j < length-2; j++) {
                if (grid[i][j] == current) count++;
            }
            if (count > 2) return false;
        }
        for (int i = 0; i < length; i++) {
            char current = grid[i][0];
            int count = 0;
            for (int j = 0; j < length-2; j++) {
                if (grid[j][i] == current) count++;
            }
            if (count > 2) return false;
        }
        return true;
    }

    public static MarupekeGame randomPuzzle(int size, int numFill, int numX, int numO) {
        if (numFill + numO + numX >= Math.pow(size, 2)) {
            return null;
        } else {
            MarupekeGame game = new MarupekeGame(size);
            int numFillCount = 0;
            while (numFillCount != numFill) {
                int x = new Random().nextInt(game.getSize());
                int y = new Random().nextInt(game.getSize());
                if (grid[x][y] != '█' || grid[x][y] != 'X' || grid[x][y] != 'O') {
                    game.setSolid(x, y);
                    ++numFillCount;
                }
            }
            int numXCount = 0;
            while (numXCount != numX) {
                int x = new Random().nextInt(game.getSize());
                int y = new Random().nextInt(game.getSize());
                if (grid[x][y] != '█' || grid[x][y] != 'X' || grid[x][y] != 'O') {
                    game.setX(x, y, false);
                    ++numXCount;
                }
            }
            int numOCount = 0;
            while (numOCount != numO) {
                int x = new Random().nextInt(game.getSize());
                int y = new Random().nextInt(game.getSize());
                if (grid[x][y] != '█' || grid[x][y] != 'X' || grid[x][y] != 'O') {
                    game.setO(x, y, false);
                    ++numOCount;
                }
            }
            return game;
        }
    }

    public String toString() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < length; i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < length; j++) {
                if (grid[i][j] != '█' || grid[i][j] != 'X' || grid[i][j] != 'O') {
                    temp.append('_');
                } else {
                    temp.append(grid[i][j]);
                }
            }
            temp.append("\n");
            out.append(temp);
        }
        return String.valueOf(out);
    }
}
