## Linked List

### Array

- 개념
    - 메모리에 데이터를 연속적으로 저장해놓은 공간
    - 사용할 사이즈와 데이터 타입을 미리 지정해야한다.
- 장점
    - 인덱스를 사용하여 데이터에 직접적으로 접근할 수 있어서 데이터를 수정하는 연산이 빠르다.
- 단점
    - 배열의 크기를 유동적으로 조절할 수 없다.
      따라서 배열의 크기가 부족하거나 줄이고 싶은 경우 새로운 배열을 선언하여 복사해야한다.
    - 배열의 원소를 삭제하더라도 원소가 위치한 공간은 그대로 남아있다.
      따라서 원소를 삭제하거나 추가할 때는 해당 위치의 다음 원소들을 전부 시프트해야한다.
    - (자바의 경우) 배열을 선언할 때 데이터 타입을 지정해야하므로 데이터 타입이 동적으로 결정되지 않는다.
- 시간복잡도
    - 삽입 : O(N)
    - 삭제 : O(N)
    - 검색 : O(1)
        - 값으로 검색할 경우 O(N), 정렬되어 있을 경우 O(logN)

```
설명
- 배열은 메모리에 데이터를 연속적으로 저장해놓은 자료구조를 의미하며, 저장될 데이터의 타입과 사용할 공간의 크기를 미리 지정해야합니다.

- 장점으로는 인덱스를 사용하여 데이터에 직접 접근할 수 있어서 참조하거나 수정하는 연산이 빠릅니다.

- 단점으로는 특정 위치에 원소를 추가하거나 삭제한 뒤 그 다음 원소들을 시프트하는 추가적인 연산이 필요합니다. 이는 배열의 데이터들이 메모리 상의 연속적인 공간에 저장되기 때문입니다.
- 또한 배열의 크기가 부족하다면 새로운 배열을 선언하여 데이터들을 복사해야합니다.

- 시간복잡도는 삽입 및 삭제연산은 O(N), 참조는 O(1), 값으로 검색 시 O(N), 정렬된 상태에서 값으로 검색 시 O(logN) 입니다.
```

### Linked list

- 개념
    - 메모리에 저장된 데이터의 주소를 참조함으로써 데이터가 이어진 것처럼 사용할 수 있는 자료구조이다.
    - Linked list는 데이터를 값을 저장하는 필드와 다음 노드의 주소를 가리키는 포인터로 구성된다.
    - 맨 첫번째 원소를 가리키는 head 포인터를 통해 리스트의 원소들에 접근한다.
    - 리스트는 노드들의 집합이며, 노드는 저장해야할 데이터의 값과 다음 노드의 주소를 가리키는 링크로 구성되어 있다.
    - 구현 방법에 따라 단방향, 양방향, 순환리스트 등으로 구분할 수 있다.
- 장점
    - 배열과는 달리 메모리에서 연속적인 공간을 사용할 필요가 없기 때문에 중간에 원소를 추가하거나 삭제하더라도 다른 원소들을 이동시킬 필요가 없다.
- 단점
    - 연속적인 공간이 아니기 때문에 원소에 직접 접근할 수 없다.
      따라서 특정 원소에 접근하기 위해서는 Head 포인터부터 차례대로 원소들을 순회해야하므로 많은 수정을 요구하는 작업에 부적합하다.
- 복잡도
    - 삽입 : O(1)
    - 삭제 : O(1)
    - 검색 : O(N)

```
- 메모리에 저장된 데이터의 주소를 참조하여 마치 연속적으로 저장된 것처럼 사용할 수 있는 자료구조입니다. 노드들의 집합인 Linked list의 각각의 노드가 데이터의 값과 다음 노드를 가리키는 포인터를 가지고 있기 때문입니다.
- 구현 방법에 따라 단방향, 양방향, 순환리스트 등으로 구분할 수 있습니다.

- 장점으로는 배열과는 달리 리스트의 중간에 원소를 추가하거나 삭제한 다음 추가적인 연산이 필요없다는 것입니다. 이는 리스트를 구성하는 각각의 노드가 다음 노드의 위치를 참조하므로 메모리 상에 연속적으로 위치할 필요가 없기 때문입니다.
- 또한 전체적인 크기가 고정되어있지 않기 때문에 동적으로 크기를 조절할 수 있다는 장점이 있습니다.

- 단점으로는 특정 원소에 접근하기 위해서는 가장 맨 앞의 노드부터 차례대로 순회해야하는 것입니다.

- 시간복잡도는 삽입과 삭제 연산은 O(1), 검색 연산은 O(N) 입니다.
```

### Single linked list

![img](C:\Users\nsm\Documents\Job\Images\[ds] Single linked list)

- 노드가 데이터의 값과 다음 노드를 가리키는 링크만으로 구현된 구조를 단방향 연결 리스트라고 한다.
- 맨 마지막 노드의 링크는 null값이 할당되어 있다.
- 다음 노드만 참조하고 있어서 이전 노드를 참조하고 싶을 때에는 맨 앞에서부터 다시 순회해야한다.

### Double linked list

![img](C:\Users\nsm\Documents\Job\Images\[ds] Double linked list)

