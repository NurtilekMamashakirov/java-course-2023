package edu.hw3.Task5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import java.util.ArrayList;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class Task5Test {

    static Arguments[] exampleAndExpected() {
        return new Arguments[] {
            Arguments.of(
                List.of("John Locke", "Thomas Aquinas", "David Hume", "Rene Descartes"), "ASC",
                List.of(new Contact("Aquinas", "Thomas"), new Contact("Descartes", "Rene"),
                    new Contact("Hume", "David"), new Contact("Locke", "John")
                )
            ),
            Arguments.of(
                List.of("Paul Erdos", "Leonhard Euler", "Carl Gauss"), "DESC",
                List.of(new Contact("Gauss", "Carl"), new Contact("Euler", "Leonhard"),
                    new Contact("Erdos", "Paul"))
            ),
            Arguments.of(new ArrayList<String>(), "DESC", new ArrayList<Contact>()),
            Arguments.of(null, "DESC", new ArrayList<Contact>())
        };
    }

    @ParameterizedTest
    @MethodSource("exampleAndExpected")
    void parseContacts(List<String> example, String progressOrRegress, List<Contact> expected) {
        Task5 task5 = new Task5();
        assertThat(task5.parseContact(example, progressOrRegress)).isEqualTo(expected);
    }

}
