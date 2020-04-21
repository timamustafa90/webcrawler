package org.oneaccount.webcrawler.ResultsSanitiser;

import java.util.List;

public interface Sanitiser {
    List<String> removeDuplicates(List<String> list);
}
