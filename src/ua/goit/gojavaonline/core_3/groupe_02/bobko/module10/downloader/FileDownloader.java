package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.downloader;

import java.io.*;

public class FileDownloader {

    private String destinationFolder;

    FileDownloader (String destinationFolder){
        this.destinationFolder = destinationFolder;
    }

    public boolean download(DownloadLink link){

        InputStream input = getInputStream(link);
        OutputStream output = getOutputStream(link);

        int byteCount = 0;
        byte[] buffer = new byte[1024];

        try{
            while ((byteCount = input.read(buffer)) != -1){
                output.write(buffer, 0, byteCount);
            }
            System.out.println(link.getFilename() + " download complete!");
        } catch (IOException e) {
            e.printStackTrace();
        }

        return true;
    }

    private InputStream getInputStream(DownloadLink link){
        try {
            return new BufferedInputStream(link.getUrl().openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    private OutputStream getOutputStream(DownloadLink link){
        try {
            return new BufferedOutputStream(new FileOutputStream(getFile(link.getFilename())));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private File getFile(String filename){
        return new File(destinationFolder+filename);
    }

    public String getDestinationFolder() {
        return destinationFolder;
    }

    public void setDestinationFolder(String destinationFolder) {
        this.destinationFolder = destinationFolder;
    }

}
