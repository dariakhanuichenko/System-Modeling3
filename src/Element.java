import java.util.ArrayList;
import java.util.List;

public class Element {
    private String name;
    private double tnext;
    private double delayMean, delayDev;

    private String distribution;
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
        distribution = "exp";
        tcurr = tnext;
        state = 0;
        nextElement = null;
        id = nextId;
        nextId++;
        nextElement = new ArrayList<>();
    }

 public Element( String name, int id, int num) {
        this.name = name;
        tnext = 0.0;
        delayMean = 0;
        distribution = "exp";
        tcurr = tnext;
        state = 0;
        nextElement = null;
        this.id = id;
        nextId++;
        nextElement = new ArrayList<>();
        this.num = num;
    }

    public Element(double delay, String name, String distribution, int id ,int num) {
        this.name = name;
        tnext = 0.0;
        delayMean = delay;
        delayDev = 30;
        this.distribution = distribution;
        tcurr = tnext;
        state = 0;
        nextElement = null;
        this.id = id;
        nextId++;
        nextElement = new ArrayList<>();
    }

 // TODO: переписать на enum
    public double getDelay() {
        double delay = getDelayMean();
        if ("exp".equalsIgnoreCase(getDistribution())) {
            delay = FunRand.Exp(getDelayMean());
        } else {
            if ("norm".equalsIgnoreCase(getDistribution())) {
                delay = FunRand.Norm(getDelayMean(), getDelayDev());
            } else {
                if ("puasson".equalsIgnoreCase(getDistribution())) {
                    delay = FunRand.Puasson(getDelayMean());
                } else {
                    if ("unif".equalsIgnoreCase(getDistribution())) {
                        delay = FunRand.Unif(getDelayMean(), getDelayDev());
                    } else {
                        if ("".equalsIgnoreCase(getDistribution()))
                            delay = getDelayMean();
                    }
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

    public String getDistribution() {
        return distribution;
    }

    public void setDistribution(String distribution) {
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
