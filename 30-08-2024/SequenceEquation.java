import java.util.ArrayList;
import java.util.List;

public class SequenceEquation {
    public static void main(String[] args) {
        List<Integer> list=new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(4);
        list.add(3);

        List<Integer> res1=permuteEquation1(list);
        System.out.println(res1);

        List<Integer> res2=permuteEquation2(list);
        System.out.println(res2);
    }

    public static List<Integer> permuteEquation1(List<Integer> p) {
            
        List<Integer> res=new ArrayList<>();
        
        for(int i=1;i<=p.size();i++) {
             int first=findPos(i,p);
             int sec=findPos(first,p);
             res.add(sec);
        }
       
        return res;

}

 public static int findPos(int num,List<Integer> p) {
      
      int pos=0;
      
      for(int i=0;i<p.size();i++)
      if(num==p.get(i))
      pos=i+1;
      
      return pos;
     
 }

 public static List<Integer> permuteEquation2(List<Integer> p) {
    List<Integer> res = new ArrayList<>();
    
    for (int i = 1; i <= p.size(); i++) {
        int firstPos = p.indexOf(i) + 1; 
        int secondPos = p.indexOf(firstPos) + 1;
        res.add(secondPos);
    }
    
    return res;
}
}
