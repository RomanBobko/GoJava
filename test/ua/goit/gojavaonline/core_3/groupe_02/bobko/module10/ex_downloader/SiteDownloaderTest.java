package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class SiteDownloaderTest {

    private final String WEB_SITE = "http://www.ex.ua/102074225?r=3,23776";
    private final String DESTINATION_FOLDER = "C:\\Download\\";

    private SiteDownloader downloader;

    @Before
    public void init() throws Exception{
        downloader = new ExUaDownloader(WEB_SITE, DESTINATION_FOLDER);
    }

    @Test
    public void testDownload() throws Exception {
        assertTrue(downloader.download());
    }

    @Test
    public void getDownloadStatus() throws Exception {
        downloader.download();
        List<String> report = downloader.getDownloadStatus();
        assertFalse(report.isEmpty());
    }

}