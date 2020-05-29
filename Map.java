/**
 * The Map class represents map in pentago
 * @author Amirreza
 * @version 1.0
 */
public class Map
{
    //list of cell for create map
    private Cell [][] cells;
    //players
    private Player player1;
    private Player player2;
    /**
     * create a map game
     * @param player1 player1
     * @param player2 player2
     */
    public Map(Player player1,Player player2)
    {
        cells = new Cell [6][6];
        this.player1 = player1;
        this.player2 = player2;
        for (int i = 0;i < 6;i++)
        {
            for (int j = 0;j < 6;j++)
            {
                cells[i][j] = new Cell(i,j,0);
            }
        }

    }

    /**
     * check player is winner
     * @param player player to check
     * @return 1 winner 0 not
     */
    public int checkWin(Player player)
    {
        int win = 0;
        for (int i = 0;i < 6;i++)
        {
            int k = 0;
            for (int j = 0;j < 5;j++)
            {
                if (cells[i][j].getType() == player.getType())
                    k = k + 1;
            }
            if(k == 5)
                win = win + 1;
        }
        for (int i = 0;i < 6;i++)
        {
            int k = 0;
            for (int j = 5;j < 0;j++)
            {
                if (cells[i][j].getType() == player.getType())
                    k = k + 1;
            }
            if(k == 5)
                win = win + 1;
        }
        for (int j = 0;j < 6;j++)
        {
            int k = 0;
            for (int i = 0;i < 5;i++)
            {
                if (cells[i][j].getType() == player.getType())
                    k = k + 1;
            }
            if(k == 5)
                win = win + 1;
        }
        for (int j = 0;j < 6;j++)
        {
            int k = 0;
            for (int i = 5;i < 0;i++)
            {
                if (cells[i][j].getType() == player.getType())
                    k = k + 1;
            }
            if(k == 5)
                win = win + 1;
        }
        if(cells[0][0].getType() == player.getType() && cells[1][1].getType() == player.getType() && cells[2][2].getType() == player.getType() && cells[3][3].getType() == player.getType() && cells[4][4].getType() == player.getType())
            win = win + 1;
        if(cells[5][5].getType() == player.getType() && cells[1][1].getType() == player.getType() && cells[2][2].getType() == player.getType() && cells[3][3].getType() == player.getType() && cells[4][4].getType() == player.getType())
            win = win + 1;
        if(cells[0][5].getType() == player.getType() && cells[1][4].getType() == player.getType() && cells[2][3].getType() == player.getType() && cells[3][2].getType() == player.getType() && cells[4][1].getType() == player.getType())
            win = win + 1;
        if(cells[5][0].getType() == player.getType() && cells[1][4].getType() == player.getType() && cells[2][3].getType() == player.getType() && cells[3][2].getType() == player.getType() && cells[4][1].getType() == player.getType())
            win = win + 1;
        if(cells[1][0].getType() == player.getType() && cells[2][1].getType() == player.getType() && cells[3][2].getType() == player.getType() && cells[4][3].getType() == player.getType() && cells[5][4].getType() == player.getType())
            win = win + 1;
        if(cells[0][1].getType() == player.getType() && cells[1][2].getType() == player.getType() && cells[2][3].getType() == player.getType() && cells[3][4].getType() == player.getType() && cells[4][5].getType() == player.getType())
            win = win + 1;
        if(cells[4][0].getType() == player.getType() && cells[3][1].getType() == player.getType() && cells[2][2].getType() == player.getType() && cells[1][3].getType() == player.getType() && cells[0][4].getType() == player.getType())
            win = win + 1;
        if(cells[5][1].getType() == player.getType() && cells[4][2].getType() == player.getType() && cells[3][3].getType() == player.getType() && cells[2][4].getType() == player.getType() && cells[1][5].getType() == player.getType())
            win = win + 1;
        if(win > 0)
            return 1;
        return 0;
    }