- 노드가 데이터의 값과 이전 노드를 카리키는 링크와 다음 노드를 가리키는 링크로 구현된 구조를 양방향 연결 리스트라고 한다.
- 이전 노드의 주소를 가지고 있으므로 특정 원소에 접근할 때 맨 앞 또는 맨 뒤에서부터 순회하여 접근할 수 있다.

### Circular linked list

![img](C:\Users\nsm\Documents\Job\Images\[ds] Circular linked list)

- 마지막 노드가 첫번째 노드를 가리키도록 구현한 리스트이다.

### `ArrayList` vs `LinkedList`

#### `Array`

- 배열이며, 논리적 저장순서와 물리적 저장순서가 일치한다.
- 특정 자료형들이 메모리 공간 상에서 연속적으로 이루어져 있다.
- immutable하다.
- 인덱스로 해당 원소에 접근할 수 있으며, 인덱스를 알고 있다면 O(1)의 시간 복잡도로 원소에 접근이 가능하다. 즉, `Random Access`가 가능하다.
- 삭제 또는 삽입 과정에서는 해당 원소에 접근하여 작업을 완료한 뒤, shift해줘야 하므로 비용이 발생한다. O(n)
- 메모리 공간 활용에 제약이 있다.

#### `LinkedList`

- 데이터 검색 시 처음 노드부터 순회해야 한다. 이유는 논리적 저장 순서와 물리적 저장 순서가 다르기 때문이다. O(n)
- 메모리 공간 상에서 각 노드들이 연속적으로 이루어져 있지 않고 흩어져 있으며, 각각의 노드가 자신의 다음 노드의 위치를 알고 있는 형태이다.
- 각 노드들이 메모리 공간 상의 어디에 위치하는지는 각각의 노드들만 알고 있고, 사용자는 제일 첫 번째 노드의 위치만 알고 있는 상태이다.
- 어떤 원소를 삽입, 삭제 시 그 원소를 찾기 위해 O(n)의 시간이 발생하고 추가적으로 작업을 완료하는 시간까지 O(n)의 시간이 걸린다.
- 결국, LinkedList는 검색과 삽입, 삭제 과정 모두 O(n)의 시간 복잡도를 갖는다.

#### 데이터 접근 속도

- Array
    - 인덱스를 사용하여 빠르게 접근하므로 시간 복잡도는 O(1)이다.
    - Random Access가 가능하다.
- LinkedList
    - 특정 원소에 접근하기 위해서는 처음부터 순차적으로 검색하기 때문에 시간 복잡도는 O(N)이다.

#### 데이터 삽입 속도

- Array
    - 데이터를 중간이나 맨 앞에 삽입할 경우, 이후의 데이터를 Shift해야 하므로 추가 과정과 시간이 소요된다.
    - 따라서 데이터가 많은 경우, 비효율적이다.
    - O(N)의 시간이 걸린다.
- LinkedList
    - 중간 삽입 없이 맨 앞과 맨 뒤에만 삽입한다면 O(1)의 시간 복잡도를 갖는다.
    - 그렇지 않다면 삽입할 위치를 찾고(O(N))과 삽입 연산을 진행하기 때문에 O(N)의 시간 복잡도를 갖는다.
    - 그럼에도 불구하고 Array보다 빠른 성능을 갖는다.

Array의 경우, 데이터를 삽입하여 모든 공간이 꽉 차게 되면 새로운 메모리 공간을 할당받아 옮겨야 하지만, LinkedList를 그럴 필요가 없다. 추가할 때마다 동적으로 메모리 공간을 할당받는다.

#### 데이터 삭제 속도

- Array
    - 데이터 삭제의 경우, 그 위치의 데이터를 삭제한 후 전체적으로 Shift해줘야 하기 때문에 O(N)의 시간 복잡도를 갖는다.
- LinkedList
    - 삭제할 원소를 찾기 위해 O(N)의 시간 복잡도를 갖고 삭제한다. 하지만, Array보다 빠르게 삭제 연산을 수행한다.

#### 메모리 할당

- Array
    - 메모리에는 Array가 선언되자 마자 Compile time에 할당되어 진다.
    - 정적 메모리 할당이라고 한다.
- LinkedList
    - 메모리는 새로운 Node가 추가될 때 runtime에 할당되어 진다.
    - 동적 메모리 할당이라고 한다.

### In Java

#### `ArrayList`

- `List`와 `RandomAccess`의 구현체이다.
- 배열로 구현되어 있기 때문에 해당 구현체의 연산속도는 배열과 같다.

#### `LinkedList`

- `List`와 `Deque`의 구현체이고 양방향 연결리스트로 구현되었다.

#### 차이

- 각각 배열과 양방향 연결리스트로 구현하였다.

- `ArrayList`는 내부적으로 배열을 참조하므로 참조연산이 빠르지만
  데이터 추가 및 삭제연산은 배열의 크기를 늘리는 추가적인 연산이 필요하므로 느리다.

- `LinkedList`는 삽입 및 삭제 연산이 빠르다.
  단, 대상인 원소를 찾기 위해 앞에서부터 순회하므로 해당 원소가 앞에 위치할 경우에만 해당된다.

- 따라서 참조가 빈번한 작업은 `ArrayList`,
  삽입, 삭제가 빈번한 작업은 `LinkedList`를 사용하는 편이 낫다.