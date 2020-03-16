package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Answer;
import com.entities.Comment;
import com.operation.result.OperationResultHolder;
import com.service.AnswerService;
import com.service.CommentService;

@Controller
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private CommentService commentService;
	
	@Autowired
	private AnswerService answerService;
	
	@Autowired
	private OperationResultHolder operationResultHolder;
	
	@RequestMapping(value = "save" , method = RequestMethod.POST)
	public @ResponseBody Map<String,Object> save(Answer answer ,@RequestParam Integer commentId) {
		Map<String , Object> responseMap = new HashMap<>();
		try {
			answer.authorize(); // cevabý yazan kiþiye göre , yetkisini ayarlýyoruz
			Comment comment = commentService.getBy(commentId);
			comment.getAnswerList().add(answer);
			commentService.update(comment);
			operationResultHolder.setSuccessResult("your answer is successfully saved.");
		}catch(Exception e) {
			operationResultHolder.setDangerResult("an error occurred , when executing the operation");
			e.printStackTrace();
		}
		
		responseMap.put("operationResult", operationResultHolder.getOperationResult());
		return responseMap;
	}

	@RequestMapping(value = "delete" , method = RequestMethod.POST)
	public @ResponseBody Map<String , Object> delete(@RequestParam int commentId , @RequestParam int answerId) {
		Map<String , Object> responseMap = new HashMap<>();

		try {
			System.out.println(commentId + " " + answerId);
			Comment comment = commentService.getBy(commentId);
			Answer answer = answerService.getBy(answerId);
			comment.getAnswerList().removeIf(argAnswer -> argAnswer.getId() == answer.getId());
			commentService.update(comment);
			answerService.delete(answer);
			operationResultHolder.setDangerResult("the answer is succesfully deleted.");
		}catch (Exception e) {
			e.printStackTrace();
			operationResultHolder.setDangerResult("an error occurred , when executing the operation");
		}
		responseMap.put("operationResult", operationResultHolder.getOperationResult());
		return responseMap;
	}
	
}
