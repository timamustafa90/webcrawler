import org.junit.jupiter.api.Test;
import org.oneaccount.webcrawler.Libraries.PopularLibrariesSorter;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PopularLibrariesSorterTest {
    //An example of a test for this type of solution
    @Test
    public void testPrintMessage() {
        PopularLibrariesSorter popularLibrariesSorter = new PopularLibrariesSorter();
        ArrayList <String> list = new ArrayList<>();
        list.add("test.js");
        list.add("test1.js");
        list.add("test2.js");
        list.add("test.js");
        list.add("test.js");
        list.add("test2.js");
        List<String> sortedList = popularLibrariesSorter.getTopLibraries(list);

        assertEquals(sortedList.get(0),"test.js");
        assertEquals(sortedList.get(1),"test2.js");
        assertEquals(sortedList.get(2),"test1.js");
        assertEquals(sortedList.size(),3);
    }


}
