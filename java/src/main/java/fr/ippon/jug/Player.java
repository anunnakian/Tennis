package fr.ippon.jug;

public class Player {

    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
    }

    public static Player of(String name) {
        return new Player(name);
    }

    public void wonPoint() {
        this.score++;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    @Override
    public String toString() {
        return this.getName();
    }
}
