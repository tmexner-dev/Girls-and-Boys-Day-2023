
public class BeispielWebseite {
    public static void main(String[] args) {

        // Instance von Webseite erstellen

        WebseitenBuilder webseite = new WebseitenBuilder();


        // Text:

        webseite.Text("1", "Text");

        webseite.TextSchriftgroesse("1", "24");

        webseite.TextFarbe("1", "green");

        webseite.TextPosition("1", "1", "1");

        webseite.TextDicke("1", "fett");


        // Bilder

        webseite.Bild("2", "url");

        webseite.BildPosition("2", "1", "1");

        webseite.BildGroesse("2",  "200", "300");


        // Video

        webseite.Video("3", "url");

        webseite.VideoPosition("3", "1", "1");

        webseite.VideoGroesse("3", "200", "300");


        // Titel (im Tab)

        webseite.Titel("Neuer Name");


        // Favicon

        webseite.Icon("url_to_fav_icon");


        // Webseiten Farbe

        webseite.HintergrundFarbe("farbe");


        webseite.fertig();
    }
}