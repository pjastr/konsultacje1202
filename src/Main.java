import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Main {
    public static void main(String[] args) {
        int[] testArray = {1, 2, 3, 4, 5, 6};
        System.out.println("Największa wartość w tej tablicy to: " + findMax(testArray));
        ArrayList<Integer> testList = new ArrayList<>();
        testList.add(1);
        testList.add(2);
        testList.add(3);
        testList.add(4);
        testList.add(5);
        System.out.println("Max value: " + findMax2(testList));
        ArrayList<Integer> intList = new ArrayList<>();
        intList.add(1);
        intList.add(2);
        intList.add(38);
        intList.add(4);
        intList.add(5);
        System.out.println("Max value (int) - ver 3: " + findMax3(intList));

        ArrayList<LocalDate> dateList = new ArrayList<>();
        dateList.add(LocalDate.of(2000, 1, 1));
        dateList.add(LocalDate.of(2022, 1, 1));
        dateList.add(LocalDate.of(2020, 1, 1));
        //System.out.println("Max value (date): " + findMax3(dateList));
        System.out.println("Max value (date) ver4: " + findMax4(dateList));

        System.out.println("Max value (int) v5 int: " + findMax5(intList));
        System.out.println("Max value (int) v6 int: " + findMax6(intList));

        //System.out.println("Max value (date): " + findMax5(dateList));
        System.out.println("Max value (date): " + findMax6(dateList));
    }

    // funkcja dla zwyklej tablicy intów
    public static int findMax(int[] array) {
        int max = array[0];
        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }

    // funkcja dla arraylisty intów
    public static int findMax2(ArrayList<Integer> list) {
        int maxValue = Integer.MIN_VALUE;
        for (int i : list) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    //funkcja szablonowa zwykla
    public static <T extends Comparable<T>> T findMax3(ArrayList<T> list) {
        T maxValue = list.get(0);
        for (T i : list) {
            if (i.compareTo(maxValue) > 0) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    //rozszerzona dla nadtypów
    public static <T extends Comparable<? super T>> T findMax4(ArrayList<T> list) {
        T maxValue = list.get(0);
        for (T i : list) {
            if (i.compareTo(maxValue) > 0) {
                maxValue = i;
            }
        }
        return maxValue;
    }

    //wersja lepsza jako przykladowe rozwiazanie
    public static <E extends Comparable<E>> E findMax5(ArrayList<E> c) {
        if (c.isEmpty())
            throw new IllegalArgumentException("Pusta kolekcja");
        E result = null;
        for (E e : c)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;
    }

    //wersja przykladowe z nadtypami i podtypami
    public static <T extends Comparable<? super T>> T findMax6(ArrayList<? extends T> list) {
        if (list.isEmpty())
            throw new IllegalArgumentException("Pusta kolekcja");
        T result = null;
        for (T e : list)
            if (result == null || e.compareTo(result) > 0)
                result = Objects.requireNonNull(e);
        return result;

    }
}