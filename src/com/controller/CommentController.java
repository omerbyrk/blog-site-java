package com.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.entities.Blog;
import com.entities.Comment;
import com.operation.result.OperationResultHolder;
import com.service.BlogService;
import com.service.CommentService;

@Controller
@RequestMapping("comment")
public class CommentController {
	
	@Autowired
	private BlogService blogService;
	
	@Autowired
	private CommentService commentService;
	
	@Autowired
	private OperationResultHolder operationResultHolder;
	
	@RequestMapping(value = "/save" , method = RequestMethod.POST)
	public @ResponseBody Map<String , Object> save(Comment comment , @RequestParam Integer blogId) {
		Map<String , Object> responseMap = new HashMap<>();
		try {
			comment.authorize(); // yorumu yazan kiþinin yetkisini ayarlýyoruz
			comment.setBlog(new Blog(blogId));
			commentService.save(comment);
			operationResultHolder.setSuccessResult("your comment is successfully saved.");
		}catch(Exception e) {
			operationResultHolder.setDangerResult("an error occurred , when executing the operation");
			e.printStackTrace();
		}
		
		responseMap.put("operationResult", operationResultHolder.getOperationResult());
		return responseMap;
	}
	/**
	 * Gelen answerId deðeri , aslýdna içinde blogId deðerini barýndýrýyor.
	 * */
	@RequestMapping(value = "delete" , method = RequestMethod.POST)
	public @ResponseBody Map<String , Object> delete(@RequestParam("answerId") int blogId , @RequestParam int commentId) {
		Map<String , Object> responseMap = new HashMap<>();
		
		try {
			Blog blog = blogService.getBy(blogId);
			Comment comment = commentService.getBy(commentId);
			blog.getCommentList().removeIf(argComment -> argComment.getId() == comment.getId());
			blogService.update(blog);
			commentService.delete(comment);
			operationResultHolder.setDangerResult("the comment is succesfully deleted.");
		}catch (Exception e) {
			operationResultHolder.setDangerResult("an error occurred , when executing the operation");
		}
		responseMap.put("operationResult", operationResultHolder.getOperationResult());
		return responseMap;
	}
	
}
