import java.io.File;

public class Main {
    int num = 0;
    int numberOfFiles = 0;
    int maxDeepNum = 0;
    File maxDeepFile = new File("");

    public static void main(String[] args) {
        File basedirPath = new File("C:/Users/user/Desktop/basedir");
        Main main = new Main();
        main.findDeep(basedirPath);
        System.out.println(main.maxDeepFile.getName()); //name of the deepest file
        //System.out.println(main.maxDeepNum); //number of parents of the deepest file
        //System.out.println(main.numberOfFiles); //number of files in folder
    }
    public void findDeep(File file) {
        for (File fl : file.listFiles()) {
            if (!fl.isDirectory()) {
                //System.out.println(fl.getName() + " not a directory");
                //System.out.println(num + 1);
                if (maxDeepNum < num + 1) {
                    maxDeepNum = num + 1;
                    maxDeepFile = fl;
                }
            } else if (fl.listFiles().length == 0) {
                //System.out.println(fl.getName() + " is empty folder");
                //System.out.println(num + 1);
                if (maxDeepNum < num + 1) {
                    maxDeepNum = num + 1;
                    maxDeepFile = fl;
                }
            } else {
                num++;
                findDeep(fl);
                //System.out.println(fl.getName() + " is a folder");
                //System.out.println(num);
                if (maxDeepNum < num + 1) {
                    maxDeepNum = num + 1;
                    maxDeepFile = fl;
                }
                num--;
            }
            numberOfFiles++;
        }
    }
}
