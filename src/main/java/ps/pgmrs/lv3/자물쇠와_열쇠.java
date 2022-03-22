package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

public class 자물쇠와_열쇠 implements Solution<Boolean> {
    @Override
    public Boolean solution(Object... params) {
        return solution((int[][]) params[0], (int[][]) params[1]);
    }

    public boolean solution(int[][] key, int[][] lock) {
        if (isFilled(lock)) return true;

        int[][] splicedLock = split(lock);
        for (int i = 0; i < 4; i++) {
            splicedLock = rotate(splicedLock);
            if (isEquals(key, splicedLock))
                return true;
        }
        return false;
    }

    boolean isFilled(int[][] lock) {
        for (int[] row : lock) {
            for (int j = 0; j < lock[0].length; j++) {
                if (row[j] == 0) return false;
            }
        }
        return true;
    }

    int[][] split(int[][] lock) {
        int l = lock[0].length - 1;
        int r = 0;
        int u = lock.length - 1;
        int d = 0;
        for (int row = 0; row < lock.length; row++) {
            for (int col = 0; col < lock[0].length; col++) {
                if (lock[row][col] == 0) {
                    l = Math.min(l, col);
                    r = Math.max(r, col);
                    u = Math.min(u, row);
                    d = Math.max(d, row);
                }
            }
        }

        int[][] res = new int[d - u + 1][r - l + 1];
        for (int row = u; row <= d; row++) {
            if (r - l + 1 >= 0)
                System.arraycopy(lock[row], l, res[row - u], 0, r - l + 1);
        }
        return res;
    }

    int[][] rotate(int[][] arr) {
        int[][] res = new int[arr[0].length][arr.length];
        for (int i = 0; i < arr[0].length; i++) {
            for (int j = 0; j < arr.length; j++) {
                res[i][j] = arr[arr.length - j - 1][i];
            }
        }
        return res;
    }

    boolean isEquals(int[][] key, int[][] lock) {
        if (key.length < lock.length || key[0].length < lock[0].length) return false;

        for (int x = 0, row = key.length - lock.length; x <= row; x++) {
            for (int y = 0, col = key[0].length - lock[0].length; y <= col; y++) {
                if (isEquals(key, lock, x, y))
                    return true;
            }
        }
        return false;
    }

    boolean isEquals(int[][] key, int[][] lock, int x, int y) {
        for (int i = 0; i < lock.length; i++) {
            for (int j = 0; j < lock[0].length; j++) {
                if (key[i + x][j + y] + lock[i][j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}
