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

            // установить tnext для каждого елемента схемы
            for (Element e : list) {
                if (e.getTnext() < tnext) {
                    tnext = e.getTnext();
                    event.add(e.getId());
                }
            }

            System.out.println("==================================================");
            event.forEach(e -> System.out.println("\nIt's time for event in " + list.get(e).getName() + ", time = " + tnext));
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
                if (e.getTnext() == tcurr && e.getState() != 0) {
                    e.outAct();
                }
            }
            event.clear();
        }
        printResult();
    }

    public void printResult() {
        System.out.println("\n-------------РЕЗУЛЬТАТИ-------------");
        for (Element e : list) {
            e.printResult();
            if (e instanceof Process) {
                Process p = (Process) e;

                if (p.getType().equals(ProcessType.CART_TT2))
                    System.out.println("Прибуток = " + p.getQuantity() * 1500);   // прибыль
                System.out.println("-------------------------------\n");

            }
        }
        System.out.println("Загальний прибуток: " + list.stream().filter(e -> e instanceof Process && ((Process)e).getType().equals(ProcessType.CART_TT2)).mapToInt(e-> e.getQuantity()*1500).sum());
    }
}
