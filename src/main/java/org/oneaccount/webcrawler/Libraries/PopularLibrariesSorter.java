package org.oneaccount.webcrawler.Libraries;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PopularLibrariesSorter implements LibrariesSorter {

    @Override
    public List<String> getTopLibraries(List<String> libraries) {
        return libraries
                .stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                //The complete implementation would have this limit placed in a properties file
                .limit(5)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

}
