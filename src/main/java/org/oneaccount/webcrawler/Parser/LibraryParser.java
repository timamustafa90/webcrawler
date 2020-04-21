package org.oneaccount.webcrawler.Parser;

import org.oneaccount.webcrawler.Search.URLRequestService;

import java.util.ArrayList;
import java.util.List;

public class LibraryParser implements WebpageParser {

    public List<String> getLibraries(List<String> pages) {

        //The complete implementation would have used the provided pages argument. However, the web crawler does not have
        //sophisticated sanitation check for the URLs and therefore invalid URLs are often picked up
        //A parsing library such as JSoup can provide this validation. Alternatively, if regex are used, then
        //exceptions will need to handled for cases where the URL is not valid
        //Additionally a limit needs to be enforced so that only
        ArrayList <String> hardCodedPages = new ArrayList<>();
        hardCodedPages.add("https://winterbe.com/");
        hardCodedPages.add("https://www.java67.com/");
        hardCodedPages.add("https://www.spareroom.co.uk/");
        hardCodedPages.add("https://uk.search.yahoo.com/");
        hardCodedPages.add("https://uk.search.yahoo.com/");
        hardCodedPages.add("https://www.deadcoderising.com/");
        //it is possible to parallelise this by using parallel stream but since we only require a small number of pages, it
        //also we can impose a limit so that we only request the first x links
        hardCodedPages.forEach(page ->  URLRequestService.requestURL(page,Integer.toString(hardCodedPages.indexOf(page)+1)));
        return ParserThreadLauncher.parseLibraries();
    }

}
