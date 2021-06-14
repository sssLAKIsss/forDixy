import org.junit.Assert;
import org.junit.Test;
import ru.tfs.someTask.MassiveSort;

import java.util.List;

public class MassiveSortTests {
    private final MassiveSort testObject = new MassiveSort();

    @Test
    public void test1() {
        String[] testArray = {
                "K1\\SK1",
                "K1\\SK2\\SSK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2"
        };

        String[] expectResult = new String[] {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK2\\SSK1",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        List<String> list = (testObject.sortByDepartmentCode(testArray));
        for (String s : list) {
            System.out.println(s);
        }
        Assert.assertEquals(List.of(expectResult), list);
    }

    @Test
    public void test2OnlyLowLevelChecks() {
        String[] testArray = {
                "K1\\SK2\\SSK1",
                "K1\\SK1\\SSK1",
                "K1\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K2\\SK1\\SSK2",
                "K2\\SK2\\SSK1"
        };

        String[] expectResult = new String[] {
                "K2",
                "K2\\SK2",
                "K2\\SK2\\SSK1",
                "K2\\SK1",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1",
                "K1\\SK2",
                "K1\\SK2\\SSK1",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };
        List<String> list = (testObject.sortByDepartmentCode(testArray));
        Assert.assertEquals(List.of(expectResult), list);
    }

    @Test
    public void test3OnlyTopLevelChecks() {
        String[] testArray = {
                "K1",
                "K2"
        };

        String[] expectResult = new String[] {
                "K2",
                "K1"
        };
        List<String> list = (testObject.sortByDepartmentCode(testArray));
        Assert.assertEquals(List.of(expectResult), list);
    }

    @Test
    public void test4() {
        String[] testArray = {
                "K1",
                "K2\\SK1\\SSK1"
        };

        String[] expectResult = new String[] {
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K1"
        };
        List<String> list = (testObject.sortByDepartmentCode(testArray));
        Assert.assertEquals(List.of(expectResult), list);
    }

    @Test(expected = NullPointerException.class)
    public void test5NullArray() {
        String[] testArray = {};
        testObject.sortByDepartmentCode(testArray);
    }
}
