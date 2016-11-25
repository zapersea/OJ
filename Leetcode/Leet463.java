package com.zaper.sea.leet;

/**
 * Created by Zaper Ocean on 2016/11/23.
 */
public class Leet463 {
    public int islandPerimeter(int[][] grid) {
        int re=0;
        int[][] dir={{0,1},{0,-1},{1,0},{-1,0}};
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==0) continue;
                int connect=0;
                for(int k=0;k<4;k++){
                    int x=i+dir[k][0];
                    int y=j+dir[k][1];
                    if(x>=0&&x<grid.length&&y>=0&&y<grid[0].length&&grid[x][y]==1)
                        connect++;
                }
                re+=4-connect;
            }
        }
        return re;
    }
}
