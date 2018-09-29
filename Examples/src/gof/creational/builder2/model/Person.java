package gof.creational.builder2.model;

/**
 * Created by Gal on 8/23/2017.
 */
public class Person {
    private int age;
    private String first_name;
    private String last_name;
    private double height;

    //Getters
    public int getAge() {
        return age;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public double getHeight() {
        return height;
    }

    @Override
    public String toString() {
        return last_name + " " + first_name + ", " + height + " cm";
    }

    public static class Builder {
        private double height;
        private String fName, lName;
        private int age;

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setFirstName(String firstName) {
            this.fName = firstName;
            return this;
        }

        public Builder setLastName(String lastName) {
            this.lName = lastName;
            return this;
        }

        public Builder setHeight(double height) {
            this.height = height;
            return this;
        }

        public Person build() {
            Person p = new Person();
            p.age = age;
            p.height = height;
            p.first_name = fName;
            p.last_name = lName;

            return p;
        }
    }

}
