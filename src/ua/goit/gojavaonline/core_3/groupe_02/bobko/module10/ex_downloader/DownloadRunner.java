package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.ex_downloader;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class DownloadRunner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        SiteDownloader downloader = null;
        String site;
        String directory;
        System.out.println("Enter source URL:");
        site = scanner.nextLine();
        System.out.println("Enter destination folder:");
        directory = scanner.nextLine();
        while (true) {
            try {
                downloader = new ExUaDownloader(site, directory);
                break;
            } catch (FileNotFoundException e) {
                System.out.println(e.getMessage());
                System.out.println("Enter correct destination folder or 'exit'");
                directory = scanner.nextLine();
                if (directory.equals("exit")) {
                    return;
                }
            } catch (InvalidLinkException e) {
                System.out.println("Enter correct source URL or 'exit':");
                site = scanner.nextLine();
                if (site.equals("exit")) {
                    return;
                }
            }
        }

        downloader.download();

        for (String line : downloader.getDownloadStatus()) {
            System.out.println(line);
        }

    }
}
