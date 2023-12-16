public class ArrayListIntSet implements IntSet {
    private int size;
    private int[] elem;

    ArrayListIntSet(int maxSize) {
        elem = new int[maxSize];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void clear() {
        size = 0;
    }

    public boolean contains(int x) {
        for (int i = 0; i < size; i++)
            if (elem[i] == x)
                return true;
        return false;
    }

    public boolean add(int x) {
        if (!contains(x)) {
            elem[size] = x;
            size++;
            return true;
        }
        return false;
    }
    
    public boolean remove(int x) {
        if (contains(x)) {
            int pos = 0;
            while (elem[pos] != x) pos++;
            size--;
            elem[pos] = elem[size];
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        String res = "{";
        for (int i = 0; i < size; i++) {
            if (i > 0)
                res += ",";
            res += elem[i];
        }
        res += "}";
        return res;
    }
}
