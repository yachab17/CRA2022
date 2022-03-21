package Command;

import Employee.Employee;

import java.util.ArrayList;
import java.util.List;

import static Command.EmployeeParser.*;

public class Command {
    private CommandType type;
    private String option1;
    private String option2;
    private String option3;
    private List<String> etcArg;

    public Command(String[] splitLine) {
        this.type = getCommandType(splitLine[0]);
        this.option1 = splitLine[1];
        this.option2 = splitLine[2];
        this.option3 = splitLine[3];
        this.etcArg = new ArrayList<>();
        for(int i = 4; i < splitLine.length; i++) {
            etcArg.add(splitLine[i]);
        }
    }

    public Employee getEmployee() {
        return new Employee(Integer.parseInt(etcArg.get(EMPLOYEE_NUMBER.ordinal())), etcArg.get(NAME.ordinal()),
                etcArg.get(CARRIER_LEVEL.ordinal()), etcArg.get(TELEPHONE_NUMBER.ordinal()),
                etcArg.get(BIRTH_DAY.ordinal()), etcArg.get(CERTI_LEVEL.ordinal()));
    }

    public String getSourceColumn() {
        return etcArg.get(0);
    }
    public String getSourceValue() {
        return etcArg.get(1);
    }
    public String getTargetColumn() {
        return etcArg.get(2);
    }
    public String getTargetValue() {
        return etcArg.get(3);
    }

    public CommandType getCommandType(String command) {
        return CommandType.valueOf(command);
    }


    public CommandType getType() {
        return type;
    }

    public void setType(CommandType type) {
        this.type = type;
    }

    public String getOption1() { return option1; }

    public void setOption1(String option1) {
        this.option1 = option1;
    }

    public String getOption2() {
        return option2;
    }

    public void setOption2(String option2) {
        this.option2 = option2;
    }

    public String getOption3() {
        return option3;
    }

    public void setOption3(String option3) {
        this.option3 = option3;
    }

    public List<String> getEtcArg() {
        return etcArg;
    }

    public void setEtcArg(List<String> etcArg) {
        this.etcArg = etcArg;
    }

    @Override
    public String toString() {
        return "Command.Command{" +
                "type=" + type +
                ", option1='" + option1 + '\'' +
                ", option2='" + option2 + '\'' +
                ", option3='" + option3 + '\'' +
                ", etcArg=" + etcArg.toString() +
                '}';
    }
}
