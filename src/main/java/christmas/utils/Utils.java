package christmas.utils;

import camp.nextstep.edu.missionutils.Console;
import christmas.exception.ExceptionHandler;

import java.util.List;

import static christmas.exception.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;


public class Utils {
    public static int readNumber(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            ExceptionHandler.printExceptionWithReEnterMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
            return readNumber();
        }
    }

    public static List<String> readStringList(){
        try{
            String inputString = Console.readLine();
            return List.of(inputString.split(","));
        } catch (NumberFormatException e){
            //TODO 예외처리 필요
            ExceptionHandler.printExceptionWithReEnterMessage(NUMBER_FORMAT_EXCEPTION.getMessage());
            return readStringList();
        }
    }
}
