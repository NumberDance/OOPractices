import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class OOPractices
{
    public static void main(String[]args) throws IOException
    {
        String name = args[0], pattern = args[1];
        String param1 = args[2], param2 = args[3];

        switch("Singleton")
        {
            case "Singleton":
                String file = new String(Files.readAllBytes(Paths.get("patterns/creational/Singleton.txt")),StandardCharsets.UTF_8);
                System.out.println(file);
            break;
        }
    }
}
