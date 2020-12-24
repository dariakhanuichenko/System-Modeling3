import java.util.List;

public class Process extends Element {
    private int queue, maxqueue;
    private double meanQueue;
    private double loadSum;
    private int maxObservedQueue;
    private ProcessType type;
    private Element previousProcess;

    public Process(double delay, String name, Distribution distribution, ProcessType type, int id, Element previousProcess, int num) {
        super(delay, name, distribution, id, num);
        queue = 0;
        maxqueue = Integer.MAX_VALUE;
        meanQueue = 0.0;
        loadSum = 0.0;
        maxObservedQueue = 0;
        this.type = type;
        this.previousProcess = previousProcess;
    }

    public Process(String name, ProcessType type, int id, Element previousProcess, int num) {
        super(name, id, num);
        queue = 0;
        maxqueue = Integer.MAX_VALUE;
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

            Element nextE = getItemWithMinDifference(super.getNextElement()); // нашли след элемент с минимальной разницей id

            if (type == ProcessType.CART_TT2 && this.getPreviousProcess() != null) // если это тележка типа тт2
                super.setTnext((getPreviousProcess().getNum() + 1) * 2 + 10 + getTcurr()); // устанавливаем время согласно формулы ( (номер устройства +1) * 2 + tcurr)
            else if (type == ProcessType.CART_TT1){
                if (nextE instanceof Process)
                    if (((Process) nextE).getType().equals(ProcessType.CART_TT2))
                        ((Process) nextE).setPreviousProcess(this);
                ((Process) nextE).queue++;
                super.setTnext(getPreviousProcess().getNum() + 1 + 10 + getTcurr()); // устанавливаем время согласно формулы ( (номер устройства +1)+10 + tcurr)
                nextE.setState(0);
            } else
                super.setTnext(super.getTcurr() + super.getDelay());        // в другом случае считаем  обычно
        } else {                                                        // если устройство занято
            setQueue(getQueue() + 1);
            System.out.println("Q=" + getQueue()); // выводим размер очереди
        }
    }

    Element getItemWithMinDifference(List<Element> nextElement) {    // выбераем след элемент для тех у кого разница между id минимальная по модулю
        int min = Integer.MAX_VALUE;
        Element result = null;
        for (Element e : nextElement) {
            if (e.getState() == 0 && Math.abs(e.getNum() - this.getNum()) < min) {
                result = e;
                min = Math.abs(e.getNum() - this.getNum());
            }
        }
        min = Integer.MAX_VALUE;
        if(result == null) {
            for (Element e : nextElement) {
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
        super.setTnext(Double.MAX_VALUE);
        super.setState(0);                      //освободили устройство
        if (getQueue() > 0) {                   // если очередь не пустая
            setQueue(getQueue() - 1);           // взяли с очереди
            super.setState(1);                  // заняли устройство
            super.setTnext(super.getTcurr() + super.getDelay());    // установили время завершения
        }

        Element nextE = getItemWithMinDifference(super.getNextElement()); // нашли след элемент с минимальной разницей id

        if (nextE != null) {                                            //если такой существует
            if (getType().equals(ProcessType.CART_TT1)) {               // и сейчас мы на тележке типа ТТ1
                super.setTnext(nextE.getNum() + 1 + 10 + getTcurr());   // считаем по специальной формуле время
            }
            if (nextE instanceof Process)
                if (((Process) nextE).getType().equals(ProcessType.CART_TT2))
                    ((Process) nextE).setPreviousProcess(this);
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

    public Element getPreviousProcess() {
        return previousProcess;
    }

    public void setPreviousProcess(Element previousProcess) {
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

    public int getMaxqueue() {
        return maxqueue;
    }

    public void setMaxqueue(int maxqueue) {
        this.maxqueue = maxqueue;
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
