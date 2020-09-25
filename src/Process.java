public class Process extends Element {
    private int queue, maxqueue, failure;
    private double meanQueue;
    private double loadSum;
    private int maxObservedQueue;

    public Process(double delay) {
        super(delay);
        queue = 0;
        maxqueue = Integer.MAX_VALUE;
        meanQueue = 0.0;
        loadSum = 0.0;
        maxObservedQueue = 0;
    }
    @Override
    public void inAct() {
        if (super.getState() == 0) {                                    // если устройство свободное
            super.setState(1);                                          // занимаем
            super.setTnext(super.getTcurr() + super.getDelay());        // генерируем время
        } else {                                                        // если устройство занято
            if (getQueue() < getMaxqueue()) {
                setQueue(getQueue() + 1);
                System.out.println("Q=" + getQueue());
                if (queue > maxObservedQueue)
                    maxObservedQueue = queue;
            } else {
                failure++;
                System.out.println("Q=f" +failure );
            }
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
