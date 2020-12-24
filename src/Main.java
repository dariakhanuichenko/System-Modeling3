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


        Process machine3 = new Process(200, "Верстат 3","norm", ProcessType.MACHINE,5, t1Cart1, 3);
        machine3.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Process machine4 = new Process(200, "Верстат 4","norm", ProcessType.MACHINE,6, t1Cart1, 4);
        machine4.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);

        Process machine5 = new Process(200, "Верстат 5","norm", ProcessType.MACHINE,7, t1Cart1, 5);
        machine5.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);

        Process machine6 = new Process(200, "Верстат 6","norm", ProcessType.MACHINE,8, t1Cart2, 6);
        machine6.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);

        Process machine7 = new Process(200, "Верстат 7","norm", ProcessType.MACHINE,9, t1Cart2, 7);
        machine7.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);

        Process machine8 = new Process(200, "Верстат 8","norm", ProcessType.MACHINE,10, t1Cart2, 8);
        machine8.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);

        Process machine9 = new Process(200, "Верстат 9","norm", ProcessType.MACHINE,11, t1Cart2, 9);
        machine9.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);

        Process machine10 = new Process(200, "Верстат 10","norm", ProcessType.MACHINE,12, t1Cart2, 10);
        machine10.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);

        Process t2Cart1 = new Process( "Візок TT2 1", ProcessType.CART_TT2,13, machine1, 1);
        t2Cart1.setMaxqueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart1);
        machine2.addNextElement(t2Cart1);
        machine3.addNextElement(t2Cart1);
        machine4.addNextElement(t2Cart1);
        machine5.addNextElement(t2Cart1);
        machine6.addNextElement(t2Cart1);
        machine7.addNextElement(t2Cart1);
        machine8.addNextElement(t2Cart1);
        machine9.addNextElement(t2Cart1);
        machine10.addNextElement(t2Cart1);

        Process t2Cart2 = new Process("Візок TT2 2", ProcessType.CART_TT2,14, machine2, 2);
        t2Cart2.setMaxqueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart2);
        machine2.addNextElement(t2Cart2);
        machine3.addNextElement(t2Cart2);
        machine4.addNextElement(t2Cart2);
        machine5.addNextElement(t2Cart2);
        machine6.addNextElement(t2Cart2);
        machine7.addNextElement(t2Cart2);
        machine8.addNextElement(t2Cart2);
        machine9.addNextElement(t2Cart2);
        machine10.addNextElement(t2Cart2);

        ArrayList<Element> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(machine1);
        list.add(machine2);
        list.add(machine3);
        list.add(machine4);
        list.add(machine5);
        list.add(machine6);
        list.add(machine7);
        list.add(machine8);
        list.add(machine9);
        list.add(machine10);
        list.add(t2Cart1);
        list.add(t2Cart2);

        Model model = new Model(list);
        model.simulate(10000.0);
    }
}
