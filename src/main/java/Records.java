public class Records {

    public static class StandardClass {
        private final int size;
        private final String name;

        public StandardClass(int size, String name) {
            this.size = size;
            this.name = name;
        }

        public int getSize() {
            return size;
        }

        public String getName() {
            return name;
        }
    }

    public record SimpleRecord(int size, String name) {
    }

    public record RecordWithCustomConstructors(int size, String name) {

        public RecordWithCustomConstructors(int size) {
            this(size, null);
        }

        public RecordWithCustomConstructors(String name) {
            this(0, name);
        }
    }

    public record RecordWithAdditionalLogicInConstructor(int size, String name) {
        public RecordWithAdditionalLogicInConstructor {
            int sizeDoubled = size * 2;
            this.size = sizeDoubled;
            this.name = String.format("%d: %s", sizeDoubled, name);
        }
    }

    public record RecordWithAdditionalLogicInAccessors(int size, String name) {
        public int size() {
            return size * 4;
        }

        public String name() {
            return "The names is: " + name;
        }
    }

    public record RecordTest(int size, String name) {
        /* Records cannot have fields
        private int sizeDoubled;
        */
        public RecordTest {
            /*
            this.sizeDoubled = size * 2;
            */
            this.name = name;
            this.size = size;
        }

        public int doubledSize() {
            return size * 2;
        }
    }
}
