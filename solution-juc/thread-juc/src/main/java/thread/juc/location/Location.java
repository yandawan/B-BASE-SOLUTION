package thread.juc.location;

/**
 * 飞机地理位置 声明为不可变的类
 */
public final class Location {

    private final double x;

    private final double y;

    public Location(double x, double y) {
        this.x = x;
        this.y = y;
    }
}
