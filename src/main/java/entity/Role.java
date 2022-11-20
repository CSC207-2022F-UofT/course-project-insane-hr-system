package entity;

public class Role {
    private final Position position;
    private final String name;

    public Role(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }
}
