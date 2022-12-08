package ps.pgmrs.lv3;

import java.util.Arrays;
import java.util.Stack;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class 표_편집 {
    public String solution(int n, int k, String[] cmds) {
        Chart chart = new Chart(n, k);

        Arrays.stream(cmds)
                .forEach(chart::action);

        return chart.result();
    }

    static class Item {
        int prev, next, value;
        boolean isDeleted;

        public Item(int value) {
            this.prev = value - 1;
            this.next = value + 1;
            this.value = value;
        }
    }

    static class Chart {
        private final Stack<Item> history;
        private final Item[] items;
        private int cursor;

        public Chart(int n, int cursor) {
            this.history = new Stack<>();
            this.cursor = cursor;
            this.items = IntStream.range(0, n)
                    .mapToObj(Item::new)
                    .toArray(Item[]::new);
            this.items[n - 1].next = -1;
        }

        String result() {
            return Arrays.stream(items)
                    .map(item -> item.isDeleted ? "X" : "O")
                    .collect(Collectors.joining());
        }

        void action(String cmd) {
            switch (cmd.charAt(0)) {
                case 'U':
                    up(Integer.parseInt(cmd.split(" ")[1]));
                    break;
                case 'D':
                    down(Integer.parseInt(cmd.split(" ")[1]));
                    break;
                case 'C':
                    remove();
                    break;
                case 'Z':
                    undo();
                    break;
            }
        }

        private void up(int count) {
            for (int i = 0; i < count; i++)
                cursor = items[cursor].prev;
        }

        private void down(int count) {
            for (int i = 0; i < count; i++)
                cursor = items[cursor].next;
        }

        private void remove() {
            Item deletedItem = items[cursor];

            history.push(items[cursor]);
            deletedItem.isDeleted = true;

            if (deletedItem.prev != -1) items[deletedItem.prev].next = deletedItem.next;
            if (deletedItem.next != -1) items[deletedItem.next].prev = deletedItem.prev;

            cursor = deletedItem.next != -1 ? deletedItem.next : deletedItem.prev;
        }

        private void undo() {
            if (history.isEmpty()) return;

            Item deletedItem = history.pop();
            deletedItem.isDeleted = false;

            if (deletedItem.prev != -1) items[deletedItem.prev].next = deletedItem.value;
            if (deletedItem.next != -1) items[deletedItem.next].prev = deletedItem.value;
        }
    }
}
