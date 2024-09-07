package kr.nomadlab.mentors.board.mapper;

import kr.nomadlab.mentors.board.domain.BoardLikeVO;
import kr.nomadlab.mentors.board.domain.BoardVO;
import kr.nomadlab.mentors.board.domain.HashTagVO;
import kr.nomadlab.mentors.common.PageRequestDTO;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
@Log4j2
class BoardMapperTest {
    @Autowired
    private BoardMapper boardMapper;

    @Test
    void insertBoardTest() {

        for (int i = 1; i <= 10000; i++) {
            BoardVO boardVO = BoardVO.builder()
                    .mno((long) i)
                    .writer("작성자" + i)
                    .title("제목" + i)
                    .content("내용" + i)
                    .build();

            boardMapper.insertBoard(boardVO);

            HashTagVO hashTagVO = HashTagVO.builder()
                    .boardNo(boardVO.getBoardNo())
                    .tagName("tagName" + i)
                    .build();
            boardMapper.insertTag(hashTagVO);
        }
    }

    @Test
    void selectBoardListTest() {
        String sort = "reply";
        PageRequestDTO pageRequestDTO = PageRequestDTO.builder()
                .build();

        // 시작 시간 기록
        long startTime = System.currentTimeMillis();

        List<BoardVO> boardVOList = boardMapper.selectBoardList(pageRequestDTO);
        boardVOList.forEach(log::info);

        // 종료 시간 기록
        long endTime = System.currentTimeMillis();

        // 실행 시간 계산
        long executionTime = endTime - startTime;

        System.out.println("쿼리 실행 시간: " + executionTime + "ms");

    }

    @Test
    void insertLikeTest() {
        Long boardNo = 3L;
        Long mNo = 2L;
        BoardLikeVO boardLikeVO = BoardLikeVO.builder()
                .boardNo(boardNo)
                .mno(mNo)
                .build();

        boardMapper.insertLike(boardLikeVO);
    }

    @Test
    void selectLikeListTest() {
        Long boardNo = 18L;
        List<BoardLikeVO> boardLikeVOList = boardMapper.selectLikeList(boardNo);
        boardLikeVOList.forEach(log::info);
    }

    @Test
    void insertTagTest() {
        Long boardNo = 3L;
        String tagName = "Tag Test1";
        HashTagVO hashTagVO = HashTagVO.builder()
                .boardNo(boardNo)
                .tagName(tagName)
                .build();
        boardMapper.insertTag(hashTagVO);
    }

    @Test
    void removeTagTest() {
        Long htNo = 2L;
        boardMapper.deleteTag(htNo);
    }

    @Test
    void getCountTest() {
        int count = boardMapper.getCount(PageRequestDTO.builder().build());
        log.info(count);
    }

    @Test
    void selectBoardTest() {
        Long boardNo = 10L;
        BoardVO boardVO = boardMapper.selectBoard(boardNo);
        log.info(boardVO);
    }

    @Test
    void selectTagListTest() {
        Long boardNo = 27L;
        List<HashTagVO> tagVOList = boardMapper.selectTagList(boardNo);
        tagVOList.forEach(log::info);
    }

    @Test
    void selectMyBoardListTest() {
        Long mno = 1L;
        List<BoardVO> boardVOList = boardMapper.selectMyBoardList(mno, 0, 10);
        boardVOList.forEach(log::info);
    }
}