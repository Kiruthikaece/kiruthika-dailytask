import java.util.*;

public class SnakeInMatrix {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter n:");
        int n=sc.nextInt();
        System.out.println("Enter list size:");
        int size=sc.nextInt();

        List<String> commands=new ArrayList<>();
        System.out.println("Enter commands:");
        for(int i=0;i<size;i++)
        commands.add(sc.next());
        int res1=findPosition1(n,commands);
        System.out.println(res1);

        int res2=findPosition2(n,commands,0,0);
        System.out.println(res2);

        int res3=findPosition3(n,commands);
        System.out.println(res3);
    }

    public static int findPosition3(int n, List<String> commands) {
        HashMap<String,Integer> map = new HashMap<>();
        map.put("DOWN",n);
        map.put("UP",-n);
        map.put("RIGHT",1);
        map.put("LEFT",-1);
        int ans = 0;
        for(int i = 0;i<commands.size();i++){
            ans = ans + map.get(commands.get(i));
        }

        return ans;
    }

    private static int findPosition2(int n, List<String> commands, int i, int position) {
       
        if(i>=commands.size())
       return position;
       
       String command=commands.get(i);
       
       if(command.equals("RIGHT"))
       position++;
       else if(command.equals("LEFT"))
       position--;
       else if(command.equals("UP"))
       position=position-n;
       else
       position=position+n;

        return findPosition2(n,commands,i+1,position);
    }

    private static int findPosition1(int n,List<String> commands) {
        int position=0;
        int i=0;
        while(i<commands.size()) {
            String command=commands.get(i);
            if(command.equals("RIGHT"))
            position++;
            else if(command.equals("LEFT"))
            position--;
            else if(command.equals("UP"))
            position=position-n;
            else
            position=position+n;

           // System.out.println(position+"pos");
            i++;
        }

        return position;
    }
}
