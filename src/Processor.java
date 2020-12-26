import java.util.List;

public class Processor extends BaseElement {
    private int queue, maxQueue;
    private double meanQueue;
    private double loadSum;
    private int maxObservedQueue;
    private ProcessType type;
    private BaseElement previousProcess;

    public Processor(double delay, String name, Distribution distribution, ProcessType type, int id, BaseElement previousProcess, int num) {
        super(delay, name, distribution, id, num);
        queue = 0;
        maxQueue = Integer.MAX_VALUE;
        meanQueue = 0.0;
        loadSum = 0.0;
        maxObservedQueue = 0;
        this.type = type;
        this.previousProcess = previousProcess;
    }

    public Processor(String name, ProcessType type, int id, BaseElement previousProcess, int num) {
        super(name, id, num);
        queue = 0;
        maxQueue = Integer.MAX_VALUE;
        meanQueue = 0.0;
        loadSum = 0.0;
        maxObservedQueue = 0;
        this.type = type;
        this.previousProcess = previousProcess;
    }

    @Override
    public void inAct() {
        if (super.getState() == 0) {                                    // если устройство свободное
            super.setState(1);                                          // занимаем

            BaseElement nextE = getItemWithMinDifference(super.getNextElement()); // нашли след элемент с минимальной разницей id

            if (type == ProcessType.CART_TT2 && this.getPreviousProcess() != null) // если это тележка типа тт2
                super.settNext((getPreviousProcess().getNum() + 1) * 2 + 10 + gettCurr()); // устанавливаем время согласно формулы ( (номер устройства +1) * 2 + tcurr)
            else if (type == ProcessType.CART_TT1){
                if (nextE instanceof Processor)
                    if (((Processor) nextE).getType().equals(ProcessType.CART_TT2))
                        ((Processor) nextE).setPreviousProcess(this);
                ((Processor) nextE).queue++;
                super.settNext(getPreviousProcess().getNum() + 1 + 10 + gettCurr()); // устанавливаем время согласно формулы ( (номер устройства +1)+10 + tcurr)
                nextE.setState(0);
            } else
                super.settNext(super.gettCurr() + super.getDelay());        // в другом случае считаем  обычно
        } else {                                                        // если устройство занято
            setQueue(getQueue() + 1);
//            System.out.println("Q=" + getQueue()); // выводим размер очереди
        }
    }

    BaseElement getItemWithMinDifference(List<BaseElement> nextElement) {    // выбераем след элемент для тех у кого разница между id минимальная по модулю
        int min = Integer.MAX_VALUE;
        BaseElement result = null;
        for (BaseElement e : nextElement) {
            if (e.getState() == 0 && Math.abs(e.getNum() - this.getNum()) < min) {
                result = e;
                min = Math.abs(e.getNum() - this.getNum());
            }
        }
        min = Integer.MAX_VALUE;
        if(result == null) {
            for (BaseElement e : nextElement) {
                if ( Math.abs(e.getNum() - this.getNum()) < min) {
                    result = e;
                    min = Math.abs(e.getNum() - this.getNum());
                }
            }
        }
        return result;
    }

    @Override
    public void outAct() {

        super.outAct();
        super.settNext(Double.MAX_VALUE);
        super.setState(0);                      //освободили устройство
        if (getQueue() > 0) {                   // если очередь не пустая
            setQueue(getQueue() - 1);           // взяли с очереди
            super.setState(1);                  // заняли устройство
            super.settNext(super.gettCurr() + super.getDelay());    // установили время завершения
        }

        BaseElement nextE = getItemWithMinDifference(super.getNextElement()); // нашли след элемент с минимальной разницей id

        if (nextE != null) {                                            //если такой существует
            if (getType().equals(ProcessType.CART_TT1)) {               // и сейчас мы на тележке типа ТТ1
                super.settNext(nextE.getNum() + 1 + 10 + gettCurr());   // считаем по специальной формуле время
            }
            if (nextE instanceof Processor)
                if (((Processor) nextE).getType().equals(ProcessType.CART_TT2))
                    ((Processor) nextE).setPreviousProcess(this);
//            ((Process) nextE).queue++;
//            nextE.setState(0);
            if (nextE != null) {   // если существует свободный след лемент
                nextE.inAct();                // запускаем в работу
            }
        }
    }


    public ProcessType getType() {
        return type;
    }

    public void setType(ProcessType type) {
        this.type = type;
    }

    public BaseElement getPreviousProcess() {
        return previousProcess;
    }

    public void setPreviousProcess(BaseElement previousProcess) {
        this.previousProcess = previousProcess;
    }

    public void addLoadSum(double loadSum) {
        this.loadSum += loadSum;
    }

    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
    }

    public void addOneToQueue() {
        this.queue++;
    }

    public int getMaxQueue() {
        return maxQueue;
    }

    public void setMaxQueue(int maxQueue) {
        this.maxQueue = maxQueue;
    }

    public double getLoadSum() {
        return loadSum;
    }

    public void setLoadSum(double loadSum) {
        this.loadSum = loadSum;
    }

    public int getMaxObservedQueue() {
        return maxObservedQueue;
    }

    public void setMaxObservedQueue(int maxObservedQueue) {
        this.maxObservedQueue = maxObservedQueue;
    }

    @Override
    public void doStatistics(double delta) {
        meanQueue = getMeanQueue() + queue * delta;
    }

    public double getMeanQueue() {
        return meanQueue;
    }


}
