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

        List<String> expectResult = List.of(
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
        );
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
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

        List<String> expectResult = List.of(
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
        );
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
    }

    @Test
    public void test3OnlyTopLevelChecks() {
        String[] testArray = {
                "K1",
                "K2"
        };

        List<String> expectResult = List.of(
                "K2",
                "K1"
        );
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
    }

    @Test
    public void test4() {
        String[] testArray = {
                "K1",
                "K2\\SK1\\SSK1"
        };

        List<String> expectResult = List.of (
                "K2",
                "K2\\SK1",
                "K2\\SK1\\SSK1",
                "K1"
        );
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
    }

    @Test(expected = NullPointerException.class)
    public void test5NullArray() {
        String[] testArray = {};
        testObject.sortByDepartmentCode(testArray);
    }

    @Test
    public void test6() {
        String[] testArray = new String[] { "K3\\SK3\\SSK3\\SSSK3\\SSSSK3\\SSSSSK3" };

        List<String> expectResult = List.of(
                "K3",
                "K3\\SK3",
                "K3\\SK3\\SSK3",
                "K3\\SK3\\SSK3\\SSSK3",
                "K3\\SK3\\SSK3\\SSSK3\\SSSSK3",
                "K3\\SK3\\SSK3\\SSSK3\\SSSSK3\\SSSSSK3"
        );
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
    }

    @Test
    public void test7() {
        String[] testArray = new String[]{
                "K2",
                "K2\\SK1\\SSK2",
                "K2\\SK1\\SSK1",
                "K1\\SK2",
                "K1\\SK2\\SSK1",
                "K1\\SK1",
                "K1\\SK1\\SSK2",
                "K1\\SK1\\SSK1"
        };

        List<String> expectResult = List.of(
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
        ) ;
        List<String> result = testObject.sortByDepartmentCode(testArray);
        Assert.assertEquals(expectResult, result);
    }
}
