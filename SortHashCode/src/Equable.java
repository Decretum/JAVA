/*
 * Copyright (c) 2017. Phasmid Software
 */

import java.util.Iterator;

public class Equable {

    public Equable(Iterable<?> elements) {
        this.elements = elements;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equable equable = (Equable) o;

        Iterator<?> thisIterator = elements.iterator();
        Iterator<?> thatIterator = equable.elements.iterator();
        while (thisIterator.hasNext()) {
            if (thatIterator.hasNext()) {
                if (!thisIterator.next().equals(thatIterator.next()))
                    return false;
            } else
                return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = 0;
        for (Object element : elements) {
            result = 31 * result + element.hashCode();
        }
        return result;
    }

    protected final Iterable<?> elements;

}