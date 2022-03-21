package Employee;

public class Employee {
    private int employeeNumber;
    private String name;
    private String careerLevel;
    private String telephoneNumber;
    private String birthDay;
    private String certiLevel;

    public Employee(int employeeNumber, String name, String careerLevel, String telephoneNumber, String birthDay, String certiLevel) {
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.careerLevel = careerLevel;
        this.telephoneNumber = telephoneNumber;
        this.birthDay = birthDay;
        this.certiLevel = certiLevel;
    }

    public String getEmployeeNumberToString() {
        return String.format("%08d", employeeNumber);
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public String getName() {
        return name;
    }

    public String getCareerLevel() {
        return careerLevel;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public String getBirthDay() {
        return birthDay;
    }

    public String getCertiLevel() {
        return certiLevel;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCareerLevel(String careerLevel) {
        this.careerLevel = careerLevel;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public void setBirthDay(String birthDay) {
        this.birthDay = birthDay;
    }

    public void setCertiLevel(String certiLevel) {
        this.certiLevel = certiLevel;
    }
}
