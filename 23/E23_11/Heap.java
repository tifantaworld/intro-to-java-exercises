import java.util.ArrayList;

public class Heap<E extends Comparable<E>> implements Cloneable {
  private ArrayList<E> list = new ArrayList<>();

  public Heap() {
  }

  public void add(E newObject) {
    list.add(newObject);
    int currentIndex = list.size() - 1;

    while (currentIndex > 0) {
      int parentIndex = (currentIndex - 1) / 2;
      if (list.get(currentIndex).compareTo(list.get(parentIndex)) > 0){
        E temp = list.get(currentIndex);
        list.set(currentIndex, list.get(parentIndex));
        list.set(parentIndex, temp);
      } else {
        break;
      }

      currentIndex = parentIndex;
    }
  }

  public E remove() {
    if (list.size() == 0) { return null; }

    E removedObject = list.get(0);
    list.set(0, list.get(list.size() - 1));
    list.remove(list.size() - 1);

    int currentIndex = 0;
    while (currentIndex < list.size()) {
      int leftChildIndex = 2 * currentIndex + 1;
      int rightChildIndex = 2 * currentIndex + 2;

      if (leftChildIndex >= list.size()) { break; }
      int maxIndex = leftChildIndex;
      if (rightChildIndex < list.size()) {
        if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0) {
          maxIndex = rightChildIndex;
        }
      }

      if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
        E temp = list.get(maxIndex);
        list.set(maxIndex, list.get(currentIndex));
        list.set(currentIndex, temp);
        currentIndex = maxIndex;
      } else {
        break;
      }
    }

    return removedObject;
  }

  public int getSize() {
    return list.size();
  }

  public ArrayList<E> getList() {
    return list;
  }

  @Override
  public boolean equals(Object obj) {
    if (obj != null && obj instanceof Heap) {
      Heap<E> heap = (Heap<E>)obj;
      if (list.equals(heap.getList())) {
        return true;
      }
    }
    return false;
  }

  @Override
  protected Object clone() throws CloneNotSupportedException {
    Heap<E> copy = new Heap<>();
    for (E elem: list) {
      copy.add(elem);
    }
    return copy;
  }
}