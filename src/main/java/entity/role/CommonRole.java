package entity.role;

import java.util.UUID;

public class CommonRole extends SuperRole implements Role {
    private final UUID Oid;

    public CommonRole(Position position, String name, UUID oid) {
        super(position, name);
        Oid = oid;
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
