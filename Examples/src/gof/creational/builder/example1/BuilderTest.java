package gof.creational.builder.example1;

import gof.creational.builder.example1.model.Person;

/**
 * Created by Gal on 8/23/2017.
 */
public class BuilderTest {
    public static void main(String[] args) {
        Person gal = new Person.Builder()
                .setAge(23)
                .setFirstName("Gal")
                .setLastName("Yedidovich")
                .setHeight(1.82)
                .build();

        System.out.println(gal);

        //String Builder
        concatTest();
        System.out.println();
        stringBuilderText();
    }

    static void concatTest() {
        long time = System.currentTimeMillis();
        String s = "";
        for (int i = 0; i < 500_000; i++) {
            s += "*";
        }
        time = System.currentTimeMillis() - time;
        System.out.println("string concatenation done, it took: " + time + " milli seconds");
    }

    static void stringBuilderText() {
        long time = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 500_000; i++) {
            sb.append("*");
        }
        time = System.currentTimeMillis() - time;
        System.out.println("string builder done, it took: " + time + " milli seconds");
    }
}
