package com.xdclass.redis.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 *
 **/
@RestController
public class SessionController {

    private static final String SESSION_KEY="request Url";

    @RequestMapping(value = "/setSession",method = RequestMethod.GET)
    public Map<String,Object> setSession(HttpServletRequest httpServletRequest){
        HashMap<String, Object> hashMap = new HashMap<>();
        httpServletRequest.setAttribute(SESSION_KEY,httpServletRequest.getRequestURL());
        hashMap.put(SESSION_KEY,httpServletRequest.getRequestURL());
        return hashMap;
    }

    @RequestMapping(value = "/getSession",method = RequestMethod.GET)
    public Object getSession(HttpServletRequest httpServletRequest){
        HashMap<String, Object> hashMap = new HashMap<>();
        hashMap.put("sessionIdUrl",httpServletRequest.getSession().getAttribute(SESSION_KEY));
        hashMap.put("sessionId",httpServletRequest.getSession().getId());
        return hashMap;
    }
}
