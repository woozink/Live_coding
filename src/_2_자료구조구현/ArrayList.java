package _2_자료구조구현;

public class ArrayList<T> {
    private Object[] array;
    private int size;
    private int capacity;

    // 생성자: 초기 용량을 지정하여 CustomArrayList 객체를 생성합니다.
    public ArrayList(int capacity) {
        this.capacity = capacity; // 최대 용량 설정
        this.size = 0; // 현재 크기를 0으로 초기화
        this.array = new Object[capacity]; // 초기 용량으로 객체 배열 초기화
    }

    // add 메소드: 리스트에 새 요소를 추가합니다.
    public void add(T element) {
        if(size == capacity){
            ensureCapacity();
        }
        array[size++] = element;
    }

    // get 메소드: 지정된 인덱스에 있는 요소를 반환합니다.
    @SuppressWarnings("unchecked")
    public T get(int index) {
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }
        return (T) array[index]; // 배열에 해당 인덱스를 반환한다.
    }

    // remove 메소드: 지정된 인덱스의 요소를 삭제합니다.
    public void remove(int index) {
        if(index <0 || index >= size){
            throw new IndexOutOfBoundsException();
        }

        for(int i = index; i < size-1; i++){
            array[i] = array[i+1];
        }
        array[size -1] = null;
        size--;
    }

    // size 메소드: 리스트의 현재 크기를 반환합니다.
    public int size() {
        return size;
    }

    // ensureCapacity 메소드: 리스트의 용량이 부족할 때 리스트의 크기를 늘려주는 메소드입니다.
    private void ensureCapacity() {
        // 용량 두 배설정
        int newCapacity = capacity *2;
        // 새 배열을 생성한다.
        Object[] newArray = new Object[newCapacity];
        // 모든 요소를 새배열로 복사
        for(int i = 0 ; i < size; i++){
            newArray[i] = array[i];
        }
        // 배열 참조를 새 배열로 업데이트
        array = newArray;
        capacity = newCapacity;
    }

    // main 메소드: CustomArrayList 클래스의 기능을 테스트합니다.
    public static void main(String[] args) {
        ArrayList<String> customArrayList = new ArrayList<>(5); // 초기 용량이 5인 CustomArrayList 객체를 생성합니다.
        customArrayList.add("Hello");
        customArrayList.add("World");
        customArrayList.add("Java");
        customArrayList.add("Custom");
        customArrayList.add("ArrayList"); // 리스트에 5개의 문자열을 추가합니다.

        System.out.println("Element at index 2: " + customArrayList.get(2)); // 인덱스 2의 요소를 출력합니다.
        System.out.println("Size: " + customArrayList.size()); // 리스트의 크기를 출력합니다.

        customArrayList.add("Extra"); // 리스트에 "Extra"를 추가합니다. 이 때 리스트의 크기가 늘어납니다.
        System.out.println("Size after adding an element: " + customArrayList.size()); // 리스트의 새로운 크기를 출력합니다.

        customArrayList.remove(1); // 인덱스 1의 요소를 삭제합니다.
        System.out.println("Size after removing an element: " + customArrayList.size()); // 리스트의 새로운 크기를 출력합니다.
        System.out.println("Element at index 1: " + customArrayList.get(1)); // 인덱스 1의 새로운 요소를 출력합니다.
    }
}

