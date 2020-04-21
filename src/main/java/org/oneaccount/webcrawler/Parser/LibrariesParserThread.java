package org.oneaccount.webcrawler.Parser;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LibrariesParserThread implements Runnable {
    private final String filename;
    private final List<String> libraries;

    public LibrariesParserThread(String filename, List<String> libraries) {
        this.filename = filename;
        this.libraries = libraries;
    }

    //This solution is not ideal because we cannot be sure that the regex is comprehensive. There may be some cases that
    // have been missed out. This approach has been taken to minimise the use of external APIs.
    //A better approach may be to use the Jsoup library
    @Override
    public void run() {
        BufferedReader file = null;
        LineNumberReader lineReader = null;

        Pattern pattern = Pattern.compile("\\b((src)=[-a-zA-Z0-9+&@#/%~?:.\"]+[/.]+[js]+[\"]+)");
        Matcher matcher = pattern.matcher("");

        try {
            file = Files.newBufferedReader(Paths.get(filename + ".txt"));
            lineReader = new LineNumberReader(file);

            String line = null;
            while ((line = lineReader.readLine()) != null) {
                matcher.reset(line);
                if (matcher.find()) {
                    String library = matcher.group(0);
                    //Further regex logic can be added to extract the js libraries from the url
                    libraries.add(library);

                }
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            try {
                file.close();
                lineReader.close();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }

}






