import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Main {

    private static String time = LocalDateTime.now()
            .format(DateTimeFormatter.ofPattern("dd.MM.yyyy - HH:mm:ss "));

    public static void main(String[] args) {

        createNewDir("Games/temp");
        createNewFile("Games/temp", "temp.txt");
        createNewDir("Games/src");
        createNewDir("Games/res");
        createNewDir("Games/savegames");
        createNewDir("Games/src/main");
        createNewDir("Games/src/test");
        createNewFile("Games/src/main", "Main.java");
        createNewFile("Games/src/main", "Utils.java");
        createNewDir("Games/res/drawables");
        createNewDir("Games/res/vectors");
        createNewDir("Games/res/icons");
    }

    public static void createNewDir(String dir) {
        File newDir = new File(dir);
        if (newDir.mkdir()) {
            toLogDirCreated(dir);
        }
    }

    public static void createNewFile(String dir, String file) {
        File newFile = new File(dir, file);
        try {
            if (newFile.createNewFile()) {
                toLogFileCreated(dir, file);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void toLogDirCreated(String dir) {
        StringBuilder stringBuilder = new StringBuilder(time + " the direction: \"" + dir + "\" was created");
        toLog(stringBuilder, "Games/temp/temp.txt");
    }

    public static void toLogFileCreated(String dir, String file) {
        StringBuilder stringBuilder = new StringBuilder(time + " the file \"" + file + "\" is created in direction: \"" + dir + "\"");
        toLog(stringBuilder, "Games/temp/temp.txt");
    }

    public static void toLog(StringBuilder stringBuilder, String tempDir) {
        try (FileWriter write = new FileWriter(tempDir, true)) {
            write.write(String.valueOf(stringBuilder));
            write.append('\n');
            write.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
