Mekki
=======
## 소비데이터 기반의 식비 가계부 서비스

* 작업 기간 : 23.06.20~23.07.13

* 작업 인원 : FE 2명 BE 3명 총 5명

* 프로젝트 목적 : 재미있는 게임을 즐기면서 작성하는 식비 가계부

* PPT : <https://www.canva.com/design/DAFobN_K6uM/-hhAlN0reLFECmJTFmla-g/edit?utm_content=DAFobN_K6uM&utm_campaign=designshare&utm_medium=link2&utm_source=sharebutton>

* Mekki : <https://web-food-roulette-rt92alkjme1ys.sel4.cloudtype.app/> 



### Mekki는 이런 기능이 있어요!
1. 룰렛 게임으로 재미있는 메뉴선정
2. 메뉴 선정시 자동가계부 입력
3. 별점 작성으로 나의 메뉴 취향파악
4. 소비 목표를 설정및 관리로 절약 소비습관 도움
5. 매달 소비 내역을 기록하여 월간 소비 패턴 분석

### ERD
![image](https://github.com/Minzion0/food_roulette/assets/130621431/e02e5a1d-9703-4275-ae4b-9bd4ae726320)

p_user : 유저 이름만 저장한다

p_management : 유저의 월별 절약 목표와 총 소비 금액을 저장한다

p_payment : 유저의 소비 내역 등(음식이름 ,가격,식당이름,별점 )을 저장한다

p_user_menu : 유저 마다 각자의 고유한추가한 커스텀 메뉴들을 저장한다

p_common_menu : 모든 유저들이 볼수있는 공통의 기본 메뉴들을 저장한다

p_tag :메뉴와 연결될 테그를 저장한다

p_tag_menu : 테그에 소속된 메뉴를 저장한다


## 시연 연상

![Mekki - Chrome 2023-07-12 11-57-47 (1)](https://github.com/Minzion0/food_roulette/assets/130621431/d0f8657f-87c6-4ce9-8e13-f36b8a32c533)
