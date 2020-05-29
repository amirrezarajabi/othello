import java.util.Scanner;
public class Main {

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("player1 name:");
        String name1 = input.nextLine();
        Player player1 = new Player(name1,1);
        System.out.println("player2 name:");
        String name2 = input.nextLine();
        Player player2 = new Player(name2,-1);
        Map map = new Map(player1,player2);
        System.out.println("for rotate to right please input: 1");
        System.out.println("for rotate to left please input: -1");
        map.print();
        while (map.checkEnd() == 0)
        {
            int x = 0;
            int y = 0;
            int quater = 0;
            int rotate = 0;
            System.out.println("x:");
            x = input.nextInt();
            System.out.println("y:");
            y = input.nextInt();
            map.choose(x,y,1);
            map.print();
            if(map.checkEnd() == 1)
            {
                System.out.println("player1 is winner");
                return;
            }
            if(map.checkEnd() == 2)
            {
                System.out.println("player2 is winner");
                return;
            }
            System.out.println("which quarter:");
            quater = input.nextInt();
            System.out.println("for rotate to right please input: 1");
            System.out.println("for rotate to left please input: -1");
            rotate = input.nextInt();
            if (rotate == 1)
                map.rotateR(quater);
            if (rotate == -1)
                map.rotateL(quater);
            map.print();
            if(map.checkEnd() == 1)
            {
                System.out.println("player1 is winner");
                return;
            }
            if(map.checkEnd() == 2)
            {
                System.out.println("player2 is winner");
                return;
            }
            if(map.checkEnd() == 3)
            {
                System.out.println("draw");
                return;
            }
            System.out.println("x:");
            x = input.nextInt();
            System.out.println("y:");
            y = input.nextInt();
            map.choose(x,y,2);
            map.print();
            if(map.checkEnd() == 1)
            {
                System.out.println("player1 is winner");
                return;
            }
            if(map.checkEnd() == 2)
            {
                System.out.println("player2 is winner");
                return;
            }
            System.out.println("which quarter:");
            quater = input.nextInt();
            System.out.println("for rotate to right please input: 1");
            System.out.println("for rotate to left please input: -1");
            rotate = input.nextInt();
            if (rotate == 1)
                map.rotateR(quater);
            if (rotate == -1)
                map.rotateL(quater);
            map.print();
            if(map.checkEnd() == 1)
            {
                System.out.println("player1 is winner");
                return;
            }
            if(map.checkEnd() == 2)
            {
                System.out.println("player2 is winner");
                return;
            }
            if(map.checkEnd() == 3)
            {
                System.out.println("draw");
                return;
            }
        }
    }
}
