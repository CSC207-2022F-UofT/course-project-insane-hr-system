package entity;

public interface Role {
    Position getPosition();
    String getName();
    @Override
    String toString();
}
