package org.oneaccount.webcrawler.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class GoogleSearchResultParser implements SearchResultParser {

    //This solution is not ideal because we cannot be sure that the regex is comprehensive. There may be some cases that
    // have been missed out. This approach has been taken to minimise the use of external APIs.
    //A better approach may be to use the Jsoup library
    //I have extracted all the links as opposed to main search links for sake of simplicity
    @Override
    public List<String> getResult() {
        List<String> links = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\b((http?|https?)://[-a-zA-Z0-9+&@#/%?=~_|!:,.;]*[-a-zA-Z0-9+&@#/%=~_|])");

        Matcher matcher = pattern.matcher("");
        //In a complete implementation, this would be picked up from properties file
        Path path = Paths.get("GoogleSearchResults.txt");
        BufferedReader reader = null;
        LineNumberReader lineReader = null;

        try {
            reader = Files.newBufferedReader(path);
            lineReader = new LineNumberReader(reader);

            String line = null;
            while ((line = lineReader.readLine()) != null) {
                matcher.reset(line);
                if (matcher.find()) {
                    String link = matcher.group(0);
                    //Further regex logic can be added to extract the js libraries from the url
                    links.add(link);
                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                reader.close();
                lineReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }

        return links;
    }
}
