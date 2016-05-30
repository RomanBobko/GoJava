package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.Files;

import java.util.List;

public class Directory extends File{
    public Directory(String fileName){
        super(fileName);
    }

    private List<File> files;

    public void setFiles(List<File> files){
        this.files = files;
    }

    public List<File> getFiles(){
        return files;
    }
}
