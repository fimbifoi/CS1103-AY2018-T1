package Lab5;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Tape {

    private List<Cell> cells = new LinkedList<>();
    private Cell currentCell;


    public void setContent(char content) {

        if(currentCell == null) {
            currentCell = new Cell();
        }
        else {
            currentCell.content = content;
            cells.add(currentCell);
        }
    }

    public void moveRight() {
        currentCell = currentCell.next;
    }

    public void moveLeft() {
        currentCell = currentCell.prev;
    }

    public char getContent() {
        return currentCell.content;
    }

    public String getTapeContents() {

        String builder = cells.stream().map(cell -> String.valueOf(cell.content)).collect(Collectors.joining());
        return builder;
    }
}
