package com.spring.mvc.chap04.controller;

import com.spring.mvc.chap04.entity.Score;
import com.spring.mvc.chap04.repository.ScoreRepository;
import com.spring.mvc.chap04.repository.ScoreRepositoryImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/*
    학생의 성적정보를 조회하고
    등록하고, 삭제할 수 있는 시스템을 만들어 보겠습니다.

    요청 URL 종류

    1. 학생 성적정보 등록화면을 보여주고, 성적정보 목록조회 처리
    /score/list : GET방식(DB변경 없음)
    2. 성적정보 등록 처리 요청
    /score/register : POST방식(DB변경 생김)
    3. 성적정보 삭제 요청
    /score/remove : POST방식(DB변경 생김)
    4. 성적정보 상세 요청
    /score/detail : GET방식(DB변경 없음)
 */

@Controller
@RequestMapping("score")
//@AllArgsConstructor // 모든 필드를 초기화해주는 롬복 생성자 어노테이션
@RequiredArgsConstructor // final 필드에 대해서 초기화 하는 생성자
public class ScoreController {

    // repository 기능을 이용해 데이터를 가져와야 화면에 요청 데이터를 양식에 맞춰서 전달할 수 있음.
    @Autowired
    private final ScoreRepository repository;
    // 스프링 4.0 이후로 생성자가 하나인 경우에는 어노테이션 없이 자동주입


    // 1. 성적등록화면 띄우기 + 정보목록조회
    @RequestMapping(value = "/list", method = RequestMethod.GET) //1. http://localhost:8181/score/list 접속
    public String list(Model model){ //2. ScoreController클래스의 46번에서 접속 주소 감지 후 메서드실행
        System.out.println("/score/list : GET방식!");

        // repository 객체 내부의 전체 조회기능을 이용해 자료를 받아서 scoreList 변수에 저장해 주세요
        List<Score> scoreList = repository.findAll(); // 3. 2번클래스의 50번라인에서 repository.findAll() 호출
                                                      // 4. ScoreRepositoryImpl의 findAll()메서드 호출

        System.out.println(scoreList);
        // 화면에 해당 성적 전체를 실어서 화면단으로 보낼수 있게 적재하기
        model.addAttribute("scoreList", scoreList);
        // /WEB-INF/views/chp04/score-list.jsp
        return "chap04/score-list";
    }
    // 2. 성적 정보 등록 처리 요청
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(Score score){ //Score 멤버변수 네임과 socre-list.jsp 파일에서 입력받은 변수 이름과 똑같기 때문에
                                         //변수명 하나하나 적는것보다 Score score 입력하는게 더 좋은 방법
        System.out.println("/score/regitster : POST방식");
        repository.save(score);
        // 추가 성공했으면 다시 목록페이지로 이동시키기
        return "redirect:/score/list";
    }
    // 3. 성적 정보 삭제 요청
    @RequestMapping(value = "/remove", method = RequestMethod.POST)
    public String remove(){
        System.out.println("/score/remove : POST방식");
        return "";
    }
    // 4. 상세 성적 조회
    @RequestMapping(value = "/detail", method = RequestMethod.GET)
    public String detail(Model model, int studentNumber){ // 데이터를 뷰단으로 적재하여 넘기기 위해 파라미터에 Model model 꼭 선언
        System.out.println("/score/detail : GET방식");
        System.out.println(studentNumber);
        // 레포지토리에서 Score 객체를 받아서 저장하고 .jsp 파일로 보낼수 있게 적재해주세요
        Score score = repository.findByStudentNumber(studentNumber);
        model.addAttribute("score", score);
        // WEB-INF/views/chap04/detail.jsp
        return "chap04/detail";
    }



}
