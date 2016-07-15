package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExUaDownloader extends AbstractSiteDownloader {

    private final String EXUA_EXP = "^(http://)?(www\\.)?ex.ua/.+";
    private final String PROTOCOL_EXP = "^http://.+";
    private final String PROTOCOL = "http://";
    private final String LOAD = "http://www.ex.ua/load";
    private final String SEARCH_EX = "<a href='/get(/[\\w/]+)' title='(.{1,100}\\.mp3)'";


    private URL webPage;

    ExUaDownloader(String webPage, String destinationFolder) throws FileNotFoundException, InvalidLinkException {
        super(destinationFolder);
        URL rootLink = null;
        if (valideteString(webPage, EXUA_EXP)) {
            if (noprotocol(webPage)) {
                webPage = PROTOCOL + webPage;
            }
            try {
                rootLink = new URL(webPage);
                HttpURLConnection connection = (HttpURLConnection) rootLink.openConnection();
                int code = connection.getResponseCode();
                if (code == 200 || code == 201 ) {
                    this.webPage = rootLink;
                } else {
                    throw new InvalidLinkException("Web page not available!");
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    @Override
    public boolean download() {
        Map<String, String> links;
        links = parseLinks();
        for (Map.Entry<String, String> link : links.entrySet()) {
            try {
                downloadFile(getUrl(link.getKey()), link.getValue());
            } catch (NoFreeSpaceException e) {
                System.out.println("Drive is full!");
                return false;
            }
        }
        return true;
    }

    private URL getUrl(String urlPath) {
        try {
            return new URL(urlPath);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Map<String, String> parseLinks() {
        Map<String, String> links = new HashMap<>();
        URLConnection connection = null;
        BufferedReader buffer = null;
        try {
            connection = webPage.openConnection();
            buffer = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }

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
        result = result.replaceAll("&#39;", "'");
        Matcher matcher = pattern.matcher(result);

        while (matcher.find()) {
            links.put(LOAD + matcher.group(1), matcher.group(2));
        }
        return links;
    }

    private boolean valideteString(String webPage, String pattern) {
        Pattern p = Pattern.compile(pattern);
        Matcher matcher = p.matcher(webPage);
        return matcher.matches();
    }

    private boolean noprotocol(String webPage) {
        return !valideteString(webPage, PROTOCOL_EXP);
    }

}
