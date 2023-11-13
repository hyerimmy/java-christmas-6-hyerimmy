package christmas.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.stream.Stream;

import static christmas.exception.ExceptionMessage.NULL_INPUT_EXCEPTION;
import static christmas.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;


public class Utils {
    public static int readNumber(){
        return parseInt(Console.readLine());
    }

    public static int parseInt(String string){
        try{
            return Integer.parseInt(string);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NUMBER_FORMAT_EXCEPTION.getMessage());
        }
    }

    public static List<String> readStringList(){
        String inputString = Console.readLine();
        List<String> stringList = Stream.of(inputString.split(","))
                .filter(s -> !s.isEmpty())
                .toList();

        if(stringList.size() == 0)
            throw new IllegalArgumentException(NULL_INPUT_EXCEPTION.getMessage());
        return stringList;
    }
}
