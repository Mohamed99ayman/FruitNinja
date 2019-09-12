package sample;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;

import static sample.MainMenu.gameController;

public class SaveLoad {
   // GameController gameController = new GameController();
    public void Save() {

        try {

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document document = dBuilder.newDocument();

            Element rootElement = document.createElement("Stats");
            document.appendChild(rootElement);

            Element easy = document.createElement("EasyScore");
            easy.appendChild(document.createTextNode(String.valueOf(gameController.getEasyScore()))); //string value of (getScore) method
            rootElement.appendChild(easy);

            Element hard = document.createElement("HardScore");
            hard.appendChild(document.createTextNode(String.valueOf(gameController.getHardScore()))); //string value of (getScore) method
            rootElement.appendChild(hard);

            Element insane = document.createElement("InsaneScore");
            insane.appendChild(document.createTextNode(String.valueOf(gameController.getInsaneScore()))); //string value of (getScore) method
            rootElement.appendChild(insane);

            Element arcade = document.createElement("ArcadeScore");
            arcade.appendChild(document.createTextNode(String.valueOf(gameController.getArcadeScore()))); //string value of (getScore) method
            rootElement.appendChild(arcade);

            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(new File("./stats.xml"));
            transformer.transform(source, result);

            StreamResult consoleResult = new StreamResult(System.out);
            transformer.transform(source, consoleResult);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void Load()
    {

        try {

            File inputFile = new File("./stats.xml");
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = dbFactory.newDocumentBuilder();
            Document document = builder.parse(inputFile);
            document.getDocumentElement().normalize();
            Element root = document.getDocumentElement();

            gameController.setEasyScore(Integer.valueOf(root.getElementsByTagName("EasyScore").item(0).getTextContent()));
            gameController.setHardScore(Integer.valueOf(root.getElementsByTagName("HardScore").item(0).getTextContent()));
            gameController.setInsaneScore(Integer.valueOf(root.getElementsByTagName("InsaneScore").item(0).getTextContent()));
            gameController.setArcadeScore(Integer.valueOf(root.getElementsByTagName("ArcadeScore").item(0).getTextContent()));
            System.out.println(gameController.getEasyScore());
            System.out.println(gameController.getHardScore());
            System.out.println(gameController.getInsaneScore());
            System.out.println(gameController.getArcadeScore());

        } catch (Exception e) {
            System.out.println("File Error");
            e.printStackTrace();
        }

    }

}