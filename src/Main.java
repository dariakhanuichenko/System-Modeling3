import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Create c = new Create(1.0/22);
        c.setDistribution("puasson");

        Process t1Cart1 = new Process("Візок TT1 1", ProcessType.CART_TT1,1, c, 1);
        t1Cart1.setMaxqueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Process t1Cart2 = new Process("Візок TT1 2", ProcessType.CART_TT1,2, c,2);
        t1Cart2.setMaxqueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Process machine1 = new Process(200,"Верстат 1","norm", ProcessType.MACHINE,3, t1Cart1, 1);
        machine1.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);

        Process machine2 = new Process(200, "Верстат 2","norm", ProcessType.MACHINE,4, t1Cart1, 2);
        machine2.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);


        Process machine3 = new Process(200, "Верстат 3","norm", ProcessType.MACHINE,5, t1Cart2, 3);
        machine3.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Process t2Cart1 = new Process( "Візок TT2 1", ProcessType.CART_TT2,6, machine1, 1);
        t2Cart1.setMaxqueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart1);
        machine2.addNextElement(t2Cart1);
        machine3.addNextElement(t2Cart1);

        Process t2Cart2 = new Process("Візок TT2 2", ProcessType.CART_TT2,7, machine2, 2);
        t2Cart2.setMaxqueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart2);
        machine2.addNextElement(t2Cart2);
        machine3.addNextElement(t2Cart2);

        ArrayList<Element> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(machine1);
        list.add(machine2);
        list.add(machine3);
        list.add(t2Cart1);
        list.add(t2Cart2);

        Model model = new Model(list);
        model.simulate(1000.0);
    }
}
