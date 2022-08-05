import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Main {
    public static void main(String[] args) {
        //__________________________________CSV-->JSON________________________________________________
        //Добавление значений в лист
        String[] people1 = "1,John,Smith,USA,25".split(",");
        String[] people2 = "2,Ivan,Petrov,RU,23".split(",");
        List<String[]> peoples = new ArrayList<>();
        peoples.add(people1);
        peoples.add(people2);

        //Создание и запись  файла "data.csv"
        try (CSVWriter writer = new CSVWriter(new FileWriter("data.csv"))) {
            writer.writeAll(peoples);
        } catch (IOException e) {
            e.printStackTrace();
        }

        // Определение стратегии
        String[] columnMapStrategy = {"id", "firstName", "lastName", "country", "age"};

        // Передача класса в виде параметра для использования стратегии в статическом методе parseCSV (метод setTYpe())
        Class<Employee> employeeClass = Employee.class;
        List<Employee> employes = null;
        try (FileReader reader = new FileReader("data.csv")) {
            // парсинг файла CSV
            Optional<List<Employee>> employesOptional = parseCSV(employeeClass, reader, columnMapStrategy);
            if (employesOptional.isPresent()) {
                employes = employesOptional.get();
            }
//            System.out.println(employes);
        } catch (IOException e) {
            e.printStackTrace();
        }

        //запись в JSON объекта, полученного из CSV файла.
        try (FileWriter writer = new FileWriter("jsonFromCsv.json")) {
            writeToJson(writer, employes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        // TODO: 16.05.2022 выполнить дефолтную реализацию для разнообразия
        //  (сделать перегруженным метод writeJsonFromCsv

        //__________________________________XML-->JSON________________________________________________

        //Создание xML  документа, и запись документа в "data.xml"
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        Document doc = null;
        try {
            doc = factory.newDocumentBuilder().newDocument();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Element staff = doc.createElement("staff");
        doc.appendChild(staff);

        Element employee1 = doc.createElement("employee");
        staff.appendChild(employee1);
        Element id1 = doc.createElement("id");
        id1.appendChild(doc.createTextNode("1"));
        Element firstname1 = doc.createElement("firstname");
        firstname1.appendChild(doc.createTextNode("John"));
        Element lastname1 = doc.createElement("lastname");
        lastname1.appendChild(doc.createTextNode("Smith"));
        Element country1 = doc.createElement("country");
        country1.appendChild(doc.createTextNode("USA"));
        Element age1 = doc.createElement("age");
        age1.appendChild(doc.createTextNode("25"));
        employee1.appendChild(id1);
        employee1.appendChild(firstname1);
        employee1.appendChild(lastname1);
        employee1.appendChild(country1);
        employee1.appendChild(age1);

        Element employee2 = doc.createElement("employee");
        staff.appendChild(employee2);
        Element id2 = doc.createElement("id");
        id2.appendChild(doc.createTextNode("2"));
        Element firstname2 = doc.createElement("firstname");
        firstname2.appendChild(doc.createTextNode("Ivan"));
        Element lastname2 = doc.createElement("lastname");
        lastname2.appendChild(doc.createTextNode("Ivanov"));
        Element country2 = doc.createElement("country");
        country2.appendChild(doc.createTextNode("RU"));
        Element age2 = doc.createElement("age");

        age2.appendChild(doc.createTextNode("23"));
        employee2.appendChild(id2);
        employee2.appendChild(firstname2);
        employee2.appendChild(lastname2);
        employee2.appendChild(country2);
        employee2.appendChild(age2);

        DOMSource source = new DOMSource(doc);
        StreamResult streamResult = new StreamResult(new File("data.xml"));
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = null;
        try {
            transformer = transformerFactory.newTransformer();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        }
        try {
            assert transformer != null;
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.transform(source, streamResult);
        } catch (TransformerException e) {
            e.printStackTrace();
        }

        //Парсинг "data.xml"
        Document document = null;
        try {
            document = factory.newDocumentBuilder().parse(new File("data.xml"));
        } catch (ParserConfigurationException | SAXException | IOException e) {
            e.printStackTrace();
        }
        List<Employee> employesFromXML;
        NodeList list = null;
        if (document != null) {
            list = document.getElementsByTagName("employee");
        }
        employesFromXML = parseXML(list);

        //Запись объектов employesFromXML, из распарсенного файла XML, в JSON файл "jsonFromXML.json"
        try (FileWriter writer = new FileWriter("jsonFromXML.json")) {
            writeToJson(writer, employesFromXML);
        } catch (IOException e) {
            e.printStackTrace();
        }
//________________________________________________JSON_____________________________________________
        // Чтение json файла,парсинг, получение jsonстроки (Десериализация)
        String json = null;
        Optional<String> optionalEmployees = getJSONString(new File("jsonFromXML.json"));
        if (optionalEmployees.isPresent()) {
            json = optionalEmployees.get();
        }
        //  (Сериализация)
        List<Employee> employeeList = jsonToList(json);
        for (Employee e : employeeList) {
            System.out.println(e);

        }

    }

    private static <T> Optional<List<T>> parseCSV(Class<T> tClass, FileReader reader, String[] columnMapStrategy) {
        try (CSVReader csvReader = new CSVReader(reader)) {
            ColumnPositionMappingStrategy<T> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(tClass);
            strategy.setColumnMapping(columnMapStrategy);
            CsvToBean<T> csv = new CsvToBeanBuilder<T>(csvReader)
                    .withMappingStrategy(strategy).build();
            return Optional.ofNullable(csv.parse());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static <T> void writeToJson(FileWriter writer, List<T> objects) throws IOException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.setPrettyPrinting().create();
        writer.write(gson.toJson(objects));
        writer.flush();
        writer.close();
    }

    private static List<Employee> parseXML(NodeList nodeList) {
        List<Employee> list = new ArrayList<>();
        for (int i = 0; i < nodeList.getLength(); i++) {
            Node employee = nodeList.item(i);
            NodeList employeeChilds = employee.getChildNodes();
            Employee parsedEmployeeFromXML = new Employee();
            for (int j = 0; j < employeeChilds.getLength(); j++) {
                Node child = employeeChilds.item(j);
                if (child.getNodeType() == Node.ELEMENT_NODE) {
                    Element childElement = (Element) child;
                    if (childElement.getTagName().equals("id")) {
                        parsedEmployeeFromXML.id = Long.parseLong(childElement.getTextContent());
                    }
                    if (childElement.getTagName().equals("firstname")) {
                        parsedEmployeeFromXML.firstName = childElement.getTextContent();
                    }
                    if (childElement.getTagName().equals("lastname")) {
                        parsedEmployeeFromXML.lastName = childElement.getTextContent();
                    }
                    if (childElement.getTagName().equals("country")) {
                        parsedEmployeeFromXML.country = childElement.getTextContent();
                    }
                    if (childElement.getTagName().equals("age")) {
                        parsedEmployeeFromXML.age = Integer.parseInt(childElement.getTextContent());
                    }
                }
            }
            list.add(parsedEmployeeFromXML);
        }
        return list;

    }

    private static Optional<String> getJSONString(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(reader);
            JSONArray jsonArray = (JSONArray) obj;
            return Optional.ofNullable(jsonArray.toJSONString());
        } catch (IOException | ParseException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    private static List<Employee> jsonToList(String jsonString) {
        JSONParser parser = new JSONParser();
        GsonBuilder builder = new GsonBuilder();
        List<Employee> finalList = new ArrayList<>();
        Gson gson = builder.setPrettyPrinting().create();
        try {
            JSONArray jsonArray = (JSONArray) parser.parse(jsonString);
            for (Object object : jsonArray) {
                JSONObject jsonObject = (JSONObject) object;
                finalList.add(gson.fromJson(String.valueOf(jsonObject), Employee.class));
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }

        return finalList;
    }
}
