package interview.drills;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class SpiralMatrixRead {
    public static void main(String[] args) {
        int matrixArray[][] = {
        { 1, 2, 3, 4, 5, 6, 7, 8, 9,10},
        {30,31,32,33,34,35,36,37,38,11},
        {29,52,53,54,55,56,57,58,39,12},
        {28,51,66,67,68,69,70,59,40,13},
        {27,50,65,64,63,62,61,60,41,14},
        {26,49,48,47,46,45,44,43,42,15},
        {25,24,23,22,21,20,19,18,17,16}
        };

        printTheSpiralOrder(matrixArray);
        List<Integer> realLogic = printLayerFromGeek4Geeks(matrixArray);
        System.out.println(realLogic.stream().map(Object::toString).collect(Collectors.joining(",")));
    }
    public static void printTheSpiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int loopCount = 0;
        if(m%2 == 0) loopCount = m/2;
        else loopCount = m/2 +1;
        List<Integer> layeredList = new ArrayList<>();
        for(int layer = 1; layer <= loopCount; layer++) {
            layeredList.addAll(printLayer(layer, matrix));
        }
        System.out.println(
                layeredList.stream().limit(m*n)
                        .map(Object::toString).collect(Collectors.joining(",")));
    }

    public static List<Integer> printLayer(int layer, int[][] matrix) {
        int rowStart, colStart;
        rowStart = colStart = layer-1;
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> integerList = new ArrayList<>();
        for(int c = colStart; c<=n-layer; c++)
            integerList.add(matrix[rowStart][c]);

        for(int r = layer; r<=m-layer; r++)
            integerList.add(matrix[r][n-layer]);

        for(int c = n-layer-1; c>=colStart; c--)
            integerList.add(matrix[m-layer][c]);

        for(int r = m-layer-1; r>=rowStart+1; r--)
            integerList.add(matrix[r][colStart]);

        return integerList;
    }

    public static List<Integer> printLayerFromGeek4Geeks(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();

        if (matrix.length == 0)
            return ans;
        int m = matrix.length, n = matrix[0].length;
        boolean[][] seen = new boolean[m][n];
        int[] dr = { 0, 1, 0, -1 };
        int[] dc = { 1, 0, -1, 0 };
        int x = 0, y = 0, di = 0;

        for (int i = 0; i < m * n; i++) {
            ans.add(matrix[x][y]);
            seen[x][y] = true;
            int cr = x + dr[di];
            int cc = y + dc[di];
            if (0 <= cr && cr < m && 0 <= cc && cc < n && !seen[cr][cc]) {
                x = cr; y = cc;
            } else {
                di = (di + 1) % 4;
                x += dr[di]; y += dc[di];
            }
        }
        return ans;
    }

}