    /**
     * check  game is finish
     * @return 1 finish and player1 is winner 2 finish and player2 is winner 3 draw 0 not finish
     */
    public int checkEnd()
    {
        if (checkWin(player1) == 1 && checkWin(player2) == 0)
            return 1;
        if (checkWin(player2) == 1 && checkWin(player1) == 0)
            return 2;
        if (checkWin(player2) == 1 && checkWin(player1) == 1)
            return 3;
        if (checkWin(player2) == 0 && checkWin(player1) == 0 && (player2.getSize()+player1.getSize()) == 36)
            return 3;
        return 0;
    }

    /**
     * choose cel for players
     * @param x x of cell
     * @param y y of cell
     * @param which player 1 or 2
     */
    public void choose(int x,int y,int which)
    {
        if (cells[x][y].getType() == 0)
        {
            if (which == 1) {
                cells[x][y].setCell(player1.getType());
                player1.addCell(cells[x][y]);
            }
            if (which == 2) {
                cells[x][y].setCell(player2.getType());
                player2.addCell(cells[x][y]);
            }
        }
    }

    /**
     * change 2 cells
     * @param x x of cell1
     * @param y y of cell1
     * @param i x of cell1
     * @param j y of cell2
     */
    public void change(int x , int y , int i , int j)
    {
        if (cells[x][y].getType() == 1 && cells[i][j].getType() == 0)
        {
            player1.removeCell(cells[x][y]);
            cells[x][y].setCell(0);
            cells[i][j].setCell(1);
            player1.addCell(cells[i][j]);

        }
        else if (cells[x][y].getType() == 0 && cells[i][j].getType() == 1)
        {
            player1.removeCell(cells[i][j]);
            cells[x][y].setCell(1);
            cells[i][j].setCell(0);
            player1.addCell(cells[x][y]);

        }
        else if (cells[x][y].getType() == -1 && cells[i][j].getType() == 0)
        {
            player2.removeCell(cells[x][y]);
            cells[x][y].setCell(0);
            cells[i][j].setCell(-1);
            player2.addCell(cells[i][j]);

        }
        else if (cells[x][y].getType() == 0 && cells[i][j].getType() == -1)
        {
            player2.removeCell(cells[i][j]);
            cells[x][y].setCell(-1);
            cells[i][j].setCell(0);
            player2.addCell(cells[x][y]);
        }
        else if (cells[x][y].getType() == 1 && cells[i][j].getType() == -1)
        {
            player1.removeCell(cells[x][y]);
            player2.removeCell(cells[i][j]);
            cells[x][y].setCell(-1);
            cells[i][j].setCell(1);
            player1.addCell(cells[i][j]);
            player2.addCell(cells[x][y]);

        }
        else if (cells[x][y].getType() == -1 && cells[i][j].getType() == 1)
        {
            player1.removeCell(cells[i][j]);
            player2.removeCell(cells[x][y]);
            cells[x][y].setCell(1);
            cells[i][j].setCell(-1);
            player2.addCell(cells[i][j]);
            player1.addCell(cells[x][y]);
        }
    }

    /**
     * rotate left quarter
     * @param which which quarter
     */
    public void rotateL(int which)
    {
        int zx = 0 , zy = 0;
        if (which == 2)
        {
            zx = 3;
            zy = 0;
        }
        if (which == 3)
        {
            zx = 0;
            zy = 3;
        }
        if (which == 4)
        {
            zx = 3;
            zy = 3;
        }
        if (which == 1)
        {
            zx = 0;
            zy = 0;
        }
        change(zx+0,zy+0,zx+0,zy+2);
        change(zx+0,zy+0,zx+2,zy+2);
        change(zx+0,zy+0,zx+2,zy+0);
        change(zx+1,zy+0,zx+0,zy+1);
        change(zx+1,zy+0,zx+1,zy+2);
        change(zx+1,zy+0,zx+2,zy+1);
    }

    /**
     * rotate right : 90 + 90 + 90 = 270 = -90
     * @param which which quarter
     */
    public void rotateR(int which)
    {
        rotateL(which);
        rotateL(which);
        rotateL(which);
    }

    /**
     * unicode
     * @param type type to unicode
     * @return unicodr for 1 , 0 , - 1
     */
    public char prCell(int type)
    {
        if (type == 1)
            return '1';
        if (type == -1)
            return '0';
        return '\u2610';
    }

