import java.util.*;

class helper {
    public static void main(String[] args) {
        Set<Integer> list = new HashSet<Integer>();
        list.add(0);
        list.add(0);
        list.add(10);
        
        for(int i : list){
            System.out.println(i);
        }
    }
}
