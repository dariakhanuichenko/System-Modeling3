import java.util.ArrayList;

public class Verification {

    public void createModel1(int time) {

        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1 1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1 2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor machine1 = new Processor(200, "Верстат 1", Distribution.NORM, ProcessType.MACHINE, 3, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат 2", Distribution.NORM, ProcessType.MACHINE, 4, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат 3", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Processor machine4 = new Processor(200, "Верстат 4", Distribution.NORM, ProcessType.MACHINE, 6, t1Cart1, 4);
        machine4.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);

        Processor machine5 = new Processor(200, "Верстат 5", Distribution.NORM, ProcessType.MACHINE, 7, t1Cart1, 5);
        machine5.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);

        Processor machine6 = new Processor(200, "Верстат 6", Distribution.NORM, ProcessType.MACHINE, 8, t1Cart2, 6);
        machine6.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);

        Processor machine7 = new Processor(200, "Верстат 7", Distribution.NORM, ProcessType.MACHINE, 9, t1Cart2, 7);
        machine7.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);

        Processor machine8 = new Processor(200, "Верстат 8", Distribution.NORM, ProcessType.MACHINE, 10, t1Cart2, 8);
        machine8.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);

        Processor machine9 = new Processor(200, "Верстат 9", Distribution.NORM, ProcessType.MACHINE, 11, t1Cart2, 9);
        machine9.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);

        Processor machine10 = new Processor(200, "Верстат 10", Distribution.NORM, ProcessType.MACHINE, 12, t1Cart2, 10);
        machine10.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);

        Processor t2Cart1 = new Processor("Візок TT2 1", ProcessType.CART_TT2, 13, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);
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

        Processor t2Cart2 = new Processor("Візок TT2 2", ProcessType.CART_TT2, 14, machine2, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);
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

        ArrayList<BaseElement> list = new ArrayList<>();
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
        model.simulateWithPrintResultForEveryElement(time, true);
        System.out.println();
    }

    /**Для прогонів з середною завантаженістю пристоїв
     * TT1 - 2
     * TT2 - 2
     *  Machines - 10*/
    public void createModelWithAvgLoad(int time) {

        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1 1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1 2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor machine1 = new Processor(200, "Верстат 1", Distribution.NORM, ProcessType.MACHINE, 3, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат 2", Distribution.NORM, ProcessType.MACHINE, 4, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат 3", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Processor machine4 = new Processor(200, "Верстат 4", Distribution.NORM, ProcessType.MACHINE, 6, t1Cart1, 4);
        machine4.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);

        Processor machine5 = new Processor(200, "Верстат 5", Distribution.NORM, ProcessType.MACHINE, 7, t1Cart1, 5);
        machine5.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);

        Processor machine6 = new Processor(200, "Верстат 6", Distribution.NORM, ProcessType.MACHINE, 8, t1Cart2, 6);
        machine6.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);

        Processor machine7 = new Processor(200, "Верстат 7", Distribution.NORM, ProcessType.MACHINE, 9, t1Cart2, 7);
        machine7.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);

        Processor machine8 = new Processor(200, "Верстат 8", Distribution.NORM, ProcessType.MACHINE, 10, t1Cart2, 8);
        machine8.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);

        Processor machine9 = new Processor(200, "Верстат 9", Distribution.NORM, ProcessType.MACHINE, 11, t1Cart2, 9);
        machine9.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);

        Processor machine10 = new Processor(200, "Верстат 10", Distribution.NORM, ProcessType.MACHINE, 12, t1Cart2, 10);
        machine10.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);

        Processor t2Cart1 = new Processor("Візок TT2 1", ProcessType.CART_TT2, 13, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);
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

        Processor t2Cart2 = new Processor("Візок TT2 2", ProcessType.CART_TT2, 14, machine2, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);
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

        ArrayList<BaseElement> list = new ArrayList<>();
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
        model.simulateWithPrintAvgLoad(time);
        System.out.println();
    }
    /**
     * TT1 - 2
     * TT2 - 2
     * Machines - 3
     * */
    public void createModelP(int time) {


        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1 1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1 2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor machine1 = new Processor(200, "Верстат 1", Distribution.NORM, ProcessType.MACHINE, 3, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат 2", Distribution.NORM, ProcessType.MACHINE, 4, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат 3", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Processor t2Cart1 = new Processor("Візок TT2 1", ProcessType.CART_TT2, 6, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart1);
        machine2.addNextElement(t2Cart1);
        machine3.addNextElement(t2Cart1);


        Processor t2Cart2 = new Processor("Візок TT2 2", ProcessType.CART_TT2, 7, machine2, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart2);
        machine2.addNextElement(t2Cart2);
        machine3.addNextElement(t2Cart2);

        ArrayList<BaseElement> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(machine1);
        list.add(machine2);
        list.add(machine3);

        list.add(t2Cart1);
        list.add(t2Cart2);

        Model model = new Model(list);
        model.simulateWithPrintOnlyMoney(time);
        System.out.println();
    }

    /** Для експериментів
     * TT1 - 4
     * TT2 - 4
     * Machines - 12
     * */
    public void createModel2() {

        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1_1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1_2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor t1Cart3 = new Processor("Візок_TT1_3", ProcessType.CART_TT1, 3, c, 3);
        t1Cart3.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart3);

        Processor t1Cart4 = new Processor("Візок_TT1_4 ", ProcessType.CART_TT1, 4, c, 4);
        t1Cart4.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart4);

        Processor machine1 = new Processor(200, "Верстат_1", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);
        t1Cart3.addNextElement(machine1);
        t1Cart4.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат_2", Distribution.NORM, ProcessType.MACHINE, 6, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);
        t1Cart3.addNextElement(machine2);
        t1Cart4.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат_3", Distribution.NORM, ProcessType.MACHINE, 7, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);
        t1Cart3.addNextElement(machine3);
        t1Cart4.addNextElement(machine3);

        Processor machine4 = new Processor(200, "Верстат_4", Distribution.NORM, ProcessType.MACHINE, 8, t1Cart1, 4);
        machine4.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);
        t1Cart3.addNextElement(machine4);
        t1Cart4.addNextElement(machine4);

        Processor machine5 = new Processor(200, "Верстат_5", Distribution.NORM, ProcessType.MACHINE, 9, t1Cart1, 5);
        machine5.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);
        t1Cart3.addNextElement(machine5);
        t1Cart4.addNextElement(machine5);

        Processor machine6 = new Processor(200, "Верстат_6", Distribution.NORM, ProcessType.MACHINE, 10, t1Cart1, 6);
        machine6.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);
        t1Cart3.addNextElement(machine6);
        t1Cart4.addNextElement(machine6);

        Processor machine7 = new Processor(200, "Верстат_7", Distribution.NORM, ProcessType.MACHINE, 11, t1Cart2, 7);
        machine7.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);
        t1Cart3.addNextElement(machine7);
        t1Cart4.addNextElement(machine7);

        Processor machine8 = new Processor(200, "Верстат_8", Distribution.NORM, ProcessType.MACHINE, 12, t1Cart2, 8);
        machine8.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);
        t1Cart3.addNextElement(machine8);
        t1Cart4.addNextElement(machine8);

        Processor machine9 = new Processor(200, "Верстат_9", Distribution.NORM, ProcessType.MACHINE, 13, t1Cart2, 9);
        machine9.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);
        t1Cart3.addNextElement(machine9);
        t1Cart4.addNextElement(machine9);

        Processor machine10 = new Processor(200, "Верстат_10", Distribution.NORM, ProcessType.MACHINE, 14, t1Cart2, 10);
        machine10.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);
        t1Cart3.addNextElement(machine10);
        t1Cart4.addNextElement(machine10);

        Processor machine11 = new Processor(200, "Верстат_11", Distribution.NORM, ProcessType.MACHINE, 15, t1Cart2, 11);
        machine11.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine11);
        t1Cart2.addNextElement(machine11);
        t1Cart3.addNextElement(machine11);
        t1Cart4.addNextElement(machine11);

        Processor machine12 = new Processor(200, "Верстат_12", Distribution.NORM, ProcessType.MACHINE, 16, t1Cart2, 12);
        machine12.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine12);
        t1Cart2.addNextElement(machine12);
        t1Cart3.addNextElement(machine12);
        t1Cart4.addNextElement(machine12);

        Processor t2Cart1 = new Processor("Візок_TT2 _1", ProcessType.CART_TT2, 17, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);

        machine9.addNextElement(t2Cart1);
        machine10.addNextElement(t2Cart1);
        machine11.addNextElement(t2Cart1);
        machine12.addNextElement(t2Cart1);

        Processor t2Cart2 = new Processor("Візок_TT2 _2", ProcessType.CART_TT2, 18, machine2, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);

        machine6.addNextElement(t2Cart2);
        machine7.addNextElement(t2Cart2);
        machine8.addNextElement(t2Cart2);
        machine9.addNextElement(t2Cart2);


        Processor t2Cart3 = new Processor("Візок_TT2 _3", ProcessType.CART_TT2, 18, machine2, 3);
        t2Cart3.setMaxQueue(Integer.MAX_VALUE);

        machine3.addNextElement(t2Cart3);
        machine4.addNextElement(t2Cart3);
        machine5.addNextElement(t2Cart3);


        Processor t2Cart4 = new Processor("Візок_TT2 _4", ProcessType.CART_TT2, 19, machine2, 4);
        t2Cart4.setMaxQueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart4);
        machine2.addNextElement(t2Cart4);
        machine3.addNextElement(t2Cart4);
        machine4.addNextElement(t2Cart4);


        ArrayList<BaseElement> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(t1Cart3);
        list.add(t1Cart4);
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
        list.add(machine11);
        list.add(machine12);
        list.add(t2Cart1);
        list.add(t2Cart2);
        list.add(t2Cart3);
        list.add(t2Cart4);

        Model model = new Model(list);
        model.simulateWithPrintOnlyMoney(1000.0);
    }

    /**
     * TT1 -2
     * TT2 - 2
     * Machines - 10
     */
    public void createModelWith2CartsTT1And2CartsTT2(int time) {

        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1 1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1 2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor machine1 = new Processor(200, "Верстат 1", Distribution.NORM, ProcessType.MACHINE, 3, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат 2", Distribution.NORM, ProcessType.MACHINE, 4, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат 3", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);

        Processor machine4 = new Processor(200, "Верстат 4", Distribution.NORM, ProcessType.MACHINE, 6, t1Cart1, 4);
        machine4.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);

        Processor machine5 = new Processor(200, "Верстат 5", Distribution.NORM, ProcessType.MACHINE, 7, t1Cart1, 5);
        machine5.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);

        Processor machine6 = new Processor(200, "Верстат 6", Distribution.NORM, ProcessType.MACHINE, 8, t1Cart2, 6);
        machine6.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);

        Processor machine7 = new Processor(200, "Верстат 7", Distribution.NORM, ProcessType.MACHINE, 9, t1Cart2, 7);
        machine7.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);

        Processor machine8 = new Processor(200, "Верстат 8", Distribution.NORM, ProcessType.MACHINE, 10, t1Cart2, 8);
        machine8.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);

        Processor machine9 = new Processor(200, "Верстат 9", Distribution.NORM, ProcessType.MACHINE, 11, t1Cart2, 9);
        machine9.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);

        Processor machine10 = new Processor(200, "Верстат 10", Distribution.NORM, ProcessType.MACHINE, 12, t1Cart2, 10);
        machine10.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);

        Processor t2Cart1 = new Processor("Візок TT2 1", ProcessType.CART_TT2, 13, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);
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

        Processor t2Cart2 = new Processor("Візок TT2 2", ProcessType.CART_TT2, 14, machine2, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);
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

        ArrayList<BaseElement> list = new ArrayList<>();
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
        model.simulateWithPrintOnlyMoney(time);
        System.out.println();
    }
    /**
     * TT1 -4
     * TT2 - 4
     * Machines - 10
     */
    public void createModelWith4CartsTT1And4CartsTT2(int time) {

        Creator c = new Creator(1.0 / 22);
        c.setDistribution(Distribution.PUASSON);

        Processor t1Cart1 = new Processor("Візок_TT1 1", ProcessType.CART_TT1, 1, c, 1);
        t1Cart1.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Processor t1Cart2 = new Processor("Візок_TT1 2", ProcessType.CART_TT1, 2, c, 2);
        t1Cart2.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Processor t1Cart3 = new Processor("Візок_TT1 3", ProcessType.CART_TT1, 3, c, 3);
        t1Cart3.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart3);

        Processor t1Cart4 = new Processor("Візок_TT1 4", ProcessType.CART_TT1, 4, c, 4);
        t1Cart4.setMaxQueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart4);

        Processor machine1 = new Processor(200, "Верстат 1", Distribution.NORM, ProcessType.MACHINE, 5, t1Cart1, 1);
        machine1.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);
        t1Cart3.addNextElement(machine1);
        t1Cart4.addNextElement(machine1);

        Processor machine2 = new Processor(200, "Верстат 2", Distribution.NORM, ProcessType.MACHINE, 6, t1Cart1, 2);
        machine2.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);
        t1Cart3.addNextElement(machine2);
        t1Cart4.addNextElement(machine2);


        Processor machine3 = new Processor(200, "Верстат 3", Distribution.NORM, ProcessType.MACHINE, 7, t1Cart1, 3);
        machine3.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);
        t1Cart3.addNextElement(machine3);
        t1Cart4.addNextElement(machine3);

        Processor machine4 = new Processor(200, "Верстат 4", Distribution.NORM, ProcessType.MACHINE, 8, t1Cart1, 4);
        machine4.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);
        t1Cart3.addNextElement(machine4);
        t1Cart4.addNextElement(machine4);

        Processor machine5 = new Processor(200, "Верстат 5", Distribution.NORM, ProcessType.MACHINE, 9, t1Cart1, 5);
        machine5.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);
        t1Cart3.addNextElement(machine5);
        t1Cart4.addNextElement(machine5);

        Processor machine6 = new Processor(200, "Верстат 6", Distribution.NORM, ProcessType.MACHINE, 10, t1Cart2, 6);
        machine6.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);
        t1Cart3.addNextElement(machine6);
        t1Cart4.addNextElement(machine6);

        Processor machine7 = new Processor(200, "Верстат 7", Distribution.NORM, ProcessType.MACHINE, 11, t1Cart2, 7);
        machine7.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);
        t1Cart3.addNextElement(machine7);
        t1Cart4.addNextElement(machine7);

        Processor machine8 = new Processor(200, "Верстат 8", Distribution.NORM, ProcessType.MACHINE, 12, t1Cart2, 8);
        machine8.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);
        t1Cart3.addNextElement(machine8);
        t1Cart4.addNextElement(machine8);

        Processor machine9 = new Processor(200, "Верстат 9", Distribution.NORM, ProcessType.MACHINE, 13, t1Cart2, 9);
        machine9.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);
        t1Cart3.addNextElement(machine9);
        t1Cart4.addNextElement(machine9);

        Processor machine10 = new Processor(200, "Верстат 10", Distribution.NORM, ProcessType.MACHINE, 14, t1Cart2, 10);
        machine10.setMaxQueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);
        t1Cart3.addNextElement(machine10);
        t1Cart4.addNextElement(machine10);

        Processor t2Cart1 = new Processor("Візок TT2 1", ProcessType.CART_TT2, 15, machine1, 1);
        t2Cart1.setMaxQueue(Integer.MAX_VALUE);
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

        Processor t2Cart2 = new Processor("Візок TT2 2", ProcessType.CART_TT2, 16, machine1, 2);
        t2Cart2.setMaxQueue(Integer.MAX_VALUE);
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

        Processor t2Cart3 = new Processor("Візок TT2 3", ProcessType.CART_TT2, 17, machine2, 3);
        t2Cart3.setMaxQueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart3);
        machine2.addNextElement(t2Cart3);
        machine3.addNextElement(t2Cart3);
        machine4.addNextElement(t2Cart3);
        machine5.addNextElement(t2Cart3);
        machine6.addNextElement(t2Cart3);
        machine7.addNextElement(t2Cart3);
        machine8.addNextElement(t2Cart3);
        machine9.addNextElement(t2Cart3);
        machine10.addNextElement(t2Cart3);

        Processor t2Cart4 = new Processor("Візок TT2 4", ProcessType.CART_TT2, 18, machine2, 4);
        t2Cart4.setMaxQueue(Integer.MAX_VALUE);
        machine1.addNextElement(t2Cart4);
        machine2.addNextElement(t2Cart4);
        machine3.addNextElement(t2Cart4);
        machine4.addNextElement(t2Cart4);
        machine5.addNextElement(t2Cart4);
        machine6.addNextElement(t2Cart4);
        machine7.addNextElement(t2Cart4);
        machine8.addNextElement(t2Cart4);
        machine9.addNextElement(t2Cart4);
        machine10.addNextElement(t2Cart4);

        ArrayList<BaseElement> list = new ArrayList<>();
        list.add(c);
        list.add(t1Cart1);
        list.add(t1Cart2);
        list.add(t1Cart3);
        list.add(t1Cart4);
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
        list.add(t2Cart4);
        list.add(t2Cart4);

        Model model = new Model(list);
        model.simulateWithPrintOnlyMoney(time);
        System.out.println();
    }

    // кількість візків типу ТТ1 - 3 , кількість візків типу ТТ2 -2
    /*
    *     public void createModel2() {

        Create c = new Create(1.0/22);
        c.setDistribution(Distribution.PUASSON);

        Process t1Cart1 = new Process("Візок TT1 1", ProcessType.CART_TT1,1, c, 1);
        t1Cart1.setMaxqueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart1);

        Process t1Cart2 = new Process("Візок TT1 2", ProcessType.CART_TT1,2, c,2);
        t1Cart2.setMaxqueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart2);

        Process t1Cart3= new Process("Візок TT1 3", ProcessType.CART_TT1,3, c,3);
        t1Cart3.setMaxqueue(Integer.MAX_VALUE);
        c.addNextElement(t1Cart3);

        Process machine1 = new Process(200,"Верстат 1",Distribution.NORM,  ProcessType.MACHINE,4, t1Cart1, 1);
        machine1.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine1);
        t1Cart2.addNextElement(machine1);
        t1Cart3.addNextElement(machine1);

        Process machine2 = new Process(200, "Верстат 2",Distribution.NORM, ProcessType.MACHINE,5, t1Cart1, 2);
        machine2.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine2);
        t1Cart2.addNextElement(machine2);
        t1Cart3.addNextElement(machine2);


        Process machine3 = new Process(200, "Верстат 3",Distribution.NORM,  ProcessType.MACHINE,6, t1Cart1, 3);
        machine3.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine3);
        t1Cart2.addNextElement(machine3);
        t1Cart3.addNextElement(machine3);

        Process machine4 = new Process(200, "Верстат 4",Distribution.NORM,  ProcessType.MACHINE,7, t1Cart1, 4);
        machine4.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine4);
        t1Cart2.addNextElement(machine4);
        t1Cart3.addNextElement(machine4);

        Process machine5 = new Process(200, "Верстат 5",Distribution.NORM,  ProcessType.MACHINE,8, t1Cart1, 5);
        machine5.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine5);
        t1Cart2.addNextElement(machine5);
        t1Cart3.addNextElement(machine5);

        Process machine6 = new Process(200, "Верстат 6",Distribution.NORM,  ProcessType.MACHINE,9, t1Cart2, 6);
        machine6.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine6);
        t1Cart2.addNextElement(machine6);
        t1Cart3.addNextElement(machine6);

        Process machine7 = new Process(200, "Верстат 7",Distribution.NORM,  ProcessType.MACHINE,10, t1Cart2, 7);
        machine7.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine7);
        t1Cart2.addNextElement(machine7);
        t1Cart3.addNextElement(machine7);

        Process machine8 = new Process(200, "Верстат 8",Distribution.NORM,  ProcessType.MACHINE,11, t1Cart2, 8);
        machine8.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine8);
        t1Cart2.addNextElement(machine8);
        t1Cart3.addNextElement(machine8);

        Process machine9 = new Process(200, "Верстат 9",Distribution.NORM,  ProcessType.MACHINE,12, t1Cart2, 9);
        machine9.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine9);
        t1Cart2.addNextElement(machine9);
        t1Cart3.addNextElement(machine9);

        Process machine10 = new Process(200, "Верстат 10",Distribution.NORM,  ProcessType.MACHINE,13, t1Cart2, 10);
        machine10.setMaxqueue(Integer.MAX_VALUE);
        t1Cart1.addNextElement(machine10);
        t1Cart2.addNextElement(machine10);
        t1Cart3.addNextElement(machine10);

        Process t2Cart1 = new Process( "Візок TT2 1", ProcessType.CART_TT2,14, machine1, 1);
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

        Process t2Cart2 = new Process("Візок TT2 2", ProcessType.CART_TT2,15, machine2, 2);
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
        list.add(t1Cart3);
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
        model.simulate(1000.0);
    }*/
}
