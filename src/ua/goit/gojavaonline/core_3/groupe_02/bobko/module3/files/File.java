package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

public abstract class File {

    File(String fileName){
        this.fileName = fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

    public abstract void open();

    public abstract File copyFile();

    @Override
    public String toString(){
        return "\nFile " + getFileName();
    }

    private String fileName;

}
