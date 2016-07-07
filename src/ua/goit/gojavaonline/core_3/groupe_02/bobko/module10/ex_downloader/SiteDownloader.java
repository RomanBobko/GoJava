package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import java.util.List;

public interface SiteDownloader {

    boolean download();

    List<String> getDownloadStatus();
}
