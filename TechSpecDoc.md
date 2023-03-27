# 테크 스펙

- 작성자: 이은택
- 서비스명: 머핀 플러스
- 작성일: 2023년 03월 27일

## 요약 ( Summary )

- 사용자가 예약 가능한 머핀 전기차 충전소를 조회하고 예약, 변경, 삭제하는 간단한 시스템을 구현합니다.

## 배경  ( Background )

- 머핀 플러스에 가입한 사용자는 여러 혜택을 누릴 수 있습니다.
- 그 중 SK 에너지에서 제공하는 머핀 충전소의 예약 시스템 혜택입니다.
- 예약 시스템은 기본적인 기능이지만 모든 충전소에서 가능한 건 아니고 별도로 머핀 플러스 사용자가 예약할 수 있는 충전서가 지정되어 있어 일반 사용자 보다 원활하게 사용할 수 있습니다.
## 목표 ( Goals )

- 요구사항에 맞춰 SK에너지 머핀 EV 예약 시스템을 구현합니다.
- 예약 시 발생할 수 있는 동시성 문제를 해결합니다.

### 요구사항
* 모든 사용자는 머핀 충전소를 조회할 수 있습니다.
  * 예약이 가능한 충전소만 별도로 조회할 수 있습니다.
  * 사용이 가능한 충전소만 별도로 조회할 수 있습니다.
* 머핀 플러스 사용자는 충전소를 예약 할 수 있습니다.
* 머핀 플러스 사용자는 충전소를 예약 변경할 수 있습니다.
* 머핀 플러스 사용자는 충전소를 예약 취소할 수 있습니다.

### 예약 시스템 API Doc

    ```
    HOST - **http://localhost:8080/api**
    
    # 충전소 목록 조회 API
    
    Method: GET
    Path: /charging-station
    QueryString
    - zcode?: (시도코드): "11"
    - zscode?: (지역구분 코드): "116600"
    - name?: (충전소명): "1"
    - status?: (상태): 0
    - chger_type?: (충전타입):2
    - limit?: (제한 갯수): default 20
    - next_id?: (다음 아이템 ID)
    
    Response
    - 200 OK
    {
       "total_count":2,
       "next_id":2,
       "item_list":[
          {
             "id":2,
             "name":"머핀1호점",
             "status":1,
             "chger_type":2,
             "zcode":11,
             "zscode":116000
          },
          {
             "id":2,
             "name":"머핀플러스점",
             "status":0,
             "chger_type":2,
             "zcode":22,
             "zscode":225000
          }
       ]
    }
    
    - 200 OK (검색 조건에 해당하는 값이 없을 경우)
    
    {
       "total_count":0,
       "next_id":null,
       "item_list":[]
    }
    
    - 400 { "code": "RESERVATION_ERROR_100", "message": "잘못된 정보" }
    - 500 { "code": "RESERVATION_ERROR_999", "message": "일시적으로 사용 불가" }
    
    # 충전소 상세 조회 API
    
    Method: GET
    Path: /charging-station/:charging_station_id
    Parameter
    - charging_station_id(충전소 ID): 1
    
    Response
    - 200 OK
    {
          "id":2,
          "name":"머핀플러스점",
          "status":0,
          "chger_type":2,
          "zcode":22,
          "zscode":225000
    }
    
    # 예약 API
    
    Method: POST 
    Path: user/:user_id/charging-station/:charging_station_id
    Parameter
    - user_id(유저ID): 1
    
    Body
    - start_at (예약 시작 일시)
    - end_at (예약 종료 일시)
    
    Response
    - 200 OK
    { 
    "reservation_id": 12345678,
     }
    
    - 400 { "code": "RESERVATION_ERROR_100", "message": "잘못된 정보" }
    - 500 { "code": "RESERVATION_ERROR_999", "message": "일시적으로 사용 불가" }
    
    # 예약 수정 API
    
    Method: PUT
    Path: user/:user_id/charging-station/:charging_station_id
    Parameter
    - user_id(사용자ID): 1
    - charging_station_id(충전소ID): 1
    
    Body
    - start_at (예약 시작 일시)
    - end_at (예약 종료 일시)
    
    Response
    - 200 OK
    { 
    "result" : true
     }
    
    - 400 { "code": "RESERVATION_ERROR_100", "message": "잘못된 정보" }
    - 500 { "code": "RESERVATION_ERROR_999", "message": "일시적으로 사용 불가" }
    
    # 예약 삭제 API
    
    Method: DELETE
    Path: user/:user_id/charging-station/:charging_station_id
    Parameter
    - charging_station_id(충전소 ID): 1
    
    Response
    - 200 OK
      {
        "result": "SUCCESS",
      }
    
    - 400 { "code": "RESERVATION_ERROR_100", "message": "잘못된 정보" }
    - 500 { "code": "RESERVATION_ERROR_999", "message": "일시적으로 사용 불가" }
    
    ```
  
## 목표가 아닌 것 ( Non-golas )

- 사용자 가입에 대한 기능은 포함하지 않으며 별도의 더미 데이터로 제공합니다.
- 향후 SK에너지의 머핀 충전소 확장을 고려하여 충전소 로직에 대한 부분은 포함하지 않으며 더미 충전소 데이터를 제공합니다.

## 계획 ( Plan )

<aside>
🚧 Sequence Diagram Editor: [https://mermaid.live/edit](https://mermaid.live/edit)

</aside>

-

## 보안, 개인정보, 리스크 ( Security, Privacy, Risks )

-

## 이외 고려사항들 ( Other Considerations )

-

## 마일스톤 ( Milestones )

- 기능 구현: 2023-03-23 - 

## 질문 ( Open Questions )