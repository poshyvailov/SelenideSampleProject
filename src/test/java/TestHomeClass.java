import java.util.Map;
import java.util.TreeMap;

public class TestHomeClass {

    public static void main(String[] args) {

        //Создал два объекта с одинаковыми параметрами, но по сути являющимися разными объекстами,чтобы проверить, что хеш код будет совпадать
        // и проверить как отработает equals
        TestWindowClass window1 = new TestWindowClass(150, 2500,"White");
        TestWindowClass window2 = new TestWindowClass(150,2500,"White");

        System.out.println("hash code for window1 object is: " + window1.hashCode());
        System.out.println("hash code for window2 object is: " + window2.hashCode());

        //Проверяем как отработает equals
        System.out.println("Are window1 and window2 equals?- " + window1.equals(window2));
        System.out.println();


        //Создал два объекта с разными параметрами, чтобы проверить что хеш код не будет совпадать
        // и проверить как отработает equals
        TestWindowClass window3 = new TestWindowClass(100, 1000,"Brown");
        TestWindowClass window4 = new TestWindowClass(100,1100,"Red");

        System.out.println("hash code for window3 object is: " + window3.hashCode());
        System.out.println("hash code for window4 object is: " + window4.hashCode());

        //Проверяем как отработает equals
        System.out.println("Are window3 and window4 equals?- " + window3.equals(window4));
        System.out.println();


        //Создаем мапу и кладем туда наши окна
        Map<TestWindowClass,Integer> map = new TreeMap<>();
        map.put(window1, 1);
        map.put(window2, 2);
        map.put(window3, 3);
        map.put(window4, 4);

        //Выводим записи из нашей мапы с уникальными значениями цены (задали цену в классе TestWindowClass в методе compareTo ).
        //Отсортировано будет по цене - от меньшей к большей
        for(Map.Entry<TestWindowClass, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println();


        //Кладем объекты класса testWindowPriceComparator и выводим отсортированные значение
        Map<TestWindowClass,Integer> mapForPriceComparator = new TreeMap<>(new testWindowPriceComparator());
        map.put(window1, 1);
        map.put(window2, 2);
        map.put(window3, 3);
        map.put(window4, 4);

        System.out.println("Results of sorting by mapForPriceComparator");
        for(Map.Entry<TestWindowClass, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }
        System.out.println();


        //Кладем объекты класса testWindowSizeComparator и выводим отсортированные значение
        Map<TestWindowClass,Integer> mapForSizeComparator = new TreeMap<>(new testWindowSizeComparator());
        map.put(window1, 1);
        map.put(window2, 2);
        map.put(window3, 3);
        map.put(window4, 4);

        System.out.println("Results of sorting by mapForSizeComparator");
        for(Map.Entry<TestWindowClass, Integer> entry: map.entrySet()){
            System.out.println(entry.getKey());
        }

    }


}
