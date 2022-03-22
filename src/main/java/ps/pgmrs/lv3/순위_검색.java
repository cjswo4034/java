package ps.pgmrs.lv3;

import ps.pgmrs.Solution;

import java.util.*;

public class 순위_검색 implements Solution<int[]> {
    @Override
    public int[] solution(Object... params) {
        return solution((String[]) params[0], (String[]) params[1]);
    }

    static final String[] LANGUAGES = {"cpp", "java", "python", "-"};
    static final String[] DEPARTMENTS = {"backend", "frontend", "-"};
    static final String[] SCIENCES = {"junior", "senior", "-"};
    static final String[] FOODS = {"chicken", "pizza", "-"};
    static final String[][] categories = {LANGUAGES, DEPARTMENTS, SCIENCES, FOODS};

    public int[] solution(String[] infos, String[] queries) {
        int[] answer = new int[queries.length];
        Category category = new Category();
        init(category, 0);

        for (String info: infos) {
            insert(category, split(info), 0);
        }

        for (int i = 0; i < queries.length; i++) {
            answer[i] = query(category, split(queries[i]));
        }

        return answer;
    }

    void init(Category category, int index) {
        if (categories.length <= index) return;

        Category next;
        for (int i = 0, len = categories[index].length; i < len; i++) {
            next = category.insert(categories[index][i]);
            init(next, index + 1);
        }
    }

    void insert(Category category, String[] queries, int index) {
        if (categories.length <= index) {
            Score score = category.getScore();
            score.addScore(Integer.parseInt(queries[4]));
            return;
        }

        insert(category.getSubCategory("-"), queries, index + 1);
        insert(category.getSubCategory(queries[index]), queries, index + 1);
    }

    int query(Category category, String[] queries) {
        Score score = category
                .getSubCategory(queries, 0, 3)
                .getScore();

        return score.getCount(Integer.parseInt(queries[4]));
    }

    String[] split(String query) {
        return query.split("[ ](and )?");
    }

    class Category {
        Map<String, Category> subCategories = new HashMap<>();
        Score score;

        Category insert(String key) {
            Category category = new Category();
            subCategories.put(key, category);
            return category;
        }

        public Category getSubCategory(String key) {
            return subCategories.get(key);
        }

        public Category getSubCategory(String[] keys, int from, int to) {
            Category result = subCategories.get(keys[from]);
            return from == to ?
                    result :
                    result.getSubCategory(keys, from + 1, to);
        }

        public Score getScore() {
            if (score == null)
                score = new Score();
            return score;
        }
    }

    class Score {
        final List<Integer> scores = new ArrayList<>();
        boolean isSorted = false;

        void addScore(int score) {
            scores.add(score);
        }

        void sort() {
            Collections.sort(scores);
            isSorted = true;
        }

        int getCount(int lowerBound) {
            if (!isSorted) sort();

            final int length = scores.size();
            int l = 0;
            int r = scores.size() - 1;
            while (l <= r) {
                int mid = (l + r) >> 1;

                if (scores.get(mid) < lowerBound) {
                    l = mid + 1;
                } else
                    r = mid - 1;
            }
            return length - l;
        }
    }
}
