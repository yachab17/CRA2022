
public class Main {
    public static void main(String[] args) {
        if(!isValidArgs(args)) return;
        String inputFile = args[0];
        String outputFile = args[1];

        FileInputManager fileInputManager = new FileInputManager();
        System.out.println(fileInputManager.loadInput(fileInputManager.covertRelativePath(inputFile)));

    }

    public static boolean isValidArgs(String[] inputArgs) {
        return (inputArgs != null && inputArgs.length == 2);
    }

}
