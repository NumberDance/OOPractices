import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Arrays;
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
        
        switch(pattern)
        {
            case "AbstractFactory":
                input = loader.getResourceAsStream("patterns/creational/java/AbstractFactory.txt");
            break;
            case "Builder":
                input = loader.getResourceAsStream("patterns/creational/java/Builder.txt");
            break;
            case "FactoryMethod":
                input = loader.getResourceAsStream("patterns/creational/java/FactoryMethod.txt");
            break;
            case "ObjectPool":
                input = loader.getResourceAsStream("patterns/creational/java/ObjectPool.txt");
                parameters.put("Type",args[2]);
            break;
            case "Prototype":
                input = loader.getResourceAsStream("patterns/creational/java/Prototype.txt");
            break;
            case "Singleton":
                input = loader.getResourceAsStream("patterns/creational/java/Singleton.txt");
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
