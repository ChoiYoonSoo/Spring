package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Board;

public interface BoardService {
   
   public void register(Board board) throws Exception;
   
   public List<Board> list() throws Exception;
   
   public Board read(Long boardNo) throws Exception;
   
}