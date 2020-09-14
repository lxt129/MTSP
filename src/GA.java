import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class GA {

    public static ArrayList<Path> GenerateOffspring(ArrayList<Path> fList,float[][] d, int n,int m){
        ArrayList<Path> sList = new ArrayList<>();
        Random random = new Random();
        int[] pathWay;
        Path path;
        double randomValue;
        for (Path value : fList) {
            for (int j = 0; j < n; j++) {
                randomValue = random.nextDouble();
                if (randomValue < 0.33) {
                    pathWay = GenPath.genNewPath1(value.getPath());
                    path = Calculation.pathCost(d, pathWay, m);
                    sList.add(path);
                }else if (randomValue < 0.66){
                    pathWay = GenPath.genNewPath1(value.getPath());
                    path = Calculation.pathCost(d, pathWay, m);
                    sList.add(path);
                }else {
                    pathWay = GenPath.genNewPath1(value.getPath());
                    path = Calculation.pathCost(d, pathWay, m);
                    sList.add(path);
                }
            }
        }
        //去重
        //....
        return sList;
    }

}
