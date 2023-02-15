package org.mps.person;

import java.util.Arrays;
import java.util.List;

public class Person {
    private final String name;
    private final int age;
    private final String gender; // Male,Female

    public Person (String name, int age, String gender) {
        this.name = name;
        if (age < 0) {
            throw new NegativeAgeException(name + "'s age is negative.");
        } else {
            this.age = age;
        }
        if ((!gender.equals("Male")) && (!gender.equals("Female"))) {
            throw new IncorrectGenderException(name + "'s gender does not correspond with the available options.");
        } else {
            this.gender = gender;
        }

    }

    public String name() {return name;}

    public int age() {return age;}

    public String gender() {return gender;}

    /**
     * Computes the average age of male and female persons in a list and returns the result in an
     * array of two elements (the first element is the male mean age and the second one is the female mean age)
     *
     * @param persons
     * @return
     */
    public double[] averageAgePerGender(List<Person> persons) {

        double male = 0;
        double cntMale = 0;
        double female = 0;
        double cntFemale = 0;

        for (Person person : persons) {
            if (person.gender == "Male") {
                male += person.age;
                cntMale += 1;
            } else {
                female += person.age;
                cntFemale += 1;
            }
        }

        male = male/cntMale;
        female = female/cntFemale;

        double[] result = new double[]{male,female};
        return result;
    }
}
