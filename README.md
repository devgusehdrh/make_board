# make_boards
## 게시판 만들기 과제
### 애로사항
1. RESTContoller Annotation을 사용 -> JSON 형식으로 반환 -> 다른 페이지 출력 하는 부분에서 시간을 오래 소요했다.
  - ModelAndView 라는 객체 사용
  - thymeleaf 사용
2. JPA cascade ondelete 기능 사용해서 게시물 삭제시 관련 댓글들 함께 삭제해주려고 했는데, 객체 인식이 안되서 결국 실패
3. 댓글 id와 포스트 id의 값이 공유되서 증가하여 GenerationType.IDENTITY로 해결
