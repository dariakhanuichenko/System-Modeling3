import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Create c = new Create(200);
        c.setName("CREATOR");
        c.setDistribution("exp");

        Process t1Cart1 = new Process(20,"norm", ProcessType.CART_TT1,1);
        t1Cart1.setName("Візок т1 1");
        t1Cart1.setMaxqueue(Integer.MAX_VALUE);
        c.setNextElement(t1Cart1);
        t1Cart1.setPreviousProcess(c);

        Process t1Cart2 = new Process(20, "norm", ProcessType.CART_TT1,2);
        t1Cart2.setName("Візок т1 2");
        t1Cart2.setMaxqueue(Integer.MAX_VALUE);
        c.setNextElement(t1Cart2);
        t1Cart2.setPreviousProcess(c);

        Process p2 = new Process(200,"norm", ProcessType.MACHINE,3);
        p2.setName("Верстат 1");
        p2.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.setNextElement(p2);
        t1Cart2.setNextElement(p2);
        p2.setPreviousProcess(t1Cart1);

        Process p3 = new Process(200, "norm", ProcessType.MACHINE,4);
        p3.setName("Верстат 2");
        p3.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.setNextElement(p3);
        t1Cart2.setNextElement(p3);
        p3.setPreviousProcess(t1Cart1);


        Process p4 = new Process(200, "norm", ProcessType.MACHINE,5);
        p4.setName("Верстат 3");
        p4.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.setNextElement(p4);
        t1Cart2.setNextElement(p4);
        p4.setPreviousProcess(t1Cart2);

        Process t2Cart1 = new Process(200, "norm", ProcessType.CART_TT2,6);
        t2Cart1.setName("Візок т2 1");
        t2Cart1.setMaxqueue(Integer.MAX_VALUE);
        p2.setNextElement(t2Cart1);
        p3.setNextElement(t2Cart1);
        p4.setNextElement(t2Cart1);
        t2Cart1.setNextElement(p2);

        Process t2Cart2 = new Process(200, "norm", ProcessType.CART_TT2,7);
        t2Cart2.setName("Візок т2 2");
        t2Cart2.setMaxqueue(Integer.MAX_VALUE);
        p2.setNextElement(t2Cart2);
        p3.setNextElement(t2Cart2);
        p4.setNextElement(t2Cart2);
        t2Cart2.setNextElement(p3);

        ArrayList<Element> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(t2Cart1);
        list.add(t2Cart2);

        Model model = new Model(list);
        model.simulate(1000.0);
    }
}
