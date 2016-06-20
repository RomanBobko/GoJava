package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.files;

import java.util.ArrayList;
import java.util.List;

public class Directory extends File{

    private List<File> files;

    Directory(String fileName){
        super(fileName);
        this.files = new ArrayList<File>();
    }

    /*ToDo by Dmitrij Lenchuk
    * К антипаттернам не относится, но тут не хватает рекурсии
    * (в директории может быть директория).
    * Не полная реализация
    * */
    Directory(Directory directory){
        super(directory.getFileName() + "_copy");
        this.files = new ArrayList<File>(directory.getFiles());
    }

    @Override
    public File copyFile() {
        return new Directory(this);
    }


    /*ToDo by Dmitrij Lenchuk
    * Можно вообще в одну строку:
    * files.forEach(file -> System.out.println(file.getFileName()));
    * */
    @ Override
    public void open() {
        for (File file : files){
            System.out.println(file.getFileName());
        }
    }

    @Override
    public String toString(){
        return "\nDirectory " + getFileName();
    }


    public List<File> getFiles(){
        return files;
    }

    /*ToDo by Dmitrij Lenchuk
    * Как пожелание:
    *   можно переписать в синтаксисе foreach
    * */
    public void createFile(File file){
        boolean fileExist = false;
        for (int i=0; i < files.size(); i++){
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


    /*ToDo by Dmitrij Lenchuk
    * Как пожелание:
    *   можно переписать в синтаксисе foreach
    * */
    public void deleteFile(String filename){
        for (int i=0; i < files.size(); i++) {
            if (files.get(i).getFileName().equals(filename)){
                files.remove(i);
                break;
            }
        }
    }

    public void setFiles(List<File> files){
        this.files = files;
    }

}
