package org.oneaccount.webcrawler.Parser;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class ParserThreadLauncher {

    final static List<String> libraries = Collections.synchronizedList(new ArrayList<>());
    final static ExecutorService executorService = Executors.newCachedThreadPool();

    public static List<String> parseLibraries() {
        //The complete implementation will pick up the number of files generated and iterate over
        //as many times as long as the number is smaller than the specified value. i.e. 4 times
            IntStream.range(1, 4)
                    .forEach(x ->executorService.submit(new LibrariesParserThread(Integer.toString(x), libraries)));

        executorService.shutdown();

        return libraries;
    }
}
