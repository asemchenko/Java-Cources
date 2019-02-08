/*
 * Author: Andrii Semchenko
 * Created at Feb 2019
 */
package site.asem;

public class Main {
    public static void main(String[] args) {
        View view = new View();
        Model model = new Model();
        Controller controller = new Controller(model, view);
        controller.processUser();
    }
}
