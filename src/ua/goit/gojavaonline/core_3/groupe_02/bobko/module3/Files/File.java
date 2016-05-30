package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.Files;

public abstract class File {
    private String fileName;

    public File(String fileName){
        this.fileName = fileName;
    }

    public void setFileName(String fileName){
        this.fileName = fileName;
    }

    public String getFileName(){
        return fileName;
    }

}
