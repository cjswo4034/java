package ps.pgmrs.lv2;

import ps.pgmrs.Solution;

import java.util.*;
import java.util.stream.Collectors;

public class 메뉴_리뉴얼 implements Solution<String[]> {
    @Override
    public String[] solution(Object... params) {
        return solution1((String[]) params[0], (int[]) params[1]);
    }

    Map<String, Integer> candidates = new HashMap<>();
    Map<Integer, Integer> maxOfCourse = new HashMap<>();

    public String[] solution1(String[] orders, int[] courses) {
        maxOfCourse = Arrays.stream(courses)
                .boxed()
                .collect(Collectors.toMap(c -> c, c -> 0));

        Arrays.stream(orders)
                .map(this::sort)
                .forEach(order -> permute(order, "", 0));

        return candidates.entrySet().stream()
                .filter(entry -> entry.getValue() > 1)
                .filter(entry -> maxOfCourse.get(entry.getKey().length()).equals(entry.getValue()))
                .map(Map.Entry::getKey)
                .sorted()
                .toArray(String[]::new);
    }

    String sort(String str) {
        char[] chars = str.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }

    void permute(String word, String curr, int index) {
        if (maxOfCourse.containsKey(curr.length())) {
            int count = candidates.getOrDefault(curr, 0) + 1;
            candidates.put(curr, count);
            maxOfCourse.put(curr.length(), Math.max(count, maxOfCourse.get(curr.length())));
        }

        for (int i = index; i < word.length(); i++) {
            permute(word, curr + word.charAt(i), i + 1);
        }
    }

    /////////////////////////////////////////////////////////////

    public String[] solution2(String[] orders, int[] course) {
        Map<String, Integer> candidates = new HashMap<>();
        Set<Integer> courses = Arrays.stream(course)
                .boxed()
                .collect(Collectors.toSet());

        for (int i = 0; i < orders.length; i++) {
            for (int j = i + 1; j < orders.length; j++) {
                addCandidate(candidates, orders[i], orders[j], courses);
            }
        }

        List<String> answer = new ArrayList<>();
        for (int count : course) {
            int max = getMax(candidates, count);
            answer.addAll(getCourses(candidates, count, max));
        }

        Collections.sort(answer);
        return answer.toArray(String[]::new);
    }

    List<String> getCourses(Map<String, Integer> candidates, int count, int orders) {
        return candidates.entrySet().stream()
                .filter(entry -> entry.getKey().length() == count)
                .filter(entry -> entry.getValue().equals(orders))
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    int getMax(Map<String, Integer> candidates, int count) {
        return candidates.entrySet().stream()
                .filter(entry -> entry.getKey().length() == count)
                .mapToInt(Map.Entry::getValue)
                .max().orElse(1);
    }

    void addCandidate(Map<String, Integer> candidates, String order1, String order2, Set<Integer> courses) {
        for (String candidate : getCandidate(order1, order2, courses)) {
            candidates.put(candidate, candidates.getOrDefault(candidate, 0) + 1);
        }
    }

    List<String> getCandidate(String order1, String order2, Set<Integer> courses) {
        List<String> result = new ArrayList<>();
        Set<Character> o1 = toCharSet(order1);
        Set<Character> o2 = toCharSet(order2);

        List<Character> menus = intersect(o1, o2);
        List<String> candidates = permute(menus, "", -1);

        for (String candidate : candidates) {
            if (courses.contains(candidate.length()))
                result.add(candidate);
        }
        return result;
    }

    Set<Character> toCharSet(String order) {
        return order.chars()
                .mapToObj(menu -> (char) menu)
                .collect(Collectors.toSet());
    }

    List<Character> intersect(Set<Character> set1, Set<Character> set2) {
        List<Character> list = new ArrayList<>();
        Set<Character> smallSet;
        Set<Character> largeSet;
        if (set1.size() <= set2.size()) {
            smallSet = set1;
            largeSet = set2;
        } else {
            smallSet = set2;
            largeSet = set1;
        }
        for (Character ch : smallSet) {
            if (largeSet.contains(ch))
                list.add(ch);
        }
        Collections.sort(list);
        return list;
    }

    List<String> permute(List<Character> list, String prev, int start) {
        if (start >= list.size()) return new ArrayList<>();

        String next;
        List<String> result = new ArrayList<>();
        for (int i = start + 1; i < list.size(); i++) {
            next = prev + list.get(i);
            result.add(next);
            result.addAll(permute(list, next, i));
        }

        return result;
    }
}
