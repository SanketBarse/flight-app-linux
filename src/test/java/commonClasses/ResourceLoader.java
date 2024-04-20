package commonClasses;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Objects;

public class ResourceLoader{

    public static InputStream getResource(String path) throws Exception{
        try{

            InputStream stream = ResourceLoader.class.getClassLoader().getResourceAsStream(path);
            System.out.println(stream);
            if(Objects.nonNull(stream)){
                return stream;
            }else {
                throw new Exception("Resource not found: " + path);
            }
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return Files.newInputStream(Path.of(path));
    }


}
