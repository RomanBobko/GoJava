package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.downloader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EXUAMP3Downloader {

    private final String EXUA_EXP = "^(http://)?(www\\.)?ex.ua/.+";
    private final String PROTOCOL_EXP = "^http://.+";
    private final String PROTOCOL = "http://";
    private final String LOAD = "http://www.ex.ua/load";
    private final String SEARCH_EX = "<a href='/get(/[\\w]+)' title='([\\w\\s\\+\\=\\-\\!А-Яа-яіІёЁїЇ.,`'&%$#@()]+\\.mp3)'";

    private String destinationFolder;
    private String webPage;

    public void download(){
        FileDownloader fd = new FileDownloader(destinationFolder);
        ArrayList<DownloadLink> links = parseMP3Links();
        for (DownloadLink link : links){
            fd.download(link);
        }
    }

    public ArrayList<DownloadLink> parseMP3Links(){
        ArrayList<DownloadLink> links = new ArrayList<>();
        URL exua = getUrl();
        URLConnection connection = getConnection(exua);
        BufferedReader buffer = getBufferedReader(connection);
        StringBuilder builder = new StringBuilder();
        try {
            String line;
            while ((line = buffer.readLine()) != null) {
                builder.append(line);
            }
            buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        String result = builder.toString();
        Pattern pattern = Pattern.compile(SEARCH_EX);
        Matcher matcher = pattern.matcher(result.replaceAll("&#39;", "'"));

        while (matcher.find()) {
            links.add(new DownloadLink(LOAD + matcher.group(1), matcher.group(2)));
        }
        return links;
    }

    public void setWebPage(String webPage){
        if (webPageIsValid(webPage)){
            if (noprotocol(webPage)){
                this.webPage = PROTOCOL + webPage;
            } else {
                this.webPage = webPage;
            }
        } else {
            throw new IllegalArgumentException("Web page " + webPage + " not valid!");
        }
    }

    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

    private boolean valideteString(String webPage, String pattern){
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(webPage);
        return matcher.matches();
    }

    private boolean webPageIsValid(String webPage){
        return valideteString(webPage, EXUA_EXP);
    }

    private boolean noprotocol(String webPage){
        return !valideteString(webPage, PROTOCOL_EXP);
    }

    private BufferedReader getBufferedReader(URLConnection connection) {
        try {
            return new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URL getUrl(){
        try {
            return new URL(webPage);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    private URLConnection getConnection(URL url){
        try {
            return url.openConnection();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

}
