package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;


public class TextFile extends File {
    TextFile(String fileName){
        super(fileName);
    }

    @Override
    public File copyFile() {
        return new TextFile(this.getFileName()+"_copy");
    }

    @Override
    public void open() {
        System.out.println("Text output");
    }
}
