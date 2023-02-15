package org.mps.person;


import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class PersonTest {
    List<Person> lista;

    Person person1 = new Person("Pablo", 13, "Male");
    Person person2 = new Person("Jose", 17, "Male");
    Person person3 = new Person("Maria", 20, "Female");
    Person person4 = new Person("Sara", 30, "Female");

    @BeforeEach
    void setup() {lista = new ArrayList<>();}
    @AfterEach
    void shutdown() {lista = null;}

    //Probamos que se haga la media de los generos bien.
    @Test
    void TestListAverage() {
        lista.add(person1);
        lista.add(person2);
        lista.add(person3);
        lista.add(person4);
        double[] obtainedResult = person1.averageAgePerGender(lista);
        double[] expectedResult = {15,25};
        assertArrayEquals(expectedResult,obtainedResult);
    }
    //Probamos que funciones las excepciones creadas (IncorrectGenderException)
    @Test
    void TestIncorrectGender() {assertThrows(IncorrectGenderException.class, () -> new Person("Alberto", 34, "Error"));}

    //Probamos que funciones las excepciones creadas (IncorrectGenderException)
    @Test
    void TestIncorrectGenderUpperCase() {assertThrows(IncorrectGenderException.class, () -> new Person("Alberto", 34, "MALE"));}

    //Probamos que funciones las excepciones creadas (IncorrectGenderException)
    @Test
    void TestIncorrectGenderLowerCase() {assertThrows(IncorrectGenderException.class, () -> new Person("Alberto", 34, "male"));}

    //Probamos que funciones las excepciones creadas (NegativeAgeException)
    @Test
    void TestNegativeAge() {assertThrows(NegativeAgeException.class, () -> new Person("Alberto", -25, "Male"));}

    //Probamos de que obtenemos el nombre esperado
    @Test
    void TestName(){
        String obtainedResult = person1.name();
        String expectedResult = "Pablo";
        assertEquals(expectedResult,obtainedResult);
    }

    //Probamos de que obtenemos la edad esperada
    @Test
    void TestAge(){
        int obtainedResult = person1.age();
        int expectedResult = 13;
        assertEquals(expectedResult,obtainedResult);
    }

    //Probamos de que obtenemos el genero esperado
    @Test
    void TestGender(){
        String obtainedResult = person1.gender();
        String expectedResult = "Male";
        assertEquals(expectedResult,obtainedResult);
    }
}