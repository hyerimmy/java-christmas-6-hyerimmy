package christmas.controller;

import christmas.model.Plan;
import christmas.view.InputView;
import christmas.view.OutputView;

import static christmas.exception.ExceptionHandler.printExceptionWithReEnterMessage;

public class EventController {
    private Plan plan;
    public EventController() {
    }

    public void run() {
        OutputView.printWelcomeMessage();
        createPlan();
    }

    private void createPlan() {
        InputView.printEnterDateOfVisit();
        setDateOfVisit();
        InputView.printEnterMenuAndNumberToOrder();
        setOrderList();
    }

    private void setDateOfVisit(){
        try{
            plan = new Plan(InputView.inputDateOfVisit());
        } catch (IllegalArgumentException e){
            printExceptionWithReEnterMessage(e.getMessage());
            setDateOfVisit();
        }
    }

    private void setOrderList(){
        try{
            plan.setOrderList(InputView.inputOrders());
        } catch (IllegalArgumentException e){
            printExceptionWithReEnterMessage(e.getMessage());
            setOrderList();
        }
    }
}
