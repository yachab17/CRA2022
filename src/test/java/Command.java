import java.util.List;

public class Command {

    private CommandType type;
    private String option1;
    private String option2;
    private String option3;
    private String sourceCol;
    private String sourceVal;
    private String targetCol;
    private String targetVal;

    public Command(String line) {
        String[] splitLine = line.split(",");
        this.type = getCommandType(splitLine[0]);
        this.option1 = splitLine[1];
        this.option2 = splitLine[2];
        this.option3 = splitLine[3];
        this.sourceCol = splitLine[4];
        this.sourceVal = splitLine[5];
        this.targetCol = splitLine[6];
        this.targetVal = splitLine[7];

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

    public String getOption1() {
        return option1;
    }

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

    public String getSourceCol() {
        return sourceCol;
    }

    public void setSourceCol(String sourceCol) {
        this.sourceCol = sourceCol;
    }

    public String getSourceVal() {
        return sourceVal;
    }

    public void setSourceVal(String sourceVal) {
        this.sourceVal = sourceVal;
    }

    public String getTargetCol() {
        return targetCol;
    }

    public void setTargetCol(String targetCol) {
        this.targetCol = targetCol;
    }

    public String getTargetVal() {
        return targetVal;
    }

    public void setTargetVal(String targetVal) {
        this.targetVal = targetVal;
    }
}
