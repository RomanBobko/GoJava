package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

public abstract class File {
    private String fileName;


    File(String fileName){
        this.fileName = fileName;
    }

    public abstract File copyFile();

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

    public abstract void open();

    @Override
    public String toString(){
        return "\nFile " + getFileName();
    }

}
