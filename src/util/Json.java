package Util;

import org.json.*;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class Json {


    private String nom;
    private Integer value;
    private List<Bar> list;
    private Bar[] array;
    private String fileName;

    public Json(String nom, Integer value, List<Bar> list, Bar[] array, String fileName) {
        this.nom = nom;
        this.value = value;
        this.list = list;
        this.array = array;
        this.fileName = fileName;
    }

    public void writeJsonFile()
    {


        JSONObject obj = new JSONObject() ;
        JSONArray  list = new JSONArray() ;
        JSONArray  list1 = new JSONArray() ;
        obj.put("nom",nom);
        obj.put("value",value);

        for (int i = 0; i < this.list.size(); i++) {

            list1.put(i,this.list.get(i));
        }


        for (int i = 0; i < array.length; i++) {
            list.put(i,array[i]);
        }

        obj.put("array",list);
        obj.put("list",list1);


        try (FileWriter file = new FileWriter(fileName))
        {
                file.write(obj.toString());

        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    public void readJsonFile()
    {

    }

}
