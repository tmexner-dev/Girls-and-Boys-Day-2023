import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

public class WebseitenBuilder {

    private ArrayList<HashMap<String, String>> website_parser = new ArrayList<>();

    /*
    #################
    # TEXT METHODEN #
    #################
    */

    /**
     * Erstellt ein Text HTML-Element mit den angegebenen Daten.
     * @param element_id Eine einzigartige ID fuer das HTML-Element. Wird zum Veraendern des Elements benoetigt.
     * @param inhalt Text der auf der Webseite angezeigt wird.
     */
    public void Text(String element_id, String inhalt) {
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "text");
        map.put("element_id", element_id);
        map.put("content", inhalt);
        map.put("size", "20");
        map.put("color", "black");
        map.put("x", "0");
        map.put("y", "0");
        map.put("font-weight", "400");

        website_parser.add(map);
        checkForDoubleID();
    }

    public String debugReturnList() {
        return website_parser.toString();
    }

    /**
     * aendert die Schriftgroesse eines Textes, der Text wird durch die eingegebene element_id ausgewaehlt.
     * @param element_id Die ID des Textes, welcher bearbeitet werden soll.
     * @param groesse Die Schriftgroesse die der Text haben soll.
     */
    public void TextSchriftgroesse(String element_id, String groesse) {

        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("size", groesse);
            }
        }

    }
    /**
     * aendert die Textfarbe eines Textes, der Text wird durch die eingegebene element_id ausgewaehlt.
     * @param element_id Die ID des Textes, welcher bearbeitet werden soll.
     * @param farbe Die Textfarbe die der Text haben soll.
     */
    public void TextFarbe(String element_id, String farbe) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("color", farbe);
            }
        }
    }

    /**
     * aendert die Position eines Textes, der Text wird durch die eingegebene element_id ausgewaehlt.
     * @param element_id Die ID des Textes, von dem die Position veraendert werden soll.
     * @param verschiebung_nach_unten Die Verschiebung des Textes nach oben/unten (Y-Achse).
     * @param verschiebung_nach_rechts Die Verschiebung des Textes nach links/rechts (X-Achse).
     */
    public void TextPosition(String element_id, String verschiebung_nach_unten, String verschiebung_nach_rechts) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("x", verschiebung_nach_rechts);
                element.replace("y", verschiebung_nach_unten);
            }
        }
    }
    /**
     * aendert die Dicke eines Textes, der Text wird durch die eingegebene element_id ausgewaehlt.
     * @param element_id Die ID des Textes, welcher bearbeitet werden soll.
     * @param dicke Die Dicke die der Text haben soll. Bereich "100"-"900" Z.b. "400" fuer normal und "700" fuer dick
     */
    public void TextDicke(String element_id, String dicke) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("font-weight", dicke);
            }
        }
    }

    /*
    #################
    # BILD METHODEN #
    #################
    */

    /**
     * Erstellt ein neues Bild HTML Element.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param url Den Link zu dem Bild.
     */
    public void Bild(String element_id, String url) {
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "image");
        map.put("element_id", element_id);
        map.put("url", url);
        map.put("x", "0");
        map.put("y", "0");
        map.put("width", "560");
        map.put("height", "315");

        website_parser.add(map);
        checkForDoubleID();

    }

    /**
     * aendert die Position des Bildes, das HTML-Element wird mithilfe der element_id ausgewaehlt.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param verschiebung_nach_unten Die Verschiebung des Bildes nach oben/unten (Y-Achse).
     * @param verschiebung_nach_rechts Die Verschiebung des Bildes nach links/rechts (X-Achse).
     */
    public void BildPosition(String element_id, String verschiebung_nach_unten, String verschiebung_nach_rechts) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("x", verschiebung_nach_rechts);
                element.replace("y", verschiebung_nach_unten);
            }
        }
    }
    /**
     * aendert die Groesse des Bildes, das HTML-Element wird mithilfe der element_id ausgewaehlt.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param hoehe Die Hoehe des Bildes in Pixeln.
     * @param breite Die Breite des Bildes in Pixeln.
     */
    public void BildGroesse(String element_id, String hoehe, String breite) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("width", breite);
                element.replace("height", hoehe);
            }
        }
    }

    /*
    ##################
    # VIDEO METHODEN #
    ##################
    */
    /**
     * Erstellt ein neues HTML Video-Element.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param url Der Link zu dem Video. Das Video muss von Youtube sein.
     */
    public void Video(String element_id, String url) {
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "video");
        map.put("element_id", element_id);
        map.put("url", url);
        map.put("x", "0");
        map.put("y", "0");
        map.put("width", "560");
        map.put("height", "315");

        website_parser.add(map);
        checkForDoubleID();

    }
    /**
     * aendert die Position des Videos, das HTML-Element wird mithilfe der element_id ausgewaehlt.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param verschiebung_nach_unten Die Verschiebung des Videos nach oben/unten (Y-Achse).
     * @param verschiebung_nach_rechts Die Verschiebung des Videos nach links/rechts (X-Achse).
     */
    public void VideoPosition(String element_id, String verschiebung_nach_unten, String verschiebung_nach_rechts) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("x", verschiebung_nach_rechts);
                element.replace("y", verschiebung_nach_unten);
            }
        }

    }
    /**
     * aendert die Groesse des Videos, das HTML-Element wird mithilfe der element_id ausgewaehlt.
     * @param element_id Eine einzigartige ID mit dieser kann das HTML-Element veraendert werden.
     * @param hoehe Die Hoehe des Videos in Pixeln.
     * @param breite Die Breite des Videos in Pixeln.
     */
    public void VideoGroesse(String element_id, String hoehe, String breite) {
        for (HashMap<String, String> element : website_parser) {
            String search_element_id = element.get("element_id");
            if (element_id.equals(search_element_id)) {
                element.replace("width", breite);
                element.replace("height", hoehe);
            }
        }
    }

    /*
    ##################
    # TITEL METHODEN #
    ##################
    */
    /**
     * aendert den Titel der Webseite.
     * Es kann immer nur einen Titel pro Seite geben.
     * @param webseiten_titel Der neue Titel der Webseite.
     */
    public void Titel(String webseiten_titel) {
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "title");
        map.put("title", webseiten_titel);

        website_parser.add(map);
    }

    /*
    #################
    # ICON METHODEN #
    #################
    */
    /**
     * Das kleine Bild das neben dem Webseitentitel angezeigt wird. Auch Favicon genannt. Es kann nur ein Favicon pro Seite geben.
     * @param icon_url Der Url zum Bild.
     */
    public void Icon(String icon_url) {
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "favicon");
        map.put("favicon", icon_url);

        website_parser.add(map);
    }

    /*
    ##############################
    # HINTERGRUND FARBE METHODEN #
    ##############################
    */
    /**
     * aendert die Hintergrundfarbe der Webseite. Es kann nur einen Hintergrund pro Seite geben.
     * @param farbe Die Farbe die verwendet werden soll. Siehe: <a href="https://htmlcolorcodes.com/color-names/">HTML Color Names</a>
     */
    public void HintergrundFarbe(String farbe){
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "background_color");
        map.put("background_color", farbe);

        website_parser.add(map);
    }

    /**
     * aendert die Hintergrundfarbe der Webseite. Es kann nur einen Hintergrund pro Seite geben.
     * @param url Der Url zum Bild.
     * @param wiederholen [Wahr]/ [Falsch] Bild wird mehrmals angezeigt.
     * @param abdecken [Wahr]/ [Falsch] Bild wird auf maximale Größe gestreckt.
     */
    public void HintergrundBild(String url, String wiederholen, String abdecken){
        HashMap<String, String> map = new HashMap<>();
        map.put("element_type", "background_image");
        map.put("background_image_url", url);
        map.put("background_repeat", wiederholen);
        map.put("background_size", abdecken);

        website_parser.add(map);
    }

    /*
    #############################
    # FEHLER DETECTION METHODEN #
    #############################
    */


    private void checkForDoubleID(){
        ArrayList<String> uuids = new ArrayList<>();
        for (HashMap<String, String> element : website_parser) {
            if (uuids.contains(element.get("element_id"))) {
                try {
                    throw new WebseitenBuilderException("Du hast die ID: '" + element.get("element_id") + "' mehrmals benutzt!");
                } catch (WebseitenBuilderException e) {
                    throw new RuntimeException(e);
                }
            } else {
                uuids.add(element.get("element_id"));
            }

        }
    }



    private void checkForDoubleContent() {
        int title = 0;
        int icon = 0;
        int backgroundColor = 0;

        for (HashMap<String, String> element : website_parser) {
            if (element.containsKey("element_type") && element.get("element_type").equals("title")) {
                title++;
            }
            if (element.containsKey("element_type") && element.get("element_type").equals("favicon")) {
                icon++;
            }
            if (element.containsKey("element_type") && element.get("element_type").equals("background_color")) {
                backgroundColor++;
            }
        }
        if(title > 1){
            System.out.println("\033[1;31mDu darfst den Titel nur 1 mal aendern!\033[0m\033[0;15m");
        }
        if(icon > 1){
            System.out.println("\033[1;31mDu darfst das Icon nur 1 mal aendern!\033[0m\033[0;15m");
        }
        if(backgroundColor > 1){
            System.out.println("\033[1;31mDu darfst die Hintergrundfarbe nur 1 mal aendern!\033[0m\033[0;15m");
        }
    }

    /*
    ########################
    # HTML CODE GENERATION #
    ########################
    */


    private static String generateText(HashMap<String, String> element){
        return "<p style=\"font-size: " + element.get("size") + "px; color: " + element.get("color") + "; position: absolute; top: " + element.get("y") + "px; left: " + element.get("x") + "px; font-weight: " + element.get("font-weight") + ";\"> " + element.get("content") + " </p>\n";
    }

    private static String generateImage(HashMap<String, String> element){
        return "<img src=\"" + element.get("url") + "\" style=\"width: " + element.get("width") + "px; height: " + element.get("height") + "px; position: absolute; top: " + element.get("y") + "px; left: " + element.get("x") + "px;\">\n";
    }


    private static String generateVideo(HashMap<String, String> element){
        element.replace("url", element.get("url").replaceAll("https://www.youtube.com/watch\\?v=", "https://www.youtube-nocookie.com/embed/"));
        System.out.println(element.get("url"));
        return "<iframe width=\"" + element.get("width") + "\" height=\""+ element.get("height") + "\" src=\"" + element.get("url") + "\" frameborder=\"0\" allowfullscreen style=\"position: absolute; top: " + element.get("y") + "px; left: " + element.get("x") +"px; encrypted-media;\"></iframe>";
    }

    private static StringBuilder generateTitle(HashMap<String, String> element, StringBuilder htmlCode){
        return new StringBuilder(htmlCode.toString().replaceAll("<title>Meine eigene Webseite</title>", "<title>" + element.get("title") + "</title>"));
    }

    private static StringBuilder generateIcon(HashMap<String, String> element, StringBuilder htmlCode){
        String old_favicon = "<link rel=\"icon\" type=\"image/png\" href=\"https://www.united-internet.de/favicon.ico\">";
        String new_favicon = "<link rel=\"icon\" type=\"image/png\" href=\"" + element.get("favicon") + "\"></head>";
        return new StringBuilder(htmlCode.toString().replaceAll(old_favicon, new_favicon));
    }

    private static StringBuilder generateBackground(HashMap<String, String> element, StringBuilder htmlCode){
        return new StringBuilder(htmlCode.toString().replaceAll("background-color: #ffffff", "background-color: " + element.get("background_color") + ";"));
    }
                                                                                                                                    //background-image: url("");
    private static StringBuilder generateBackgroundImage(HashMap<String, String> element, StringBuilder htmlCode){
        String currendCode = htmlCode.toString().replaceAll("background-image: url\\(\"\"\\);","background-image: url(\"" + element.get("background_image_url") + "\");");
        if(element.get("background_repeat").equals("Falsch"))
            currendCode = currendCode.replaceAll(" *background-repeat: repeat;", "background-repeat: no-repeat;");
        if(element.get("background_size").equals("Falsch"))
            currendCode = currendCode.replaceAll(" *background-size: cover;", "background-size: auto;");
        return new StringBuilder(currendCode);
    }



    private static StringBuilder htmlPreset(){
        return new StringBuilder("""
                <!DOCTYPE html>
                <html lang="en">
                <head>
                    <meta charset="UTF-8">
                    <title>Meine eigene Webseite</title>
                    <link rel="icon" type="image/png" href="https://www.united-internet.de/favicon.ico">
                    <style>
                        body {
                            background-image: url("");
                            background-repeat: repeat;
                            background-size: cover;
                            background-color: #ffffff;
                        }
                    </style>
                </head>
                <body>""");
    }

    /**
     * Schliesst die Webseitenerstellung ab, generiert den HTML-Code.
     */
    public void fertig() {
        System.out.println(website_parser);
        checkForDoubleContent();
        StringBuilder htmlCode = htmlPreset();
        for (HashMap<String, String> element : website_parser) {
            String element_type = element.get("element_type");
            switch (element_type) {
                case "text":
                    htmlCode.append(generateText(element));
                    break;
                case "image":
                    htmlCode.append(generateImage(element));
                    break;
                case "video":
                    htmlCode.append(generateVideo(element));
                    break;
                case "title":
                    htmlCode = generateTitle(element, htmlCode);
                    break;
                case "favicon":
                    htmlCode = generateIcon(element, htmlCode);
                    break;
                case "background_color":
                    htmlCode = generateBackground(element, htmlCode);
                break;
                case "background_image":
                    htmlCode = generateBackgroundImage(element, htmlCode);
                    break;
            }

        }
        htmlCode.append("</body>\n" + "</html>");
        String finalCode = htmlCode.toString();

        File file = new File("index.html");

        try {
            FileWriter writer = new FileWriter(file);
            writer.write(finalCode);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(file);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }




}
