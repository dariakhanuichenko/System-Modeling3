public class Process extends Element {
    private int queue, maxqueue, failure;
    private double meanQueue;
    private double loadSum;
    private int maxObservedQueue;
    private ProcessType type;
    private Element previousProcess;

    public Process(double delay, String distribution, ProcessType type, int id) {
        super(delay, distribution);
        queue = 0;
        maxqueue = Integer.MAX_VALUE;
        meanQueue = 0.0;
        loadSum = 0.0;
        maxObservedQueue = 0;
        this.type = type;
    }
    @Override
    public void inAct() {
        if (super.getState() == 0) {                                    // если устройство свободное
            super.setState(1);                                          // занимаем
//            if(type == ProcessType.CART_TT1)

            super.setTnext(super.getTcurr() + super.getDelay());        // генерируем время
        } else {                                                        // если устройство занято
//            if (getQueue() < getMaxqueue()) {
                setQueue(getQueue() + 1);
                System.out.println("Q=" + getQueue());
//                if (queue > maxObservedQueue)
//                    maxObservedQueue = queue;
//            } else {
//                failure++;
//                System.out.println("Q=f" +failure );
//            }
        }
    }
    @Override
    public void outAct() {

        super.outAct();
        super.setTnext(Double.MAX_VALUE);
        super.setState(0);
        if (getQueue() > 0) {
            setQueue(getQueue() - 1);
            super.setState(1);
            super.setTnext(super.getTcurr() + super.getDelay());
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

    public int getFailure() {
        return failure;
    }
    public int getQueue() {
        return queue;
    }

    public void setQueue(int queue) {
        this.queue = queue;
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
    public void printInfo() {
        super.printInfo();
        System.out.println("failure = " + this.getFailure());
    }

    @Override
    public void doStatistics(double delta) {
        meanQueue = getMeanQueue() + queue * delta;
    }
    public double getMeanQueue() {
        return meanQueue;
    }
}
