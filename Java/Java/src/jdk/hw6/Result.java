package jdk.hw6;

public class Result {
    private boolean isChanged;
    private boolean isWin;

    public Result(boolean isChanged, boolean isWin){
        this.isChanged = isChanged;
        this.isWin = isWin;
    }

    public boolean isChanged() {
        return isChanged;
    }

    public void setChanged(boolean changed) {
        isChanged = changed;
    }

    public boolean isWin() {
        return isWin;
    }

    public void setWin(boolean win) {
        isWin = win;
    }
}
