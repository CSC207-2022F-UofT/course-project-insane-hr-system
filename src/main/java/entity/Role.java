package entity;

import java.io.Serializable;
import java.util.UUID;

public class Role implements Serializable {
    private final Position position;
    private final String name;
    private final UUID Oid;

    public Role(Position position, String name, UUID oid) {
        this.position = position;
        this.name = name;
        Oid = oid;
    }

    public Position getPosition() {
        return position;
    }

    public String getName() {
        return name;
    }

    public UUID getOid() {
        return Oid;
    }

    @Override
    public String toString() {
        return "Role{" +
                "position=" + position +
                ", name='" + name + '\'' +
                ", Oid=" + Oid +
                '}';
    }
}
