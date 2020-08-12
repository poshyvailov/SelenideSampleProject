import java.util.Comparator;

public class testWindowSizeComparator implements Comparator<TestWindowClass> {

    //Реализуем Comparator для параметра Size
    @Override
    public int compare(TestWindowClass o1, TestWindowClass o2) {
        if(o1.getWindowSize() == o2.getWindowSize()){
            return 0;
        } else if(o1.getWindowSize() > o2.getWindowSize()){
            return 1;
        } else {
            return -1;
        }
    }
}
