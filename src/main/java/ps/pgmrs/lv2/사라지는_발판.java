package ps.pgmrs.lv2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 사라지는_발판 {
    private static final int[][] DIRECTION = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public int solution(int[][] board, int[] aloc, int[] bloc) {
        return playGame(board, new Player(aloc), new Player(bloc)).count;
    }

    private Result playGame(int[][] board, Player a, Player b) {
        List<Player> nextPlayers = getNextPlayers(board, a);

        if (nextPlayers.size() == 0)
            return new Result(false, 0);

        board[a.row][a.col] = 0;
        List<Result> nextResults = nextPlayers.stream()
                .map(np -> playGame(board, b, np))
                .collect(Collectors.toList());
        board[a.row][a.col] = 1;

        boolean isAbleToWin = nextResults.stream().anyMatch(result -> !result.firstIsWin);
        int count = isAbleToWin
                ? filter(nextResults, res -> !res.firstIsWin).min().orElse(0)
                : filter(nextResults, res -> res.firstIsWin).max().orElse(Integer.MAX_VALUE);

        return new Result(isAbleToWin, count + 1);
    }

    private IntStream filter(List<Result> results, Predicate<Result> func) {
        return results.stream()
                .filter(func)
                .mapToInt(result -> result.count);
    }

    private List<Player> getNextPlayers(int[][] board, Player player) {
        if (board[player.row][player.col] == 0) return Collections.emptyList();

        return Arrays.stream(DIRECTION)
                .map(player::moveTo)
                .filter(nextPlayer -> nextPlayer.isNotIsolatedIn(board))
                .collect(Collectors.toList());
    }

    static class Result {
        boolean firstIsWin;
        int count;

        public Result(boolean firstIsWin, int count) {
            this.firstIsWin = firstIsWin;
            this.count = count;
        }
    }

    static class Player {
        int row, col;

        public Player(int[] arr) {
            this(arr[0], arr[1]);
        }

        public Player(int row, int col) {
            this.row = row;
            this.col = col;
        }

        public Player moveTo(int[] dir) {
            return new Player(row + dir[0], col + dir[1]);
        }

        public boolean isNotIsolatedIn(int[][] board) {
            if (row < 0 || col < 0 || board.length <= row || board[0].length <= col) return false;
            return board[row][col] == 1;
        }
    }
}
