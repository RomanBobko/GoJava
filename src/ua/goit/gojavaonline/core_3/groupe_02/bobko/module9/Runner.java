package ua.goit.gojavaonline.core_3.groupe_02.bobko.module9;

import ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music.Guitar;
import ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music.MusicalInstrument;
import ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music.Piano;
import ua.goit.gojavaonline.core_3.groupe_02.bobko.module3.music.Trumpet;

import java.security.GuardedObject;
import java.util.ArrayList;

/**
 * Created by bobko on 27.06.2016.
 */
public class Runner {

    public static void main(String[] args) {

        ArrayList<MusicalInstrument> list = new ArrayList<>();
        list.add(new Guitar());
        list.add(new Piano());
        list.add(new Trumpet());
        list.add(new Guitar());

        String s = list.toString();
        final int ENCRYPTION_CODE = 32;

        s = CaesarChiper.encryption(s, ENCRYPTION_CODE);
        System.out.println(s);

        s = CaesarChiper.decryption(s, ENCRYPTION_CODE);
        System.out.println(s);



    }




}
