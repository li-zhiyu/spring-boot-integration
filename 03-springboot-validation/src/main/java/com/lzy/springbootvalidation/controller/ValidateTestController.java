package com.lzy.springbootvalidation.controller;

import com.lzy.springbootvalidation.common.AjaxResult;
import com.lzy.springbootvalidation.entity.User;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ValidateTestController {

    @PostMapping("/")
    public AjaxResult testDemo(@Valid User user, BindingResult bindingResult){
        StringBuffer stringBuffer = new StringBuffer();
        if(bindingResult.hasErrors()){
            List<ObjectError> list =bindingResult.getAllErrors();
            for (ObjectError objectError:list) {
                stringBuffer.append(objectError.getDefaultMessage());
                stringBuffer.append("---");
            }
            return AjaxResult.error(stringBuffer.toString());
        }
        return AjaxResult.success();
    }
}
