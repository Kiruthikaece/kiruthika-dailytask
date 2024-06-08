import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;


class SortString  {
	
public static void main(String[] args) {
  Scanner sc=new Scanner(System.in);
  System.out.println("Enter String:");
  String str=sc.nextLine();
  String res1=StringSort1(str);
  System.out.println("Sorted string:"+res1);
  String res2=StringSort2(str);
  System.out.println("Sorted string:"+res2);
  String res3=StringSort3(str);
  System.out.println("Sorted string:"+res3);
  
}

// soln- 1 using loop

public static String StringSort1(String str) {
	
   char[] ch=str.toCharArray();
   
   for(int i=0;i<ch.length;i++) {
   for(int j=i+1;j<ch.length;j++)
    if(ch[i]>ch[j]) {
        char c=ch[i];
        ch[i]=ch[j];
        ch[j]=c;
    }
   }
   return String.valueOf(ch);
}


// soln-2

public static String StringSort2(String str) {
	
	   Set<Character>sortSet=new TreeSet<>();
        StringBuilder Sortedstr=new StringBuilder();

        for(char ch:str.toCharArray())
        sortSet.add(ch);

        for(Character sortStr:sortSet)
        Sortedstr.append(sortStr);

        return Sortedstr.toString();
}




// solution -3 (quick sort)

public static String StringSort3(String str) {
	
	char[] ch=str.toCharArray();
	quickSort(ch,0,ch.length-1);
	return String.valueOf(ch);
}

public static void quickSort(char[] ch,int low,int high){
	if(low<high){
		int pivotIndex=partition(ch,low,high);
		quickSort(ch,low,pivotIndex-1);
		quickSort(ch,pivotIndex+1,high);
	}
		
}
public static int partition(char[] ch,int low,int high) {
	 
	  char pivot=ch[high];
	  int i=low-1;
	  for(int j=low;j<high;j++) {
		  if(ch[j]<pivot) {
			  i++;
			  swap(ch,i,j);
		  }
	  }
	  swap(ch,i+1,high);
	  return i+1;
	  
}


public static void swap(char[] ch,int i,int j) {
	
				char t=ch[i];
				ch[i]=ch[j];
				ch[j]=t;
	
	
	
}
}