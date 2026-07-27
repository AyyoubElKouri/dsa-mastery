package com.ayyoub.dsa;

import java.util.LinkedHashMap;
import java.util.Map;

public class Main {

    private static final Map<String, Runnable> DEMOS = new LinkedHashMap<>();

    static {
        register("array", com.ayyoub.dsa.datastructures.linear.array.ArrayDemo::run);
        // add one line here each time you finish a topic
    }

    private static void register(String key, Runnable demo) {
        DEMOS.put(key, demo);
    }

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Available demos (" + DEMOS.size() + "):");
            DEMOS.keySet().forEach(k -> System.out.println("  - " + k));
            System.out.println("\nRun one with: mvn compile exec:java -Dexec.args=\"<name>\"");
            return;
        }

        String key = args[0];
        Runnable demo = DEMOS.get(key);
        if (demo == null) {
            System.out.println("Unknown demo: \"" + key + "\". Available: " + DEMOS.keySet());
            return;
        }

        System.out.println("=== " + key + " ===");
        demo.run();
    }
}
