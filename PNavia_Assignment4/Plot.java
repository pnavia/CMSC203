package application;

/*
 * Class: CMSC203 
 * Instructor: Tarek, Ahmed
 * Description: This class defines a rectangular plot with coordinates and size, and includes methods to check for overlap and containment.
 * Due: 04/04/2025
 * Platform/compiler: Eclipse  
 * I pledge that I have completed the programming 
 * assignment independently. I have not copied the code 
 * from a student or any source. I have not given my code 
 * to any student.
   Print your Name here: Paulo Navia
*/

public class Plot {
    private int x;
    private int y;
    private int width;
    private int depth;

    public Plot() {
        this.x = 0;
        this.y = 0;
        this.width = 1;
        this.depth = 1;
    }

    public Plot(Plot otherPlot) {
        this.x = otherPlot.x;
        this.y = otherPlot.y;
        this.width = otherPlot.width;
        this.depth = otherPlot.depth;
    }

    public Plot(int x, int y, int width, int depth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.depth = depth;
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getWidth() { return width; }
    public int getDepth() { return depth; }

    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setWidth(int width) { this.width = width; }
    public void setDepth(int depth) { this.depth = depth; }

    public boolean overlaps(Plot p) {
        return !(p.x + p.width <= this.x ||
                 p.x >= this.x + this.width ||
                 p.y + p.depth <= this.y ||
                 p.y >= this.y + this.depth);
    }

    public boolean encompasses(Plot p) {
        return (this.x <= p.x &&
                this.y <= p.y &&
                this.x + this.width >= p.x + p.width &&
                this.y + this.depth >= p.y + p.depth);
    }

    public String toString() {
        return x + "," + y + "," + width + "," + depth;
    }
}
