# StringBuilder

* Language : Java
* IDE : intellij IDEA
* 날짜 : 20.05.03

## Description

string은 새로운 값을 할당할 때마다 새로 생성되기 때문에 stack에 쌓이고 클래스들은 GC가 호출되기 전까지 heap에 지속적으로 쌓이게 된다. 메모리 관리 측면에서 치명적이라고 볼 수 있다.    이럴 때 용이하게 사용하기 위해서 있는 것이 StringBuilder이다. 

문자열 연산이 자주 있을 때는 String보다 StringBuilder를 사용하면 좋다.  
(단, 멀티 스레드 환경에서는 StringBuffer를 권장한다.  StringBuilder는 동기화를 보장하지 않는다.)

<br>
<br>

### append 

StringBuilder의 꽃은 append가 아닐까 싶다.  StringBuilder는  +연산을  빠르게 해결할 수 있다.  반면에, String은 + 연산이 16만 번 이상 넘어가면 10초이상 걸린다.  