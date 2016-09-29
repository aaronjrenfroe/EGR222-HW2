/*
Program Draws Rows and Grids of Boxes to create a Cafe Illusion
Created by Aaron Renfroe Fall 2016
MORTAR must be set to 1 or 2 or the Illusion breaks down
*/

import java.awt.*;
public class CafeWall {

    static final DrawingPanel panel = new DrawingPanel(650,400);
    static final Color backgroundColor = Color.GRAY;
    static final Graphics g = panel.getGraphics();
    static final int MORTAR = 2;                            //spacing between rows


    public static void main(String[] args) {

        panel.setBackground(backgroundColor);
        drawTheRows();
        drawTheGrids();

    }

    public static void drawTheRows(){
        //drawRow(x, y, pairs, box size)
        drawRow(0, 0, 4, 20);
        drawRow(50, 70,5, 30);
    }
    public static void drawTheGrids(){
        //drawGrid(size,width, height, x, y, offSet))
        drawGrid(10,150,4,25,0);
        drawGrid(250,200,3,25,10);
        drawGrid(425,180,5,20,10);
        drawGrid(400,20,2,35,35);
    }

    // Draws a grid of boxes by calling drawRow() with in a loop
    // And offsetting the Y position by MORTAR and the given Size of the box to shift the row down
    public static void drawGrid(int startX, int startY, int pairs, int boxSize, int offset){

        startY = startY - boxSize - MORTAR;

        for (int i = 0; i < pairs*2; i++) {

            startY = startY +(boxSize) + (MORTAR);

            drawRow(startX +((i%2)*offset), startY,pairs, boxSize);
        }

    }

    //draws a row of boxes with specified parameters by drawing a pair at a time.
    public static void drawRow( int x, int y,int numberOfPairs, int size){

        for (int i = 0; i < numberOfPairs; i++) {
            g.setColor(Color.BLACK);
            g.fillRect(x, y, size, size);

            g.setColor(Color.WHITE);
            g.fillRect(x+size, y, size, size);

            g.setColor(Color.BLUE);
            g.drawLine(x, y, x+ size, y + size);
            g.drawLine(x+size, y, x, y+size);
            x += 2*size; //shifts starting point to the right for the next pair of boxes to be put down

        }

    }


}

