package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

import static org.junit.Assert.*;

public class SiteDownloaderTest {

    public static final String WEB_SITE = "http://www.ex.ua/787284920617";
    public static final String DESTINATION_FOLDER = "C:\\Download\\Test";

    public static SiteDownloader downloader;

    @BeforeClass
    public static void testInit() throws Exception {
        downloader = new ExUaDownloader(WEB_SITE, DESTINATION_FOLDER);
        File folder = new File(DESTINATION_FOLDER);
        for (File f : folder.listFiles()) {
            f.delete();
        }
    }

    @Test
    public void testDownload() throws Exception {

        File file = new File(DESTINATION_FOLDER + "\\Test.mp3");
        assertFalse(file.exists());
        assertTrue(downloader.download());
        assertTrue(file.exists());
    }

    @Test
    public void testGetDownloadStatusOK() throws Exception {
        downloader.download();
        List<String> report = downloader.getDownloadStatus();
        assertEquals("Test.mp3 download complete!", report.get(0));
    }

    @Test(expected = InvalidLinkException.class)
    public void testBadUrl() throws Exception {
        SiteDownloader badDownloader = new ExUaDownloader("ex.ua/badUrl", DESTINATION_FOLDER);
    }

    @Test(expected = FileNotFoundException.class)
    public void testBadFolder() throws Exception {
        SiteDownloader badDownloader = new ExUaDownloader(WEB_SITE, "c:\\notExistFolder");
    }

    @Test (expected = NoFreeSpaceException.class)
    public void testNoFreeSpace()throws Exception {
        AbstractSiteDownloader.class.getField("destinationFolder");
    }

}