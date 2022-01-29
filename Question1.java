import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1 {

    public void InsertionSort(List<Integer> array) {
        int i = 1;
        while(i < array.size()) {
            int j = i;
            while ((j > 0) && (array.get(j - 1) > array.get(j))) {
                int x = array.get(j);
                int y = array.get(j - 1);

                array.set(j - 1, x);
                array.set(j, y);

                j -= 1;
            }
            i += 1;
        }
    }

    public int partitionA(ArrayList<Integer> array, int p, int r){
        int x = array.get(r);
        int i = p - 1;
        for(int j = p; j <= r-1; j++){
            if(array.get(j) <= x){
                i += 1;
                Collections.swap(array,i,j);
            }
        }
        Collections.swap(array,i+1,r);
        return i + 1;
    }

    public int partitionC(ArrayList<Integer> array, int p, int r){

        System.out.println(p + " " + r);

        int x = array.get(p);
        int y = array.get((p+r)/2);
        int z = array.get(r);

        System.out.println(x + " " + y + " " + z);

        ArrayList<Integer> smallList = new ArrayList<Integer>(Arrays.asList(x, y, z));
        Collections.sort(smallList);
        return smallList.get(1);
    }

    public void QuicksortA(ArrayList<Integer> array, int p, int r){
        if(p < r){
            int q = partitionA(array, p, r);
            QuicksortA(array, p, q-1);
            QuicksortA(array,q+1, r);
        }
    }

    public void QuicksortB(ArrayList<Integer> array, int p, int r, int k){
        if(p < r){

            int q = partitionA(array, p, r);

            if((q-1)-p < k){
                InsertionSort(array.subList(p,q-1));
            }else{
                QuicksortA(array, p, q-1);
            }
            if(r-(q+1) < k){
                InsertionSort(array.subList(q+1,r));
            }else{
                QuicksortA(array,q+1, r);
            }
        }
    }

    public void QuicksortC(ArrayList<Integer> array, int p, int r){
        if(p < r){
            int q = partitionC(array, p, r);
            System.out.println(q);
            QuicksortA(array, p, q-1);
            QuicksortA(array,q+1, r);
        }
    }

    public static void main(String[] args){

        ArrayList<Integer> array = new ArrayList<>(Arrays.asList(6,5,0,4,1,8,3));

        Question1 trial = new Question1();
        trial.QuicksortC(array,0,6);
        System.out.println(array);
    }
}
