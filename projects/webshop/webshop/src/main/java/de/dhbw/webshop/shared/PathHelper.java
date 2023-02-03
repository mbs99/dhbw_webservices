package de.dhbw.webshop.shared;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PathHelper {

    public static String[] pathSegments(String base, List<String> pathSeqments) {
        List<String> segments = new ArrayList<>(Arrays.asList(base.split("/")));
        segments.addAll(pathSeqments);

        return segments.stream().filter(segment -> !segment.isEmpty()).toList().toArray(new String[]{});
    }

    public static String[] pathSegments(String base) {
        return pathSegments(base, new ArrayList<>());
    }
}
