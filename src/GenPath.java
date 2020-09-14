import java.util.Arrays;
import java.util.Random;
import java.util.SortedSet;

public class GenPath {
    public static int[] initPath(int n, int m){
        int[] path = new int[n + m + 1];
        for (int i = 0; i < n; i++){
            path[i] = i+1;
        }
        int q,p,t;
        Random random = new Random();
        for (int i = 0; i < n; i++){
            q = random.nextInt(n + m - 1);
            p = random.nextInt(n + m - 1);
            t = path[q];
            path[q] = path[p];
            path[p] = t;
        }
        t = path[0];
        path[0] = path[n + m - 1];
        path[n + m - 1] = t;
        return path;
    }
    //随机交换点位
    public static int[] genNewPath1(int[] path){
        int len = path.length;
        int[] thisPath = Arrays.copyOf(path,len);
        int q,p,t;
        Random random = new Random();
        q = random.nextInt(len - 2) + 1;//获取路径中的随机位置（不包过头尾的出发节点）
        p = random.nextInt(len - 2) + 1;
        t = thisPath[q];
        thisPath[q] = thisPath[p];
        thisPath[p] = t;
        return thisPath;
    }

    //随机路径倒置  abc ——> cba
    public static int[] genNewPath2(int[] path){
        int len = path.length;
        int[] thisPath = Arrays.copyOf(path,len);
        int q,p,t;
        Random random = new Random();
        q = random.nextInt(len - 2) + 1;
        p = random.nextInt(len - 2) + 1;
        if (q > p){
            t = q;
            q = p;
            p = t;
        }//保证随机点位q < p
        for(int i = 0;i <= (p - q) / 2; i++){
            t = thisPath[q + i];
            thisPath[q + i] = thisPath[p - i];
            thisPath[p - i] = t;
        }
        return thisPath;
    }


    //随机路径滑动  abcdefgh ——> deabcfgh
    public static int[] genNewPath3(int[] path){
        int len = path.length;
        int[] thisPath = new int[len];
        int[] arr = new int[3];
        int c1,c2,c3;
        Random random = new Random();
        arr[0] = random.nextInt(len - 2) + 1;
        arr[1] = random.nextInt(len - 2) + 1;
        arr[2] = random.nextInt(len - 2) + 1;
        Arrays.sort(arr);
        c1 = arr[0];
        c2 = arr[1];
        c3 = arr[2];
        //System.out.println(c1+"  "+c2+"  "+c3);
        int j=0,k=0;
        for (int i = 0; i < len; i++){
            if (i < c1){
                thisPath[i] = path[i];
            }else if(i <= c1 + c3 - c2){
                thisPath[i] = path[c2 + j];
                j++;
            }else if(i <= c3){
                thisPath[i] = path[c1 + k];
                k++;
            }else {
                thisPath[i] = path[i];
            }
        }

        return thisPath;
    }

}
