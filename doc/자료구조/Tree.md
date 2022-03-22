## Tree

### Tree

#### 개념

- 계층적 관계를 표현하는 자료구조이다.
- 트리를 구성하는 요소들을 노드라고 부르며, 각각의 트리는 단 하나의 루트 노드를 갖는다.
- 루트 노드는 0개 이상의 자식 노드들을 갖고 있으며,
  그 자식 노드들도 0개 이상의 자식 노드들을 가진다.
- 루트 노드를 제외한 하위 노드는 모두 단 하나의 부모노드만을 갖는다.

#### 조건

- 루트노드는 유일하다.
- 루트노드를 제외한 모든 노드는 단 하나의 부모 노드만을 갖는다.
- 서로 다른 임의의 두 노드를 연결하는 경로는 유일하다.
- 싸이클이 발생하지 않는다.
- 노드가 N개인 트리는 항상 N-1개의 간선을 가진다.

#### 용어

![img](https://github.com/boostcamp-ai-tech-4/ai-tech-interview/raw/main/images/adc/data-structure/tree-terms.png)

| 용어                         | 설명                                            |
| ---------------------------- | ----------------------------------------------- |
| 노드                         | 트리를 구성하는 기본 요소                       |
| 루트 노드                    | 부모 노드가 없는 유일한 최상위 노드             |
| 부모 노드                    | 루트 노드 방향으로 직접 연결된 노드             |
| 자식 노드                    | 루트 노드 반대 방향으로 직접 연결된 노드        |
| 형제 노드 (Sibling)          | 같은 부모노드를 갖는 노드들의 집합              |
| 단말 노드 (Terminal / Leaf)  | 자식이 없는 노드                                |
|                              |                                                 |
| 경로 (Path)                  | 한 노드에서 다른 노드 사이에 있는 노드들의 순서 |
| 길이 (Length)                | 출발 노드에서 도착 노드까지 거치는 노드의 개수  |
| 깊이 (Depth)                 | 루트 노드에서 도착 노드까지의 길이              |
| 레벨 (Level)                 | 루트 노드부터 특정 노드까지의 길이              |
| 높이 (Height)                | 루트 노드부터 단말 노드까지의 길이              |
|                              |                                                 |
| 크기 (Size)                  | 노드들의 개수                                   |
| 차수 (Degree)                | 각 노드의 자식의 개수                           |
| 트리의 차수 (Degree of tree) | 가장 많은 자식을 가진 노드의 크기               |
| 너비 (Width)                 | 가장 많은 노드를 가진 레벨의 크기               |


#### 종류

- 이진 트리

    - 모든 노드의 자식 노드 개수가 2개 이하인 트리이다.
    - 공집합이거나 노드가 하나인 트리도 이진 트리에 속한다.

- 포화 이진 트리
    - 터미널 노드를 제외한 모든 노드의 자식 개수가 2개인 트리이다.
    - 트리의 높이를 n이라고 할 때, 트리의 크기는 2^n-1이다.
    - 트리의 높이를 n이라고 할 때, level n의 크기는 2^(n-1)이다.

- 완전 이진 트리
    - 노드가 위에서 아래로, 왼쪽에서 오른쪽으로 차곡차곡 채워진 트리이다.

- 전 이진 트리

    - 모든 노드의 자식 노드 개수가 0개 또는 2개인 트리이다.

  ```
  포화 이진 트리는 완전 이진 트리이자 전 이진 트리이다.
  ```

  
#### BST 연산

- 제거
  - 단말 노드인 경우: 해당 노드를 제거한다.
  - 자식 노드가 한개인 경우: 자식 노드를 해당 노드와 바꾼다.
  - 자식 노드가 두개인 경우: 왼쪽의 서브트리 중 가장 큰 값 또는 오른쪽 서브트리 중 최소값을 가진 노드와 현재 노드를 바꾼다.
  
- 삽입
  - 삽입될 데이터의 값이 현재 노드의 값보다 작고, 왼쪽 노드가 Null인 경우 왼쪽 트리에 삽입한다.
  - 삽입될 데이터의 값이 현재 노드의 값보다 크고, 오른쪽 노드가 Null인 경우 오른쪽 트리에 삽입한다.
  - 삽입될 위치의 노드가 Null이 아닌 경우 위의 과정을 재귀적으로 반복한다.

-

## Red-black tree

### 개념

- 노드의 개수가 동일할 때, depth를 최소화하여 시간 복잡도를 줄이고자 설계된 균형 잡힌 트리이다.
- 삽입, 삭제, 검색 연산을 O(logN)에 수행하도록 보장한다.

### 정의

1. 모든 노드는 빨간색 혹은 검은색이다.
2. 루트 노드는 검은색이다.
3. 리프노드는 검은색이다.
4. 빨간색 노드의 자식 노드는 항상 검은색이다.
5. 리프노드에서 루프노드까지 가는 경로에서 만나는 검은색 노드의 개수는 같다.

### 특징

- 루트 노드부터 단말 노드까지의 모든 경로 중 최소/최대의 차이가 2보다 크지 않다.
- 정의 4에 의해 레드노드는 연속될 수 없으므로 높이가 h인 블랙-높이는 h/2보다 크거나 같다.
- Java Collection의 `ArrayList`, `HashMap`의 `Separate Chaining`에서 Red-black tree를 사용한다.



### Rotation

- 삽입과 삭제 연산 시 레드블랙 트리의 조건을 만족하기 위하여 한 노드를 중심으로 모양을 조정하는 연산이다.
- 시간 복잡도는 O(1)이다.
- 이진 탐색트리의 특성을 유지한다.

![img](C:\Users\nsm\Documents\Interview\Images\[ds] Red-Black rotation)

#### Left rotation

- y = right[x] != NIL 이라고 가정

- 알고리즘

  - x와 y의 위치를 바꾼다.

  1. x의 자식노드를 y의 왼쪽노드로 만든다.
  2. y의 부모노드를 x의 부모노드로 만든다.

- 의사 코드

  1. x의 오른쪽 자식노드를 y에 저장한다.
  2. x의 오른쪽 자식노드를 b로 만든다.
    1. b의 부모노드를 x로 만든다.
  3. y의 부모노드를 x의 부모노드로 만든다.
    1. x가 루트라면 y를 루트로 만든다.
    2. x가 부모노드의 왼쪽 자식노드라면 y를 x의 부모노드의 왼쪽 자식노드로 만든다.
    3. x가 부모노드의 오른쪽 자식노드라면 y를 x의 부모노드의 오른쪽 자식노드로 만든다.
  4. x를 y의 왼쪽 자식노드로 만든다.
    1. y를 x의 부모노드로 만든다.

```pseudocode
LEFT-ROTATE(T, x)
01 y <- right[x]
02 right[x] <- left[y]
03 parent[left[y]] <- x
04 parent[y] <- parent[x]
05 if parent[x] = NIL
06 	then root[T] <- y
07 else if x = left[parent[x]]
08 	then left[parent[x]] <- y
09 else right[parent[x]] <- y
11 left[y] <- x
12 parent[x] <- y
```



#### Right rotation

- x = left[y] != NIL 이라고 가정
- 의사 코드
  1. y의 왼쪽 자식노드를 x에 저장한다.
  2. y의 왼쪽 자식노드를 b로 만든다.
    1. b의 부모노드를 y로 만든다.
  3. x의 부모노드를 y의 부모노드로 만든다.
    1. y가 루트라면 x를 루트로 만든다.
    2. y가 부모노드의 왼쪽 자식노드라면 x를 y의 부모노드의 왼쪽 자식노드로 만든다.
    3. y가 부모노드의 오른쪽 자식노드라면 x를 y의 부모노드의 오른쪽 자식노드로 만든다.
  4. y를 x의 오른쪽 자식노드로 만든다.
    1. x를 y의 부모노드로 만든다.



### 삽입

#### 의사 코드

1. 삽입할 값을 INSERT한다.
2. RN-INSERT_FIXUP을 호출한다.

```pseudocode
RB_INSERT(T, z)
01 y <- nil[T]				// y가 x의 한칸 뒤를 가리키게 한다.
02 x <- root[T]
03 while x != nil[T]		// z가 삽입될 위치를 찾는다.
04 	y <- x
05  if key[z] < key[x]
06 		then x <- left[x]
07 	else 
08 		then x <- right[x]
09 parent[z] <- y			// z의 부모노드를 y로 만든다. 
10 if y = nil[T]			// y가 루트일 경우 z를 루트로 만든다.
11  then root[T] <- z		// 
12 else if key[z] < key[y]	// z가 y보다 작을 경우 z를 y의 왼쪽노드로 만든다.
13 	then left[y] <- z		// 
14 else right[y] <- z		// z가 y보다 클 경우 z를 y의 오른쪽노드로 만든다.
15 
16 left[z] <- nil[T]		// z의 왼쪽 및 오른쪽 노드를 NULL로 만든다.
17 right[z] <- nil[T]		// (새로운 노드는 leaf 노드가 되기 때문)
18 color[z] <- RED			// z의 색을 빨간색으로 만든다.
19 RB-INSERT-FIXUP(T, z)	
// 노드 z의 부모노드가 RED이거나, 트리의 높이차가 2 이상일 경우 조건을 위배하므로 조정한다.
```



#### 조정

- 조건에 위배될 가능성이 있는 경우
  1. 각 노드는 red 혹은 black이다. (위배 가능성 없음)
  2. 모든 리프노드는 black이다.
    - z의 자식노드들을 NIL로 설정하므로 위배 가능성이 없다.
  3. **루트노드는 black이다.**
    - z가 루트노드일 경우 규칙을 위반한다.
      이 때는 루트노드를 검은색으로 바꾼다.
  4. **red 노드의 자식노드들은 전부 black이다.**
    - z의 부모노드가 red일 경우 규칙을 위반한다.
  5. 모든 노드에 대해서 리프노드에 이르는 경로들의 black 노드의 개수는 동일하다.
    - z가 red이기 때문에 규칙을 위반하지 않는다.

#### 문제

- z의 삼촌이 RED인 경우
  - 부모노드와 그 형제노드(D)를 BLACK으로 바꾸고 할아버지 노드를 RED로 바꾼다.
  - 할아버지 노드 C를 z로 설정한다.
  - z부터 루트노드까지 경로 상에 있는 노드들을 검증한다.

![img](https://github.com/namjunemy/TIL/raw/master/Algorithm/img/red_black_04.png?raw=true)

- z의 삼촌이 BLACK인 경우 (값이 존재하는 노드이거나 NULL인 경우)
  - z가 오른쪽 자식인 경우
    1. parent[z]를 기준으로 left-rotation한 뒤 parent[z]를 z로 만든다.
    2. 아래 z가 왼쪽 자식인 경우를 따른다.
  - z가 왼쪽 자식인 경우
    1. parent[parent[z]]를 기준으로 right-rotation 한다.
    2. parent[z]를 BLACK, parent[parent[z]]를 RED로 바꾼다.

![img](https://github.com/namjunemy/TIL/raw/master/Algorithm/img/red_black_05.png?raw=true)

##### 의사코드

```pseudocode
RB-INSERT-FIXUP(T, z)
01 while (color[p[z]] = RED)	// 규칙 4 검증.
02 	if (p[z] = left[p[p[z]]])
03  	then y <- right[p[p[z]]]
04      	 if (color[y] = RED)
05      	 	then color[p[z]] <- BLACK   >> CASE 1
06          	 	 color[y] <- BLACK      >> CASE 1
07               	 color[p[p[z]]] <- RED  >> CASE 1
08               	 z <- p[p[z]]           >> CASE 1
09 			 else if (z = right[p[z]])
10      	 	then z <- p[z]           	>> CASE 2
11          	 	 LEFT-ROTATE(T, z)   	>> CASE 2
12			 end if
13      	 color[p[z]] <- BLACK     	 	>> CASE 3
14      	 color[p[p[z]]] <- RED    	 	>> CASE 3
15      	 RIGHT-ROTATE(T, p[p[z]]) 		>> CASE 3
16 	else (same as then clause with "right" and "left" exchanged)
		 // z의 부모노드가 할아버지노드의 오른쪽 자식인 경우 15에서 LEFT-ROTATE 호출
17	end if
18 end while
19 color[root[T]] <- BLACK
```

![img](https://github.com/namjunemy/TIL/raw/master/Algorithm/img/red_black_06.png?raw=true)

### 삭제

#### 의사 코드

- 삭제할 노드를 제거한다.
  1. 삭제된 노드가 RED일 경우 종료한다.
  2. BLACK일 경우 RB-DELETE-FIXUP을 호출한다.
     (Black-height가 1 감소한 경로에 Black 노드가 추가되도록 rotation 하고 색깔을 조정한다.)

- pseudo code

  ```pseudocode
  RB-DELETE(T, z)		
  01 if left[z] = nil[T] or right[z] = nil[T]
  02   then y <- z
  03 else y <- TREE-SUCCESSOR(z) >> Successor: x보다 크면서 가장 작은 키를 가진 노드
  04 end if    
  05 if left[y] != nil[T]
  06   then x <- left[y]
  07 else 
  08 	 then x <- right[y]
  09 end if
  10
  12 p[x] <- p[y]
  13
  14 if p[y] = nil[T]
  15   then root[T] <- x
  16 else if y = left[p[y]]
  17   then left[p[y]] <- x
  18 else 
  19	 then right[p[y]] <- x
  20 end if
  21
  22 if y != z
  23   then key[z] <- key[y]
  24     copy y's satellite data into z
  25 end if  
  26 if color[y] = BLACK
  27   then RB-DELETE-FIXUP(T, x)
  28 end if
  29 return y    
  ```



#### 문제

1. x의 형제노드 w가 RED인 경우

  - 자식 노드가 NIL이 아닌 BLACK노드이다.

  1. w를 BLACK, p[x]를 RED로 바꾼다.
  2. p[x]에 대해서 left-rotation을 적용한다.
    - x의 새로운 형제노드는 원래 w의 자식노드이다.
    - 새로운 w 노드는 black노드이다. (case 2, 3, 4로 이동)

  - Case 1의 경우 x의 부모노드에 대해서 left-rotation을 적용하면,
    새로운 w노드가 black이 되므로 Case 2, 3, 4를 적용한다.

   ![img](https://github.com/namjunemy/TIL/raw/master/Algorithm/img/red_black_07.png?raw=true)

2. w는 BLACK, w의 자식들도 BLACK인 경우

  - 부모 노드 B가 RED일 수도 있고 BLACK일 수도 있다.
  - x와 w로부터 BLACK 노드를 하나씩 뺏어서 부모노드에게 준다.



##### 의사 코드

```pseudocode
RB-DELETE-FIXUP(T, x)
01 while x != root[T] and color[x] = BLACK
02   do if x = left[p[x]]
03        then w <- right[p[x]] 
04          if color[w] = RED
05            then color[w] <- BLACK                                  // Case1
06                 color[p[x]] <- RED                                 // Case1
07                 LEFT-ROTATE(T, p[x])                               // Case1
08                 w <- right[p[x]]                                   // Case1
09          if color[left[w]] = BLACK and color[right[w]] = BLACK
10            then color[w] <- RED                                    // Case2
11                 x <- p[x]                                          // Case2
12          else if color[right[w]] = BLACK 
13              then color[left[w]] <- BLACK                          // Case3
14                   color[w] <- RED                                  // Case3
15                   RIGHT-ROTATE(T, w)                               // Case3
16                   w <- right[p[x]]                                 // Case3
17            color[w] <- color[p[x]]                                 // Case4
18            color[p[x]] <- BLACK                                    // Case4
19            color[right[w]] <- BLACK                                // Case4
20            LEFT-ROTATE(T, p[x])                                    // Case4
21            x <- root[T]                                            // Case4
22        else (same as then clause with "right" and "left" exchanged)
23 color[x] <- BLACK
```

![img](https://github.com/namjunemy/TIL/raw/master/Algorithm/img/red_black_12.png?raw=true)



## B-tree

![B트리](https://github.com/boostcamp-ai-tech-4/ai-tech-interview/raw/main/images/penguin/b-tree.png)

### B-tree

#### 개념

- 데이터베이스, 파일 시스템에서 널리 사용되는 트리 자료구조의 일종이다.
- 이진 트리를 확장해서 더 많은 수의 자식을 가지면서 모든 경로의 길이가 동일한 균형 잡힌 트리이다.
  차수가 N이면 N차 B트리라고 부른다.

#### 조건

1. 노드의 Key가 N개이면 자식의 수는 N+1이다.

2. 각 노드의 Key는 오름차순으로 정렬되어야 한다.

3. 루트 노드는 적어도 2개 이상의 자식 노드를 가져야 한다.

4. 루트 노드를 제외한 모든 노드는 적이도 M/2 개의 Key를 가져야 한다.

   > M: B-트리의 차수

5. 리프 노드는 모두 같은 레벨에 있어야 한다.

6. 저장된 자료는 중복될 수 없다.

#### 특징

- 최악의 경우에도 O(logN)의 성능을 가진다.



#### 연산 [[링크](https://velog.io/@emplam27/자료구조-그림으로-알아보는-B-Tree)]

- 검색

  - 루트노드에서 시작하는 하향식 검색을 수행한다.

  1. 루트 노드에서 Key를 순회한다.
    1. x와 같은 key를 찾았다면 검색을 종료한다.
    2. x와 key의 대소관계를 비교한 뒤 관계를 만족하는 key 사이의 자식노드를 순회한다.
  2. 1의 과정을 리프노드에 도달할 때까지 반복한다.

- 삽입

  - 요소 삽입에 적절한 리프 노드를 검색하고 **필요한 경우 노드를 분할**한다.
    위치 검색은 **하향식**, 분할은 **상향식**으로 수행된다.

  1. 트리가 비어있으면 루트 노드를 할당하고 x를 삽입한다.
     루트 노드가 가득 찼다면 노드를 분할하고 리프 노드를 생성한다.

  2. 삽입할 위치를 검색연산과 동일한 방법으로 찾는다.

  3. 분할이 발생하지 않은 경우

    1. 리프노드에 삽입할 수 있다면 오름차순을 만족하는 위치에 x를 삽입한다.

  4. 분할이 발생한 경우

    1. 중앙값에서 분할을 수행한다. 이 때, 중앙값은 부모 노드로 병합되거나 새로 생성된다.

       > 왼쪽 키들은 왼쪽 자식으로, 오른쪽 키들은 오른쪽 자식으로 분할된다.

    2. 부모 노드부터 루트 노드까지 1을 반복수행한다.

- 제거

  - key를 삭제하기 위해서 다음과 같은 과정을 수행한다.

    1. 삭제할 키가 있는 노드를 검색한다.
    2. 키를 삭제한다.
    3. 필요한 경우 트리를 조정한다.

  - 삭제할 key가 단말 노드일 경우

    1. 현재 노드의 차수가 1보다 크다면 해당 key를 제거한다.

    2. 현재 노드의 차수가 1이면서 형제의 차수가 1보다 클 경우

      1. 현재 노드의 key를 부모 노드의 key로 대체한다.

      2. 부모 노드의 자식 노드 중 하나를 부모 노드로 바꾼다.

         > 왼쪽 노드일 경우 큰 값으로, 오른쪽 노드일 경우 작은 값으로 바꾼다.

    3. 형제의 차수가 1이고 부모 노드의 차수가 1보다 클 경우

      - x를 삭제한 후 부모 노드의 key를 형제 노드와 병합한다.

    4. 자신과 형제, 부모노드가 1개일 경우

      - 트리의 높이가 줄어들기 때문에 트리의 재구조화를 수행한다. (Case 3-2 수행)

  - 삭제할 key가 비단말 노드이면서 자신이나 자식 노드의 키가 최소 키수보다 많을 경우

    1. 현재 노드의 `inorder predecessor` 또는 `inorder successor`와 x의 자리를 바꾼다.

       > `inorder predecesse` : 노드의 **왼쪽 자손**에서 가장 **큰 key**
       >
       > `inorder successor` : 노드의 **오른쪽 자손**에서 가장 **작은 key**

    2. k가 리프노드가 되므로 해당되는 Case 1로 이동한 뒤 삭제연산을 수행한다.

  - 삭제할 key가 비단말 노드이면서 자신과 자식 노드의 key의 수가 최소 개수일 경우

    x를 삭제하면 트리의 높이가 줄어들어 재구조화가 발생한다.

    1. x를 삭제하고 x의 양쪽 자식을 병합하여 하나의 노드로 만든다.
    2. x의 부모 key를 x의 형제 노드와 병합한다.
    3. 병합한 1의 노드를 자식노드로 만든다.
    4. 부모 노드의 개수에 따라 다음 과정을 수행한다.
      1. 형제 노드의 key가 최대 key 수를 초과한다면 삽입 연산의 노드 분할 과정을 수행한다.
      2. 트리의 균형이 깨졌을 경우, x의 부모 노드에 대하여 2부터 다시 수행한다.

### B+tree

#### 개념

- 데이터의 빠른 접근을 위해 인덱스 역할만 하는 비단말 노드를 가지고 있는 B-Tree의 변형이다.
  데이터는 리프노드에만 저장된다.
- Index 부분과 단말 노드로 구성된 순차 데이터 부분으로 이루어져있다.
  Index의 key 값은 단말에 있는 key 값을 직접 찾아가는데 사용한다.

> B-Tree의 각 노드는 디스크의 블록과 같기 때문에 노드 하나를 접근하는 것은 디스크를 한번 더 접근하는 것을 의미한다. 그러므로 보다 **적은 수의 노드를 생성하는 것이 색인구조의 성능을 높일 수 있다.** **생성되는 노드의 수를 줄이기 위해** B-Tree의 변형으로 B* 트리가 나오게 되었다.
>
> B-Tree는 특성을 유지하기 위해 삽입과정에서의 분열과 삭제 과정에서의 합병 등의 보조 연산이 필요하다. B* Tree에서는 이런 **보조 연산을 가급적 지연시켜 회수를 감소**시키려 했다.
>
>[[링크](https://wangin9.tistory.com/entry/B-tree-B-tree)]



#### 조건

1. Root 노드를 제외한 모든 노드는 2/3 이상 채워져야 한다. (B-tree는 1/2 이상)

2. 노드가 정해진 차수를 벗어나면 이웃한 형제 노드로 재배치를 한다.

   >  노드의 분열 횟수를 줄여서 보조 연산을 줄이고자 하기 때문이다.
   >
   >  재배치는 부모노드+해당노드+형제노드의 key들을 나열한 뒤, 중간 key 값을 부모 노드로 보내고 남은 key들을 반분하여 해당노드와 형제노드에 배치하는 행동이다

3. 어떤 노드 및 그 노드의 인접 노드들이 가득찰때까지 분열을 지연한다.



#### 연산

- 삽입

  - B-tree와 같은 방법으로 삽입한다.
  - 노드가 가득차면 이웃한 형제 노드들 중 빈 노드에 삽입한다.
  - 인접 노드에 빈 자리가 없을 경우 가득찬 두 노드를 분열하여 2/3정도만 채워진 3개의 노드로 만든다. (이 때 재배치는 2번 일어난다.)

- 삭제

  - B-tree와 같은 방법으로 삭제한다.
  - Key의 개수가 모자르면 형제 노드로부터 재배치하고 재배치 할 수 없는 경우 병합한다.
    이 때, 세 개의 노드를 두 개의 노드로 병합한다.

  1. 재배치와 병합이 발생하지 않을 때는 단말 노드에서만 삭제한다.
  2. Index 부분은 다른 key값을 찾는데 사용될 수 있으므로 삭제하지 않는다.
  3. 재배치할 경우 Index 노드의 key값은 변하지만 tree의 구조는 변하지 않는다.
  4. 합병할 경우 Index 노드의 key값을 삭제한다.



#### 장점

1. 블럭 사이즈를 효율적으로 이용할 수 있다.
   Key 값에 대한 하드디스크 주소가 없기 때문이다.
2. 단말 노드끼리 연결리스트로 연결되어 있어서 범위 탐색에 유리하다.

#### 단점

- B-tree의 경우 최상 케이스에서는 루트노드에서 종료될 수 있지만
  B+tree는  항상 단말노드까지 탐색해야한다.