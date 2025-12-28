package com.examly.springapp.service;

import com.examly.springapp.model.Comment;
import java.util.List;

public interface CommentService {
    Comment saveComment(Comment comment);
    List<Comment> getAllComments();
    Comment getCommentById(Long id);
    Comment updateComment(Long id, Comment comment);
    void deleteComment(Long id);
}