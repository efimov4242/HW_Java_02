package jsonParsing;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;

/*
1 . Дана строка sql-запроса "select * from students where ". Сформируйте часть WHERE этого запроса, используя
StringBuilder. Данные для фильтрации приведены ниже в виде json строки.
Если значение null, то параметр не должен попадать в запрос.
Параметры для фильтрации: {"name":"Ivanov", "country":"Russia", "city":"Moscow", "age":"null"}
*/
public class readJson {
    public static void main(String[] args) throws IOException, ParseException {

        JSONParser jsonParse = new JSONParser();
        JSONObject jsonObject = (JSONObject) jsonParse.parse((new FileReader("test.json")));

        JSONArray studentsArr = (JSONArray) jsonObject.get("students");
        Iterator studentsItr = studentsArr.iterator();
        while (studentsItr.hasNext()) {
            JSONObject test = (JSONObject) studentsItr.next();
            StringBuilder sb = new StringBuilder("select * from students where ");
            sb.append("name = " + test.get("name"));
            System.out.print(sb.toString());
            }
        }
    }
