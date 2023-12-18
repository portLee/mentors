package kr.nomadlab.mentors.main.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MainDTO {
    private Long mbNo; // 메인게시물 번호
    private Long mNo; // 회원번호(멘토)
    private String paidFree; // 무료인지 유료인지
    private String nickName; // 멘토닉네임
    private String devLanguage; // 멘토 전공언어
    private String title; // 게시물 제목
    private String position; // 직무
    private String career; // 경력
    private String introduce; // 정보
    private LocalDateTime startDate; // 수업 시작일
    private LocalDateTime endDate; // 수업 종료일
    private LocalDateTime addDate; // 등록일
    private double score; // 수강평점수
    private String price; // 가격
}