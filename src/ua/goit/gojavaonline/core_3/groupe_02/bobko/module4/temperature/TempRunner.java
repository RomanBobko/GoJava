package ua.goit.gojavaonline.core_3.groupe_02.bobko.module4.temperature;

public class TempRunner {
    public static void main(String[] args) {
        Temperature t1 = new Temperature("36.6C");

        System.out.println(t1.getFarenheithValue());
        System.out.println(t1.getCelsiusValue());

        Temperature t2 = new Temperature("97.88F");
        System.out.println(t2.getFarenheithValue());
        System.out.println(t2.getCelsiusValue());

        Temperature t3 = t1.add(t2);
        System.out.println(t3);
        System.out.println(t3.getFarenheithValue());
    }
}
