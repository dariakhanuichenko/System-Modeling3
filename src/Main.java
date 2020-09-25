import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Create c = new Create(2);
        c.setName("CREATOR");
        c.setDistribution("exp");

        Process p1 = new Process(1);
        p1.setName("PROCESSOR 1");
        p1.setMaxqueue(5);

        Process p2 = new Process(2);
        p2.setName("PROCESSOR 2");
        p2.setMaxqueue(5);
        p1.setNextElement(p2);

        Process p3 = new Process(5);
        p3.setName("PROCESSOR 3");
        p3.setMaxqueue(5);
        p1.setNextElement(p3);

        Process p4 = new Process(5);
        p4.setName("PROCESSOR 4");
        p4.setMaxqueue(5);
        p3.setNextElement(p4);

//        Process p5 = new Process(5);
//        p5.setName("PROCESSOR 5");
//        p5.setMaxqueue(3);
//        p4.setNextElement(p5);

        c.setNextElement(p1);

        ArrayList<Element> list = new ArrayList<>();
        list.add(c);
        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
//        list.add(p5);

        Model model = new Model(list);
        model.simulate(1000.0);
    }
}
