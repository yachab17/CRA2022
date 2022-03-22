package Command;

public enum CommandOption {
    NO_OPTION {
        @Override
        public String toString() { return " "; }
    },
    PRINT {
        @Override
        public String toString() { return "-p"; }
    },
    NAME_FIRST {
        @Override
        public String toString() { return "-f"; }
    },
    NAME_LAST {
        @Override
        public String toString() { return "-l"; }
    },
    PHONE_MIDDLE {
        @Override
        public String toString() { return "-m"; }
    },
    PHONE_LAST {
        @Override
        public String toString() { return "-l"; }
    },
    BIRTHDAY_YEAR  {
        @Override
        public String toString() { return "-y"; }
    },
    BIRTHDAY_MONTH {
        @Override
        public String toString() { return "-m"; }
    },
    BIRTHDAY_DAY {
        @Override
        public String toString() { return "-d"; }
    }
}