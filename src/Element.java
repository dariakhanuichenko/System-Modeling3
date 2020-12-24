import java.util.ArrayList;
import java.util.List;

public class Element {
    private String name;
    private double tnext;
    private double delayMean, delayDev;

    private Distribution distribution;
    private int quantity;
    private double tcurr;
    private int state;
    private List<Element> nextElement;
    private static int nextId = 0;
    private int id;
    private int num;


    public Element(double delay, String name) {
        this.name = name;
        tnext = 0.0;
        delayMean = delay;
        distribution = Distribution.EXP;
        tcurr = tnext;
        state = 0;
        nextElement = null;
        id = nextId;
        nextId++;
        nextElement = new ArrayList<>();
    }

    public Element(String name, int id, int num) {
        this.name = name;
        tnext = Double.MAX_VALUE;
        delayMean = 0;
        distribution = Distribution.EXP;
        tcurr = 0.0;
        state = 0;
        nextElement = null;
        this.id = id;
        nextId++;
        nextElement = new ArrayList<>();
        this.num = num;
    }

    public Element(double delay, String name, Distribution distribution, int id, int num) {
        this.name = name;
        tnext = Double.MAX_VALUE;
        delayMean = delay;
        delayDev = 30;
        this.distribution = distribution;
        tcurr = 0.0;
        state = 0;
        nextElement = null;
        this.id = id;
        nextId++;
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

    public double getTcurr() {
        return tcurr;
    }

    public void setTcurr(double tcurr) {
        this.tcurr = tcurr;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public List<Element> getNextElement() {
        return nextElement;
    }

    public void addNextElement(Element nextElement) {
        if (nextElement != null)
            this.nextElement.add(nextElement);
    }

    public void inAct() {
    }

    public void outAct() {
        quantity++;
    }

    public double getTnext() {
        return tnext;
    }

    public void setTnext(double tnext) {
        this.tnext = tnext;
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
        System.out.println(getName() + " quantity = " + quantity);
    }

    public void printInfo() {
        System.out.println(getName() + " state= " + state + " quantity = " + quantity + " tnext= " + tnext);
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
