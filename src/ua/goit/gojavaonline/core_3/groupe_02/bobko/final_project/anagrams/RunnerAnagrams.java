package ua.goit.gojavaonline.core_3.groupe_02.bobko.final_project.anagrams;


import java.util.Arrays;

public class RunnerAnagrams {

    public static void main(String[] args) {
        String s1 = "покраснение";
        String s2 = "пенсионерка";
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        char [] c1 = s1.toCharArray();
        char [] c2 = s2.toCharArray();
        Arrays.sort(c1);
        Arrays.sort(c2);
        System.out.println(Arrays.equals(c1, c2));

    }

}
