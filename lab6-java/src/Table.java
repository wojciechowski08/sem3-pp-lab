import java.lang.reflect.Array;
import java.util.Arrays;

public class Table<T> {

    public static void main(String[] args) {

        Integer[] array1 = {1,5,9,10,12};
        System.out.println(Arrays.toString(insert(array1, 12)));
        System.out.println(Arrays.toString(insert(array1, -1)));
        System.out.println(Arrays.toString(insert(array1, 4)));
        System.out.println(Arrays.toString(insert(array1, 7)));


    }

    @SuppressWarnings("unchecked")
    static <T extends Comparable> T[] insert(T[] array, T toInsert) {

        T[] outcome = (T[])(Array.newInstance(array.getClass().getComponentType(), array.length + 1));

        int i = 0;

        for (; i < array.length && array[i].compareTo(toInsert) < 0; i++) {
            outcome[i] = array[i];
        }
        outcome[i] = toInsert;
        for (; i < array.length; i++) {
            outcome[i + 1] = array[i];
        }

        return outcome;
    }
}
