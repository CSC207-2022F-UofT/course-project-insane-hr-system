package Entity;

import java.time.LocalDateTime;
import java.util.Set;
import static Entity.Constants.CLOSED;

public class LeaveRequestProject extends AutoProject {
    private int numResponses = 0;

    public LeaveRequestProject(int oid, String name, Integer head, Set<Integer> members, String description,
                               LocalDateTime createTime) {
        super(oid, name, head, members, description, createTime);
    }

    public int getNumResponses() {
        return numResponses;
    }

    public void setNumResponses(int numResponses) {
        this.numResponses = numResponses;
    }

    @Override
    public void close() {
        this.setState(CLOSED);
        this.setCloseTime(LocalDateTime.now());
        // TODO: get userFile from head/uid, update user status
    }

    public void update() {
        this.numResponses += 1;
        // close the project when all responses have been gathered
        if (this.numResponses == this.getMembers().size()) {
            this.close();
        }
    }
}
