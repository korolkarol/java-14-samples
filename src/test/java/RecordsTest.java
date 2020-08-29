import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RecordsTest {

    @Test
    void recordCreatesDefaultConstructorWithAllArgs() {
        final var record = new Records.SimpleRecord(1, "myRecord");
        assertNotNull(record);
    }

    @Test
    void recordAutomaticallyGeneratesAccessorMethods() {
        var record = new Records.SimpleRecord(1, "myRecord");
        assertEquals(1, record.size());
        assertEquals("myRecord", record.name());
    }

    @Test
    void recordAutomaticallyGeneratesEqualsMethod() {
        // In records equals is overridden with generated implementation that is based on all the arguments
        final var record1 = new Records.SimpleRecord(1, "myRecord");
        final var record2 = new Records.SimpleRecord(1, "myRecord");
        assertEquals(record2, record1);
        // In standard class equals comes from Object.equals, and returns true only for the same object
        var standardClass1 = new Records.StandardClass(1, "myRecord");
        var standardClass2 = new Records.StandardClass(1, "myRecord");
        assertNotEquals(standardClass1, standardClass2);
        assertEquals(standardClass1, standardClass1);
    }

    @Test
    void recordAutomaticallyGeneratesHashCodeMethod() {
        // In records hashCode method is overridden with generated implementation that is based on all the arguments
        final var record1 = new Records.SimpleRecord(1, "myRecord");
        final var record2 = new Records.SimpleRecord(1, "myRecord");
        assertEquals(record2.hashCode(), record1.hashCode());
        // In standard class hashCode method comes from Object.hashCode, and returns same value only for the same object
        var standardClass1 = new Records.StandardClass(1, "myRecord");
        var standardClass2 = new Records.StandardClass(1, "myRecord");
        assertNotEquals(standardClass1.hashCode(), standardClass2.hashCode());
        assertEquals(standardClass1.hashCode(), standardClass1.hashCode());
    }

    @Test
    void recordAutomaticallyGeneratesToStringMethod() {
        // In records toString method is overridden with generated implementation that is based on all the arguments
        final var record1 = new Records.SimpleRecord(1, "myRecord");
        final var record2 = new Records.SimpleRecord(1, "myRecord");
        assertEquals(record2.toString(), record1.toString());
        assertEquals("SimpleRecord[size=1, name=myRecord]", record1.toString());
        assertEquals("SimpleRecord[size=1, name=myRecord]", record2.toString());
        System.out.println(record1.toString());
        // In standard class toString() method comes from Object.toString, and returns same value only for the same object
        var standardClass1 = new Records.StandardClass(1, "myRecord");
        var standardClass2 = new Records.StandardClass(1, "myRecord");
        assertNotEquals(standardClass1.toString(), standardClass2.toString());
        assertEquals(standardClass1.toString(), standardClass1.toString());
    }

    @Test
    void recordsConstructorCanBeSupplementedWithAdditionLogic() {
        var record = new Records.RecordWithAdditionalLogicInConstructor(1, "myRecord");
        assertEquals(2, record.size());
        assertEquals("2: myRecord", record.name());
    }

    @Test
    void recordsAccessorsCanBeSupplementedWithAdditionLogic() {
        var record = new Records.RecordWithAdditionalLogicInAccessors(1, "myRecord");
        assertEquals(4, record.size());
        assertEquals("The names is: myRecord", record.name());
    }
}