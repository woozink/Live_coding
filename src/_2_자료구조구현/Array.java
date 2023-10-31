package _2_자료구조구현;

public class Array {
    // 1. 배열을 저장할 정수 배열
    private int[] array;
    // 2. 배열의 현재 크기
    private int size;
    // 3. 배열의 최대 용량
    private int capacity;

    // 4. 생성자 : 초기 용량을 지정하여 Array 객체를 생성한다.
    public Array(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }
    // 5. 배열의 새요소를 추가한다.
    public void add(int element) {
        // 6. 현재 크기가 최대 용량에 도달했다면
        if (size == capacity) {
            // 7. 용량을 늘려준다.
            ensureCapacity();
        }
        // 8. 초기 용량으로 정수 배열 초기화
        array[size++] = element;
    }
    // 9. 지정된 인덱스에 있는 요소를 반환한다.
    public int get(int index) {
        // 10. 인덱스가 유효한 범위를 벗어나면
        if (index < 0 || index >= size) {
            // 11. 예외 던지기
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }
        // 12. 배열의 해당 인덱스 값을 변환한다.
        return array[index];
    }
    // 13. 지정된 인덱스의 요소를 삭제한다.
    public void remove(int index) {
        // 14. 인덱스가 유효한 범위를 벗어나면
        if (index < 0 || index >= size) {
            // 에러 처리
            throw new IndexOutOfBoundsException("Index out of range: " + index);
        }

        // 15. 삭제된 요소 뒤의 모든 요소를 한칸씩 앞으로 땡긴다.
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        // 16. 배열 크기 1 감소
        size--;
    }

    // 17. 배열의 현재 크기를 반환한다.
    public int size() {
        return size;
    }

    // 18. 배열의 용량이 부족할 때 배열의 크기르 늘려주는 메소드
    public void ensureCapacity() {
        // 새 용향을 현재 용량의 두배로 설정한다.
        int newCapacity = capacity * 2;
        // 새 배열을 생성한다.
        int[] newArray = new int[newCapacity];
        // 모든 요소를 새 배열을 복사한다.
        for (int i = 0; i < size; i++) {
            newArray[i] = array[i];
        }
        // 배열 참조를 새 배열로 업데이트한다.
        array = newArray;
        // 용량 정보를 업데이트한다.
        capacity = newCapacity;
    }

    public static void main(String[] args) {
        Array customArray = new Array(5);
        customArray.add(1);
        customArray.add(2);
        customArray.add(3);
        customArray.add(4);
        customArray.add(5);

        System.out.println("Element at index 2: " + customArray.get(2));
        System.out.println("Size: " + customArray.size());

        customArray.add(6);
        System.out.println("Size after adding an element: " + customArray.size());

        customArray.remove(1);
        System.out.println("Size after removing an element: " + customArray.size());
        System.out.println("Element at index 1: " + customArray.get(1));
    }
}

