package ps.pgmrs.lv4;

import ps.pgmrs.Solution;

import java.util.*;

public class 가사검색 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((String[]) params[0], (String[]) params[1]);
    }

    public int[] solution(String[] words, String[] queries) {
        Trie trie = new Trie();
        Trie reversed = new Trie();

        for (String word : words) {
            insert(trie, word);
            insert(reversed, reverse(word));
        }

        return Arrays.stream(queries)
                .map(query -> query.startsWith("?") ? query(reversed, reverse(query)) : query(trie, query))
                .mapToInt(count -> count)
                .toArray();
    }

    String reverse(String str) {
        return new StringBuilder(str).reverse().toString();
    }

    int query(Trie root, String word) {
        Trie runner = root;
        for (int i = 0, len = word.length(); i < len; i++) {
            Character ch = word.charAt(i);
            if (ch.equals('?')) return runner.counts.getOrDefault(len - i, 0);
            if (runner.isTerminal) return 0;
            if (!runner.children.containsKey(ch)) return 0;
            runner = runner.children.get(ch);
        }

        return 0;
    }

    void insert(Trie root, String word) {
        int len = word.length();
        Trie run = root;
        for (int i = 0; i < len; i++) {
            Character ch = word.charAt(i);
            if (!run.children.containsKey(ch)) {
                run.children.put(ch, new Trie());
            }
            run.counts.put(len - i, run.counts.getOrDefault(len - i, 0) + 1);
            run = run.children.get(ch);
        }
        run.isTerminal = true;
    }

    class Trie {
        Map<Character, Trie> children = new HashMap<>();
        Map<Integer, Integer> counts = new HashMap<>();
        boolean isTerminal;
    }
}
