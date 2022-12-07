package data_access;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckProfileIMDataAccessTest {
    @Test
    void checkUUIDNotChange(){
        CheckProfileIMDataAccess dataAccess = new CheckProfileIMDataAccess();
        CheckProfileIMDataAccess dataAccess1 = new CheckProfileIMDataAccess();
        assertEquals(dataAccess1.getDpt().getOid(), dataAccess.getDpt().getOid());
        assertEquals(dataAccess.getEe11().getTasks().get(0).getOid(), dataAccess1.getEe11().getTasks().get(0).getOid());
    }


}