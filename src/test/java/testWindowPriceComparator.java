import java.util.Comparator;

public class testWindowPriceComparator implements Comparator<TestWindowClass> {

    //Реализуем Comparator для параметра Price
    @Override
    public int compare(TestWindowClass o1, TestWindowClass o2) {
        if(o1.getWindowPrice() == o2.getWindowPrice()){
            return 0;
        } else if (o1.getWindowPrice() > o2.getWindowPrice()){
            return 1;
        } else {
            return -1;
        }
    }
}
