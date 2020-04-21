package org.oneaccount.webcrawler;

import org.oneaccount.webcrawler.Input.ConsoleInputReader;
import org.oneaccount.webcrawler.Input.InputReader;
import org.oneaccount.webcrawler.Libraries.PopularLibrariesSorter;
import org.oneaccount.webcrawler.Parser.LibraryParser;
import org.oneaccount.webcrawler.Parser.GoogleSearchResultParser;
import org.oneaccount.webcrawler.ResultsSanitiser.Sanitiser;
import org.oneaccount.webcrawler.Search.URLRequestService;
import org.oneaccount.webcrawler.ResultsSanitiser.DuplicationSanitiser;

import java.util.List;

public class WebCrawlerApplication {

    public static void main(String[] args) {

        InputReader inputReader = new ConsoleInputReader();

        URLRequestService.querySearchEngine(inputReader.getSearchTerm());

        GoogleSearchResultParser googleResultParser = new GoogleSearchResultParser();

        List<String> pages = googleResultParser.getResult();

        LibraryParser libraryParser = new LibraryParser();

        List<String> libraries = libraryParser.getLibraries(pages);

        PopularLibrariesSorter topLibrariesCalculator = new PopularLibrariesSorter();
        List <String> topLibraries = topLibrariesCalculator.getTopLibraries(libraries);

        Sanitiser duplicationSanitiser = new DuplicationSanitiser();
        List <String> finalResult = duplicationSanitiser.removeDuplicates(topLibraries);
        System.out.println(finalResult);
    }




}
