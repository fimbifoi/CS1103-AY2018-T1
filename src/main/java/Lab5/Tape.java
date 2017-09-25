package Lab5;


public class Tape {

    private Cell currentCell;

    public Tape() {
        currentCell = new Cell();
    }

    public void setContent(char content) {

        if (currentCell == null) {
            currentCell = new Cell();
        } else {
            currentCell.content = content;
        }
    }

    public void moveRight() {
        /*Just.. don't touch this! It is work!*/
        if (currentCell.next == null) {
            Cell cell = new Cell();
            cell.content = ' ';
            cell.prev = currentCell;
            currentCell.next = cell;
            currentCell = currentCell.next;
        } else {
            currentCell = currentCell.next;
        }
    }

    public void moveLeft() {
        /*Just.. don't touch this! It is work too!*/
        if (currentCell.prev == null) {
            Cell cell = new Cell();
            cell.content = ' ';
            cell.next = currentCell;
            currentCell.prev = cell;
            currentCell = currentCell.prev;

        } else {
            currentCell = currentCell.prev;
        }
    }

    public char getContent() {
        return currentCell.content;
    }

    public String getTapeContents() {

        /*temporary variable for save current position*/
        Cell savedCell = currentCell;

        /*moving to left while not found first cell*/
        while (!(currentCell.prev == null)) {
            moveLeft();
        }
        /*initialize first cell by finding value*/

        StringBuilder builder = new StringBuilder();
        while (!(currentCell.next == null)) {
            builder.append(currentCell.content);
            moveRight();
        }

         /*return start position*/
        currentCell = savedCell;

        return builder.toString();
    }
}
