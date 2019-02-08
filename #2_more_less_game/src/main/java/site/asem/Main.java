package site.asem;

public class Main {
    public static void main(String[] args) {
        Model model = new MoreLessGame(0, 100);
        View view = new View();
        Controller controller = new Controller(model, view);
        controller.start();
    }
}
