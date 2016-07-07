package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import java.io.*;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public abstract class AbstractSiteDownloader implements SiteDownloader {

    private List<String> downloadStatus = new ArrayList<>();
    private File destinationFolder;
    private final int BYTE_BLOCK = 4096;

    AbstractSiteDownloader(String destinationFolder) throws FileNotFoundException {
        File folder = new File(destinationFolder);
        if (!folder.exists()) {
            throw new FileNotFoundException("Directory " + destinationFolder + " not exist!");
        }
        if (!folder.isDirectory()) {
            throw new FileNotFoundException(destinationFolder + " is not Directory!");
        }
        if (!folder.canWrite()) {
            throw new FileNotFoundException("Write in catalog " + destinationFolder + " is not available!");
        }
        this.destinationFolder = folder;
    }

    @Override
    public List<String> getDownloadStatus() {
        return downloadStatus;
    }

    protected boolean downloadFile(URL link, String filename) throws NoFreeSpaceException {
        try (InputStream inputStream = new BufferedInputStream(link.openConnection().getInputStream())) {
            try (OutputStream outputStream = new BufferedOutputStream(new FileOutputStream(getOutputFile(filename)))) {
                int byteCount = 0;
                long freeBytes = destinationFolder.getFreeSpace();
                byte[] buffer = new byte[BYTE_BLOCK];
                while ((byteCount = inputStream.read(buffer)) != -1) {
                    if (freeBytes < BYTE_BLOCK) {
                        downloadStatus.add(filename + " not loaded!");
                        throw new NoFreeSpaceException();
                    }
                    outputStream.write(buffer, 0, byteCount);
                }
                downloadStatus.add(filename + " download complete!");
            }
        } catch (IOException e) {
            downloadStatus.add(filename + " not loaded!");
            return false;
        }
        return true;
    }

    private File getOutputFile(String filename) {
        return new File(destinationFolder.getAbsolutePath() + "\\" + filename);
    }


}
