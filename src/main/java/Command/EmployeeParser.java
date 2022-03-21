package Command;

public enum EmployeeParser {
    EMPLOYEE_NUMBER {
        @Override
        public String toString() {
            return "employeeNum";
        }
    },
    NAME {
        @Override
        public String toString() {
            return "name";
        }
    },
    CARRIER_LEVEL {
        @Override
        public String toString() {
            return "cl";
        }
    },
    TELEPHONE_NUMBER {
        @Override
        public String toString() {
            return "phoneNum";
        }
    },
    BIRTH_DAY {
        @Override
        public String toString() {
            return "birthday";
        }
    },
    CERTI_LEVEL {
        @Override
        public String toString() {
            return "certi";
        }
    }
}
