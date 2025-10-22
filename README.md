# java-racingcar-precourse
-------------------
## 입력값 검증
1. 자동차 이름은 최대 5개까지 입력 가능하게 했습니다.(1개 입력 X)
2. 영어만 입력 가능하게 했습니다.(대소문자 상관X)
3. 차이름은 중복은 안되게 했습니다.
4. 경기 횟수도 최대 5번까지만 가능하게 했습니다.(음수 X)  

-----------------
## 패키지 구조
```
src<br>
│<br>
├─ main<br>
│   └─ java
│     └─ racingcar
│        ├─ config
│        │   └─ Appconfig # 앱의 의존성 주입 작업을 시행합니다
│        ├─ controller
│        │   ├─ RaceController  # 뷰와 서비스, Validators등을 사용하는 컨트롤러입니다    
│        │   └─ View
│        │     ├─ RaceViewImpl # 뷰를 담당합니다
│        │     └─ RaceView 
│        ├─ entity
│        │   └─ GameRules # Validators에서 사용할 Pattern객체들을 가지고 있는 유틸 클래스입니다.
│        ├─ pattern
│        │   └─ Car # 자동차 객체입니다.이름과 이동 전략을 의존성 주입 받으며 위치의 경우 0으로 초기화 시켜줍니다.
│        ├─ repository
│        │   ├─ CarRepository
│        │   └─ Repository # Car 객체들을 저장하고 관리해주는 레포지토리입니다.
│        ├─ service
│        │   ├─ RaceService
│        │   └─ RaceServiceImpl # 여러가지 요구사항들을 시행하는 서비스 클래스입니다.
│        ├─ strategy
│        │   ├─ MovementStrategy
│        │   └─ RandomMovementStrategy # 요구사항과 같은 이동전략입니다. 테스트때 단위테스트의 용이함을 위해 전략패턴을 적용하였습니다.
│        ├─ validate
│        │   ├─ Validators
│        │   └─ ValidatorsImpl # 사용자 입력값을 검증하는 역할을 합니다.
│        └─ Application # 앱의 시작점입니다.
│
└─  test
   └─ java
     └─ racingcar
        ├─ service 
        │   ├─ FakeCarRepository # 서비스 단위 테스트시 사용하는 레포지토리입니다.
        │   ├─ FakeMovementStrategy # 자동차가 랜덤이 아닌 사용자가 주입한 boolean값에 따라 무조건 움직이거나 가만히 있게 합니다.
        │   ├─ FakeValidators # 서비스 단위테스트에 사용할 아무 기능이 없는 가짜 Validators입니다.
        │   └─ RaceServiceImplTest # 위의 가짜 혹은 테스트용 클래스들을 의존성 주입받아 RaceServiceImpl 단위테스트를 진행합니다.
        ├─ validate
        │   └─ ValidatorsImplTest # ValidatorsImpl 단위 테스트를 담당합니다.
        └─ ApplicationTest # 통합 테스트를 담당합니다.

```
-------------------

## 도전 내용
1. main을 깔끔하게 하고 싶어서 의존성 주입은 AppConfig에서 처리하였습니다.  
2. Controller,Service,repository 패턴을 사용해보았습니다.  

-------------------
## 리뷰 요청사항
1. 제가 스트림이 익숙치 않아 for문을 자주 사용하였는데 스트림으로 하면 어땠을까 하는 부분들 찝어주시면 감사하겠습니다.
2. 레포지토리에서 Car를 ArrayList로 관리하게하였습니다. 고민하던게 List랑 Queue였는데 List를 사용했습니다. 사유로는
- 중간에 값 수정이 없고 추가되는거만 있기에(여기서 Queue->LinkedList를 고민하였습니다)
- 경기 진행과정을 보여줄려면 순회해야하기 때문에 연결노드 주소값을 찾아야하는 LinkedList보단 ArrayList가 낫지 않나 생각이 들었습니다.
  - 허나 마지막에 우승자를 보여주려 할때는 Queue로 Poll하는게 if문 for문등이 필요 없을거같아서 getWinners에서는 Queue를 반환하게 하였습니다.
과연 가장 옳바른(코드에 정답은 없다지만) 선택이였을까 궁금합니다.(그 외에도 더 좋은 자료구조가 있었다면 추천 부탁드립니다!)      
3. 검증로직을 어디에 넣는게 제일 나을까요? 컨트롤러? 서비스?   
4. 네이밍과 패키지 분리 그리고 코드 흐름이 읽기 쉬운지 메서드들을 찾기 쉬운지 평가해주시면 감사하겠습니다!   
5. 기타 모든 리뷰 전부 감사합니다!
