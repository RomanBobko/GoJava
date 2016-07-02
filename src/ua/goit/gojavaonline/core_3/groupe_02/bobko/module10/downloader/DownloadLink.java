package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.downloader;

import java.net.MalformedURLException;
import java.net.URL;

public class DownloadLink {

    private URL url;
    private String filename;

    DownloadLink(String url, String filename){
        try {
            this.url = new URL(url);
            this.filename = filename;
        } catch (MalformedURLException e) {
            System.out.println("URL " + url +" not valid!");
        }
    }

    public String toString(){
        return getUrl() +" " + getFilename();
    }

    public URL getUrl() {
        return url;
    }

    public String getFilename() {
        return filename;
    }
}