    /**
     * print map
     */
    public void print()
    {
        System.out.print(prCell(cells[0][0].getType()));
        System.out.print(prCell(cells[1][0].getType()));
        System.out.print(prCell(cells[2][0].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][0].getType()));
        System.out.print(prCell(cells[4][0].getType()));
        System.out.print(prCell(cells[5][0].getType()));
        System.out.println();
        System.out.print(prCell(cells[0][1].getType()));
        System.out.print(prCell(cells[1][1].getType()));
        System.out.print(prCell(cells[2][1].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][1].getType()));
        System.out.print(prCell(cells[4][1].getType()));
        System.out.print(prCell(cells[5][1].getType()));
        System.out.println();
        System.out.print(prCell(cells[0][2].getType()));
        System.out.print(prCell(cells[1][2].getType()));
        System.out.print(prCell(cells[2][2].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][2].getType()));
        System.out.print(prCell(cells[4][2].getType()));
        System.out.print(prCell(cells[5][2].getType()));
        System.out.println();
        System.out.println("----------");
        System.out.print(prCell(cells[0][3].getType()));
        System.out.print(prCell(cells[1][3].getType()));
        System.out.print(prCell(cells[2][3].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][3].getType()));
        System.out.print(prCell(cells[4][3].getType()));
        System.out.print(prCell(cells[5][3].getType()));
        System.out.println();
        System.out.print(prCell(cells[0][4].getType()));
        System.out.print(prCell(cells[1][4].getType()));
        System.out.print(prCell(cells[2][4].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][4].getType()));
        System.out.print(prCell(cells[4][4].getType()));
        System.out.print(prCell(cells[5][4].getType()));
        System.out.println();
        System.out.print(prCell(cells[0][5].getType()));
        System.out.print(prCell(cells[1][5].getType()));
        System.out.print(prCell(cells[2][5].getType()));
        System.out.print("|");
        System.out.print(prCell(cells[3][5].getType()));
        System.out.print(prCell(cells[4][5].getType()));
        System.out.print(prCell(cells[5][5].getType()));
        System.out.println();
        /*System.out.print((cells[0][0].getType()));
        System.out.print((cells[1][0].getType()));
        System.out.print((cells[2][0].getType()));
        System.out.print("|");
        System.out.print((cells[3][0].getType()));
        System.out.print((cells[4][0].getType()));
        System.out.print((cells[5][0].getType()));
        System.out.println();
        System.out.print((cells[0][1].getType()));
        System.out.print((cells[1][1].getType()));
        System.out.print((cells[2][1].getType()));
        System.out.print("|");
        System.out.print((cells[3][1].getType()));
        System.out.print((cells[4][1].getType()));
        System.out.print((cells[5][1].getType()));
        System.out.println();
        System.out.print((cells[0][2].getType()));
        System.out.print((cells[1][2].getType()));
        System.out.print((cells[2][2].getType()));
        System.out.print("|");
        System.out.print((cells[3][2].getType()));
        System.out.print((cells[4][2].getType()));
        System.out.print((cells[5][2].getType()));
        System.out.println();
        System.out.println("----------");
        System.out.print((cells[0][3].getType()));
        System.out.print((cells[1][3].getType()));
        System.out.print((cells[2][3].getType()));
        System.out.print("|");
        System.out.print((cells[3][3].getType()));
        System.out.print((cells[4][3].getType()));
        System.out.print((cells[5][3].getType()));
        System.out.println();
        System.out.print((cells[0][4].getType()));
        System.out.print((cells[1][4].getType()));
        System.out.print((cells[2][4].getType()));
        System.out.print("|");
        System.out.print((cells[3][4].getType()));
        System.out.print((cells[4][4].getType()));
        System.out.print((cells[5][4].getType()));
        System.out.println();
        System.out.print((cells[0][5].getType()));
        System.out.print((cells[1][5].getType()));
        System.out.print((cells[2][5].getType()));
        System.out.print("|");
        System.out.print((cells[3][5].getType()));
        System.out.print((cells[4][5].getType()));
        System.out.print((cells[5][5].getType()));
        System.out.println();*/
    }
}
