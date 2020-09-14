import java.util.Arrays;

public class Path {
    private int[] path;
    private float pathValue;
    private float subPathAverage;
    private int level;

    public int[] getPath() {
        return path;
    }

    public void setPath(int[] path) {
        this.path = path;
    }

    public float getPathValue() {
        return pathValue;
    }

    public void setPathValue(float pathValue) {
        this.pathValue = pathValue;
    }

    public float getSubPathAverage() {
        return subPathAverage;
    }

    public void setSubPathAverage(float subPathAverage) {
        this.subPathAverage = subPathAverage;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public Path() {
    }

    public Path(int[] path, float pathValue, float subPathAverage, int level) {
        this.path = path;
        this.pathValue = pathValue;
        this.subPathAverage = subPathAverage;
        this.level = level;
    }

    @Override
    public String toString() {
        return "Path{" +
                "path=" + Arrays.toString(path) +
                ", pathValue=" + pathValue +
                ", subPathAverage=" + subPathAverage +
                ", level=" + level +
                '}';
    }
}
