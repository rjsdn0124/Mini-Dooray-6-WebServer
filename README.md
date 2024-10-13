# Mini-Dooray-6-Task
미니 두

## Rules
- 코드 컨벤션 지키기
- 커밋 내용 알아듣게 적고 커밋 좀 최대한 작게 하기
- 객체가 단수면 엔티티 명 그대로. 복수면 엔티티명 뒤에 s 붙이기 (복수형으로).
- URL 작성 방식 GET/POST/DELETE/PUT/PATCH
  - METHOD /api/{도메인 이름}/{id?}?field={key}
  - GET /api/projects/1
  - GET /api/task/1
  - GET /api/tasks/projects/1
  - POST /api/task
- 브랜치 전략<br/>
main<br/>
&nbsp;&nbsp;&nbsp;&nbsp;ㄴdevelop<br/>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;ㄴfeature/{기능 이름}<br/>

기능 완성 시 develop으로 pull request 후 merge 입니당

## erd
![image](https://github.com/user-attachments/assets/07b872ee-0657-4218-9e16-f43400fee07e)

## api 문서
api 문서는 각 서버에서 swagger 페이지로 확인할 수 있습니다.
- http://localhost:8081/swagger-ui/index.html#/
- http://localhost:8082/swagger-ui/index.html#/
