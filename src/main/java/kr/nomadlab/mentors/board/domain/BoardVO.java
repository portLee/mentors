package kr.nomadlab.mentors.board.domain;

import lombok.*;

import java.time.LocalDateTime;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class BoardVO {
    private Long boardNo; // 게시글 고유번호
    private String memberId; // 회원 아이디
    private String writer; // 회원 닉네임
    private String title; // 게시글 제목
    private String content; // 게시글 내용
    private Long hit; // 게시글 조회수
    private LocalDateTime addDate; // 게시글 등록 날짜
    private Long replyCount; // 게시글 댓글 수
    private Long likeCount; // 좋아요 수
} 