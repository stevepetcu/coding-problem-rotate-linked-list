package com.stefanpetcu.rotatelinkedlist.utils;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;

class ListUtilsTest {

    static private Stream<Arguments> listRotationTestDataProvider() {
        return Stream.of(
                arguments(new LinkedList<Integer>(List.of()), 2, new LinkedList<Integer>(List.of()), "Rotating an empty list returns the empty list."),
                arguments(new LinkedList<>(Arrays.asList(1, 2, 3)), -1, new LinkedList<>(Arrays.asList(1, 2, 3)), "Rotating a list by a negative place ordinal returns the list."),
                arguments(new LinkedList<>(Arrays.asList(1, 2, 3)), 0, new LinkedList<>(Arrays.asList(1, 2, 3)), "Rotating a list by 0 places returns the list.")
//                arguments(new LinkedList<>(Arrays.asList(7, 7, 3, 5)), 2, new LinkedList<>(Arrays.asList(3, 5, 7, 7)), "Rotating the list by 2 places."),
//                arguments(new LinkedList<>(Arrays.asList(1, 2, 3, 4, 5)), 3, new LinkedList<>(Arrays.asList(3, 4, 5, 1, 2)), "Rotating the list by 3 places.")
        );
    }

    @ParameterizedTest
    @MethodSource("listRotationTestDataProvider")
    void testRotateLikedListByReturnsExpectedResults(LinkedList<Integer> inputList, Integer inputPlaces,
                                                     LinkedList<Integer> expectedOutputList, String message) {

        ListUtils.rotateLikedListBy(inputList, inputPlaces);

        assertEquals(expectedOutputList, inputList, message);
    }
}
