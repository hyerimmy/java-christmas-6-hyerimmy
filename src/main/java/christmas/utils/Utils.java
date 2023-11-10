package christmas.utils;

import camp.nextstep.edu.missionutils.Console;
import christmas.constant.message.ExceptionMessage;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Utils {
    public static int readNumber(){
        try{
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e){
            System.out.println(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
            return readNumber();
        }
    }

    public static List<String> readStringList(){
        try{
            String inputString = Console.readLine();
            return List.of(inputString.split(","));
        } catch (NumberFormatException e){
            //TODO 예외처리 필요
            System.out.println(ExceptionMessage.NUMBER_FORMAT_EXCEPTION);
            return readStringList();
        }
    }
}
