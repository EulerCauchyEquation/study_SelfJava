# String class

* Language : Java
* IDE : intellij IDEA
* 날짜 : 20.05.03

## Description

String class

string instance는 한 번 생성되면 그 값을 읽기만 할 수 있다.  이것을 불변 객체(immutable object)라고 하는데, 대표적인 immutable pattern의 예시이다. 

```
private final char[] value; 
```

String은 char형 배열로 element를 가지고 있는데, final로 선언돼있고, 다른 메소드들을 보면 return을 new String형태로 반환한다.  이를 보면 읽기만 가능한 형태임을 알 수 있다.  즉, 덧셈 연산자를 이용한 문자열 결합이나 문자열 수정은 변경이 아닌 새로운 String Instance를 생성한다.

<br>
<br>

### String constant pool

string은 생성 방식은 두 가지가 있다.

---
1. new 연산자를 이용한 방식<br>
2. 리터럴을 이용한 방식
---

new 연산자는 Heap영역에 존재하게 되고 리터럴을 이용한 경우 String constant pool이라는 영역에 포함한다.  

```
String a = "Hello";
String b = "Hello";
String c = new String("Hello");
System.out.println(a==b);  //true
System.out.println(a==c);  //false
```


* a는 string pool에 포함된다.
* b는 이미 string pool에 존재하므로 같은 값을 참조한다.
* c는 heap영역에 생성된다. (string pool이 아닌 다른 곳, string pool도 heap 영역에 있음)



이렇게 String pool이 있는 이유는 무분별하게 생겨나는 String 객체를 줄이기 위함이다.  

<br>
<br>

### lmmutable 

string을 immutable object로 만든 이유는 여러가지가 있다.

```
1. 보안 이슈
2. multi-thread 환경에서 안전(thread-safe)
3. Runtime에서heap 영역 메모리 절약
```

1. String이 immutable하지 않다면, 보안상 문제가 될 수 있다.  DB의 username, password 라던가 통신에서 host와 port가 string 다루어지므로, 불변이어야 해커의 공격을 예방할 수 있다.

2. String은 immutable하기 때문에, multi-thread환경에서 안전하다. 불변이므로 동기화 문제를 걱정하지 않아도 된다.

3. String은 string constant pool에서 관리를 한다.  같은 string은 같은 메모리를 참조하므로, heap영역에서 많은 메모리를 절약할 수 있다.  이는 string이 불변이기 때문에 string pool이 존재한다.

4. 추가로, string은 hashCode를 생성 단계에서부터 캐싱한다. 따라서, String의 hashCdoe는 쓰일 때마다 매번 계산 되지 않는다. 이 특징은 HashMap의 key로 사용 시 효과를 발휘한다. 다른 객체로 key를 사용하는 것보다 더 빠른 속도로 사용할 수 있다.

<br>
<br>

### String Method

기본적으로 덧셈 연산자나 병합, replace, substring 등 String 수정은 새로운 문자열로 반환한다.

<br>

#### indexOf,  startsWith

sub string을 찾는 방법이 2가지가 있다.  
```
1. indexOf
- 서브 문자열이 매치되는 첫번째 index를 찾아준다.
- 전형적인 완전 탐색 방식을 사용한다. 따라서, time - complexity는 O(MN)이다.
2. startsWith
- 서브 문자열이 문자열의 접두사에 포함하는지 체크하는 함수다.
- 이 또한, 완전 탐색 방식이지만, 한 번만 서칭하므로 time - complexity는 O(N)이다.
```

indexOf는 생각보다 시간 복잡도가 높으므로, 가능하다면 startsWith를 사용한다.   kmp 알고리즘을 사용하면 O(N+M)으로 줄일 수 있는데, 완전 탐색을 사용한 이유를 모르겠다.

