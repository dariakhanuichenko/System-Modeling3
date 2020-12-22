import java.util.ArrayList;
import java.util.List;

public class Model {

    private ArrayList<Element> list;
    private double tnext, tcurr;
    private List<Integer> event;

    public Model(ArrayList<Element> elements) {
        list = elements;
        tcurr = tnext = 0.0;
        event = new ArrayList<>();
    }

    public void simulate(double time) {
        while (tcurr < time) {
            tnext = Double.MAX_VALUE;
            // initialize tnext for every process
            for (Element e : list) {
                if (e.getTnext() < tnext) {
                    tnext = e.getTnext();
                    event.add(e.getId());
                }
            }
            System.out.println("==================================================");
            event.forEach(e ->System.out.println("\nIt's time for event in " + list.get(e).getName() + ", time = " + tnext));
            System.out.println("--------------------------------------------------");
//            for (Element e : list) {
//                if (e instanceof Process) {
//                    var p = (Process) e;
//                    p.addLoadSum(p.getState() * (tnext - tcurr));
//                }
//                e.doStatistics(tnext - tcurr);
//            }

            // просунуть время
            tcurr = tnext;

            // обновить tcurr для всех процесов
            for (Element e : list) {
                e.setTcurr(tcurr);
            }
            // завершение event-ов на даной итерации
            event.forEach(e -> list.get(e).outAct());

            // завершение если время завршение равно..
            for (Element e : list) {
                if (e.getTnext() == tcurr) {
                    e.outAct();
                }
            }
//            printInfo();
            event.clear();
        }
        printResult();
    }

    public void printInfo() {
        for (Element e : list) {
            e.printInfo();
        }
    }

    public void printResult() {
        System.out.println("\n-------------RESULTS-------------");
        for (Element e : list) {
            e.printResult();
            if (e instanceof Process) {
                Process p = (Process) e;
                System.out.println("mean length of queue = " + p.getMeanQueue() / tcurr +                       //средняя длина очереди
                        "\nfailure probability = " + p.getFailure() / (double) p.getQuantity() +     // вероятность отказа
                        "\navg load = " + p.getLoadSum() / p.getTcurr() +                            // средняя загрузка устройства
                        "\nmax observed length of queue = " + p.getMaxObservedQueue());              // максимальная длина очереди
                System.out.println("-------------------------------\n");

            }
        }
    }
}
