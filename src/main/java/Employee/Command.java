package Employee;

public interface Command {
    String getSourceColumn();
    String getSourceValue();
    String getTargetColumn();
    String getTargetValue();
}
