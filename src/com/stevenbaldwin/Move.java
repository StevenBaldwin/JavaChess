package com.stevenbaldwin;
//  Created by Steven J Baldwin  on 2016-09-26.

import java.awt.*;
import java.io.Serializable;

public class Move implements Serializable { //Data Transfer Object
    private Point start;
    private Point end;
public Move(Point start, Point end){
    this.start = start;
    this.end = end;
}
    public Move(int x_start, int y_start, int x_end, int y_end){
        this.start = new Point(x_start,y_start);
        this.end = new Point(x_end,y_end);
    }
    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public Point getStart() {

        return start;
    }

    public void setStart(Point start) {

        this.start = start;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Move move = (Move) o;

        if (!start.equals(move.start)) return false;
        return end.equals(move.end);

    }

    @Override
    public int hashCode() {
        int result = start.hashCode();
        result = 31 * result + end.hashCode();
        return result;
    }

    @Override
    public String toString() {
        String representation = "" + "( " + start.x + " , " + start.y +")->" +"( " + end.x + " , " + end.y +")\t";
        return representation;
    }
}
