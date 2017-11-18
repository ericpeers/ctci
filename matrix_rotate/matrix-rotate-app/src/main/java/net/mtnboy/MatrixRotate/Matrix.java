package net.mtnboy.MatrixRotate;

public class Matrix {
    int rc[][];
    int size;

    public Matrix(int src[][], int n) {
        this.size = n;
        rc = new int[size][size];

        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                this.rc[row][col] = src[row][col];
            }
        }
    }

    public void rotate90WasteRam() {
        int target[][] = new int[size][size];
        int terminal = size - 1;
        for (int row = 0; row <= terminal; row++) {
            for (int col = 0; col <= terminal; col++) {
                //hold column constant in target, work down row
                //hold row constant in src. work across column.
                target[col][terminal-row] = rc[row][col];
            }
        }
        rc = target;
    }

    public void rotate90InPlace() {
        int swap, swap2;
        int ringlen = size;
        int ring = 0;
        while (ringlen > 1) {
            int terminal = size-ring-1;
            for (int col=0;col<=ringlen-2;col++) { //I don't want to double swap my corners.
                //do a 4 way swap. Top goes to Right. Right goes to Bottom. Bottom goes to Left, Left to Top

                //top to right
                int targetCol = terminal;
                int targetRow = col + ring;
                swap = rc[targetRow][targetCol];
                rc[targetRow][targetCol] = rc[ring][col+ring];

                //right to bottom
                targetCol = terminal-col;
                targetRow = terminal;
                swap2 = rc[targetRow][targetCol];
                rc[targetRow][targetCol] = swap;

                //bottom to left
                targetCol = ring;
                targetRow = terminal-col;
                swap = rc[targetRow][targetCol];
                rc[targetRow][targetCol] = swap2;

                //left to top
                rc[ring][col + ring] = swap;
            }
            ringlen-=2;
            ring++;


        }

    }
    /*
        public void rotate90() {
            int swap;
            int ring = size - 1; //start at the outermost ring.
            int ringsize = size;

            while (ring >= (size / 2)) {
                // assume a square that looks like
                //    W
                //   1234         D951
                //   5678  X      EA62
                // Z 9ABC         FB73
                //   DEFG         GC84
                //    Y
                //row 0 becomes column n-1. 0th element in row becomes 0th element in column.  A
                //column n-1 becomes row n-1. n-1 element in column becomes 0th element.       B
                //row n-1 becomes column 0. 0th element becomes 0th element in column.         C
                //column 0 becomes row 0. n-1 element becomes 0'th element.                    D
                int temp;
                int row, col, targetRow, targetCol;
                for (int el=0;el<ringsize;el++) {
                    row = el+ring;
                    col = el+ring;
                    targetRow = col;
                    targetCol = el+ring;


                    temp = rc[row][col];



                }


                y = ring;

                for (int x = ring; x < ringsize + ring; x++) {
                    //now walk around the ring for a single element
                    //topleft goes to topright - which is go to
                    temp = rc[x][y];
                }
            }
        }

    */
    public int[][] getVals() {
        return rc;
    }
}
