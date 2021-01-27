package com.example.calculator.callbacks;

import com.example.calculator.model.ExampleResponse;

import java.util.List;

public interface JsonResponseCallback {
     void getResponse(List<ExampleResponse> responseList);
}
