package ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.flowers;

import java.util.*;

public class Bouquet {

    private List<Flower> flowers;

    public void addFlower(Flower flower){
        if (flowers == null) {
            flowers = new ArrayList<Flower>();
        }
        flowers.add(flower);
    }

    public List<Flower> getFlowers(){
        return flowers;
    }

    public void setFlowers(List<Flower> flowers){
        this.flowers = flowers;
    }
}
