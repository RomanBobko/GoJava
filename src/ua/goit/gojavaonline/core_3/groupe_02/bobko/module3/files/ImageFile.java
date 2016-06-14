package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

public class ImageFile extends File{

    ImageFile(String fileName){
        super(fileName);
    }

    @Override
    public File copyFile() {
        return new ImageFile(this.getFileName()+"_copy");
    }

    @Override
    public void open() {
        System.out.println("Draw image");
    }
}
