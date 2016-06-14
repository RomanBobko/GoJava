package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;



public class FilesRunner {
    public static void main(String[] args) {

        Directory root = new Directory("\\");

        AudioFile audio1 = new AudioFile("Sonata.mp3");
        root.createFile(audio1);

        TextFile text1 = new TextFile("book.txt");
        root.createFile(text1);

        ImageFile image1 = new ImageFile("Picture.jpg");
        root.createFile(image1);

        Directory dir1 = new Directory("home");
        root.createFile(dir1);

        TextFile text_home = new TextFile("User.dat");
        dir1.createFile(text_home);

        root.createFile(image1.copyFile());
        root.createFile(dir1.copyFile());

        dir1.deleteFile("User.dat");

        for (File file : root.getFiles()) {
            System.out.println(file.toString());
            file.open();
        }



    }
}
