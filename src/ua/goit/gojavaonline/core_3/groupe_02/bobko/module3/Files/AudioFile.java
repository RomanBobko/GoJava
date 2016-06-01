package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

public class AudioFile extends File {

    AudioFile(String fileName) {
        super(fileName);
    }

    @Override
    public File copyFile() {
        return new AudioFile(this.getFileName()+"_copy");
    }

    @Override
    public void open() {
        System.out.println("Play sound");
    }
}
