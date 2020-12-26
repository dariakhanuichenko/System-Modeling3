import java.util.ArrayList;
import java.util.List;

public class BaseElement {
    private String name;
    private double tNext;
    private double delayMean, delayDev;

    private Distribution distribution;
    private int quantity;
    private double tCurr;
    private int state;
    private List<BaseElement> nextElement;
    private int id;
    private int num;


    public BaseElement(double delay, String name) {
        this.name = name;
        tNext = 0.0;
        delayMean = delay;
        distribution = Distribution.EXP;
        tCurr = tNext;
        state = 0;
        nextElement = null;
        id = 0;
        nextElement = new ArrayList<>();
    }

    public BaseElement(String name, int id, int num) {
        this.name = name;
        tNext = Double.MAX_VALUE;
        delayMean = 0;
        distribution = Distribution.EXP;
        tCurr = 0.0;
        state = 0;
        nextElement = null;
        this.id = id;
        nextElement = new ArrayList<>();
        this.num = num;
    }

    public BaseElement(double delay, String name, Distribution distribution, int id, int num) {
        this.name = name;
        tNext = Double.MAX_VALUE;
        delayMean = delay;
        delayDev = 30;
        this.distribution = distribution;
        tCurr = 0.0;
        state = 0;
        nextElement = null;
        this.id = id;
        nextElement = new ArrayList<>();
    }

    public double getDelay() {
        double delay = getDelayMean();
        if (getDistribution().equals(Distribution.EXP)) {
            delay = FunRand.Exp(getDelayMean());
        } else {
            if (getDistribution().equals(Distribution.NORM)) {
                delay = FunRand.Norm(getDelayMean(), getDelayDev());
            } else {
                if (getDistribution().equals(Distribution.PUASSON)) {
                    delay = FunRand.Puasson(getDelayMean());
                }
            }
        }
        return delay;
    }

    public double getDelayDev() {
        return delayDev;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setDelayDev(double delayDev) {
        this.delayDev = delayDev;
    }

    public Distribution getDistribution() {
        return distribution;
    }

    public void setDistribution(Distribution distribution) {
        this.distribution = distribution;
    }

    public int getQuantity() {
        return quantity;
    }

    public double gettCurr() {
        return tCurr;
    }

    public void settCurr(double tCurr) {
        this.tCurr = tCurr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<BaseElement> getNextElement() {
        return nextElement;
    }

    public void addNextElement(BaseElement nextElement) {
        if (nextElement != null)
            this.nextElement.add(nextElement);
    }

    public void inAct() {
    }

    public void outAct() {
        quantity++;
    }

    public double gettNext() {
        return tNext;
    }

    public void settNext(double tNext) {
        this.tNext = tNext;
    }

    public double getDelayMean() {
        return delayMean;
    }

    public void setDelayMean(double delayMean) {
        this.delayMean = delayMean;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void printResult() {
        System.out.print(getName() +" - " + quantity +";  ");
    }

    public void printInfo() {
        System.out.println(getName() + " state= " + state + " quantity = " + quantity + " tnext= " + tNext);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void doStatistics(double delta) {
    }


}
