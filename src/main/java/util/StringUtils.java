package util;

import java.util.Map;

public class StringUtils {
    public static void print(Map<?, ?> map) {
        map.entrySet().forEach(
                entry -> {
                    System.out.println(entry.getKey());
                    System.out.println(entry.getValue());
                    System.out.println();
                }
        );
    }
}
