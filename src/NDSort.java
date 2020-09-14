import javax.sound.midi.Soundbank;
import java.util.ArrayList;

public class NDSort {
    //非支配排序
    public static ArrayList<Path> sort(ArrayList<Path> list){
        //System.out.println(list.toString());
        int index = 1;
        ArrayList<Path> dominateSortList = new ArrayList<>();
        while (list.size() > 0){
            for (int i = 0; i < list.size();i++){
                for (int j = 0; j< list.size(); j++){
                    //被支配
                    if (list.get(i).getPathValue() > list.get(j).getPathValue() && list.get(i).getSubPathAverage() > list.get(j).getSubPathAverage()){
                        break;
                    }
                    if (j == list.size() - 1){
                        list.get(i).setLevel(index);
                    }
                }
            }
            for (int k = 0; k < list.size(); k++){
                if (list.get(k).getLevel() == index){
                    dominateSortList.add(list.get(k));
                }
            }
            for (int k = 0; k < list.size(); k++){
                if (list.get(k).getLevel() == index){
                    list.remove(k);
                }
            }
            index++;
        }
        return dominateSortList;
    }
}
