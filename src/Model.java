import java.util.ArrayList;

public class Model {

    private ArrayList<Element> list;
    private double tnext, tcurr;
    private int event;

    public Model(ArrayList<Element> elements) {
        list = elements;
        tcurr = tnext = 0.0;
        event = 0;
    }

    public void simulate(double time) {
        while (tcurr < time) {
            tnext = Double.MAX_VALUE;
            for (Element e : list) {
                if (e.getTnext() < tnext) {
                    tnext = e.getTnext();
                    event = e.getId();
                }
            }
            System.out.println("\nIt's time for event in " + list.get(event).getName() + ", time = " + tnext);

            for (Element e : list) {
                if (e instanceof Process) {
                    var p = (Process) e;
                    p.addLoadSum(p.getState() * (tnext - tcurr));
                }
                e.doStatistics(tnext - tcurr);
            }
            tcurr = tnext;
            for (Element e : list) {
                e.setTcurr(tcurr);
            }
            list.get(event).outAct();
            for (Element e : list) {
                if (e.getTnext() == tcurr) {
                    e.outAct();
                }
            }
//            printInfo();
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