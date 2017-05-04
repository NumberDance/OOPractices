import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OOPractices
{   
    public static void main(String[]args) throws IOException, URISyntaxException
    {
        new OOPractices().initGenerator(args);
    }
    
    private void initGenerator(String [] args)
    {
        String name = args[0];
        String pattern = args[1];
        
        HashMap<String,String> parameters = new HashMap<>();
        
        ClassLoader loader = new OOPractices().getClass().getClassLoader();
        InputStream input = null;
        
        String behavioral = "patterns/behavioral/java/";
        String creational = "patterns/creational/java/";
        String structural = "patterns/structural/java/";
        
        switch(pattern)
        {
            case "AbstractFactory":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
                parameters.put("Type",args[2]);
            break;
            case "Builder":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
            break;
            case "FactoryMethod":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
                parameters.put("Type",args[2]);
            break;
            case "ObjectPool":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
                parameters.put("Type",args[2]);
            break;
            case "Prototype":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
            break;
            case "Singleton":
                input = loader.getResourceAsStream(creational + pattern + ".txt");
            break;
            
            case "Adapter":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
                parameters.put("LegacyObject",args[2]);
                parameters.put("LatestObject",args[3]);
            break;
            case "Bridge":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
            case "Composite":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
            case "Decorator":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
            case "Facade":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
            case "Flyweight":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
            case "Proxy":
                input = loader.getResourceAsStream(structural + pattern + ".txt");
            break;
        }
        
        this.generatePattern(name,pattern,input,parameters);
    }
    private void generatePattern(String name,String pattern,InputStream input,HashMap<String,String> parameters)
    {   
        try
        {
            String generated = "FAIL";
            
            Scanner scanner = new Scanner(input);
            scanner.useDelimiter("\\Z");  
            generated = scanner.next(); 
            scanner.close();
            
            generated = generated.replaceAll(pattern,name);
            for(Map.Entry<String, String> entry : parameters.entrySet())
            {
                generated = generated.replace(entry.getKey(),entry.getValue());
            }
            
            PrintWriter writer = new PrintWriter(new FileWriter(name + ".java"));
            writer.write(generated);
            writer.close();
        } 
        catch (IOException ex)
        {
            Logger.getLogger(OOPractices.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
