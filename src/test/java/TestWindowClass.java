import java.util.Objects;

public class TestWindowClass implements Comparable <TestWindowClass> {

    private int windowSize;
    private int windowPrice;
    private String windowColor;


    public int getWindowPrice() {
        return windowPrice;
    }

    public int getWindowSize() {
        return windowSize;
    }

    public TestWindowClass(int windowSize, int windowPrice, String windowColor) {
        this.windowSize = windowSize;
        this.windowPrice = windowPrice;
        this.windowColor = windowColor;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TestWindowClass that = (TestWindowClass) o;
        return windowSize == that.windowSize &&
                windowPrice == that.windowPrice &&
                Objects.equals(windowColor, that.windowColor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(windowSize, windowPrice, windowColor);
    }

    //Переопределяем метод compareTo чтобы он сортировал по цене
    @Override
    public int compareTo(TestWindowClass o) {
        return windowPrice - o.windowPrice;
    }

    @Override
    public String toString() {
        return "TestWindowClass{" +
                "windowSize=" + windowSize +
                ", windowPrice=" + windowPrice +
                ", windowColor='" + windowColor + '\'' +
                '}';
    }
}
