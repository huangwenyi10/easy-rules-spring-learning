package com.appdemo.demo;


import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class UserApi {

    @Autowired
    RulesEngine myEngine;

    @Autowired
    ConfigRules configRules;

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public Object info(@RequestBody User user) throws Exception {
        // 生成一个唯一id，方便基于数据id规则流程查询
        user.setUniqueId(UUID.randomUUID().toString());

        Rules rules = configRules.fetchConfigRules();
        MyRule<User> rule = new MyRule<>();
        rules.register(rule);

        //  默认模式
        // myEngine.fire(rules,facts);
        // 应该使用原型模式
        Facts facts = new Facts();
        facts.put("user", user);
        SpringBeanUtil.getBean("myEngine", RulesEngine.class).fire(rules, facts);

        if (rule.isExecuted()) {
            User userResult = rule.getResult();
            System.out.println("result from final ruls" + userResult.toString());
            return userResult;
        } else {
            return null;
        }
    }
}

