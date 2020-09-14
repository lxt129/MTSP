import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MainClass {
    public static void main(String[] args) {
        int n = 30;//目标点个数（不算起始点）
        int m = 4;//旅行商数目
        float[][] coordinate = GenCoordinate.genCoordinate(n);//随机生成点的坐标
        System.out.println(Arrays.deepToString(coordinate));

        float d[][] = Calculation.distanceMatrix(coordinate);
        int[] path;
        ArrayList<Path> fList = new ArrayList<>();
        for (int i = 0;i < n; i++){
            path = GenPath.initPath(n,m);
            fList.add(Calculation.pathCost(d,path,m));
        }
        ArrayList<Path> sList;
        for (int i = 0;i < 500; i++){
            sList = GA.GenerateOffspring(fList,d,n,m);
            sList.addAll(fList);
            sList = NDSort.sort(sList);
            fList.clear();
            for (int j = 0;j< n ;j++){
                fList.add(sList.get(j));
            }
            if (i%10 == 0){
                System.out.println(fList.get(0));
            }
        }
        System.out.println(fList.toString());
    }
}
