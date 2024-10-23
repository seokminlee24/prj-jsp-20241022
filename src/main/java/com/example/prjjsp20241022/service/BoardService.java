package com.example.prjjsp20241022.service;

import com.example.prjjsp20241022.dto.Board;
import com.example.prjjsp20241022.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {

    private final BoardMapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }

    public List<Board> list(Integer page) {
        //Controller에 넘갸줄
        Map<String, Object> map = new HashMap<>();

        //List<Board> list = mapper.selectAll();
        Integer offset = (page - 1) * 10;
        List<Board> list = mapper.selectAllPaging(offset);

        // 페이지 관련 정보들
        Integer countAll = mapper.countAll();
        Integer lastPageNumber = (countAll - 1) / 10 + 1; //마지막 페이지 번호

        map.put("lastPageNumber", lastPageNumber);
        map.put("boardList", list);
        return list;
    }

    public Board get(Integer id) {
        return mapper.selectById(id);
    }

    public void remove(Integer id) {

        mapper.deleteById(id);
    }

    public void update(Board board) {
        mapper.update(board);
    }


}