package by.it.kharevich.calculator;

import by.it.kharevich.calculator.controllers.MainController;
import by.it.kharevich.calculator.model.Var;
import by.it.kharevich.calculator.services.CalcService;
import by.it.kharevich.calculator.view.Printer;

import java.util.Scanner;

public class Application {

    public static final String END = "end";
    private final Printer printer;
    private final CalcService calcService;
    private final MainController mainController;

    public Application(Printer printer, CalcService calcService, MainController mainController) {
        this.printer = printer;
        this.calcService = calcService;
        this.mainController = mainController;
    }

    public void run() {
        System.out.println("App started");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String line = scanner.nextLine();
            if (!line.equals(END)) {
                try {
                    Var processResult = mainController.processCalcService(line);
                    printer.print(processResult);
                } catch (ArithmeticException e) {
                    printer.print(e);
                }
            } else {
                System.out.println("App finished");
                break;
            }
        }
    }
}
