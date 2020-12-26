import java.util.List;

public class Creator extends BaseElement {
    public Creator(double delay) {
        super(delay, "CREATOR");
    }

    BaseElement getItemWithMinNum(List<BaseElement> nextElement) {
        int min = Integer.MAX_VALUE;
        BaseElement result = null;
        for (BaseElement e : nextElement) {
            if (e.getState() == 0 && e.getNum() < min) {
                result = e;
                min = e.getNum();
            }
        }

        min = Integer.MAX_VALUE;

        if (result == null){
            for (BaseElement e : nextElement) {
                if( e instanceof Processor)
                if ( ((Processor)e).getQueue() < min) {
                    result = e;
                    min = ((Processor)e).getQueue();
                }
                if(min == 0)
                    break ;
            }
        }
        return result;
    }

    @Override
    public void outAct() {
        super.outAct();                                             // закончить обработку
        super.settNext(super.gettCurr() + super.getDelay());

        BaseElement nextE = getItemWithMinNum(super.getNextElement());

        if (nextE != null) {   // если существует свободный след лемент
            nextE.inAct();                // запускаем в работу
        }
    }
}
