package site.asem;

import java.util.Scanner;

public class Controller {
    // TODO refactor - a few lines below is too long
    private static final String REQUEST_FOR_MOVE_MESSAGE = "Input your move: ";
    private static final String IS_NOT_INTEGER_MESSAGE = "It's not a number!";
    private static final String CURRENT_RANGE_PATTERN = "Current range: [%d;%d]";
    private static final String ERROR_OUT_OF_RANGE_PATTERN = "Sorry, wrong input."
            + "An integer from range [%d;%d] should be entered."
            + "Please try again.";
    private static final String CONGRATULATIONS_MESSAGE = "Congratulations!"
            + "You win!";

    private Model model;
    private View view;
    private Scanner scanner = new Scanner(System.in);

    public Controller(Model model, View view) {
        this.model = model;
        this.view = view;
    }

    public void start() {
        Model.GameMoveOutcome moveOutcome = null;
        while (moveOutcome != Model.GameMoveOutcome.WIN) {
            view.println(getCurrentRangeMessage());
            int move = getUsersMove();
            try {
                moveOutcome = model.makeMove(move);
            } catch (OutOfRangeException e) {
                String errMsg = String.format(ERROR_OUT_OF_RANGE_PATTERN,
                        model.getMinValue(),
                        model.getMaxValue());
                view.println(errMsg);
                continue;
            }
            // TODO print more/less here
        }
        view.println(CONGRATULATIONS_MESSAGE);
        // TODO print statistics here
    }

    private int getUsersMove() {
        while (true) {
            view.print(REQUEST_FOR_MOVE_MESSAGE);
            String response = scanner.next();
            int move;
            try {
                move = Integer.parseInt(response);
            } catch (NumberFormatException e) {
                view.println(IS_NOT_INTEGER_MESSAGE);
                continue;
            }
            return move;
        }
    }

    private String getCurrentRangeMessage() {
        return String.format(CURRENT_RANGE_PATTERN,
                model.getMinValue(),
                model.getMaxValue());
    }
}
