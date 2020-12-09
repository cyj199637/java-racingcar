package com.jaenyeong.mission2.racingcar.view;

import java.util.Arrays;
import java.util.List;

public interface Input {
    int CAN_NOT_READ = -1;
    String SEPARATOR = ",";

    int inputHowManyUseCars();

    int inputHowManyTryTimes();

    List<String> inputNamesOfTheCarsToBeRaced();

    default List<String> separateInputBySeparator(String input) {
        return Arrays.asList(input.split(SEPARATOR));
    }
}