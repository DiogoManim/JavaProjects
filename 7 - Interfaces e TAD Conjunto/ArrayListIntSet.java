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


    // -------------------------------------------
    // Implementações apenas para deixar compilar
    // -------------------------------------------

    public boolean remove(int x) {return true;}
}
