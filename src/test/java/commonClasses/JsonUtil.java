package commonClasses;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.InputStream;

public class JsonUtil {

    private static final ObjectMapper mapper = new ObjectMapper();
    public static <T> T getTestData(String path, Class<T> type){
        try (InputStream stream = ResourceLoader.getResource(path)){
            return mapper.readValue(stream,type);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        return null;

    }

}
