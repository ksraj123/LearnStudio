package com.learnstudio.contentservice.controller;

import com.learnstudio.contentservice.pojo.reponse.ErrorResponse;
import com.learnstudio.contentservice.pojo.reponse.Response;

public abstract class AbstractController {
    protected <T> Response<?> getSuccessResponse(T t) {
        return new Response<>(true, t, null);
    }

    protected <T> Response<?> getFailureResponse(T t, ErrorResponse error) {
        return new Response<>(true, t, error);
    }
}
