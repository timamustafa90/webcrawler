package org.oneaccount.webcrawler.ResultsSanitiser;

import java.util.List;
import java.util.stream.Collectors;

public class DuplicationSanitiser implements Sanitiser {
    public List<String> removeDuplicates(List<String> list) {
        //The complete implementation would have added the logic to remove duplicates here
        //Currently, this method is unnecessary as we have already removed duplicates from the
        //list in PopularLibrariesSorter::getTopLibraries
        return list.stream()
                .distinct()
                .collect(Collectors.toList());
    }
}
