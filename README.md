# java-lotto-precourse

간단한 로또 발매기를 구현한다.

## 📝기능 구현 목록

## 로또 구입 금액을 입력받는 기능

- [ ] `구입금액을 입력해 주세요.`를 출력한다.
    - [ ] 구입금액을 입력받는다.
    - [ ] 1,000원으로 나누어 떨어지지 않는 경우 예외 처리한다.

## 로또를 발행하고 출력하는 기능

- [ ] 구입한 금액만큼 로또를 발행한다. (로또 1장의 가격은 1,000원)
- [ ] 발행한 로또 수량 및 번호를 출력한다.
    - [ ] 로또 번호는 오름차순으로 정렬하여 보여준다.

## 당첨번호와 보너스 번호를 입력하는 기능

- [ ] `당첨 번호를 입력해 주세요.`를 출력한다.
    - [ ] 1 ~ 45 범위의 중복되지 않는 숫자 6개를 입력받는다.
- [ ] `보너스 번호를 입력해 주세요.`를 출력한다.
    - [ ] 당첨번호와 중복되지 않는 1 ~ 45 범위의 숫자 1개를 입력받는다.

## 발행한 로또와 당첨번호 및 보너스 번호를 비교하여 당첨 내역 및 수익률을 산출하는 기능

- [ ] 사용자가 구매한 로또 번호와 당첨 번호를 비교하여 당첨 내역 및 수익률을 산출한다.
- [ ] 당첨 내역 및 수익률을 출력한다.
- [ ] 당첨 기준과 수익 금액은 다음과 같다.

```
- 1등: 6개 번호 일치 / 2,000,000,000원
- 2등: 5개 번호 + 보너스 번호 일치 / 30,000,000원
- 3등: 5개 번호 일치 / 1,500,000원
- 4등: 4개 번호 일치 / 50,000원
- 5등: 3개 번호 일치 / 5,000원
```

## 그 외 요구사항

- [ ] 사용자가 잘못된 값을 입력할 경우 IllegalArgumentException 을 발생시키고, "[ERROR]"로 시작하는 에러 메시지를 출력 후 그 부분부터 입력을 다시 받는다.
- [ ] Random 값 추출은`camp.nextstep.edu.missionutils.Randoms`의`pickUniqueNumbersInRange()`를 활용한다.
  (Randoms.pickUniqueNumbersInRange(1, 45, 6);)
- [ ] 사용자가 입력하는 값은`camp.nextstep.edu.missionutils.Console`의`readLine()`을 활용한다.
- [ ] Lotto에 numbers 이외의 필드(인스턴스 변수)를 추가할 수 없다.
- [ ] numbers의 접근 제어자인 private은 변경할 수 없다.

실행 결과 예시

```
구입금액을 입력해 주세요.
8000

8개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[1, 3, 5, 14, 22, 45]

당첨 번호를 입력해 주세요.
1,2,3,4,5,6

보너스 번호를 입력해 주세요.
7

당첨 통계
---
3개 일치 (5,000원) - 1개
4개 일치 (50,000원) - 0개
5개 일치 (1,500,000원) - 0개
5개 일치, 보너스 볼 일치 (30,000,000원) - 0개
6개 일치 (2,000,000,000원) - 0개
총 수익률은 62.5%입니다.

```