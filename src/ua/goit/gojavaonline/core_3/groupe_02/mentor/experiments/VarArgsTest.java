package ua.goit.gojavaonline.core_3.groupe_02.mentor.experiments;

import java.util.Arrays;

/**
 * Created by dima on 05.07.2016.
 */
public class VarArgsTest {

    public static void varArgsMeth(Long ... parameters){
        System.out.println(parameters);
        System.out.println(Arrays.toString(parameters));
    }

    public static void arrArgMeth(Long[] l){
        System.out.println(l);
    }

    public static void singleArgMeth(Long l){
        System.out.println(l);
    }

    public static void main(String[] args) {
        varArgsMeth(1L);
        varArgsMeth(1L,2L,3L);

        arrArgMeth(new Long[]{1L,2L,3L,4L});

        singleArgMeth(1L);
    }
}
