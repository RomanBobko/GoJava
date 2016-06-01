package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File{
    Directory(String fileName){
        super(fileName);
        this.files = new ArrayList<File>();
    }

    Directory(Directory directory){
        super(directory.getFileName()+"_copy");
        this.files = new ArrayList<File>(directory.getFiles());
    }

    @Override
    public File copyFile() {
        return new Directory(this);
    }

    @Override
    public void open() {
        for (File file:files){
            System.out.println(file.getFileName());
        }
    }

    @Override
    public String toString(){
        return "\nDirectory " + getFileName();
    }

    public void setFiles(List<File> files){
        this.files = files;
    }

    public List<File> getFiles(){
        return files;
    }

    public void createFile(File file){
        boolean fileExist = false;
        for (int i=0; i<files.size(); i++){
            if (files.get(i).getFileName().equals(file.getFileName())){
                fileExist = true;
                break;
            }
        }
        if (fileExist){
            System.out.println("the file name exists, can not create!");
        }
        else{
            files.add(file);
        }

    }

    public void deleteFile(String filename){
        for (int i=0; i<files.size(); i++) {
            if (files.get(i).getFileName().equals(filename)){
                files.remove(i);
                break;
            }
        }
    }

    private List<File> files = new ArrayList<File>();

}
