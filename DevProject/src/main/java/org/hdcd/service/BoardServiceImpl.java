package org.hdcd.service;

import java.util.List;

import org.hdcd.domain.Board;
import org.hdcd.repository.BoardRepository;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class BoardServiceImpl implements BoardService {
   
   private final BoardRepository repository;
   
   @Override
   public void register(Board board) throws Exception{
      repository.save(board);
   }
   
   @Override
   public List<Board> list() throws Exception{
	   return repository.findAll(Sort.by(Direction.DESC,"boardNo"));
   }
   
   @Override
   public Board read(Long boardNo) throws Exception{
	   return repository.getOne(boardNo);
   }
}