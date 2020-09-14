import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Calculation {

    public static float[][] distanceMatrix(float[][] coordinate){
        int len = coordinate.length;
        float[][] d = new float[len][len];
        for (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                d[i][j] = (float) Math.sqrt(Math.pow(coordinate[i][0]-coordinate[j][0],2)+Math.pow(coordinate[i][1]-coordinate[j][1],2));
            }
        }
        return d;
    }

    public static Path pathCost(float[][] d, int[] path,int m){
        float[] subPath = new float[m];
        int sub = -2;
        float pathValue = 0, subPathAverage = 0,subValue = 0;
        for(int i = 0; i < path.length - 1; i++){
            pathValue += d[path[i]][path[i + 1]];
            subValue += d[path[i]][path[i + 1]];
                if (path[i] == 0){
                    sub++;
                    if (sub >= 0){
                        subPath[sub] = subValue;
                        subValue = 0;
                    }
                }
        }

        subPath[m - 1] = subValue;
        Arrays.sort(subPath);
        subPathAverage = subPath[m - 1];
        return new Path(path,pathValue,subPathAverage,0);
    }
}
