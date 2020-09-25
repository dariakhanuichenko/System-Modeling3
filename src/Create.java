public class Create extends Element {
    public Create(double delay) {
        super(delay);
    }

    boolean iterElem(Element nextE) {
        if (nextE == null)                                              //нету свободных элементов
            return false;
        if (nextE.getState() == 0) {                                    //если есть след свободный елемент - передать на обработку
            nextE.inAct();
            return true;
        }
        if (isNextElementExist(nextE)) {
            int index = randomElementIndex(nextE.getNextElement().size());  // иначе рандомно выбрать  элемент из списка
            return iterElem(nextE.getNextElement().get(index));
        } else return false;
    }

    boolean isNextElementExist(Element nextE) {
        return !nextE.getNextElement().isEmpty();
    }

    int randomElementIndex(int size) {
        return (int) (Math.random() * (size));
    }

    int iterElem2(Element nextE, int min) {
        if (nextE == null)
            return min;
        if (nextE.getQuantity() < min) // выбираем елемент где обработано меньше заявок
            min = nextE.getQuantity();

        if (isNextElementExist(nextE)) {     //проверяем на минимум для след елементов
            int index = randomElementIndex(nextE.getNextElement().size());
            return iterElem2(nextE.getNextElement().get(index), min);
        } else return min;
    }

    void iterElem3(Element nextE, int min) {
        if (nextE == null)
            return;
        if (nextE.getQuantity() == min) {   // если выбронае к-во обработаных заявок соответствует даномы элементу
            nextE.inAct();                // запускаем в работу
            return;
        }

        if (isNextElementExist(nextE)) {
            int index = randomElementIndex(nextE.getNextElement().size());
            iterElem3(nextE.getNextElement().get(index), min);
        }
    }

    @Override
    public void outAct() {
        super.outAct();                                             // закончить обработку
        super.setTnext(super.getTcurr() + super.getDelay());
        int index = randomElementIndex(super.getNextElement().size());

        boolean processed = iterElem(super.getNextElement().get(index)); // проверка есть ли след свободный елемент
        if (!processed) // если нет
        {
            int minQuantity = iterElem2(super.getNextElement().get(index), Integer.MAX_VALUE);
            iterElem3(super.getNextElement().get(index), minQuantity);
        }
    }
}
