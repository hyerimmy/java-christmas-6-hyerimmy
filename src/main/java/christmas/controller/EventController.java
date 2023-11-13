package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public EventController() {
    }

    public void run() {
        OutputView.printWelcomeMessage();
        takeOrder();
    }

    private void takeOrder() {
        InputView.takeDateOfVisit();
        InputView.takeMenus();
    }
}
