package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/10/28.
 */
public class Leet36 {
    public static boolean isValidSudoku(char[][] board) {
        int[][] game=new int[board.length][board[0].length];
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(board[i][j]-'0'>=0 && board[i][j]-'0'<=9)
                    game[i][j]=board[i][j]-'0';
                else if(board[i][j]=='.')
                    game[i][j]=0;
                else
                    return false;
            }
        }
        for(int i=0;i<9;i++){
            int[] fr=new int[10];
            int[] fc=new int[10];
            for(int j=0;j<9;j++) {
                fr[game[i][j]]++;
                fc[game[j][i]]++;
            }
            for(int j=1;j<10;j++){
                //System.out.println("----2-----");
                if(fr[j]>1||fc[j]>1)
                    return false;
            }
        }
        int[][] dir={{0,0},{0,3},{0,6},{3,0},{3,3},{3,6},{6,0},{6,3},{6,6}};
        for(int k=0;k<9;k++){
            int[] fm=new int[10];
            for(int i=0;i<3;i++){
                for(int j=0;j<3;j++){
                    fm[game[i+dir[k][0]][j+dir[k][1]]]++;
                }
            }
            for(int i=1;i<10;i++){
                //System.out.println("----3-----");
                if(fm[i]>1)
                    return false;
            }
        }
        return true;
    }
}
