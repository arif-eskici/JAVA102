package MyListClass_withGeneric;

public class MyList <T> {

    private T [] array;
    private int capacity = 10;      // array initial value
    private int index = 0;

    public MyList () {
        this.array = (T[]) new Object [capacity];
    }

    public MyList (int capacity) {      // MyList<Integer> list = new MyList<>();
        this.capacity = capacity;
    }

    public int getCapacity () {
        return this.capacity;
    }

    public int size () {
        return index;
    }

    public void add (T data) {
        if (index == this.capacity) {
            T[] newArray = (T[]) new Object [capacity * 2];
            int i = 0;
            for (T array : this.array) {
                newArray [i] = array;
                i++;
            }
            this.array = newArray;
            this.capacity = this.capacity * 2;  
        }
        array[index] = data;
        index++;
    }

    public T get (int index) {
        if (index < 0 || index > this.index) {
            return null;
        } else {
            return array [index];
        }
    }

    public T remove (int index) {
        this.index--;
        if (index < 0 || index > this.index) {
            return null;
        } else {
            T deleteIndexValue = this.array[index];
            for (int i = index; i < this.index; i++) {
                this.array[i] = this.array[i+1];
            }
            this.array[size()] = null;
            return deleteIndexValue;
        }
    }

    public T set (int index, T data) {
        if (index < 0 || index > this.index) {
            return null;
        } else {
            T setIndexValue = this.array[index];
            this.array[index] = data;
            return setIndexValue;
        }
    }

    public String toString () {
        StringBuilder sb = new StringBuilder();
        sb.append("[ ");
        for (T array : this.array) {
            if (array != null) {
                sb.append(array.toString()+ ", ");

            }
        }
        sb.deleteCharAt(sb.length()-1);
        sb.append(" ]");
        return sb.toString();
    }

    public int indexOf (T data) {       // belirtilen elemanın indeksini verir
        for (int i = 0; i <= this.size()-1; i++) {
            if (this.array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf (T data) {                   // listedeki son indeksi  verir    
        for (int i = this.size() - 1; i >= 0; i--) {    // bakmaya sondan başladığı için  ilk gördüğünde sonlandırır.
            if (this.array[i].equals(data)) {
                return i;
            }
        }
        return -1;
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }
    
    public T [] toArray () {
        return this.array;
    }

    public void clear() {
        for (int i = 0; i < this.size(); i++) {
            this.array[i] = null;
        }
    }

    public MyList <T> sublist (int start, int finish) {
        MyList <T> newMyList = new MyList<>();
        for (int i = start + 1; i < finish; i++) {
            newMyList.add(this.array[i]);
        }
        return newMyList;
    }

    public boolean contains (T data) {
        for (T array : this.array) {       // for (int i = 0; i < this.size(); i++)
            if (array == data) {           // if (this.array[i].equals(data))
                return true;
            }
        }
        return false;
    }

}
