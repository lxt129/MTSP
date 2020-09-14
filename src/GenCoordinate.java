import java.util.Random;

public class GenCoordinate {
    public static float[][] genCoordinate(int n){
        Random random = new Random();
        float[][] coordinate = new float[n + 1][2];
        coordinate[0][0] =  500;
        coordinate[0][1] =  500;
        for (int i = 1; i <= n; i++){
            for (int j = 0; j < 2; j++){
                //coordinate[i][j] = (float) (random.nextDouble()*500);
                coordinate[i][j] = (float) (random.nextInt(1000));
            }
        }
        return coordinate;
    }
}
