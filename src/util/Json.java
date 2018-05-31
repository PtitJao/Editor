package Util;

import org.json.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileNotFoundException;
import java.io.FileReader;
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

    public Json(String fileName) {
        this.fileName = fileName;
    }

    public String getNom() {
        return nom;
    }

    public Integer getValue() {
        return value;
    }

    public List<Bar> getList() {
        return list;
    }

    public Bar[] getArray() {
        return array;
    }

    public String getFileName() {
        return fileName;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public void setList(List<Bar> list) {
        this.list = list;
    }

    public void setArray(Bar[] array) {
        this.array = array;
    }

    public void setFileName(String fileName) {
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
        JSONParser parser = new JSONParser();

        try {

            Object obj = parser.parse(new FileReader(fileName));

            JSONObject jsonObject = (JSONObject) obj;

            this.nom = (String) jsonObject.get("nom");
            Integer value = (Integer) jsonObject.get("value");

            JSONArray list = (JSONArray) jsonObject.get("list");
            for (int i = 0; i <list.length() ; i++) {
                this.list.add((Bar) list.get(i));
            }

            JSONArray array = (JSONArray) jsonObject.get("array");
            for (int i = 0; i <array.length() ; i++) {
                this.array[i] = (Bar) array.get(i);
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

    }

}
