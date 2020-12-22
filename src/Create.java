import java.util.List;

public class Create extends Element {
    public Create(double delay) {
        super(delay, "CREATOR");
    }

    Element getItemWithMinId(List<Element> nextElement) {
        int min = Integer.MAX_VALUE;
        Element result = null;
        for (Element e : nextElement) {
            if (e.getState() == 0 && e.getId() < min) {
                result = e;
                min = e.getId();
            }
        }
        return result;
    }

    @Override
    public void outAct() {
        super.outAct();                                             // закончить обработку
        super.setTnext(super.getTcurr() + super.getDelay());

        Element nextE = getItemWithMinId(super.getNextElement());

        if (nextE != null) {   // если существует свободный след лемент
            ((Process) nextE).setPreviousProcess(this); // устанавливаем преведущий процесс
            nextE.inAct();                // запускаем в работу
        }
    }
}
