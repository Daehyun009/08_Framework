package com.kh.test.customer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.kh.test.customer.dto.Customer;
import com.kh.test.customer.service.CustomerService;

@Controller
@RequestMapping("customer")
public class CustomerController {

  @Autowired 
  private CustomerService service;

  @PostMapping("insertCustomer") 
  public String insertCustomer(Customer customer, Model model) {
    int result = service.insertCustomer(customer);

    
    if (result > 0)
      model.addAttribute("message", "추가 성공!!!");
    else
      model.addAttribute("message", "추가 실패...");

    return "result"; 
  }
}


/*
 * 프로젝트 설정 기본 세팅
 * 
 * dbeaver에서 계정 설정 및 테이블 만들기
 * 
 * 이전 파일에서 복사 src/main/resources 폴더
 * 
 * application.properties - 로깅 레벨 주소 수정 config.proproperties - properties utf-8로
 * - 계정명, 비밀번호 수정 mybatis-config-xml
 * 
 * resources폴더 안에 새폴더 mappers 만들기
 * 
 * ----------------------------------------------------- src/main/java 폴더
 * 
 * edu.kh.project.common.config 패키지 만들기 DBConfig 파일 복사해오기 75번줄 별칭 관련 주소
 * (edu.kh.project)로 수정
 * 
 * 여기까지하고 서버 켜서 열리나 확인(페이지가 없으면 404가 뜨는게 맞음)
 * 
 * Spring Security 자동 설정을 실행 시 포함하지 않기 위해(쓸때도있고 안할때도 있음) BoardProjectApplication
 * 어노테이선
 * 
 * @SpringBootApplication( exclude = {SecurityAutoConfiguration.class}) 으로 수정
 * 
 * controller 만들기 -> @Controller 추가 패키지 : edu.kh.project.main.controller 이름 :
 * MainController Main Controller class안에
 * 
 * @RequestMapping("/") // "/" 요청 매핑(method 가리지 않음) public String mainPage() {
 * return "common/main"; } -----------------------------------------------------
 * VSCode로 넘어가서 src/main/resources/templates에 common 폴더 안에 header, footer,
 * common.html 파일 생성 main.html 먼저 작성
 * 
 * static 폴더 안에 css,js,images 폴더 만든 뒤 폴더 안에 파일 만들기
 * 
 * resoureces 폴더에 messages.properties 파일 만들기 해당 파일 내에 할 것 하기
 * 
 * -----------------------------------------------------
 * 
 * edu.kh.project 고정
 * 
 * member.controller 패키지 안에 MemberController 클래스
 * 
 * member.service 패키지 안에 MemberService 인터페이스 MemberServiceImpl 클래스
 * 
 * member.mapper 패키지 안에 MemberMapper 인터페이스
 * 
 * member.dto 패키지 안에 Member 클래스
 * 
 * /resources/mappers 폴더 안에 member-mapper.xml xml 파일로 만들고 만들때 selectDTD or XML
 * Schema File -> user specified entries 에서 mapper 선택
 * 
 * 같이 파일 및 패키지 만들기
 * 
 * -----------------------------------------------------
 * 
 * DTO 먼저 작성(lombok적용 등)
 * 
 * mappers. -mapper.xml에 연결할 Mapper 작성 예시) <mapper
 * namespace="edu.kh.project.member.mapper.MemberMapper"> 그러고 해당 Mapper 파일
 * class명 위에 @Mapper 어노테이션 추가
 * 
 * ServiceImpl 클래스명 뒤에 implements Service명 추가 + @Service 어노테이션, + @Autowired
 * private MemberMapper mapper;
 * 
 * Controller 클래스
 * 
 * @Controller, @RequestMapping("/member ") (/member로 시작하는 요청 매핑), @Slf4j 어노테이션
 * 추가 + class 내부에 @Autowired private MemberService service; 추가
 * 
 * 

 * -----------------------------------------------------
 * 
 * controller에서 가져올 기능들 뚝딱뚝딱하기 만들면서 log.debug사용해서 로그로 확인해보기!
 */
