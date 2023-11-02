package cat.iesesteveterradas.mp06.uf1.exemples;

import java.io.File;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

// En aquest exemple es fa servir
// UtilsXML per llegir i modificar
// les dades d'un XML

public class GestioXML {
    public static void main(String args[]) {
        String basePath = System.getProperty("user.dir") + "/data/";
        String fileName = "Arxiu.xml";
        String filePath = basePath + fileName;

        // Crear la carpeta 'data' si no existeix
        File dir = new File(basePath);
        if (!dir.exists()){
            if(!dir.mkdirs()) {
                System.out.println("Error en la creació de la carpeta 'data'");
            }
        }

        System.out.println("");

        Document doc = UtilsXML.read(filePath);

        // Exemple d'agafar un text a partir d'un XPath
        String id3Name = UtilsXML.getTextFromXPath(doc, "/menu/food[@id='id_03']/name");
        System.out.println("El nom del menjar amb (id=\"id_03\") és: " + id3Name);

        // Exemple d'agafar un element a partir d'un XPath (i llegir-ne un atribut i el seu text)
        Element id4ElmCoin = UtilsXML.getFirstElementFromXpath(doc, "/menu/food[@id='id_04']/price");
        String id4AttrCoin = id4ElmCoin.getAttribute("coin");
        String id4TxtCoin = id4ElmCoin.getTextContent();
        System.out.println("El nom de la moneda amb (id=\"id_04\") és \"" + id4AttrCoin + "\" i el preu és " + id4TxtCoin);

        // Exemple de llistar tots els elements d'un XPath
        System.out.println("Llista de menjars:");
        NodeList llista0 = UtilsXML.getNodeList(doc, "/menu/food");
        printLlistaMenjars(llista0);

        // Exemple de llistar tots els elements amb un filtre d'attribut
        System.out.println("Llista de menjars amb veggy igual a 'true':");
        NodeList llista1 = UtilsXML.getNodeList(doc, "/menu/food[@veggy='true']");
        printLlistaMenjars(llista1);

        // Exemple de llistar tots els elements amb un filtre de text
        System.out.println("Llista de menjars amb name que conté 'Belgian':");
        NodeList llista2 = UtilsXML.getNodeList(doc, "/menu/food/name[contains(text(), 'Belgian')]/parent::food");
        printLlistaMenjars(llista2);

        // Exemple de llistar tots els elements amb un filtre d'attibut a un fill
        System.out.println("Llista de menjars que es paguen amb 'dollar':");
        NodeList llista3 = UtilsXML.getNodeList(doc, "/menu/food/price[@coin='dollar']/parent::food");
        printLlistaMenjars(llista3);

        // Exemple de modificar un element
        Element id2ElmCalories = UtilsXML.getFirstElementFromXpath(doc, "/menu/food[@id='id_02']/calories");
        int oldCal = Integer.parseInt(id2ElmCalories.getTextContent());
        int nouCal = (int) ((Math.random() * (999 - 500)) + 500);
        id2ElmCalories.setTextContent(Integer.toString(nouCal));
        UtilsXML.write(filePath, doc);
        System.out.println("S'han canviat les calories de (id)=\"id_02\"), eren " + oldCal + " i s'ha posat " + nouCal);
    }

    static void printLlistaMenjars (NodeList llista) {
        for(int cnt = 0; cnt < llista.getLength(); cnt = cnt + 1) {
            Node nodeFood = llista.item(cnt);
            if(nodeFood.getNodeType() == Node.ELEMENT_NODE) {
                // Si és de tipus "ELEMENT_NODE" podem fer el cast a Element
                Element elmFood = (Element) nodeFood;
                String attrId = elmFood.getAttribute("id");
                Element childName = UtilsXML.getFirstChildByName(elmFood, "name");
                String txtName = childName.getTextContent();
                System.out.println(" - " + attrId + " : " + txtName);
            }
        }
    }
}
