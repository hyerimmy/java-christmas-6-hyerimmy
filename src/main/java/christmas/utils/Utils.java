package christmas.utils;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

import static christmas.constant.message.ExceptionMessage.NUMBER_FORMAT_EXCEPTION;


public class Utils {
    public static int readNumber(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println(NUMBER_FORMAT_EXCEPTION.getMessage());
            return readNumber();
        }
    }

    public static List<String> readStringList(){
        try{
            String inputString = Console.readLine();
            return List.of(inputString.split(","));
        } catch (NumberFormatException e){
            //TODO 예외처리 필요
            System.out.println(NUMBER_FORMAT_EXCEPTION);
            return readStringList();
        }
    }
}
