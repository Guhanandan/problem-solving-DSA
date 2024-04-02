import java.util.*;

public class PermutationOfString {
    public List<List<Integer>> stringPermutation(int str[],List<Integer> list,List<List<Integer>> ans,int ch[]){
        if(list.size()==str.length){
            ans.add(list);
            return ans;
        }
        for(int i=0;i<str.length;i++){
            if(ch[i]==0){
                ch[i] = 1;
                list.add(str[i]);
                stringPermutation(str,new ArrayList<>(list),ans,ch);
                list.remove(list.size()-1);
                ch[i] = 0;
            }
        }
        return ans;
    }
    public static void main(String arg[]){
        PermutationOfString obj = new PermutationOfString();
        int str[] = {1,2,3,4};
        int ch[] = new int[str.length];
        List<List<Integer>> ans = obj.stringPermutation(str,new ArrayList<>(),new ArrayList<>(),ch);
        for(int i=0;i<ans.size();i++){
            System.out.println(ans.get(i));
        }
    }
}
