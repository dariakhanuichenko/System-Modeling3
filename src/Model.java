import java.util.ArrayList;

public class Model {

    private ArrayList<Element> list;
    private double tnext, tcurr;
    private int event;

    public Model(ArrayList<Element> elements) {
        list = elements;
        tcurr = tnext = 0.0;
    }

    public void simulate(double time) {
        while (tcurr < time) {
            tnext = Double.MAX_VALUE;

            // пошук найближчої події
            for (Element e : list) {
                if (e.getTnext() < tnext) {
                    tnext = e.getTnext();
                    event = e.getId();
                }
            }

//            System.out.println("==================================================");
            System.out.println("\nIt's time for event in " + list.get(event).getName() + ", time = " + tnext);
            System.out.println("--------------------------------------------------");

            // просунуть время
            tcurr = tnext;

            // обновить tcurr для всех процесов
            for (Element e : list) {
                e.setTcurr(tcurr);
            }
            // завершение event на даной итерации
            list.get(event).outAct();
            // завершение если время завршение равно..
            for (Element e : list) {
                if (e.getTnext() <= tcurr && e.getState() != 0) {
                    e.outAct();
                }
            }
        }
        printResult(time);
    }

    public void printResult(Double time) {
        System.out.println("\n-------------РЕЗУЛЬТАТИ-------------");
        for (Element e : list) {
            e.printResult();
            if (e instanceof Process) {
                Process p = (Process) e;

                if (p.getType().equals(ProcessType.CART_TT2))
                    System.out.println("Прибуток = " + p.getQuantity() * 1500);   // прибыль
                System.out.println("-------------------------------");

            }
        }
        System.out.println("Загальний прибуток: " + list.stream().filter(e -> e instanceof Process && ((Process) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum());

        System.out.println("Чистий прибуток: " +
                (list.stream().filter(e -> e instanceof Process && ((Process) e).getType().equals(ProcessType.CART_TT2)).mapToInt(e -> e.getQuantity() * 1500).sum() - // чистий прибуток
                list.stream().filter(e -> e instanceof Process &&(((Process) e).getType().equals(ProcessType.CART_TT2) || ((Process) e).getType().equals(ProcessType.CART_TT1)) ).count() * // кількість візків
                        time*2)); // помножети на час та на витрати за од. часу
    }
}
