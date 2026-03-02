package com.bytebites.service;

import java.util.List;

import com.bytebites.Exception.ReviewException;
import com.bytebites.model.Review;
import com.bytebites.model.User;
import com.bytebites.request.ReviewRequest;

public interface ReviewSerive {
	
    public Review submitReview(ReviewRequest review,User user);
    public void deleteReview(Long reviewId) throws ReviewException;
    public double calculateAverageRating(List<Review> reviews);
}
