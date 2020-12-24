import java.util.List;

public class Create extends Element {
    public Create(double delay) {
        super(delay, "CREATOR");
    }

    Element getItemWithMinNum(List<Element> nextElement) {
        int min = Integer.MAX_VALUE;
        Element result = null;
        for (Element e : nextElement) {
            if (e.getState() == 0 && e.getNum() < min) {
                result = e;
                min = e.getId();
            }
        }

        min = Integer.MAX_VALUE;

        if (result == null){
            for (Element e : nextElement) {
                if ( e.getNum() < min) {
                    result = e;
                    min = e.getId();
                }
            }
        }
        return result;
    }

    @Override
    public void outAct() {
        super.outAct();                                             // закончить обработку
        super.setTnext(super.getTcurr() + super.getDelay());

        Element nextE = getItemWithMinNum(super.getNextElement());

        if (nextE != null) {   // если существует свободный след лемент
            nextE.inAct();                // запускаем в работу
        }
    }
}
