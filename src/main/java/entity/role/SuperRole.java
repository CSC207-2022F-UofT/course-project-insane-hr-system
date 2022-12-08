package entity.role;

public class SuperRole implements Role {
    protected final Position position;
    protected final String name;

    public SuperRole(Position position, String name) {
        this.position = position;
        this.name = name;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "SuperRole{" +
                "position=" + position +
                ", name='" + name + '\'' +
                '}';
    }
}
