package ru.tfs.someTask;

import java.util.*;

public class MassiveSort {

    public List<String> sortByDepartmentCode(String[] array) {
        checkArrayForNull(array);

        List<String> arrayToList = addDepartmentCodes(array);
        int numberOfSorts = findMaxSorts(arrayToList);

        arrayToList.sort(Comparator.comparingInt(MassiveSort::findNumberOfElements));
        for (int k = numberOfSorts; k > 0; k--) {
            int finalK = k;
            arrayToList.sort((o1, o2) ->
                    findNumberOfElements(o1) < finalK || findNumberOfElements(o2) < finalK ?
                            0 :
                            compareOfCheckCodes(o1, o2, finalK - 1));
        }
        return arrayToList;
    }

    public  List<String> addDepartmentCodes(String[] array) {
        checkArrayForNull(array);

        Set<String> arraySet = new HashSet<>(Set.of(array));
        List.of(array).stream()
                .filter(s -> findNumberOfElements(s) == 3)
                .forEach(s -> {
                    String[] buff = s.split("\\\\");
                    arraySet.add(buff[0]);
                    arraySet.add(buff[0] + "\\" + buff[1]);
                });
        return new ArrayList<>(arraySet);
    }

    private static void checkArrayForNull(String[] array) {
        if (Objects.isNull(array) || array.length == 0) {
            throw new NullPointerException("Пустой массив строк");
        }
    }

    private static int findMaxSorts(List<String> list) {
        int max = 0;
        for (String str : list) {
            int strLength = findNumberOfElements(str);
            max = Math.max(max, strLength);
        }
        return max;
    }

    private static int findNumberOfElements(String str) {
        return str.split("\\\\").length;
    }

    private static int convertToInt(String str) {
        return Integer.parseInt(str.split("K")[1]);
    }

    private static int compareOfCheckCodes(String first, String second, int sortIndex) {
        String firstSortElement = first.split("\\\\")[sortIndex];
        String secondSortElement = second.split("\\\\")[sortIndex];

        return convertToInt(secondSortElement) - convertToInt(firstSortElement);
    }
}
