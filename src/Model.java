import java.util.ArrayList;

public class Model {

    private ArrayList<BaseElement> list;
    private double tnext, tcurr;
    private int event;

    public Model(ArrayList<BaseElement> elements) {
        list = elements;
        tcurr = tnext = 0.0;
    }

    public void simulateWithPrintResultForEveryElement(double time, boolean showAllSteps) {
        this.simulateGeneral(time, showAllSteps);
        printResultForEveryElement(time);

    }
    public void simulateWithPrintAvgLoad(double time) {
        this.simulateGeneral(time, false);
        printResultWithAvgLoad(time);
    }
    public void simulateWithPrintOnlyMoney(double time) {
        this.simulateGeneral(time, false);
        printOnlyMoney(time);
    }

    public void simulateGeneral(double time, boolean showAllSteps) {
        while (tcurr < time) {
            tnext = Double.MAX_VALUE;

            // пошук найближчої події
            for (BaseElement e : list) {
                if (e.gettNext() < tnext) {
                    tnext = e.gettNext();
                    event = e.getId();
                }
            }
            if (showAllSteps) {
                System.out.println("==================================================");
                System.out.println("\nIt's time for event in " + list.get(event).getName() + ", time = " + tnext);
                System.out.println("--------------------------------------------------");
            }

            for (BaseElement e : list) {
                if (e instanceof Processor) {
                    Processor p = (Processor) e;
                    p.addLoadSum(p.getState() * (tnext - tcurr));
                }
                e.doStatistics(tnext - tcurr);
            }
            // просунуть время
            tcurr = tnext;

            // обновить tcurr для всех процесов
            for (BaseElement e : list) {
                e.settCurr(tcurr);
            }
            // завершение event на даной итерации
            list.get(event).outAct();
            // завершение если время завршение равно..
            for (BaseElement e : list) {
                if (e.gettNext() <= tcurr && e.getState() != 0) {
                    e.outAct();
                }
            }
        }
//        printResult(time);
    }

    public void printResultWithAvgLoad(Double time) {
        System.out.println("\n-------------РЕЗУЛЬТАТИ-------------");
        System.out.println("TIME = " + time + ";");
        for (BaseElement e : list) {
//            e.printResult();
            if (e instanceof Processor) {
                Processor p = (Processor) e;
                System.out.println("name = " + p.getName() +
                        " | avg load = " + p.getLoadSum() / p.gettCurr());                           // средняя загрузка устройства
                System.out.println("-------------------------------");
            }
        }
    }

    public void printResultForEveryElement(Double time) {
        System.out.println("\n-------------РЕЗУЛЬТАТИ-------------");
        for (BaseElement e : list) {
            e.printResult();
            if (e instanceof Processor) {
                Processor p = (Processor) e;
                System.out.print(
                        " | quantity = " + p.getQuantity() );                           // средняя загрузка устройства
                if (p.getType().equals(ProcessType.CART_TT2))
                    System.out.print("   |    Прибуток = " + p.getQuantity() * 1500);   // прибыль
                System.out.println("\n-------------------------------");

            }
        }

        System.out.print("Загальний прибуток: " + list.stream().filter(e -> e instanceof Processor && ((Processor) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum());

        System.out.print("  |   Чистий прибуток: " +
                (list.stream().filter(e -> e instanceof Processor && ((Processor) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum() - // чистий прибуток
                        list.stream().filter(e -> e instanceof Processor && (((Processor) e).getType().equals(ProcessType.CART_TT2) || ((Processor) e).getType().equals(ProcessType.CART_TT1))).count() * // кількість візків
                                time * 2)); // помножети на час та на витрати за од. часу
    }

    public void printOnlyMoney(Double time) {
        System.out.print("  Загальний прибуток: " + list.stream().filter(e -> e instanceof Processor && ((Processor) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum());

        System.out.print("  |   Чистий прибуток: " +
                (list.stream().filter(e -> e instanceof Processor && ((Processor) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum() - // чистий прибуток
                        list.stream().filter(e -> e instanceof Processor && (((Processor) e).getType().equals(ProcessType.CART_TT2) || ((Processor) e).getType().equals(ProcessType.CART_TT1))).count() * // кількість візків
                                time * 2)); // помножети на час та на витрати за од. часу
    }
}
