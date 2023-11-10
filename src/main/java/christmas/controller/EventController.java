package christmas.controller;

import christmas.view.InputView;
import christmas.view.OutputView;

public class EventController {
    public EventController() {
    }

    public void run() {
        OutputView.printWelcomeMessage();
        takeReservation();
    }

    private void takeReservation() {
        InputView.inputReservationDate();
        InputView.inputMenus();
    }
}
