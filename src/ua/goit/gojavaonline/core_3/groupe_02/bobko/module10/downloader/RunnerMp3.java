package ua.goit.gojavaonline.core_3.groupe_02.bobko.module10.downloader;

import java.util.Scanner;

public class RunnerMp3 {

    public static void main(String[] args) {

        EXUAMP3Downloader downloader = new EXUAMP3Downloader();

        try {
            downloader.setWebPage(args[0]);
        } catch(ArrayIndexOutOfBoundsException e){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter web resource:");
            downloader.setWebPage(scanner.nextLine());
        }

        try {
            downloader.setDestinationFolder(args[1]);
        } catch (ArrayIndexOutOfBoundsException e){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter destination folder:");
            downloader.setDestinationFolder(scanner.nextLine());

        }

        downloader.download();

    }

}
